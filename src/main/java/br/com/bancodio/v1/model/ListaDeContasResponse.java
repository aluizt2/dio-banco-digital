package br.com.bancodio.v1.model;

import br.com.bancodio.v1.model.response.ContaResponse;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;

import java.util.List;

@Data
@AllArgsConstructor
@Builder
public class ListaDeContasResponse {
    private List<ContaResponse> contas;
}
