package com.hr.componentes;

import org.springframework.core.convert.converter.Converter;
import org.springframework.lang.Nullable;
import org.springframework.stereotype.Component;

import com.hr.modelos.PaisModel;

@Component
public class ConvertirPaisId implements Converter<String, PaisModel> {

  @Override
  @Nullable
  public PaisModel convert(String source) {
    Integer id = Integer.valueOf(source);
    PaisModel datos = new PaisModel();
    datos.setId(id);
    return datos;
  }

}
