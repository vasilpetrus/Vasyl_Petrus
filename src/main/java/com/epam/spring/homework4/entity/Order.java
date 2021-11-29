package com.epam.spring.homework4.entity;

import com.epam.spring.homework4.dto.UserOrderDTO;
import lombok.Data;

import javax.persistence.*;
import java.util.List;

@Entity
@Table(name = "orders")
@Data
public class Order {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "id")
    private long id;

    @OneToMany(fetch = FetchType.LAZY)
    private List <Product> product;

    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "user_id", referencedColumnName = "id")
    private User user;

    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "user_order_id", referencedColumnName = "id")
    private UserOrder userOrder;

    @Column(name = "number")
    private String number;
}
