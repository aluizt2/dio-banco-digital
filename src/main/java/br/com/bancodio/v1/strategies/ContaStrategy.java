package br.com.bancodio.v1.strategies;

import br.com.bancodio.v1.enuns.TipoDeContaEnum;
import br.com.bancodio.v1.model.Cliente;
import br.com.bancodio.v1.model.Conta;

public interface ContaStrategy {

    boolean selecionaTipo(TipoDeContaEnum tipoDeContaEnum);

    Conta criaConta(Cliente cliente);
}
