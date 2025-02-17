package com.app.api.persistence.crud;

import java.util.List;

import org.springframework.data.repository.CrudRepository;

import com.app.api.persistence.entity.Producto;

public interface ProductoCrudRepository extends CrudRepository<Producto, Integer> {
    List<Producto> findByIdCategoriaOrderByAsc(int idCategoria);

}
