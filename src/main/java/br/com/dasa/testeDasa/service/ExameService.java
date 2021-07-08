package br.com.dasa.testeDasa.service;

import java.util.List;

import br.com.dasa.testeDasa.model.Exame;

public interface ExameService {

	List<Exame> listaExames(Long codigoExame) throws Exception;
}
