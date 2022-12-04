package com.example.angajati.angajat

import org.jetbrains.annotations.NotNull
import java.time.LocalDate
import javax.validation.constraints.NotEmpty


class AngajatCreateRequest (
    @field:NotEmpty(message = "Numele nu trebuie sa fie null")
    val nume: String?,
    @field:NotEmpty(message = "Prenumele nu trebuie sa fie null")
    val prenume: String?,
    @field:NotEmpty(message = "Emailul nu trebuie sa fie null")
    val email: String?,
    @field:NotEmpty(message = "Functia nu trebuie sa fie null")
    val functie: String?,
    @field:NotNull("Data nasterii nu poate fi null")
    val dataNasterii : LocalDate?
)