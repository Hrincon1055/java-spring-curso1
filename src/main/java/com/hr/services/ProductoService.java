package com.hr.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Primary;
import org.springframework.stereotype.Service;

import com.hr.modelos.ProductosModel;
import com.hr.repositorios.IProductoRepositorio;

@Service
@Primary
public class ProductoService {
  @Autowired
  private IProductoRepositorio repositorio;

  public List<ProductosModel> listar() {
    return this.repositorio.findAll();
  }
}
