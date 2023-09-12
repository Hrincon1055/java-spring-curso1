package com.hr.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Primary;
import org.springframework.stereotype.Service;

import com.hr.modelos.CategoriaModel;
import com.hr.repositorios.ICategoriaRepositorio;

@Service
@Primary
public class CategoriaService {
  @Autowired
  private ICategoriaRepositorio repositorio;

  public List<CategoriaModel> listar() {
    return this.repositorio.findAll();
  }
}
