package com.example.angajati.angajat

import org.springframework.data.jpa.repository.JpaRepository
import org.springframework.data.jpa.repository.Query
import org.springframework.stereotype.Repository

@Repository
public interface AngajatRepository: JpaRepository<Angajat, Long> {

    fun existsByEmailEqualsIgnoreCase(email: String): Boolean
    override fun existsById(idAngajat: Long): Boolean

    fun findAngajatById(id: Long): Angajat?
}