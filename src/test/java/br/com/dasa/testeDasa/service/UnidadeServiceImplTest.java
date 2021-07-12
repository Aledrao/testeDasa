package br.com.dasa.testeDasa.service;

import static org.junit.Assert.assertThat;

import java.util.ArrayList;
import java.util.List;

import org.hamcrest.Matchers;
import org.junit.jupiter.api.Assertions;
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
import org.springframework.test.context.junit.jupiter.SpringExtension;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;
import org.springframework.web.servlet.view.json.MappingJackson2JsonView;

import br.com.dasa.testeDasa.model.Exame;
import br.com.dasa.testeDasa.model.Laboratorio;
import br.com.dasa.testeDasa.model.Unidade;
import br.com.dasa.testeDasa.repository.UnidadeRepository;
import br.com.dasa.testeDasa.service.impl.UnidadeServiceImpl;

@ExtendWith(SpringExtension.class)
@SpringBootTest
@AutoConfigureMockMvc
public class UnidadeServiceImplTest {

	@Autowired
	private MockMvc mockMvc;
	
	@Mock
	private UnidadeRepository unidadeRepository;
	
	@InjectMocks
	private UnidadeServiceImpl unidadeService;
	
	@BeforeEach
	public void setup() {
		mockMvc = MockMvcBuilders.standaloneSetup(unidadeService)
				.setCustomArgumentResolvers(new PageableHandlerMethodArgumentResolver())
				.setViewResolvers((s, locale) -> new MappingJackson2JsonView())
				.build();
	}
	
	@Test
	public void deveriaBuscarListaUnidade_sucesso() throws Exception {
		Laboratorio laboratorio = new Laboratorio();
		laboratorio.setCodigoLaboratorio(1L);
		laboratorio.setNomeLaboratorio("Dasa");
		
		Unidade unidade = new Unidade();
		unidade.setCodigoUnidade(1L);
		unidade.setNomeUnidade("Santo Amaro");
		unidade.setLaboratorio(laboratorio);
		
		List<Unidade> unidades = new ArrayList<>();
		unidades.add(unidade);
		
		Mockito.when(unidadeRepository.findByCodigoUnidade(1L)).thenReturn(unidades);
		
		List<Unidade> response = unidadeService.listaUnidades(1L);
			
		Assertions.assertNotNull(response);
		assertThat(response, Matchers.hasSize(1));
	}
}
