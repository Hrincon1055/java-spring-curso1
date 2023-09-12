package com.hr.repositorios;

import org.springframework.data.jpa.repository.JpaRepository;

import com.hr.modelos.ProductosModel;

public interface IProductoRepositorio extends JpaRepository<ProductosModel, Integer> {

}
