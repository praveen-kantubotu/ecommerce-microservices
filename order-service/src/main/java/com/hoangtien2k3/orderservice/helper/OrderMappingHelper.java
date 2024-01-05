package com.hoangtien2k3.orderservice.helper;

import com.hoangtien2k3.orderservice.dto.CartDto;
import com.hoangtien2k3.orderservice.dto.OrderDto;
import com.hoangtien2k3.orderservice.entity.Cart;
import com.hoangtien2k3.orderservice.entity.Order;

public interface OrderMappingHelper {
    static OrderDto map(Order order) {
        if (order == null) return null;
        return OrderDto.builder()
                .orderId(order.getOrderId())
                .orderDate(order.getOrderDate())
                .orderDesc(order.getOrderDesc())
                .orderFee(order.getOrderFee())
                .cartDto(CartDto.builder()
                        .cartId(order.getCart().getCartId())
                        .userId(order.getCart().getUserId())
                        .build())
                .build();
    }

    static Order map(final OrderDto orderDto) {
        if (orderDto == null) return null;
        return Order.builder()
                .orderId(orderDto.getOrderId())
                .orderDate(orderDto.getOrderDate())
                .orderDesc(orderDto.getOrderDesc())
                .orderFee(orderDto.getOrderFee())
                .cart(Cart.builder()
                        .cartId(orderDto.getCartDto().getCartId())
                        .userId(orderDto.getCartDto().getUserId())
                        .build())
                .build();
    }
}
