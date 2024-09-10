package com.app.cart.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.app.cart.entity.LineItem;

@Repository
public interface LineItemRepository extends JpaRepository<LineItem, Integer> {

}
