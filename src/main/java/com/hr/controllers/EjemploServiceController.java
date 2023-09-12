package com.hr.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.hr.services.EjemploService;

@Controller
@RequestMapping("/ejemplo-service")
public class EjemploServiceController {
  @Autowired
  private EjemploService ejemploService;

  @GetMapping("")
  public String home(Model model) {
    model.addAttribute("saludo", this.ejemploService.saludo());
    return "ejemplo_service/home";
  }
}
