package com.latihan.service;

import com.latihan.model.Product;
import com.latihan.repository.ProductRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Collection;

@Service
public class ProductServiceImpl implements ProductService{

    @Autowired
    ProductRepository productRepository;

    @Override
    public String createProduct(Product product) {
        try {
            productRepository.save(product);
            return "Product is created succesfully";
        } catch (Exception e) {
            System.out.println("Error : " + e);
            return "Failed to create product : " + e.getMessage();
        }
    }

    @Override
    public String updateProduct(Product product) {
        try {
            int result = productRepository.updateProduct(product.getId(), product.getName(), product.getPrice());
            System.out.println("ini lohhhh = " + result);

            // 0 means no transaction is done
            if (result == 0) return "Failed to update product : Invalid key or value";

            return "Product is updated succesfully";
        } catch (Exception e) {
            System.out.println("Error : " + e);
            return "Failed to update product : " + e.getMessage();
        }
    }

    @Override
    public String deleteProduct(long id) {
        try {
            productRepository.deleteById(id);
            return "Product is deleted succesfully";
        } catch (Exception e) {
            return "Failed to delete product = " + e.getMessage();
        }
    }

    @Override
    public Collection<Product> findProducts() {
        return productRepository.findAll();
    }

    @Override
    public Product findProductById(long id) {
        return productRepository.findById(id);
    }
}
