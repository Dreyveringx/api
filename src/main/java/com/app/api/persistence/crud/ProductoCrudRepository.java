package com.app.api.persistence.crud;

import java.util.List;
import java.util.Optional;

import org.springframework.data.repository.CrudRepository;

import com.app.api.persistence.entity.Producto;

public interface ProductoCrudRepository extends CrudRepository<Producto, Integer> {
    List<Producto> findByIdCategoriaOrderByAsc(int idCategoria);
    Optional<List<Producto>> finByCantidadStockLessThanAndEstado(int cantidadStock, boolean estado);

}
