package br.com.bancodio.v1.mapper;

import br.com.bancodio.v1.model.Conta;
import br.com.bancodio.v1.model.ListaDeContasResponse;
import br.com.bancodio.v1.model.response.ContaResponse;
import lombok.AccessLevel;
import lombok.NoArgsConstructor;

import java.util.List;
import java.util.Objects;
import java.util.stream.Collectors;

@NoArgsConstructor(access = AccessLevel.PRIVATE)
public class ContaMapper {
    public static ContaResponse mapToContaResponse(Conta conta) {
        return ContaResponse.builder()
                .nomeDoCliente(ClienteMapper.mapToNomeCliente(conta.getCliente()))
                .agencia(conta.getAgencia())
                .numero(conta.getNumero())
                .saldo(conta.getSaldo())
                .build();
    }

    public static ListaDeContasResponse mapToListaDeContasResponse(List<Conta> listarContas) {
        return ListaDeContasResponse.builder()
                .contas(listarContas.stream()
                        .filter(Objects::nonNull).map(ContaMapper::mapToContaResponse).collect(Collectors.toList()))
                .build();
    }
}
