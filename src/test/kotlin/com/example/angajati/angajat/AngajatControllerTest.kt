package com.example.angajati.angajat

import org.junit.jupiter.api.AfterEach
import org.junit.jupiter.api.BeforeEach
import org.junit.jupiter.api.Test
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc
import org.springframework.boot.test.context.SpringBootTest
import org.springframework.http.MediaType.APPLICATION_JSON
import org.springframework.test.web.servlet.MockMvc
import org.springframework.test.web.servlet.delete
import org.springframework.test.web.servlet.get
import java.nio.charset.StandardCharsets.UTF_8
import java.time.LocalDate
import java.time.Month

@SpringBootTest
@AutoConfigureMockMvc
internal class AngajatControllerTest {

    @Autowired
    lateinit var mockMvc: MockMvc

    @Autowired
    lateinit var angajatRepository: AngajatRepository

    @BeforeEach
    fun setup() {
        angajatRepository.deleteAll()
    }

    @AfterEach
    fun cleanup() {
        angajatRepository.deleteAll()
    }

    @Test
    fun `getAngajat - should retrive an angajat from DB - when the request contains a valid ID`() {
        val angajatSalvat: Angajat = angajatRepository.save(
            Angajat(
                nume = "Pulica",
                prenume = "Romel",
                email = "romelpulica@mail.com",
                dataNasterii = LocalDate.of(1999, Month.FEBRUARY, 10),
                functie = "Maturator profesionist"
            )
        )
        var idangajat = angajatSalvat.id

        mockMvc.get("/api/v1/angajat/$idangajat") {
            contentType = APPLICATION_JSON
            characterEncoding = UTF_8.name()
        }.andExpect {
            status { isOk() }
            jsonPath("$.nume") { value("Pulica") }
            jsonPath("$.prenume") { value("Romel") }
            jsonPath("$.email") { value("romelpulica@mail.com") }
            jsonPath("$.dataNasterii") { value("1999-02-10") }
            jsonPath("$.functie") { value("Maturator profesionist") }
        }
    }

    @Test
    fun registerNewAngajat() {
    }

    @Test
    fun `deleteAngajat - should delete an angajat from DB - when the request contains a valid ID`() {
        val angajatSalvat: Angajat = angajatRepository.save(
            Angajat(
                nume = "Pulica",
                prenume = "Romel",
                email = "romelpulica@mail.com",
                dataNasterii = LocalDate.of(1999, Month.FEBRUARY, 10),
                functie = "Maturator profesionist"
            )
        )
        var idangajat = angajatSalvat.id

        mockMvc.delete("/api/v1/angajat/$idangajat") {
            contentType = APPLICATION_JSON
            characterEncoding = UTF_8.name()
        }.andExpect {
            status { isOk() }
        }

    }

    @Test
    fun updateStudent() {
    }
}