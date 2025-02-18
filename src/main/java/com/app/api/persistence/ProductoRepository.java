package com.app.api.persistence;

import java.util.List;
import java.util.Optional;

import com.app.api.domain.Product;
import com.app.api.persistence.mapper.ProductMapper;
import org.springframework.stereotype.Repository;

import com.app.api.domain.repository.ProductRepository;
import com.app.api.persistence.crud.ProductoCrudRepository;
import com.app.api.persistence.entity.Producto;

@Repository
public class ProductoRepository implements ProductRepository{
    private ProductoCrudRepository productoCrudRepository;
    private ProductMapper mapper;

    @Override
    public List<Product> getAll(){
        List<Producto> productos = (List<Producto>) productoCrudRepository.findAll();
        return mapper.toProducts(productos);
    }

    @Override
    public Optional<List<Product>> getByCategory(int categoryId) {
        List<Producto> productos = productoCrudRepository.findByIdCategoriaOrderByAsc(categoryId);
        return Optional.of(mapper.toProducts(productos));
    }

    @Override
    public Optional<List<Product>> getScarseProducts(int quantity) {
        Optional<List<Producto>> productos = productoCrudRepository.finByCantidadStockLessThanAndEstado(quantity, true);;
        return productos.map(prods -> mapper.toProducts(prods));
    }

    @Override
    public Optional<Product> getProduct(int productId) {
        return productoCrudRepository.findById(productId).map(producto -> mapper.toProduct(producto));
    }

    @Override
    public Product saveProduct(Product product) {
        Producto producto = mapper.toProducto(product);
        return mapper.toProduct(productoCrudRepository.save(producto));
    }

    @Override
    public void delete(int productId) {
        productoCrudRepository.deleteById(productId);
    }
}
