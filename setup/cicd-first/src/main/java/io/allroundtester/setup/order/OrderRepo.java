package io.allroundtester.setup.order;

import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

/**
 * @author patrick
 * @date created on 2019-05-08
 **/
public interface OrderRepo extends JpaRepository<Order,Integer> {

    List<Order> findByProduct(String product);
}
