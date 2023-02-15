package com.example.final_auth.Controller;

import com.example.final_auth.model.MyUser;
import com.example.final_auth.model.Product;
import com.example.final_auth.service.ProductService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.web.bind.annotation.*;

@RestController
@RequiredArgsConstructor
@RequestMapping("/api/v1/product")
public class ProductController {
    private final ProductService productService;

    @GetMapping("/all-product")
    public ResponseEntity getAllproduct(){
        return ResponseEntity.status(200).body(productService.getProduct());
    }
    @GetMapping("/my-product")
    public ResponseEntity getMyproduct(@AuthenticationPrincipal MyUser myUser){
        return ResponseEntity.status(200).body(productService.getProductId(myUser.getId()));
    }
    @GetMapping("/{id}")
    public ResponseEntity getProductById(Integer id ){
        return ResponseEntity.status(200).body(productService.getProductId(id));
    }
    @PostMapping("/add")
    public ResponseEntity add(@RequestBody @Valid Product product, @AuthenticationPrincipal MyUser myUser){
        productService.addProduct(product,myUser.getId());
        return ResponseEntity.status(201).body(("product Added"));
    }
    @PutMapping("/update/{id}")
    public ResponseEntity updateBlog(@RequestBody @Valid Product product, Integer id){
        productService.updateProduct(product,id);
        return ResponseEntity.status(200).body(("product Updated"));
    }
    @PutMapping("/delete/{id}")
    public ResponseEntity delete( Integer id){
        productService.removeProduct(id);
        return ResponseEntity.status(200).body(("product deletes"));
    }
}