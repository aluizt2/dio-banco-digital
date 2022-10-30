package br.com.bancodio.v1.model.request;

import br.com.bancodio.v1.enuns.TipoDeContaEnum;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;

import javax.validation.constraints.Min;
import javax.validation.constraints.NotNull;

@Data
@Builder
@AllArgsConstructor
public class TransferenciaRequest {
    @NotNull
    private int agencia;
    @NotNull
    private int numeroDaConta;
    @NotNull
    @Min(0)
    private Double valor;
    @NotNull
    private TipoDeContaEnum tipoDeContaOrigem;
    @NotNull
    private int agenciaDestino;
    @NotNull
    private int numeroDaContaDeDestino;
    @NotNull
    private TipoDeContaEnum tipoDeContaDestino;
}
