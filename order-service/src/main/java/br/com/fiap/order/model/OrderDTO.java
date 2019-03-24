package br.com.fiap.order.model;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.List;

import lombok.AllArgsConstructor;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@EqualsAndHashCode
@NoArgsConstructor
@AllArgsConstructor
public class OrderDTO {

    private Integer id;
    private String nome;
    private String email;
    private String shippingAddress;
    private List<OrderItem> orderItens;
    private BigDecimal precoTotal;
    private Pagamento pagamento;
    private LocalDate dataPedido;
    private String status;

}
