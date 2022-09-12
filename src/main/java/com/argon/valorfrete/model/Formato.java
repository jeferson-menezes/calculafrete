package com.argon.valorfrete.model;

public enum Formato {

	CAIXA_PACOTE(1), ROLO_PRISMA(2),  ENVELOPE(3);

	private final int value;

	Formato(int i) {
		value = i;
	}
	
	public int getValue(){
		return value;
	}
}
	
