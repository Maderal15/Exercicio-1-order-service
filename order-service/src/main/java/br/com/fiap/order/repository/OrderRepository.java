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
        
   /*     OrderDTO orderDTO = new OrderDTO();
        orderDTO.setId(1l);
        orderDTO.setNome("Danilo Maderal");
        orderDTO.setEmail("maderal@gmail.com");
        orderDTO.setShippingAddress("Avenida Paulista");
        
        List<OrderItem> orderItens = new ArrayList<>();
        OrderItem orderItem = new OrderItem();
        orderItem.setId(1l);
        orderItem.setNome("jogo");
        orderItem.setPreco(100);
        orderItens.add(orderItem);
        orderDTO.setOrderItens(orderItens);
        
        orderDTO.setPrecoTotal(100);
        
        Pagamento pagamento = new Pagamento();
        pagamento.setId(1l);
        pagamento.setIdTransacao("1a3a3a4a");
        pagamento.setValidadeCartao(LocalDate.now());
        pagamento.setNumeroCartao(1552254l);
        pagamento.setBandeira("Dinners");
        orderDTO.setPagamento(pagamento);
        
        orderDTO.setDataPedido(LocalDate.now());
        orderDTO.setStatus("A");
        
        orders.add(orderDTO);*/
        
        
    }

    public OrderDTO findById(Integer id) {
        return orders.stream().filter((orderDTO) -> orderDTO.getId().equals(id)).findFirst().orElse(null);
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
