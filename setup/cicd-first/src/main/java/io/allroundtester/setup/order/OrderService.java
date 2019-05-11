package io.allroundtester.setup.order;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

/**
 * @author patrick
 * @date created on 2019-05-08
 **/
@Service
public class OrderService {
    private Double ZERO = 0.0;
    @Autowired
    private OrderRepo orderRepo;

    public List<Order> getOrders(){
        return orderRepo.findAll();
    }

    public Order getOrderById(Integer id){
        Optional<Order> orderOptional = orderRepo.findById(id);
        if(orderOptional.isPresent()){
            Order result = orderOptional.get();
            if(result.getTotalPrice()==null) {
                result.setTotalPrice(result.getPricePerUnit()*result.getQuantity());
            }
            return result;
        }else{
            throw new RuntimeException("Not Found!");
        }
    }

    public void save(Order order){
         orderRepo.save(order);
    }
}
