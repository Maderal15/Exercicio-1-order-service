package br.com.fiap.order.model;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.List;

import io.swagger.annotations.ApiModelProperty;
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

	@ApiModelProperty(notes = "Id da ordem")
    private Integer id;

	@ApiModelProperty( notes = "Nome do usuário", required = true)
    private String nome;
	
	@ApiModelProperty( notes = "Email do usuásio", required = true)
    private String email;
    
    @ApiModelProperty( notes = "Endereço ond irá a ordem", required = true)
    private String shippingAddress;
    
    @ApiModelProperty( notes = "Lista de ordem", required = true)
    private List<OrderItem> orderItens;
    
    @ApiModelProperty( notes = "Preço total da ordem", required = true)
    private	BigDecimal precoTotal;
    
    @ApiModelProperty( notes = "Pagamento da ordem", required = true)
    private Pagamento pagamento;
    
    @ApiModelProperty( notes = "data do pedido ordem", required = true)
    private LocalDate dataPedido;
    
    @ApiModelProperty( notes = "status da ordem", required = true)
    private String status;
    

}
