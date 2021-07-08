package br.com.dasa.testeDasa.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import br.com.dasa.testeDasa.model.Unidade;

public interface UnidadeRepository extends JpaRepository<Unidade, Long> {

	List<Unidade> findByCodigoUnidade(Long codigoUnidade);
	
	Unidade save(Unidade unidade);
}
