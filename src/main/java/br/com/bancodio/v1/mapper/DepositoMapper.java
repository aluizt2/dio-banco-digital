package br.com.bancodio.v1.mapper;

import br.com.bancodio.v1.model.Deposito;
import br.com.bancodio.v1.model.request.DepositoRequest;
import lombok.AccessLevel;
import lombok.NoArgsConstructor;

@NoArgsConstructor(access = AccessLevel.PRIVATE)
public class DepositoMapper {
    public static Deposito mapToDeposito(DepositoRequest depositoRequest) {
        return Deposito.builder()
                .valor(depositoRequest.getValor())
                .agencia(depositoRequest.getAgencia())
                .numeroDaConta(depositoRequest.getNumeroDaConta())
                .build();
    }
}
