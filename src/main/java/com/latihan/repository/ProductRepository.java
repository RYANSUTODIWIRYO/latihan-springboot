package com.latihan.repository;

import com.latihan.model.Product;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.transaction.annotation.Transactional;

import java.math.BigDecimal;
import java.util.List;

// <Entity, ID>
// By extending CrudRepository,
// ProductRepository inherits several methods for working with Product persistence,
// including methods for saving, deleting, and finding Product entities.
public interface ProductRepository extends CrudRepository<Product, Long> {

    List<Product> findAll();
    Product findById(long id);

    @Modifying
    @Transactional
    @Query(value =  "UPDATE product SET name = ?2, price = ?3 WHERE id = ?1", nativeQuery = true)
    int updateProduct(long id, String name, BigDecimal price);
}
