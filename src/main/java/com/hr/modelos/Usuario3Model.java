package com.hr.modelos;

import javax.validation.constraints.Email;
import javax.validation.constraints.NotEmpty;

public class Usuario3Model {
  @NotEmpty(message = "Esta vacío")
  private String username;
  @NotEmpty(message = "Esta vacío")
  @Email(message = "Ingresado no es valido")
  private String correo;
  @NotEmpty(message = "Esta vacío")
  private String password;

  private PaisModel paisId;

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

  public PaisModel getPaisId() {
    return this.paisId;
  }

  public void setPaisId(PaisModel paisId) {
    this.paisId = paisId;
  }
}
