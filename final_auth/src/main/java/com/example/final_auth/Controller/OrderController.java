package com.example.final_auth.Controller;

import com.example.final_auth.model.MyUser;
import com.example.final_auth.model.Order;
import com.example.final_auth.service.OrderService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.web.bind.annotation.*;

@RestController
@RequiredArgsConstructor
@RequestMapping("/api/v1/order")
public class OrderController {
    private final OrderService orderService;
    @GetMapping("/all-order")
    public ResponseEntity getAllorder(){
        return ResponseEntity.status(200).body(orderService.getAllOrders());
    }
    @GetMapping("/my-order")
    public ResponseEntity getMyorder(@AuthenticationPrincipal MyUser myUser){
        return ResponseEntity.status(200).body(orderService.getOrder(myUser.getId()));
    }
    @GetMapping("/{id}")
    public ResponseEntity getorderById(Integer id ){
        return ResponseEntity.status(200).body(orderService.getOrder(id));
    }
    @PostMapping("/add-blog")
    public ResponseEntity addBlog(@RequestBody @Valid Order order, @AuthenticationPrincipal MyUser myUser){
        orderService.addOrder(order);
        return ResponseEntity.status(201).body(("order Added"));
    }
    @PutMapping("/update/{id}")
    public ResponseEntity updateBlog(@RequestBody Integer order, Integer id){
        orderService.updateOrder(order,id);
        return ResponseEntity.status(200).body(("order Updated"));
    }
}
