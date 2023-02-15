package com.example.final_auth.service;

import com.example.final_auth.Advice.ApiExeption;
import com.example.final_auth.model.Product;
import com.example.final_auth.repository.ProductRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@AllArgsConstructor

public class ProductService {
    private final ProductRepository productRepository;
    public List<Product> getProduct(){
        return productRepository.findAll();
    }

    public void addProduct(Product product){
        productRepository.save(product);

    }
    public void updateProduct(Integer id ,Product product){
        Product product1= productRepository.findProductById(id);
        if(product1==null){
            return;
        }

        product1.setName(product.getName());
        product1.setPrice(product.getPrice());
        productRepository.save(product1);
    }

    public void removeProduct(Integer id){
        Product product1= productRepository.findProductById(id);
        if(product1==null){
            return;
        }
        productRepository.deleteById(id);
    }

    public Product getProductId(Integer id){
        Product product=productRepository.findProductById(id);
        if (product==null){
            throw new ApiExeption("product Not Found!");
        }
        return product;
    }



}
