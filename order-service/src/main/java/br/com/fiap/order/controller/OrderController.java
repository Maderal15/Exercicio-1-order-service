package br.com.fiap.order.controller;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import br.com.fiap.order.model.OrderDTO;
import br.com.fiap.order.service.OrderService;
import lombok.extern.slf4j.Slf4j;

@Slf4j
@RestController
@RequestMapping(value = "/order", produces = "application/json")
public class OrderController {

    private OrderService orderService;

    @Autowired
    public OrderController(OrderService orderService){
        this.orderService = orderService;
    }


    @GetMapping("/{id}")
    public ResponseEntity<OrderDTO> findById(@PathVariable(value="id") Integer id){

        System.out.printf("findById %s", id);

        OrderDTO orderDTO = orderService.findById(id);

        return ResponseEntity.status(HttpStatus.OK).body(orderDTO);
    }

    @PostMapping
    public ResponseEntity save(@RequestBody @Valid OrderDTO orderDTO){

        orderDTO = orderService.save(orderDTO);

        return ResponseEntity.status(HttpStatus.CREATED).body("{ \"order\" : \"/order/"+orderDTO.getId()+ "\"}");
    }


    @PutMapping("/{id}")
    public ResponseEntity update(@PathVariable Integer id, @RequestBody @Valid OrderDTO orderDTO) {

        orderDTO = orderService.update(id,orderDTO);

        return ResponseEntity.status(HttpStatus.OK).body("{ \"order\" : \"/order/"+orderDTO.getId()+ "\"}");
    }


    @DeleteMapping("/{id}")
    public ResponseEntity<OrderDTO> delete(@PathVariable Integer id) {
        return new ResponseEntity<>(orderService.delete(id),HttpStatus.OK);
    }

 }
