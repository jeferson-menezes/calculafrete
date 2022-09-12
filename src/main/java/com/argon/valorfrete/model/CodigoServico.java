package com.argon.valorfrete.model;

public enum CodigoServico {

	PAC_SEM_CONTRATO("41106"),
	SEDEX_SEM_CONTRATO("40010"), 
	SEDEX_A_COBRAR_SEM_CONTRATO("40045"),
	SEDEX_A_COBRAR_COM_CONTRATO("40126"), 
	SEDEX_10_SEM_CONTRATO("40215"),
	SEDEX_HOEJE_SEM_CONTRATO("40290"),
	SEDEX_COM_CONTRATO("40096"),
	E_SEDEX_COM_CONTRATO("81019"), 
	PAC_COM_CONTRATO("41068");

	private final String codigo;

	private CodigoServico(String codigo) {
		this.codigo = codigo;
	}

	public String getCodigo() {
		return codigo;
	}

}
