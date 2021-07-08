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
import br.com.dasa.testeDasa.exception.DatabaseErrorException;
import br.com.dasa.testeDasa.exception.InvalidDataException;
import br.com.dasa.testeDasa.model.Unidade;
import br.com.dasa.testeDasa.service.impl.UnidadeServiceImpl;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;
import io.swagger.v3.oas.annotations.Parameter;

@RestController
@RequestMapping("unidade")
public class UnidadeController {

	private static final Logger logger = LoggerFactory.getLogger(UnidadeController.class);

	@Autowired
	private UnidadeServiceImpl unidadeService;	

	@ApiOperation(value = "Retorna uma lista de unidades")
	@ApiResponses(value = {
			@ApiResponse(code = 200, message = "listar as unidades disponiveis"),
			@ApiResponse(code = 500, message = "Foi gerada uma exceção"),
	})
	@GetMapping("listar/{id}")
	public ResponseEntity<?> listaUnidades(@Parameter(description = "id da unidade a ser encontrado") @PathVariable String id) throws DatabaseErrorException {
		try {
			logger.info(String.format("Find unidade: %s", id));
			Long codigoUnidade;

			if(StringUtils.isNumeric(id)) {
				codigoUnidade = Long.parseLong(id);
			} else {
				throw new InvalidDataException("Informe valor numerico");
			}
			
			List<Unidade> unidades = unidadeService.listaUnidades(codigoUnidade);
			return ResponseEntity.ok(unidades);
		} catch (Exception e) {
			return ResponseEntity.ok(new ErrorResponseDTO(e.getMessage()));
		}
	}
}
