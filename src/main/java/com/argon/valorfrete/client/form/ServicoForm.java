package com.argon.valorfrete.client.form;

import javax.xml.bind.annotation.XmlElement;

import lombok.Getter;
import lombok.Setter;

@Setter
public class ServicoForm {

	@XmlElement(name = "Codigo")
	private String Codigo;

	@XmlElement(name = "Valor")
	private String Valor;

	@XmlElement(name = "ValorMaoPropria")
	private String ValorMaoPropria;

	@XmlElement(name = "PrazoEntrega")
	private String PrazoEntrega;

	@XmlElement(name = "ValorSemAdicionais")
	private String ValorSemAdicionais;

	@XmlElement(name = "ValorAvisoRecebimento")
	private String ValorAvisoRecebimento;

	@XmlElement(name = "ValorValorDeclarado")
	private String ValorValorDeclarado;

	@XmlElement(name = "EntregaDomiciliar")
	private String EntregaDomiciliar;

	@XmlElement(name = "EntregaSabado")
	private String EntregaSabado;

//	@XmlElement(name = "obsFim")
//	private String obsFim;

	@XmlElement(name = "Erro")
	private String Erro;

	@XmlElement(name = "MsgErro")
	private String MsgErro;

	@Override
	public String toString() {
		return String.format(
				"[ \n - Valor: %s \n - Prazo Entrega: %s \n - Valor sem adicionais: %s \n - Valor Mão Própria: %s \n - Valor Aviso Recebimento: %s \n - Entrega Domiciliar: %s \n - Entrega Sabado: %s \n - Erro: %s  \n - Código Erro: %s \n]",
				Valor, PrazoEntrega, ValorSemAdicionais, ValorMaoPropria, ValorAvisoRecebimento, EntregaDomiciliar,
				EntregaSabado, MsgErro, Erro);
	}
}
