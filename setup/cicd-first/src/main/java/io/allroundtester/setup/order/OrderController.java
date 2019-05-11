package io.allroundtester.setup.order;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

/**
 * @author patrick
 * @date created on 2019-05-08
 **/
@RestController
@RequestMapping("/order")
public class OrderController {
    @Autowired
    OrderService orderService;

    @GetMapping(value = "/{id}")
    public Order getOrderById(@PathVariable Integer id) {
        return orderService.getOrderById(id);
    }

    @PostMapping()
    public Order purchase(@RequestBody Order order) {
        orderService.save(order);
        return order;
    }
}
