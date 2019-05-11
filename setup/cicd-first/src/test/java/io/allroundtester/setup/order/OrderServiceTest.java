package io.allroundtester.setup.order;

import org.assertj.core.api.Assertions;
import org.assertj.core.util.Lists;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.context.TestConfiguration;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.context.annotation.Bean;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import java.util.List;
import java.util.Optional;

@RunWith(SpringJUnit4ClassRunner.class)
//@SpringBootTest
public class OrderServiceTest {

    @Autowired
    private OrderService orderService;

    @MockBean
    private OrderRepo mockedOrderRepo;

    @Before
    public void setup(){
        Order testOrder = Order.builder().id(1).product("testProduct").pricePerUnit(12.0).quantity(2)
                .build();
        Mockito.when(mockedOrderRepo.findById(1))
                .thenReturn(Optional.of(testOrder));
        Mockito.when(mockedOrderRepo.findAll()).thenReturn(Lists.newArrayList(testOrder));
    }
    @Test
    public void getOrders() {
        List<Order> orders= orderService.getOrders();
        Assertions.assertThat(orders.size()).isEqualTo(1);
    }

    @Test
    public void getOrderById() {
        Order actual = orderService.getOrderById(1);
        Assertions.assertThat(actual.getTotalPrice()).isEqualTo(24.0);
    }

    @Test
    public void save() {
    }

    @TestConfiguration
    static class OrderServiceConfig {

        @Bean
        public OrderService orderService() {
            return new OrderService();

        }
    }
}