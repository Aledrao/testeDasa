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

import br.com.dasa.testeDasa.model.Exame;
import br.com.dasa.testeDasa.model.Laboratorio;
import br.com.dasa.testeDasa.service.impl.ExameServiceImpl;

@ExtendWith(SpringExtension.class)
@SpringBootTest
@AutoConfigureMockMvc
public class ExameControllerTest {

	private static final String EXAME = "/exame/";

	@Autowired
	private MockMvc mockMvc;

	@Autowired
	private ObjectMapper objectMapper;

	@Mock
	private ExameServiceImpl exameService;

	@InjectMocks
	private ExameController exameController;

	@BeforeEach
	public void setup() {
		mockMvc = MockMvcBuilders.standaloneSetup(exameController)
				.setCustomArgumentResolvers(new PageableHandlerMethodArgumentResolver())
				.setViewResolvers((s, locale) -> new MappingJackson2JsonView())
				.build();
	}

	@Test
	public void deveriaBuscarExames_Sucesso() throws Exception {
		Exame hemograma = new Exame();
		hemograma.setCodigoExame(1L);
		hemograma.setNomeExame("Hemograma");
		hemograma.setLaboratorio(laboratorios().get(0));

		List<Exame> exames = new ArrayList<>();
		exames.add(hemograma);

		Mockito.when(exameService.listaExames(1L)).thenReturn(exames);

		mockMvc.perform(get(EXAME + "listar/1")
				.contentType(MediaType.APPLICATION_JSON))
		.andExpect(status().isOk())
		.andDo(print())
		.andExpect(jsonPath("$[0].codigoExame", is(exames.get(0).getCodigoExame().intValue())))
		.andExpect(jsonPath("$[0].nomeExame", is(exames.get(0).getNomeExame())));

	}

	@Test
	public void deveriaLancarMessagemErroPorDadoIncorreto_Exception() throws Exception {
		mockMvc.perform(get(EXAME + "listar/T")
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
