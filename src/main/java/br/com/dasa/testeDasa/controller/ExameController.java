package br.com.dasa.testeDasa.controller;

import java.util.List;

import org.apache.commons.lang3.StringUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import br.com.dasa.testeDasa.dto.ErrorResponseDTO;
import br.com.dasa.testeDasa.exception.InvalidDataException;
import br.com.dasa.testeDasa.model.Exame;
import br.com.dasa.testeDasa.service.impl.ExameServiceImpl;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;
import io.swagger.v3.oas.annotations.Parameter;

@RestController
@RequestMapping("exame")
public class ExameController {

	private static final Logger logger = LoggerFactory.getLogger(ExameController.class.getName());

	@Autowired
	private ExameServiceImpl exameService;

	@ApiOperation(value = "Retorna uma lista de Exames")
	@ApiResponses(value = {
			@ApiResponse(code = 200, message = " lista os exames disponiveis"),
			@ApiResponse(code = 500, message = "Foi gerada uma exceção"),
	})
	@GetMapping("listar/{id}")
	public ResponseEntity<?> listaExames(@Parameter(description = "id do exame a ser encontrado") @PathVariable String id)  {		
		try {
			logger.info(String.format("Find exame: %s", id));
			Long codigoExame;

			if(StringUtils.isNumeric(id)) {
				codigoExame = Long.parseLong(id);
			} else {
				throw new InvalidDataException("Informe valor numerico");
			}	

			List<Exame> exames = exameService.listaExames(codigoExame);
			return ResponseEntity.ok(exames);
		} catch (Exception e) {
			return ResponseEntity.ok(new ErrorResponseDTO(e.getMessage()));
		}
	}
}
