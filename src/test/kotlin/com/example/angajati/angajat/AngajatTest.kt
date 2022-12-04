package com.example.angajati.angajat

import org.junit.jupiter.api.Test
import org.junit.jupiter.api.Assertions.*
import java.time.Month
import java.time.LocalDate
import java.time.Period

internal class AngajatTest {

    @Test
    fun `it should get the age of an Angajat`() {
         val angajat : Angajat = Angajat(dataNasterii = LocalDate.of(2000, Month.JANUARY, 23 ))

    val expected = Period.between(angajat.dataNasterii, LocalDate.now()).years
    assertEquals(expected, angajat.getVarsta())
    }

}