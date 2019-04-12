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
import org.springframework.web.bind.annotation.RestController;

import br.com.fiap.order.model.ExceptionResponse;
import br.com.fiap.order.model.OrderDTO;
import br.com.fiap.order.service.OrderService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;
import lombok.extern.slf4j.Slf4j;

@Slf4j
@RestController
@Api(value = "Order", description ="Order Service REST API")
@RequestMapping(value = "/order", produces = "application/json")
public class OrderController {

    private OrderService orderService;

    @Autowired
    public OrderController(OrderService orderService){
        this.orderService = orderService;
    }


    @ApiOperation(httpMethod = "GET", value = "Método get para buscar pedido filtrando por id")
    @ApiResponses(value = {
    		@ApiResponse(code = 200, message = "Retorna um OrderDTO",  response = OrderDTO.class),
    		@ApiResponse(code = 404, message = "Id não encontrado", response = ExceptionResponse.class)
    })		
    @GetMapping("/{id}")
    public ResponseEntity<OrderDTO> findById(@ApiParam(value = "Order Id", required= true) @PathVariable(value="id") Integer id){

        System.out.printf("findById %s", id);

        OrderDTO orderDTO = orderService.findById(id);

        return ResponseEntity.status(HttpStatus.OK).body(orderDTO);
    }

    @ApiOperation(httpMethod = "POST", value = "Método post para salvar um oder.")
    @ApiResponses(value = {
    		@ApiResponse(code = 201, message = "Retorna uma com uma mensagem  /order/?",  response = OrderDTO.class),
    		@ApiResponse(code = 404, message = "Nome não encontrado, erro para cadastrar.",  response = ExceptionResponse.class)
    })
    @PostMapping
    public ResponseEntity save(@RequestBody @Valid OrderDTO orderDTO){

        orderDTO = orderService.save(orderDTO);

        return ResponseEntity.status(HttpStatus.CREATED).body("{ \"order\" : \"/order/"+orderDTO.getId()+ "\"}");
    }
    
    @ApiOperation(httpMethod = "PUT", value = "Método put para atualizar um order filtrand por id.")
    @ApiResponses(value = {
    		@ApiResponse(code = 200, message = "Retorna uma com uma mensagem /order/?",  response = OrderDTO.class),
    		@ApiResponse(code = 400, message = "Erro para atualizar.",  response = ExceptionResponse.class)
    })
    @PutMapping("/{id}")
    public ResponseEntity update(@ApiParam(value = "Order Id", required= true) @PathVariable Integer id, @RequestBody @Valid OrderDTO orderDTO) {

        orderDTO = orderService.update(id,orderDTO);

        return ResponseEntity.status(HttpStatus.OK).body("{ \"order\" : \"/order/"+orderDTO.getId()+ "\"}");
    }

    @ApiOperation(httpMethod = "DELETE", value = "Método delete que deleta um order filtrand por id.")
    @ApiResponses(value = {
    		@ApiResponse(code = 200, message = "Retorna um OrderDTO",  response = OrderDTO.class)
    })
    @DeleteMapping("/{id}")
    public ResponseEntity<OrderDTO> delete(@ApiParam(value = "Order Id", required= true) @PathVariable Integer id) {
        return new ResponseEntity<>(orderService.delete(id),HttpStatus.OK);
    }

 }
