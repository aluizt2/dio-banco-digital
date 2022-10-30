package br.com.bancodio.v1.model;

import br.com.bancodio.v1.enuns.TipoDeContaEnum;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;

@Data
@AllArgsConstructor
@Builder
public class Transferencia {
    private int agencia;
    private int numeroDaConta;
    private Double valor;
    private TipoDeContaEnum tipoDeContaOrigem;
    private int agenciaDestino;
    private int numeroDaContaDeDestino;
    private TipoDeContaEnum tipoDeContaDestino;
}
