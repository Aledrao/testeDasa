package br.com.dasa.testeDasa.service;

import java.util.List;

import br.com.dasa.testeDasa.exception.DatabaseErrorException;
import br.com.dasa.testeDasa.model.Laboratorio;

public interface LaboratorioService {

	List<Laboratorio> laboratorios(Long codigo) throws DatabaseErrorException;
}
