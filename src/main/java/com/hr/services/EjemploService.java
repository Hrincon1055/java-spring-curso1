package com.hr.services;

import org.springframework.context.annotation.Primary;
import org.springframework.stereotype.Service;

@Service
@Primary
public class EjemploService {
  public String saludo() {
    return "Hola";
  }
}
