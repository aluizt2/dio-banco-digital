package br.com.bancodio.v1.model;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;

@Data
@Builder
@AllArgsConstructor
public class Cliente {
    private String nome;
}
