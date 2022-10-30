package br.com.bancodio.v1.controller;

import br.com.bancodio.v1.annotationswagger.ContaSwagger;
import br.com.bancodio.v1.model.ListaDeContasResponse;
import br.com.bancodio.v1.model.request.ClienteRequest;
import br.com.bancodio.v1.model.request.ContaRequest;
import br.com.bancodio.v1.model.request.DepositoRequest;
import br.com.bancodio.v1.model.request.TransferenciaRequest;
import br.com.bancodio.v1.model.response.ContaResponse;
import br.com.bancodio.v1.service.ContaService;
import io.swagger.annotations.Api;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import javax.ws.rs.BeanParam;

@RestController
@RequestMapping("/v1/contas")
@AllArgsConstructor
@Api(tags = "Contas")
public class ContaController {

    private final ContaService contaService;

    @GetMapping("/agencia/{agencia}/conta/{numeroDaConta}")
    @ResponseStatus(HttpStatus.OK)
    @ContaSwagger
    public ContaResponse buscaConta(@Valid @BeanParam ContaRequest contaRequest) {
        return contaService.buscarConta(contaRequest);
    }

    @GetMapping
    @ResponseStatus(HttpStatus.OK)
    @ContaSwagger
    public ListaDeContasResponse buscaContas() {
        return contaService.buscarContas();
    }

    @PostMapping()
    @ResponseStatus(HttpStatus.CREATED)
    @ContaSwagger
    public void criarConta(@Valid @RequestBody ClienteRequest clienteRequest) {
        contaService.criarConta(clienteRequest);
    }

    @PostMapping("/deposito")
    @ResponseStatus(HttpStatus.CREATED)
    @ContaSwagger
    public void depositar(@Valid @RequestBody DepositoRequest depositoRequest) {
        contaService.depositar(depositoRequest);
    }

    @PostMapping("/transferencia")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    @ContaSwagger
    public void transferir(@Valid @RequestBody TransferenciaRequest transferenciaRequest) {
        contaService.transferir(transferenciaRequest);
    }
}
