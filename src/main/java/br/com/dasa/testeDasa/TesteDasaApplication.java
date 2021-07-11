package br.com.dasa.testeDasa;

import java.util.Date;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import br.com.dasa.testeDasa.dto.HealthTesteDTO;
import br.com.dasa.testeDasa.model.Exame;
import br.com.dasa.testeDasa.model.Laboratorio;
import br.com.dasa.testeDasa.model.Unidade;
import br.com.dasa.testeDasa.repository.ExameRepository;
import br.com.dasa.testeDasa.repository.LaboratorioRepository;
import br.com.dasa.testeDasa.repository.UnidadeRepository;

@SpringBootApplication
@EnableJpaRepositories
@RestController
@RequestMapping("/")
public class TesteDasaApplication {
	
	@Autowired
	private LaboratorioRepository laboratorioRepository;
	
	@Autowired
	private ExameRepository exameRepository;
	
	@Autowired
	private UnidadeRepository unidadeRepository;
	
	public static void main(String[] args) {
		SpringApplication.run(TesteDasaApplication.class, args);		
	}

	@Bean
    public CommandLineRunner commandLineRunner() {
        return args -> {
        	
        	//Criação de laboratórios
        	Laboratorio laboratorioDois = new Laboratorio("Segundo laboratorio");
        	Laboratorio laboratorioTres = new Laboratorio("Terceiro laboratorio");
        	Laboratorio laboratorioQuatro = new Laboratorio("Quarto laboratorio");
        	Laboratorio laboratorioCinco = new Laboratorio("Quinto laboratorio");
        	Laboratorio laboratorioSeis = new Laboratorio("Sexto laboratorio");
        	Laboratorio laboratorioUm = new Laboratorio("Primeiro laboratorio");
        	
        	//Persistencia de laboratórios
        	laboratorioRepository.save(laboratorioUm);
        	laboratorioRepository.save(laboratorioDois);
        	laboratorioRepository.save(laboratorioTres);
        	laboratorioRepository.save(laboratorioQuatro);
        	laboratorioRepository.save(laboratorioCinco);
        	laboratorioRepository.save(laboratorioSeis);
        	
        	//Criação de exames
    		Exame exameUm = new Exame("Exame Um", laboratorioUm);
    		Exame exameDois = new Exame("Exame Dois", laboratorioDois);
    		Exame exameTres = new Exame("Exame Tres", laboratorioUm);
        	
    		//Persistencia de exames
        	exameRepository.save(exameUm);
        	exameRepository.save(exameDois);
        	exameRepository.save(exameTres);
        	
        	//Criação de unidades
        	Unidade unidadeUm = new Unidade("Unidade Um", laboratorioUm);
        	Unidade unidadeDois = new Unidade("Unidade Dois", laboratorioDois);
        	Unidade unidadeTres = new Unidade("Unidade Tres", laboratorioDois);
        	
        	//Persistencia de unidades
        	unidadeRepository.save(unidadeUm);
        	unidadeRepository.save(unidadeDois);
        	unidadeRepository.save(unidadeTres);
        };
	}
	
	 @GetMapping()
	    public HealthTesteDTO index() {
	        HealthTesteDTO healthTest = new HealthTesteDTO("Teste Dasa",
	        		"Bem-vindo ao teste da Dasa, desenvolvido por Alex Sandro de Almeida Souza", new Date());
	        return healthTest;
	    }
}
