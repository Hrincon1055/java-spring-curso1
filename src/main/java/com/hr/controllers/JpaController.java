package com.hr.controllers;

import java.util.HashMap;
import java.util.Map;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.hr.modelos.CategoriaModel;
import com.hr.services.CategoriaService;
import com.hr.utils.Utilidades;

@Controller
@RequestMapping("jpa-repository")
public class JpaController {
  @Autowired
  private CategoriaService categoriaService;

  @GetMapping("")
  public String home(Model model) {
    return "jpa_repository/home";
  }

  @GetMapping("/categorias")
  public String categorias(Model model) {
    model.addAttribute("datos", this.categoriaService.listar());
    return "jpa_repository/categorias";
  }

  @GetMapping("/categorias/add")
  public String categorias_add(Model model) {
    CategoriaModel categoria = new CategoriaModel();
    model.addAttribute("categoria", categoria);
    return "jpa_repository/categorias_add";
  }

  @PostMapping("/categorias/add")
  public String categorias_add_post(@Valid CategoriaModel categoria, BindingResult result, RedirectAttributes flash,
      Model model) {
    if (result.hasErrors()) {
      Map<String, String> errores = new HashMap<>();
      result.getFieldErrors().forEach(err -> {
        errores.put(err.getField(),
            "El campo ".concat(err.getField()).concat(" ").concat(err.getDefaultMessage()));
      });

      model.addAttribute("errores", errores);
      model.addAttribute("categoria", categoria);
      return "jpa_repository/categorias_add";
    }
    String slug = Utilidades.getSlug(categoria.getNombre());

    if (this.categoriaService.buscarPorSlug(slug) == false) {
      flash.addFlashAttribute("clase", "danger");
      flash.addFlashAttribute("mensaje", "La categoría ingresada ya existe en la base de datos");
      return "redirect:/jpa-repository/categorias/add";
    } else {
      categoria.setSlug(slug);
      this.categoriaService.guardar(categoria);
      flash.addFlashAttribute("clase", "success");
      flash.addFlashAttribute("mensaje", "Se creó el registro exitosamente");
      return "redirect:/jpa-repository/categorias/add";
    }
  }
}
