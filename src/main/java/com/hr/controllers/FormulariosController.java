package com.hr.controllers;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.hr.modelos.InteresesModel;
import com.hr.modelos.PaisModel;
import com.hr.modelos.Usuario2Model;
import com.hr.modelos.Usuario3Model;
import com.hr.modelos.UsuarioCheckboxModel;
import com.hr.modelos.UsuarioModel;
import com.hr.modelos.UsuarioUpload;
import com.hr.utils.Utilidades;

@Controller
@RequestMapping("/formularios")
public class FormulariosController {

  @Value("${henry.valores.ruta_upload}")
  private String rutaUpload;

  @Value("${henry.valores.base_url}")
  private String baseUrl;

  @GetMapping("")
  public String home() {
    return "formularios/home";
  }

  // #################FORMULARIO SIMPLE#####################
  @GetMapping("/simple")
  public String simple() {
    return "formularios/simple";
  }

  @PostMapping("/simple")
  @ResponseBody
  public String simple_post(
      @RequestParam(name = "username") String username,
      @RequestParam(name = "correo") String correo,
      @RequestParam(name = "password") String password) {
    return "username " + username;
  }
  // #################FORMULARIO OBJETOS#####################

  @GetMapping("/objeto")
  public String objeto() {
    return "formularios/objeto";
  }

  @PostMapping("/objeto")
  @ResponseBody
  public String objeto_post(UsuarioModel usuario) {
    return "objeto " + usuario.getUsername();
  }

  // #################FORMULARIO OBJETOS 2#####################
  @GetMapping("/objeto2")
  public String objeto2(Model model) {
    model.addAttribute("usuario", new UsuarioModel());
    return "formularios/objeto2";
  }

  @PostMapping("/objeto2")
  @ResponseBody
  public String objeto2_post(UsuarioModel usuario) {
    return "objeto " + usuario.getUsername() + " " + usuario.getCorreo();
  }

  // #################FORMULARIO DE VALIDACIONES#####################
  @GetMapping("/validaciones")
  public String validaciones(Model model) {
    model.addAttribute("usuario", new Usuario2Model());
    return "formularios/validaciones";
  }

  @PostMapping("/validaciones")
  public String validaciones_post(@Valid Usuario2Model usuario, BindingResult result, Model model) {
    if (result.hasErrors()) {
      Map<String, String> errores = new HashMap<>();
      result.getFieldErrors().forEach(err -> {
        errores.put(err.getField(), "El Campo ".concat(err.getField()).concat(" ").concat(err.getDefaultMessage()));
      });
      model.addAttribute("errores", errores);
      model.addAttribute("usuario", usuario);
      return "formularios/validaciones";
    }
    model.addAttribute("usuario", usuario);
    return "formularios/validaciones_result";
  }

  // #################FORMULARIO SELECT DINAMICO#####################
  @GetMapping("/select-dinamico")
  public String select_dinamico(Model model) {

    model.addAttribute("usuario", new Usuario3Model());
    return "formularios/select_dinamico";
  }

  @PostMapping("/select-dinamico")
  public String select_dinamicot_post(@Valid Usuario3Model usuario, BindingResult result, Model model) {
    if (result.hasErrors()) {
      Map<String, String> errores = new HashMap<>();
      result.getFieldErrors().forEach(err -> {
        errores.put(err.getField(), "El Campo ".concat(err.getField()).concat(" ").concat(err.getDefaultMessage()));
      });
      model.addAttribute("errores", errores);
      model.addAttribute("usuario", usuario);
      return "formularios/select_dinamico";
    }
    model.addAttribute("usuario", usuario);
    return "formularios/select_dinamico_result";
  }

  // #################FORMULARIO CHEK#####################
  @GetMapping("/checkbox")
  public String checkbox(Model model) {
    model.addAttribute("usuario", new UsuarioCheckboxModel());
    return "formularios/checkbox";
  }

  @PostMapping("/checkbox")
  public String checkbot_post(@Valid UsuarioCheckboxModel usuario, BindingResult result, Model model) {
    if (result.hasErrors()) {
      Map<String, String> errores = new HashMap<>();
      result.getFieldErrors().forEach(err -> {
        errores.put(err.getField(), "El Campo ".concat(err.getField()).concat(" ").concat(err.getDefaultMessage()));
      });
      model.addAttribute("errores", errores);
      model.addAttribute("usuario", usuario);
      return "formularios/checkbox";
    }
    model.addAttribute("usuario", usuario);
    return "formularios/checkbox_result";
  }
  // #################MENSAJES FLASH#####################

  @GetMapping("/flash")
  public String flash(Model model) {
    model.addAttribute("usuario", new UsuarioModel());
    return "formularios/flash";
  }

  @PostMapping("/flash")
  public String flash_post(UsuarioModel usuario, RedirectAttributes flash) {
    flash.addFlashAttribute("clase", "danger");
    flash.addFlashAttribute("mensaje", "Ejemplo mensaje");
    return "redirect:/formularios/flash_result";
  }

  @GetMapping("/flash_result")
  public String flash_result(Model model) {
    return "formularios/flash_result";
  }

  // #################FORMULARIO UPLOAD#####################
  @GetMapping("/upload")
  public String upload(Model model) {
    model.addAttribute("usuario", new UsuarioUpload());
    return "formularios/upload";
  }

  @PostMapping("/upload")
  public String upload_post(
      @Valid UsuarioUpload usuario,
      BindingResult result,
      Model model,
      @RequestParam("archivoImagen") MultipartFile multiPart,
      RedirectAttributes flash) {
    if (result.hasErrors()) {
      Map<String, String> errores = new HashMap<>();
      result.getFieldErrors().forEach(err -> {
        errores.put(err.getField(), "El Campo ".concat(err.getField()).concat(" ").concat(err.getDefaultMessage()));
      });
      model.addAttribute("errores", errores);
      model.addAttribute("usuario", usuario);
      return "formularios/upload";
    }
    if (multiPart.isEmpty()) {
      flash.addFlashAttribute("clase", "danger");
      flash.addFlashAttribute("mensaje", "Error foto");
      return "redirect:/formularios/upload";
    }
    if (!multiPart.isEmpty()) {
      String nombreImagen = Utilidades.guardarArchivo(multiPart, this.rutaUpload);
      if (nombreImagen == "NO") {
        flash.addFlashAttribute("clase", "danger");
        flash.addFlashAttribute("mensaje", "Error foto");
        return "redirect:/formularios/upload";
      }
      if (nombreImagen != null) {
        usuario.setFoto(nombreImagen);
      }
    }
    model.addAttribute("usuario", usuario);
    return "formularios/upload_result";
  }

  // #################CAMPOS GENERICOS MEDIANTE MODEL#####################
  @ModelAttribute
  public void setGenericos(Model model) {
    List<PaisModel> paises = new ArrayList<PaisModel>();
    paises.add(new PaisModel(1, "Chile"));
    paises.add(new PaisModel(2, "Colombia"));
    paises.add(new PaisModel(3, "Venezuela"));
    paises.add(new PaisModel(4, "Peru"));
    model.addAttribute("paises", paises);
    List<InteresesModel> intereses = new ArrayList<InteresesModel>();
    intereses.add(new InteresesModel(1, "Musica"));
    intereses.add(new InteresesModel(2, "Deportes"));
    intereses.add(new InteresesModel(3, "Economia"));
    model.addAttribute("intereses", intereses);
    model.addAttribute("base_url", this.baseUrl);
  }
}