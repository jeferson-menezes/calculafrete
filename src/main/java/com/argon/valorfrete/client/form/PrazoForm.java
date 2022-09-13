package com.argon.valorfrete.client.form;

import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;

import lombok.Getter;
import lombok.Setter;

@Setter
@Getter
@XmlRootElement(name = "Servicos")
public class PrazoForm {

	@XmlElement(name = "cServico")
	private ServicoForm cServico;

	@Override
	public String toString() {
		return cServico.toString();
	}
}
