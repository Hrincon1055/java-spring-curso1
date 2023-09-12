package com.hr.modelos;

import java.util.List;

import javax.validation.constraints.Email;
import javax.validation.constraints.NotEmpty;

public class UsuarioCheckboxModel {
  @NotEmpty(message = "Esta vacío")
  private String username;
  @NotEmpty(message = "Esta vacío")
  @Email(message = "Ingresado no es valido")
  private String correo;
  @NotEmpty(message = "Esta vacío")
  private String password;
  private List<InteresesModel> intereses;

  public String getUsername() {
    return this.username;
  }

  public void setUsername(String username) {
    this.username = username;
  }

  public String getCorreo() {
    return this.correo;
  }

  public void setCorreo(String correo) {
    this.correo = correo;
  }

  public String getPassword() {
    return this.password;
  }

  public void setPassword(String password) {
    this.password = password;
  }

  public List<InteresesModel> getIntereses() {
    return this.intereses;
  }

  public void setIntereses(List<InteresesModel> intereses) {
    this.intereses = intereses;
  }

}
