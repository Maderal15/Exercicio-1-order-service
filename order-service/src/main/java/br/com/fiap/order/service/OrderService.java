package br.com.fiap.order.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.fiap.order.exception.OrderNotFoundException;
import br.com.fiap.order.exception.UpdateException;
import br.com.fiap.order.model.OrderDTO;
import br.com.fiap.order.repository.OrderRepository;

@Service
public class OrderService {


    private OrderRepository orderRepository;

    @Autowired
    public OrderService(OrderRepository orderRepository){
        this.orderRepository = orderRepository;
    }

    public OrderDTO findById(Integer id) {

        OrderDTO orderDb = orderRepository.findById(id);

        if(orderDb == null){
        	 throw new OrderNotFoundException("Id não encontrado");	
        }

        return orderDb;
    }

    public OrderDTO save(OrderDTO orderDTO){
        if(orderDTO.getNome() == null || orderDTO.getNome().equals("")){
        	throw new OrderNotFoundException("Erro para cadastrar");	
        }

        return orderRepository.save(orderDTO);
    }


    public OrderDTO update(Integer id, OrderDTO orderDTO){
        if(orderDTO.getNome() == null || orderDTO.getNome().equals("")){
        	 throw new UpdateException("Erro para atualizar");
        }

        return orderRepository.update(id, orderDTO);
    }

    public OrderDTO delete(Integer id){
        return orderRepository.delete(id);
    }

}
