package br.com.bancodio.v1.service;

import br.com.bancodio.v1.bd.ContaBd;
import br.com.bancodio.v1.mapper.ContaMapper;
import br.com.bancodio.v1.mapper.TransferenciaMapper;
import br.com.bancodio.v1.model.ListaDeContasResponse;
import br.com.bancodio.v1.model.request.ClienteRequest;
import br.com.bancodio.v1.model.request.ContaRequest;
import br.com.bancodio.v1.model.request.DepositoRequest;
import br.com.bancodio.v1.model.request.TransferenciaRequest;
import br.com.bancodio.v1.model.response.ContaResponse;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import static br.com.bancodio.v1.mapper.ClienteMapper.mapToCliente;
import static br.com.bancodio.v1.mapper.ContaMapper.mapToContaResponse;
import static br.com.bancodio.v1.mapper.ContaMapper.mapToListaDeContasResponse;
import static br.com.bancodio.v1.mapper.DepositoMapper.mapToDeposito;
import static br.com.bancodio.v1.mapper.TransferenciaMapper.mapToTransferencia;

@Service
@AllArgsConstructor
public class ContaService {
    private ContaBd contaBd;

    public ContaResponse buscarConta(ContaRequest contaRequest) {
        return mapToContaResponse(contaBd.getConta(contaRequest.getAgencia(), contaRequest.getNumeroDaConta()));
    }

    public void criarConta(ClienteRequest clienteRequest) {
        contaBd.criarConta(mapToCliente(clienteRequest), clienteRequest.getTipoDeConta());
    }

    public ListaDeContasResponse buscarContas() {
        return mapToListaDeContasResponse(contaBd.buscarContas());
    }

    public void depositar(DepositoRequest depositoRequest) {
        contaBd.depositar(mapToDeposito(depositoRequest));
    }

    public void transferir(TransferenciaRequest transferenciaRequest) {
        contaBd.transferir(mapToTransferencia(transferenciaRequest));
    }
}
