package br.com.dasa.testeDasa.service;

import java.util.List;

import br.com.dasa.testeDasa.exception.DatabaseErrorException;
import br.com.dasa.testeDasa.model.Unidade;

public interface UnidadeService {

	List<Unidade> listaUnidades(Long idUnidade) throws DatabaseErrorException;
}
