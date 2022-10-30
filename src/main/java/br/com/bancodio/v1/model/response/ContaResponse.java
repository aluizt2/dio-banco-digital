package br.com.bancodio.v1.model.response;

import com.fasterxml.jackson.annotation.JsonInclude;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;

@Data
@AllArgsConstructor
@Builder
@JsonInclude(JsonInclude.Include.NON_NULL)
public class ContaResponse {
    protected int agencia;
    protected int numero;
    protected double saldo;
    protected String nomeDoCliente;
}
