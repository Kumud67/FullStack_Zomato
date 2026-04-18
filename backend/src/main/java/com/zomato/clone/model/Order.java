package com.zomato.clone.model;

import jakarta.persistence.*;
import io.swagger.v3.oas.annotations.media.Schema;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import java.time.LocalDateTime;
import java.util.List;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "orders")
@Schema(description = "Order entity representing a customer order")
public class Order {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Schema(description = "Unique identifier for the order", example = "1")
    private Long id;

    @Schema(description = "ID of the restaurant", example = "1")
    private Long restaurantId;

    @Schema(description = "Total order amount in rupees", example = "599.0")
    private Double totalAmount;

    @Schema(description = "Status of the order", example = "PENDING", allowableValues = {"PENDING", "CONFIRMED", "DELIVERED"})
    private String status;

    @Schema(description = "Order placement timestamp", example = "2024-04-18T10:30:00")
    private LocalDateTime orderDate;

    @ElementCollection
    @Schema(description = "List of items in the order")
    private List<OrderItem> items;

    @PrePersist
    protected void onCreate() {
        orderDate = LocalDateTime.now();
        status = "PENDING";
    }
}
