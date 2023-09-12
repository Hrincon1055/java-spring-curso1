package com.hr.configuration;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.ResourceHandlerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

@Configuration
public class Configuracion implements WebMvcConfigurer {
  @Value("${henry.valores.ruta_upload}")
  private String rutaUpload;

  // para configurar una carpeta de archivos debes configurar un apache para que
  // este comparta dichas imagenes, esto tambien puedes usuarlo para compartir
  // -todos los archivos de la carpeta static.
  @Override
  public void addResourceHandlers(ResourceHandlerRegistry registry) {

    // WebMvcConfigurer.super.addResourceHandlers((registry));
    // registry.addResourceHandler("/micarpetadeapache/**").addResourceLocations("file:
    // /mirutacompleta");
    /* C:/xampp/htdocs/upload */
    registry.addResourceHandler("/upload/**").addResourceLocations("file: " + this.rutaUpload);
  }
}
