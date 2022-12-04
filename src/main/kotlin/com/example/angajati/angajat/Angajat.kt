package com.example.angajati.angajat

import net.bytebuddy.asm.Advice.Local
import javax.persistence.*
import java.time.*
import kotlin.jvm.Transient

@Entity
@Table
data class Angajat (
    @Id
    @SequenceGenerator(
        name = "angajat_sequence",
        sequenceName = "angajat_sequence",
        allocationSize = 1
    )
    @GeneratedValue(
        strategy = GenerationType.SEQUENCE,
        generator = "angajat_sequence"
    )
    public val id: Long = 0,
             val nume: String? = "",
             val prenume: String? = "",
             val email: String? = "",
             val dataNasterii: LocalDate? = LocalDate.of(1969,
        Month.APRIL, 16),
             val functie: String? = ""
        ){

    @Transient
    private var varsta = 0

    public fun getVarsta(): Int{
        return Period.between(this.dataNasterii,
        LocalDate.now()).years
    }
}
