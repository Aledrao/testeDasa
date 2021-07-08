package br.com.dasa.testeDasa.controller;

import static org.hamcrest.CoreMatchers.is;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import java.util.ArrayList;
import java.util.List;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.data.web.PageableHandlerMethodArgumentResolver;
import org.springframework.http.MediaType;
import org.springframework.test.context.junit.jupiter.SpringExtension;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;
import org.springframework.web.servlet.view.json.MappingJackson2JsonView;

import com.fasterxml.jackson.databind.ObjectMapper;

import br.com.dasa.testeDasa.model.Laboratorio;
import br.com.dasa.testeDasa.service.impl.LaboratorioServiceImpl;

@ExtendWith(SpringExtension.class)
@SpringBootTest
@AutoConfigureMockMvc
public class LaboratorioControllerTest {

	private static final String LABORATORIO = "/laboratorio/";

	@Autowired
	private MockMvc mockMvc;

	@Autowired
	private ObjectMapper objectMapper;

	@Mock
	private LaboratorioServiceImpl laboratorioService;

	@InjectMocks
	private LaboratorioController laboratorioController;

	@BeforeEach
	public void setup() {
		mockMvc = MockMvcBuilders.standaloneSetup(laboratorioController)
				.setCustomArgumentResolvers(new PageableHandlerMethodArgumentResolver())
				.setViewResolvers((s, locale) -> new MappingJackson2JsonView())
				.build();
	}

	@Test
	public void deveriaBuscarLaboratorios_Sucesso() throws Exception {

		List<Laboratorio> laboratorios = new ArrayList<>();
		laboratorios.add(laboratorios().get(1));

		Mockito.when(laboratorioService.laboratorios(1L)).thenReturn(laboratorios);

		mockMvc.perform(get(LABORATORIO + "listar/1")
				.contentType(MediaType.APPLICATION_JSON))
		.andExpect(status().isOk())
		.andDo(print())
		.andExpect(jsonPath("$[0].codigoLaboratorio", is(laboratorios.get(0).getCodigoLaboratorio().intValue())))
		.andExpect(jsonPath("$[0].nomeLaboratorio", is(laboratorios.get(0).getNomeLaboratorio())));

	}

	@Test
	public void deveriaLancarMessagemErroPorDadoIncorreto_Exception() throws Exception {
		mockMvc.perform(get(LABORATORIO + "listar/T")
				.contentType(MediaType.APPLICATION_JSON))
		.andExpect(status().isOk())
		.andDo(print())
		.andExpect(jsonPath("$.errorMessage", is("Informe valor numerico")));

	}

	private List<Laboratorio> laboratorios() {
		Laboratorio delbone = new Laboratorio();
		delbone.setCodigoLaboratorio(1L);
		delbone.setNomeLaboratorio("Delbone");

		Laboratorio lavoisier = new Laboratorio();
		lavoisier.setCodigoLaboratorio(2L);
		lavoisier.setNomeLaboratorio("Lavoisier");

		List<Laboratorio> laboratorios = new ArrayList<>();
		laboratorios.add(delbone);
		laboratorios.add(lavoisier);

		return laboratorios;
	}
}
