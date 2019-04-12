package br.com.fiap.order.model;

import java.math.BigDecimal;

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
public class OrderItem {

	@ApiModelProperty(notes = "id do item ordem", required = true)
    private int id;
	
	@ApiModelProperty( notes = "Nome do item", required = true)
    private String nome;
    
	@ApiModelProperty( notes = "Preço do item", required = true)
	private BigDecimal preco;

    
}
