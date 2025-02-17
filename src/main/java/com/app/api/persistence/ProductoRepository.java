package com.app.api.persistence;

import java.util.List;

import com.app.api.persistence.crud.ProductoCrudRepository;
import com.app.api.persistence.entity.Producto;

public class ProductoRepository {
    private ProductoCrudRepository productoCrudRepository;

    public List<Producto> getAll(){
        return (List<Producto>) productoCrudRepository.findAll();
    }

    public List<Producto> getByCategoria(int idCategoria){
        return productoCrudRepository.findByIdCategoriaOrderByAsc(idCategoria);
    }
}
