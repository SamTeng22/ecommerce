package com.samantha.ecommerce.repository;

import com.samantha.ecommerce.model.Order;
import com.samantha.ecommerce.model.User;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface OrderRepository extends JpaRepository<Order, Long> {
    List<Order> findByUserOrderByCreatedAtDesc(User user);
}
