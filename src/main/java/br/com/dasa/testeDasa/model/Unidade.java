package br.com.dasa.testeDasa.model;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonBackReference;

import io.swagger.annotations.ApiModelProperty;

@Entity
@Table(name = "unidade")
public class Unidade implements Serializable {	
	
	public Unidade() {}	

	public Unidade(String nomeUnidade, Laboratorio laboratorio) {
		this.nomeUnidade = nomeUnidade;
		this.laboratorio = laboratorio;
	}

	private static final long serialVersionUID = -2490521582239004165L;
	
	@ApiModelProperty(value = "Código da unidade")
	@Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "cod_unidade")	
	private Long codigoUnidade;	
	
	@ApiModelProperty(value = "Nome da unidade")	
	@Column(name = "nome_unidade")
	private String nomeUnidade;
	
	@ApiModelProperty(value = "Laboratorio")
	@ManyToOne
	@JoinColumn(name = "cod_laboratorio", referencedColumnName = "cod_laboratorio", nullable = false)
	@JsonBackReference
	private Laboratorio laboratorio;

	public Long getCodigoUnidade() {
		return codigoUnidade;
	}

	public void setCodigoUnidade(Long codigoUnidade) {
		this.codigoUnidade = codigoUnidade;
	}

	public String getNomeUnidade() {
		return nomeUnidade;
	}

	public void setNomeUnidade(String nomeUnidade) {
		this.nomeUnidade = nomeUnidade;
	}

	public Laboratorio getLaboratorio() {
		return laboratorio;
	}

	public void setLaboratorio(Laboratorio laboratorio) {
		this.laboratorio = laboratorio;
	}

	@Override
	public String toString() {
		return "Unidade [codigoUnidade=" + codigoUnidade + ", nomeUnidade=" + nomeUnidade + ", laboratorio="
				+ laboratorio + "]";
	}	
}
