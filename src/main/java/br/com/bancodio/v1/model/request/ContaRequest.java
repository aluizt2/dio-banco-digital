package br.com.bancodio.v1.model.request;

import lombok.AllArgsConstructor;
import lombok.Data;

import javax.validation.constraints.NotNull;

@Data
@AllArgsConstructor
public class ContaRequest {
    @NotNull
    private int agencia;
    @NotNull
    private int numeroDaConta;
}
