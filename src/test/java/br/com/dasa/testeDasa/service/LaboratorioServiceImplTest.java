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

import br.com.dasa.testeDasa.model.Laboratorio;
import br.com.dasa.testeDasa.repository.LaboratorioRepository;
import br.com.dasa.testeDasa.service.impl.LaboratorioServiceImpl;

@ExtendWith(SpringExtension.class)
@SpringBootTest
@AutoConfigureMockMvc
public class LaboratorioServiceImplTest {

	@Autowired
	private MockMvc mockMvc;
	
	@Mock
	private LaboratorioRepository laboratorioRepository;
	
	@InjectMocks
	private LaboratorioServiceImpl laboratorioService;
	
	@BeforeEach
	public void setup() {
		mockMvc = MockMvcBuilders.standaloneSetup(laboratorioService)
				.setCustomArgumentResolvers(new PageableHandlerMethodArgumentResolver())
				.setViewResolvers((s, locale) -> new MappingJackson2JsonView())
				.build();
	}
	
	@Test
	public void deveriaBuscarListaLaboratorio_sucesso() throws Exception {
		Laboratorio laboratorio = new Laboratorio();
		laboratorio.setCodigoLaboratorio(1L);
		laboratorio.setNomeLaboratorio("Dasa");		
				
		List<Laboratorio> laboratorios = new ArrayList<>();
		laboratorios.add(laboratorio);
		
		Mockito.when(laboratorioRepository.findByCodigoLaboratorio(1L)).thenReturn(laboratorios);
		
		List<Laboratorio> response = laboratorioService.laboratorios(1L);
			
		Assertions.assertNotNull(response);
		assertThat(response, Matchers.hasSize(1));
	}
}
