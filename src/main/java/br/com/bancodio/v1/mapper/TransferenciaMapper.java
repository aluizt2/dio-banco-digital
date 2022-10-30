package br.com.bancodio.v1.mapper;

import br.com.bancodio.v1.model.Transferencia;
import br.com.bancodio.v1.model.request.TransferenciaRequest;
import lombok.AccessLevel;
import lombok.NoArgsConstructor;

@NoArgsConstructor(access = AccessLevel.PRIVATE)
public class TransferenciaMapper {
    public static Transferencia mapToTransferencia(TransferenciaRequest transferenciaRequest) {
        return Transferencia.builder()
                .agencia(transferenciaRequest.getAgencia())
                .numeroDaConta(transferenciaRequest.getNumeroDaConta())
                .valor(transferenciaRequest.getValor())
                .tipoDeContaOrigem(transferenciaRequest.getTipoDeContaOrigem())
                .agenciaDestino(transferenciaRequest.getAgenciaDestino())
                .numeroDaContaDeDestino(transferenciaRequest.getNumeroDaContaDeDestino())
                .tipoDeContaDestino(transferenciaRequest.getTipoDeContaDestino())
                .build();
    }
}
