package com.coursework.demo.repository;

import com.coursework.demo.dto.OrderWithStatusDTO;
import com.coursework.demo.entity.Client;
import com.coursework.demo.entity.Order;
import com.coursework.demo.entity.enums.PaymentOption;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.test.context.jdbc.Sql;

import java.util.Arrays;
import java.util.List;

import static com.coursework.demo.entity.enums.CallStatus.ACCEPTED;
import static com.coursework.demo.entity.enums.CallStatus.DELIVERED;
import static com.coursework.demo.entity.enums.CallStatus.WAITING;
import static com.coursework.demo.entity.enums.PaymentOption.*;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;

@DataJpaTest
public class OrderRepositoryTest {

    @Autowired
    private OrderRepository orderRepository;

    @Test
    @Sql("/scripts/getOrdersAndCallStatusByClient.sql")
    public void testGetOrdersAndCallStatusByClient() {
        final Pageable pageable = PageRequest.of(0, 5);

        List<OrderWithStatusDTO> result = orderRepository.getOrdersAndCallStatusByClient(1L, pageable);

        assertFalse(result.isEmpty());
        assertEquals(getExpectedOrderWithStatusDto(), result);
    }

    private List<OrderWithStatusDTO> getExpectedOrderWithStatusDto() {
        Client client = Client.builder()
                .id(1L)
                .address("Main Street")
                .name("John")
                .phoneNumber("+380932930")
                .build();

        return Arrays.asList(
                OrderWithStatusDTO.builder()
                        .orderDTO(Order.builder()
                                .id(1L)
                                .bonus(3L)
                                .description("2 pizza")
                                .paymentOption(VISA)
                                .price(50L)
                                .client(client)
                                .build())
                        .callStatus(WAITING).build(),
                OrderWithStatusDTO.builder()
                        .orderDTO(Order.builder()
                                .id(2L)
                                .bonus(5L)
                                .description("beer")
                                .paymentOption(MASTERCARD)
                                .price(33L)
                                .client(client)
                                .build())
                        .callStatus(ACCEPTED).build(),
                OrderWithStatusDTO.builder()
                        .orderDTO(Order.builder()
                                .id(3L)
                                .bonus(77L)
                                .description("sushi")
                                .paymentOption(CASH)
                                .price(100L)
                                .client(client)
                                .build())
                        .callStatus(DELIVERED).build()
        );
    }

}
