package br.com.fiap.order.model;

import java.time.LocalDate;

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
public class Pagamento {

	@ApiModelProperty(notes = "Id do Pagamento", required = true)
    private Integer id;
	
	@ApiModelProperty( notes = "Id da Transação", required = true)
    private String idTransacao;
	
	@ApiModelProperty( notes = "Número do cartão de crédito", required = true)
    private Long numeroCartao;
	
	@ApiModelProperty( notes = "Data de validade do cartão de crédito", required = true)
    private LocalDate validadeCartao;
	
	@ApiModelProperty( notes = "Bandeira", required = true)
    private String bandeira;

}
