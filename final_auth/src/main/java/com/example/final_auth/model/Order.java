package com.example.final_auth.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.Date;

@Getter
@Setter
@AllArgsConstructor
@Entity
@NoArgsConstructor
public class Order {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    private int quantity;
    private int totalPrice;
    private Date dateReceived;
    @Column(columnDefinition = "varchar(10) not null check (status='new' or status='inProgress' or status='completed')")
    private String status;

    @ManyToOne
    @JoinColumn(name = "user_id" , referencedColumnName = "id")
    @JsonIgnore
    private MyUser myUser;

    @ManyToOne
    @JoinColumn(name = "product_id" , referencedColumnName = "id")
    @JsonIgnore
    private Product product;

}

