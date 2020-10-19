package com.latihan.service;

import com.latihan.model.Product;

import java.util.Collection;

public interface ProductService {
    public abstract String createProduct(Product product);
    public abstract String updateProduct(Product product);
    public abstract String deleteProduct(long id);
    public abstract Collection<Product> findProducts();
    public abstract Product findProductById(long id);
}
