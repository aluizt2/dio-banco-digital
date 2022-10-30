package br.com.bancodio.v1.strategies;

import br.com.bancodio.v1.enuns.TipoDeContaEnum;
import br.com.bancodio.v1.exceptions.GenericException;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@AllArgsConstructor
public class StrategyService {
    private List<ContaStrategy> strategies;

    public ContaStrategy buscaStrategy(TipoDeContaEnum tipoDeContaEnum) {
        return strategies.stream()
                .filter(conta -> conta.selecionaTipo(tipoDeContaEnum))
                .findFirst()
                .orElseThrow(() -> new GenericException("Tipo de conta invalido", HttpStatus.BAD_REQUEST));
    }
}
