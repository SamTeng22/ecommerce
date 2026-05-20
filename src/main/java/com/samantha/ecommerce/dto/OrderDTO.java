package com.samantha.ecommerce.dto;

import lombok.Data;
import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.List;

@Data
public class OrderDTO {
    private Long id;
    private List<OrderItemDTO> items;
    private BigDecimal totalPrice;
    private String status;
    private LocalDateTime createdAt;
}
