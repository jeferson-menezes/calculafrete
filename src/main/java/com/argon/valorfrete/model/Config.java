package com.argon.valorfrete.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

import lombok.Getter;
import lombok.Setter;

@Setter
@Getter
@Entity
public class Config {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	private String codigoEmpresa;
	private String senhaEmpresa;

	public Config() {
	}

	public Config(Long id, String codigoEmpresa, String senhaEmpresa) {

		this.id = id;
		this.codigoEmpresa = codigoEmpresa;
		this.senhaEmpresa = senhaEmpresa;
	}

	@Override
	public String toString() {
		return String.format("[ Código: %s - Senha: %s ]", codigoEmpresa, senhaEmpresa);
	}
}
