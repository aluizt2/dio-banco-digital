package br.com.bancodio.v1.model;

import br.com.bancodio.v1.enuns.TipoDeContaEnum;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;

@Data
@Builder
@AllArgsConstructor
public class Deposito {
    private int agencia;
    private int numeroDaConta;
    private Double valor;
    private TipoDeContaEnum tipoDeConta;
}
