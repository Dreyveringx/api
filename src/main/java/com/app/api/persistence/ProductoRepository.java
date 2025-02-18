package com.app.api.persistence;

import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Repository;

import com.app.api.domain.repository.ProductRepository;
import com.app.api.persistence.crud.ProductoCrudRepository;
import com.app.api.persistence.entity.Producto;

@Repository
public class ProductoRepository implements ProductRepository{
    private ProductoCrudRepository productoCrudRepository;

    public List<Producto> getAll(){
        return (List<Producto>) productoCrudRepository.findAll();
    }

    public List<Producto> getByCategoria(int idCategoria){
        return productoCrudRepository.findByIdCategoriaOrderByAsc(idCategoria);
    }

    public Optional<List<Producto>> getEscasos(int cantidad){
        return productoCrudRepository.finByCantidadStockLessThanAndEstado(cantidad, true);
    }

    public Optional<Producto> getProducto(int idProducto){
        return productoCrudRepository.findById(idProducto);
    }

    public Producto save(Producto producto){
        return productoCrudRepository.save(producto);
    }

    public void delete(int idProducto){
        productoCrudRepository.deleteById(idProducto);
    }
}
