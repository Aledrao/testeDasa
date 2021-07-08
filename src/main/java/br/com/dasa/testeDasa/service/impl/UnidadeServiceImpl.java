package br.com.dasa.testeDasa.service.impl;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.dasa.testeDasa.exception.DatabaseErrorException;
import br.com.dasa.testeDasa.model.Unidade;
import br.com.dasa.testeDasa.repository.UnidadeRepository;
import br.com.dasa.testeDasa.service.UnidadeService;

@Service
public class UnidadeServiceImpl implements UnidadeService {

	private static final Logger logger = LoggerFactory.getLogger(UnidadeServiceImpl.class.getName());

	@Autowired
	private UnidadeRepository unidadeRepository;

	@Override
	public List<Unidade> listaUnidades(Long idUnidade) throws DatabaseErrorException {
		try {
			List<Unidade> unidades = unidadeRepository.findByCodigoUnidade(idUnidade);
			logger.info(String.format("Unidades find with success"));
			return unidades;
		} catch (Exception e) {
			logger.error("Error to find unidade");
			throw new DatabaseErrorException("Error to find unidade", e);
		}
	}
}
