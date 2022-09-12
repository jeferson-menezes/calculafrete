package com.argon.valorfrete.client.dto;

import com.argon.valorfrete.model.Produto;

import lombok.Getter;

@Getter
public class ParamentrosDto {

	private final String nCdEmpresa;
	private final String sDsSenha;
	private final String nCdServico;
	private final String sCepOrigem;
	private final String sCepDestino;
	private final double nVlPeso;
	private final int nCdFormato;
	private final double nVlComprimento;
	private final double nVlAltura;
	private final double nVlLargura;
	private final double nVlDiametro;
	private final String sCdMaoPropria;
	private final double nVlValorDeclarado;
	private final String sCdAvisoRecebimento;
	private final String StrRetorno;

	public ParamentrosDto(String codigoEmpresa, String senhaEmpresa, Produto produto, String cepOrigem,
			String cepDestino) {

		nCdEmpresa = codigoEmpresa;
		sDsSenha = senhaEmpresa;
		nCdServico = produto.getCodigoServico().getCodigo();
		sCepOrigem = cepOrigem;
		sCepDestino = cepDestino;
		nVlPeso = produto.getPeso();
		nCdFormato = produto.getFormato().getValue();
		nVlComprimento = produto.getComprimento();
		nVlAltura = produto.getAltura();
		nVlLargura = produto.getLargura();
		nVlDiametro = produto.getDiametro();
		sCdMaoPropria = produto.getMaoPropria() ? "S" : "N";
		nVlValorDeclarado = produto.getValorDeclarado();
		sCdAvisoRecebimento = produto.getAvisoRecebimento() ? "S" : "N";
		this.StrRetorno = "xml";
	}
}
