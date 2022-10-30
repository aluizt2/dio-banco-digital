package br.com.bancodio.v1.annotationswagger;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

@Retention(RetentionPolicy.RUNTIME)
@Target(ElementType.METHOD)
@Operation(description = "API para gerenciar contas")
@ApiResponses(value = {
        @ApiResponse(responseCode = "200", description = "Retorno OK "),
        @ApiResponse(responseCode = "201", description = "Retorno CREATED "),
        @ApiResponse(responseCode = "404", description = "Conta não encontrada")
})
public @interface ContaSwagger {
}
