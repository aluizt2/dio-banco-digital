package br.com.bancodio.v1.bd;

import br.com.bancodio.v1.enuns.TipoDeContaEnum;
import br.com.bancodio.v1.exceptions.GenericException;
import br.com.bancodio.v1.model.Cliente;
import br.com.bancodio.v1.model.Conta;
import br.com.bancodio.v1.model.Deposito;
import br.com.bancodio.v1.model.Transferencia;
import br.com.bancodio.v1.strategies.StrategyService;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

@Component
@AllArgsConstructor
public class ContaBd {

    private static List<Conta> contas = new ArrayList<>();
    private final StrategyService strategyService;

    public Conta getConta(int agencia, int numeroDaConta) {
        return contas.stream()
                .filter(Objects::nonNull)
                .filter(conta -> conta.buscaConta(agencia, numeroDaConta))
                .findFirst()
                .orElseThrow(() -> new GenericException("Conta não cadastrada", HttpStatus.NOT_FOUND));
    }

    public void criarConta(Cliente cliente, TipoDeContaEnum tipoDeContaEnum) {
        contas.add(strategyService.buscaStrategy(tipoDeContaEnum).criaConta(cliente));
    }

    public List<Conta> buscarContas() {
        return contas;
    }

    public void depositar(Deposito deposito) {
        getConta(deposito.getAgencia(), deposito.getNumeroDaConta()).depositar(deposito.getValor());
    }

    public void transferir(Transferencia transferencia) {
        if (validaSaldoDisponivel(transferencia)) {
            getConta(transferencia.getAgencia(), transferencia.getNumeroDaConta())
                    .transferir(
                            transferencia.getValor(),
                            getConta(transferencia.getAgenciaDestino(), transferencia.getNumeroDaContaDeDestino()));
        } else {
            throw new GenericException("Saldo insuficiente", HttpStatus.BAD_REQUEST);
        }
    }

    private boolean validaSaldoDisponivel(Transferencia transferencia) {
        Conta conta = getConta(transferencia.getAgencia(), transferencia.getNumeroDaConta());
        return conta.getSaldo() >= transferencia.getValor();
    }
}
