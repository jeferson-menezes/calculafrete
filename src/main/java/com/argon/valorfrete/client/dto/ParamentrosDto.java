package com.argon.valorfrete.client.dto;

import com.argon.valorfrete.model.Produto;

import lombok.Getter;

@Getter
public class ParamentrosDto {

	private String nCdEmpresa;
	private String sDsSenha;
	private String nCdServico;
	private String sCepOrigem;
	private String sCepDestino;
	private double nVlPeso;
	private int nCdFormato;
	private double nVlComprimento;
	private double nVlAltura;
	private double nVlLargura;
	private double nVlDiametro;
	private String sCdMaoPropria;
	private double nVlValorDeclarado;
	private String sCdAvisoRecebimento;

	public ParamentrosDto(String codigoEmpresa, String senhaEmpresa, Produto produto, String cepOrigem, String cepDestino) {

		nCdEmpresa = codigoEmpresa;
		sDsSenha = senhaEmpresa;
		nCdServico = produto.getCodigoServico().getCodigo();
		sCepOrigem = cepOrigem;
		sCepDestino = cepDestino;
		nVlPeso = produto.getPeso();
		nCdFormato = produto.getFormato().getValue();
		nVlComprimento = produto.getComprimento();
		nVlDiametro = produto.getDiametro();
		sCdMaoPropria = produto.getMaoPropria() ? "S" : "N";
		nVlValorDeclarado = produto.getValorDeclarado();
		sCdAvisoRecebimento = produto.getAvisoRecebimento() ? "S" : "N";
	}
}
