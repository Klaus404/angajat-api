package com.example.angajati.angajat

import java.time.LocalDate

class AngajatUpdateRequest(
    val nume: String?,
    val prenume: String?,
    val email: String?,
    val functie: String?,
    val dataNasterii: LocalDate?
)