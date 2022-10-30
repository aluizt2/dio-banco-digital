package br.com.bancodio.v1.model.request;

import br.com.bancodio.v1.enuns.TipoDeContaEnum;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

@Data
@Builder
@AllArgsConstructor
public class ClienteRequest {
    @NotBlank
    private String nome;
    @NotNull
    private TipoDeContaEnum tipoDeConta;
}
