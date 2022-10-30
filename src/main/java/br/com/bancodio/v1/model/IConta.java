package br.com.bancodio.v1.model;

public interface IConta {
	
	void sacar(double valor);
	
	void depositar(double valor);
	
	void transferir(double valor, IConta contaDestino);
	
	void imprimirExtrato();

	boolean buscaConta(int agencia, int numeroDaConta);
}
