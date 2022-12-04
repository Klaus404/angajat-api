package com.example.angajati.angajat

import org.springframework.beans.factory.annotation.Autowired
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.*
import java.time.LocalDate
import java.time.Month
import javax.validation.Valid

@RestController
@RequestMapping("api/v1/angajat")
public class AngajatController (
    private val angajatService : AngajatService
        ){

    @GetMapping
    fun getAngajati(): List<Angajat>{
        return angajatService.getAngajati()
    }

    @GetMapping("/{idAngajat}")
    fun getAngajat(@PathVariable idAngajat: Long) : Angajat?{
        return angajatService.getById(idAngajat)
    }

    @PostMapping
    fun registerNewAngajat(
        @Valid
        @RequestBody
        angajatCreateRequest: AngajatCreateRequest
    ) : ResponseEntity<Angajat> = ResponseEntity.ok(angajatService addNewAngajat  angajatCreateRequest)

    @DeleteMapping("/{idAngajat}")
    fun deleteAngajat(
        @PathVariable idAngajat:Long){
        ResponseEntity.ok(angajatService deleteAngajat idAngajat)
    }

    @PutMapping("/{idAngajat}")
    fun updateStudent(
        @PathVariable idAngajat: Long,
        //Aici poti sa nu mai treci ("idAngajat") daca ai acelasi nume si la variabila si sus la putmapping
        @RequestParam(required = false) nume: String?,
        @RequestParam(required = false) prenume: String?,
        @RequestParam(required = false) email: String?,
        @RequestParam(required = false) functie: String?,
        @RequestParam(required = false) dataNasterii: LocalDate?

    ){
        angajatService.updateAngajat(idAngajat, AngajatUpdateRequest(nume,
            prenume ,
            email,
            functie,
            dataNasterii)
        )
    }

}