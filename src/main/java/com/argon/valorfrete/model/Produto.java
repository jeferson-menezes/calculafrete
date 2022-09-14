package com.argon.valorfrete.model;

import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

import lombok.Getter;
import lombok.Setter;

/**
 * @author jeh
 *
 */
@Setter
@Getter
@Entity
public class Produto {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;

	@Enumerated(EnumType.STRING)
	private CodigoServico codigoServico;

	private double peso;
	private double comprimento;
	private double altura;
	private double largura;

	@Enumerated(EnumType.STRING)
	private Formato formato = Formato.ENVELOPE;
//	não usar pois é para Formato Rolo
	private double diametro = 0;

//	Indica se a encomenda será entregue com o serviço
//	adicional mão própria.
	private Boolean maoPropria = Boolean.FALSE;

	private double valorDeclarado = 0;

	private Boolean avisoRecebimento = Boolean.FALSE;

	public Produto() {
	}

	public Produto(CodigoServico codigoServico, double peso, double comprimento, double altura, double largura) {
		this.id = 1l;
		this.codigoServico = codigoServico;
		this.peso = peso;
		this.comprimento = comprimento;
		this.altura = altura;
		this.largura = largura;
	}

	@Override
	public String toString() {
		return String.format(
				"[ \n - Código Serviço: %s \n - Peso: %s \n - Comprimento: %s \n - Altura: %s \n - Largura: %s \n - Formato: %s \n - Diametro: %s \n - Mão Própria: %s \n - Valor Declarado: %s \n - Aviso Recebimento: %s \n]",
				codigoServico, peso, comprimento, altura, largura, formato, diametro, maoPropria, valorDeclarado,
				avisoRecebimento);
	}
}
