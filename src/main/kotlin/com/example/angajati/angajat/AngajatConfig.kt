package com.example.angajati.angajat

import org.springframework.boot.CommandLineRunner
import org.springframework.context.annotation.Bean
import org.springframework.context.annotation.Configuration
import java.time.LocalDate
import java.time.Month

@Configuration
class AngajatConfig {
    @Bean
    fun init(repository: AngajatRepository) = CommandLineRunner {
        var costel = Angajat(
            nume = "Ionel",
            prenume = "Costel",
            email = "ionelcostel@mail.com",
            dataNasterii = LocalDate.of(2001, Month.JANUARY, 14),
            functie = "Maturator profesionist"
        )

        var mirel = Angajat(
            nume = "Gica",
            prenume = "Mirel",
            email = "gmirel@email.com",
            dataNasterii = LocalDate.of(1999, Month.MARCH, 16),
            functie = "Operator calculator"
        )

        repository.saveAll(
            listOf<Angajat>(costel, mirel)
        )
    }
}