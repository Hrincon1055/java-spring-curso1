package com.hr.utils;

import java.io.File;
import java.io.IOException;

import org.springframework.web.multipart.MultipartFile;

public class Utilidades {
  private Utilidades() {
  }

  public static String guardarArchivo(MultipartFile multipar, String ruta) {
    if (Utilidades.validaImagen(multipar.getContentType()) == false) {
      return "NO";
    } else {
      long time = System.currentTimeMillis();
      String nombre = time + Utilidades.getExtencion(multipar.getContentType());
      try {
        File imageFile = new File(ruta + nombre);
        multipar.transferTo(imageFile);
        return nombre;
      } catch (IOException e) {
        return null;
      }
    }

  }

  public static boolean validaImagen(String mime) {
    boolean retorno = false;
    switch (mime) {
      case "image/jpeg":
        retorno = true;
        break;
      case "image/jpg":
        retorno = true;
        break;
      case "image/png":
        retorno = true;
        break;
      default:
        retorno = false;
        break;
    }
    return retorno;
  }

  public static String getExtencion(String mime) {
    String retorno = "";
    switch (mime) {
      case "image/jpeg":
        retorno = ".jpeg";
        break;
      case "image/jpg":
        retorno = ".jpg";
        break;
      case "image/png":
        retorno = ".png";
        break;
    }
    return retorno;
  }
}
