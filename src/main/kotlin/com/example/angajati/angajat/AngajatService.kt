package com.example.angajati.angajat

import org.springframework.beans.factory.annotation.Autowired
import org.springframework.data.repository.findByIdOrNull
import org.springframework.http.HttpStatus
import org.springframework.stereotype.Service
import org.springframework.web.server.ResponseStatusException
import java.util.*
import javax.transaction.Transactional
import kotlin.IllegalStateException

@Service
public class AngajatService(
    private val angajatRepository: AngajatRepository
) {
    fun <T> Optional<T>.unwrap(): T? = orElse(null)

    fun findAngajatById(idAngajat: Long) = angajatRepository.findAngajatById(idAngajat)
        ?: throw IllegalStateException("Angajatul cu id-ul $idAngajat nu exista!")

    fun getById(idAngajat: Long): Angajat ?= angajatRepository.findById(idAngajat).unwrap() ?:
    throw ResponseStatusException(HttpStatus.NOT_FOUND)



    public fun getAngajati(): List<Angajat> {
        return listOf(
            return angajatRepository.findAll()
        )
    }

    infix fun addNewAngajat(angajatCreateRequest: AngajatCreateRequest): Angajat {
        if (angajatRepository.existsByEmailEqualsIgnoreCase(angajatCreateRequest.email!!)) throw IllegalStateException("EMAIL TAKEN")


        return angajatRepository.save(
            Angajat(
                nume = angajatCreateRequest.nume!!,
                prenume = angajatCreateRequest.prenume!!,
                email = angajatCreateRequest.email,
                dataNasterii = angajatCreateRequest.dataNasterii!!,
                functie = angajatCreateRequest.functie
            )
        )
    }

    @Transactional
    fun updateAngajat(
        idAngajat: Long, angjatUpdateRequest: AngajatUpdateRequest
    ) {
        val angajat: Angajat = findAngajatById(idAngajat)

        with(angjatUpdateRequest) {
            angajatRepository.save(
                angajat.copy(
                    nume = nume ?: angajat.nume,
                    prenume = prenume ?: angajat.prenume,
                    email = email ?: angajat.email,
                    functie = functie ?: angajat.functie,
                    dataNasterii = if (dataNasterii != null) dataNasterii else angajat.dataNasterii
                )
            )
        }
    }

    infix public fun deleteAngajat(idAngajat: Long) {
        var existaAngajat = angajatRepository.existsById(idAngajat)
        if (!existaAngajat) {
            throw IllegalStateException("Nu exista un angajat cu id:$idAngajat")
        } else {
            angajatRepository.deleteById(idAngajat)
        }
    }

}