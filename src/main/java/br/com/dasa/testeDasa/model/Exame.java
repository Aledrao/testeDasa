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
@Table(name = "exame")
public class Exame implements Serializable {
	
	public Exame() {}	

	public Exame(String nomeExame, Laboratorio laboratorio) {
		this.nomeExame = nomeExame;
		this.laboratorio = laboratorio;
	}

	private static final long serialVersionUID = -7668896135109098738L;	

	@ApiModelProperty(value = "Código do exame")
	@Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "cod_exame")	
	private Long codigoExame;	
	
	@ApiModelProperty(value = "Nome do exame")
	@Column(name = "nome_exame", nullable = false)
	private String nomeExame;
	
	@ApiModelProperty(value = "Laboratorio")
	@ManyToOne
	@JoinColumn(name = "cod_laboratorio", referencedColumnName = "cod_laboratorio", nullable = false)
	@JsonBackReference
	private Laboratorio laboratorio;

	public Long getCodigoExame() {
		return codigoExame;
	}

	public void setCodigoExame(Long codigoExame) {
		this.codigoExame = codigoExame;
	}

	public String getNomeExame() {
		return nomeExame;
	}

	public void setNomeExame(String nomeExame) {
		this.nomeExame = nomeExame;
	}

	public Laboratorio getLaboratorio() {
		return laboratorio;
	}

	public void setLaboratorio(Laboratorio laboratorio) {
		this.laboratorio = laboratorio;
	}

	@Override
	public String toString() {
		return "Exame [codigoExame=" + codigoExame + ", nomeExame=" + nomeExame + ", laboratorio=" + laboratorio + "]";
	}	
}
