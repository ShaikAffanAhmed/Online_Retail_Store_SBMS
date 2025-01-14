package com.app.order.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.app.order.entity.Order;

@Repository
public interface OrderRepository extends JpaRepository<Order, Integer> {

}
