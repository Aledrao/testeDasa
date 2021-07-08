package br.com.dasa.testeDasa.service.impl;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.dasa.testeDasa.exception.DatabaseErrorException;
import br.com.dasa.testeDasa.model.Exame;
import br.com.dasa.testeDasa.repository.ExameRepository;
import br.com.dasa.testeDasa.service.ExameService;

@Service
public class ExameServiceImpl implements ExameService {
	
	private static final Logger logger = LoggerFactory.getLogger(ExameServiceImpl.class.getName());
	
	@Autowired
	private ExameRepository exameRepository;

	@Override
	public List<Exame> listaExames(Long codigoExame) throws Exception {
		try {
			List<Exame> exames = exameRepository.findByCodigoExame(codigoExame);
			logger.info("Exames find with success");
			return exames;
		} catch (Exception e) {
			logger.error("Error to find exame");
			throw new DatabaseErrorException("Error to find exame", e);
		}
		
	}
}
