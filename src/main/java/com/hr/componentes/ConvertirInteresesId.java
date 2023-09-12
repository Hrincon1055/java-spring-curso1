package com.hr.componentes;

import org.springframework.core.convert.converter.Converter;
import org.springframework.lang.Nullable;
import org.springframework.stereotype.Component;

import com.hr.modelos.InteresesModel;

@Component
public class ConvertirInteresesId implements Converter<String, InteresesModel> {

  @Override
  @Nullable
  public InteresesModel convert(String source) {
    Integer id = Integer.valueOf(source);
    InteresesModel datos = new InteresesModel();
    datos.setId(id);
    return datos;
  }

}
