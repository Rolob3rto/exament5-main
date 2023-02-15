package com.oretania.portal.controllers;

import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/asignaturas")

public class AsignaturaController {   

    @GetMapping(value = { "/matematicas" })
    @PreAuthorize("hasAnyAuthority('MAT', 'ADMIN')")
    public String matematicas() {

        return "asignaturas/matematicas";
    }

    @GetMapping(value = { "/lengua" })
    @PreAuthorize("hasAnyAuthority('LEN', 'ADMIN')")
    public String lengua() {

        return "asignaturas/lengua";
    }

    @GetMapping(value = { "/ingles" })
    @PreAuthorize("hasAnyAuthority('ING', 'ADMIN')")
    public String ingles() {

        return "asignaturas/ingles";
    }

    @GetMapping(value = { "/religion" })
    @PreAuthorize("hasAnyAuthority('REL', 'ADMIN')")
    public String religion() {

        return "asignaturas/religion";
    }

    @GetMapping(value = { "/fisica" })
    @PreAuthorize("hasAnyAuthority('FIS', 'ADMIN')")
    public String fisica() {

        return "asignaturas/fisica";
    }

    @GetMapping(value = { "/quimica" })
    @PreAuthorize("hasAnyAuthority('QUI', 'ADMIN')")
    public String quimica() {

        return "asignaturas/quimica";
    }
}