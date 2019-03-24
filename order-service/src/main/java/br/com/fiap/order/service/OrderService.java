package br.com.fiap.order.service;

import br.com.fiap.order.model.OrderDTO;
import br.com.fiap.order.repository.OrderRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class OrderService {


    private OrderRepository orderRepository;

    @Autowired
    public OrderService(OrderRepository orderRepository){
        this.orderRepository = orderRepository;
    }
    
    public OrderDTO findById(Integer id) {
        return orderRepository.findById(id);
    }

    public OrderDTO save(OrderDTO orderDTO){
        return orderRepository.save(orderDTO);
    }


    public OrderDTO update(Integer id, OrderDTO orderDTO){
        return orderRepository.update(id, orderDTO);
    }

    public OrderDTO delete(Integer id){
        return orderRepository.delete(id);
    }

}
