package br.com.fiap.order.model;

import java.time.LocalDate;

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

    private Integer id;
    private String idTransacao;
    private Long numeroCartao;
    private LocalDate validadeCartao;
    private String bandeira;

}
