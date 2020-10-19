package com.latihan.controller;

import com.latihan.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.Map;

import com.latihan.model.Product;
import com.latihan.exception.ProductNotFoundException;


@RestController
//@CrossOrigin(origins = "http://192.168.1.100")
//@RequestMapping("")
public class ProductController {

    @Autowired
    private ProductService productService;

    private static final Logger logger = LoggerFactory.getLogger(ProductController.class);

    @RequestMapping(value = {"/hello", "/"})
    public String hello(@RequestParam(required = false, defaultValue = "") String name){
        logger.info("/hello is accessed.. (info)");
        return "Hello " + name;
    }

    // http://localhost:8080/hi?place=bandung&name=ryan
    @RequestMapping(value = "/hi")
    public String hi(@RequestParam(required = false, defaultValue = "") Map<String, String> requestParam){
        logger.info("/hi is accessed.. (info)");

        // Get the values from url
        String name = requestParam.get("name");
        String place = requestParam.get("place");

        if (name == null && place == null) {
            return "Hi there";
        } else if (name == null && place != null) {
            return "Hi there from " + place;
        } else if (name != null && place == null) {
            return "Hi " + name;
        } else {
            return "Hi " + name + " from " + place;
        }
    }

    @RequestMapping(value = "/products", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<?> findProducts(){
        logger.info("/products is accessed..");

        return new ResponseEntity<>(productService.findProducts(), HttpStatus.OK);
    }

    @RequestMapping(value = "/products/{id}", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<?> findProductById(@PathVariable long id){
        logger.info("/products/" + id + " is accessed..");

        // Find product
        Product product = productService.findProductById(id);

        // Exception handler
        if (product == null) {
            logger.info("product with id = " + id + " is not found");
            throw new ProductNotFoundException();
        }

        return new ResponseEntity<>(product, HttpStatus.OK);
    }

    @RequestMapping(value = "/add_product", method = RequestMethod.POST, produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<?> addProduct(@RequestBody Product product){
        logger.info("/add_product is accessed..");

        String result = productService.createProduct(product);
        return new ResponseEntity<>(result, HttpStatus.OK);
    }

    @RequestMapping(value = "/update_product", method = RequestMethod.PUT, produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<?> updateProduct(@RequestBody Product product) {
        String result  = productService.updateProduct(product);
        return new ResponseEntity<>(result, HttpStatus.OK);
    }

    @RequestMapping(value = "/delete_product/{id}", method = RequestMethod.DELETE)
    public ResponseEntity<?> deleteProduct(@PathVariable long id) {
        String result = productService.deleteProduct(id);
        return new ResponseEntity<>(result, HttpStatus.OK);
    }
}
