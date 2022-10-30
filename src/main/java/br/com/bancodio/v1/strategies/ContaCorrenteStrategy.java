package br.com.bancodio.v1.strategies;

import br.com.bancodio.v1.enuns.TipoDeContaEnum;
import br.com.bancodio.v1.model.Cliente;
import br.com.bancodio.v1.model.Conta;
import br.com.bancodio.v1.model.ContaCorrente;
import org.springframework.stereotype.Component;

@Component
public class ContaCorrenteStrategy implements ContaStrategy {

    @Override
    public boolean selecionaTipo(TipoDeContaEnum tipoDeContaEnum) {
        return TipoDeContaEnum.CONTA_CORRENTE.equals(tipoDeContaEnum);
    }

    @Override
    public Conta criaConta(Cliente cliente) {
        return new ContaCorrente(cliente);
    }
}
