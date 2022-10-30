package br.com.bancodio.v1.model;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;

import java.util.List;

@Data
@Builder
@AllArgsConstructor
public class Banco {
    private String nome;
    private List<Conta> contas;
}
