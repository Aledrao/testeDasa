package br.com.dasa.testeDasa.model;

import java.io.Serializable;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonManagedReference;

import io.swagger.annotations.ApiModelProperty;

@Entity
@Table(name = "laboratorio")
public class Laboratorio implements Serializable {
	
	public Laboratorio() {}

	public Laboratorio(String nomeLaboratorio) {
		this.nomeLaboratorio = nomeLaboratorio;
	}

	private static final long serialVersionUID = 8747813422267512477L;	

	@ApiModelProperty(value = "Código do laboratorio")
	@Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "cod_laboratorio")	
	private Long codigoLaboratorio;
	
	@ApiModelProperty(value = "Nome do laboratorio")
	@Column(name = "nome_laboratorio")
	private String nomeLaboratorio;
	
	@OneToMany(mappedBy = "laboratorio", cascade = CascadeType.MERGE)
	@JsonManagedReference
	private Set<Exame> exames;
	
	@OneToMany(mappedBy = "laboratorio", cascade = CascadeType.MERGE)
	@JsonManagedReference
	private Set<Unidade> unidades;

	public Long getCodigoLaboratorio() {
		return codigoLaboratorio;
	}

	public void setCodigoLaboratorio(Long codigoLaboratorio) {
		this.codigoLaboratorio = codigoLaboratorio;
	}

	public String getNomeLaboratorio() {
		return nomeLaboratorio;
	}

	public void setNomeLaboratorio(String nomeLaboratorio) {
		this.nomeLaboratorio = nomeLaboratorio;
	}

	public Set<Exame> getExames() {
		return exames;
	}

	public void setExames(Set<Exame> exames) {
		this.exames = exames;
	}

	public Set<Unidade> getUnidades() {
		return unidades;
	}

	public void setUnidades(Set<Unidade> unidades) {
		this.unidades = unidades;
	}

	@Override
	public String toString() {
		return "Laboratorio [codigoLaboratorio=" + codigoLaboratorio + ", nomeLaboratorio=" + nomeLaboratorio
				+ ", exames=" + exames + ", unidades=" + unidades + "]";
	}	
}
