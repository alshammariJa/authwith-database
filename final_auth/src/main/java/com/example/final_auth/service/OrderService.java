package com.example.final_auth.service;

import com.example.final_auth.model.Order;
import com.example.final_auth.repository.OrderRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@AllArgsConstructor

public class OrderService {
    private final OrderRepository orderRepository;
     public List<Order> getOrders(){
         return orderRepository.findAll();
     }

     public void addOrder(Order order){
       orderRepository.save(order);

     }
     public void updateOrder(Integer id , Integer order){
   Order order1= orderRepository.findOrderById(id);
  if(order1==null){
      return;
  }
     order1.setQuantity(order.getQuantity());
     order1.setTotalPrice(order.getTotalPrice());
     order1.setDateReceived(order.getDateReceived());
     order1.setStatus(order.getStatus());
       orderRepository.save(order);
     }

     public void removeOrder(Integer id){
         Order order1= orderRepository.findOrderById(id);
         if(order1==null){
             return;
         }
         orderRepository.deleteById(id);
     }

    public Object getAllOrders() {
        return null;
    }

    public Object getOrder(Integer id) {
        return null;
    }
}
