package com.argon.valorfrete.client.form;

import lombok.Getter;
import lombok.Setter;

@Setter
@Getter
public class ServicoForm {

	private String Codigo;
	private String Valor;
	private String PrazoEntrega;
	private String ValorSemAdicionais;
	private String ValorMaoPropria;
	private String ValorAvisoRecebimento;
	private String ValorValorDeclarado;
	private String EntregaDomiciliar;
	private String EntregaSabado;
	private String obsFim;
	private String Erro;
	private String MsgErro;
}
