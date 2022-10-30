package br.com.bancodio.v1.mapper;

import br.com.bancodio.v1.model.Cliente;
import br.com.bancodio.v1.model.request.ClienteRequest;
import lombok.AccessLevel;
import lombok.NoArgsConstructor;

import java.util.Objects;

@NoArgsConstructor(access = AccessLevel.PRIVATE)
public class ClienteMapper {

    public static String mapToNomeCliente(Cliente cliente) {
        return Objects.isNull(cliente) ? null : cliente.getNome();
    }

    public static Cliente mapToCliente(ClienteRequest clienteRequest) {
        return Cliente.builder().nome(clienteRequest.getNome()).build();
    }
}
