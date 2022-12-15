package com.example.backendh93p1.controller;


import com.example.backendh93p1.services.PreguntaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/preguntas")
@CrossOrigin("*")
public class PreguntasController {

    @Autowired
    private PreguntaService preguntaService;


}
