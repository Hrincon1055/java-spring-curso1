package com.hr.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.hr.modelos.UsuarioRestModel;
import com.hr.services.ClienteRestService;

@Controller
@RequestMapping("/cliente-rest")
public class ClienteRestController {
  @Autowired
  private ClienteRestService clienteRestService;

  @GetMapping("")
  public String home(Model model) {
    List<UsuarioRestModel> datos = this.clienteRestService.listaUsuarios();
    System.out.println(datos.toString());
    model.addAttribute("datos", datos);
    return "cliente_rest/home";
  }
}
