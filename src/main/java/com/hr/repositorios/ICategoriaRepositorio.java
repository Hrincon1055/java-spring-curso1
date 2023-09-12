package com.hr.repositorios;

import org.springframework.data.jpa.repository.JpaRepository;

import com.hr.modelos.CategoriaModel;

public interface ICategoriaRepositorio extends JpaRepository<CategoriaModel, Integer> {

}
