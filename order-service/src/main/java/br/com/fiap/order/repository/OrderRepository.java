package br.com.fiap.order.repository;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Repository;

import br.com.fiap.order.model.OrderDTO;

@Repository
public class OrderRepository {

    private List<OrderDTO> orders;

    public OrderRepository(){
        orders = new ArrayList<>();
               
    }

    public OrderDTO findById(Integer id) {
       for (OrderDTO orderDTO : orders) {
    	   if(orderDTO.getId().equals(id)) {
    		   return orderDTO;
    	   }
		
       }
       
       return null;
	
    }


    public OrderDTO save(OrderDTO order){
    	order.setId((orders.size()+1));
        this.orders.add(order);
        return order;
    }


    public OrderDTO update(Integer id, OrderDTO order){
        OrderDTO orderDT = findById(id);
        int indice = orders.indexOf(orderDT);
        order.setId(orderDT.getId());
        orders.set(indice, order);
        return order;
    }

    public OrderDTO delete(Integer id){
        OrderDTO orderDT = findById(id);
        orders.remove(orderDT);
        return orderDT;
    }

}
