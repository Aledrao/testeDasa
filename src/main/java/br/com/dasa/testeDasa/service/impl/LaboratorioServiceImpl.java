package br.com.dasa.testeDasa.service.impl;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.dasa.testeDasa.exception.DatabaseErrorException;
import br.com.dasa.testeDasa.model.Laboratorio;
import br.com.dasa.testeDasa.repository.LaboratorioRepository;
import br.com.dasa.testeDasa.service.LaboratorioService;

@Service
public class LaboratorioServiceImpl implements LaboratorioService {
	
	private static final Logger logger = LoggerFactory.getLogger(LaboratorioServiceImpl.class.getName());

	@Autowired
	private LaboratorioRepository laboratorioRepository;
	
	@Override
	public List<Laboratorio> laboratorios(Long codigo) throws DatabaseErrorException {		
		try {		
		List<Laboratorio> laboratorios = laboratorioRepository.findByCodigoLaboratorio(codigo);
		logger.info(String.format("Laboratorios find with success"));
		return laboratorios;
		} catch (Exception e) {
			logger.error("Error to find laboratorio");
			throw new DatabaseErrorException("Error to find laboratorio", e);
		}
	}
}