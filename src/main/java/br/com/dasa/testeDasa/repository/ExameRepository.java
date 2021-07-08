package br.com.dasa.testeDasa.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import br.com.dasa.testeDasa.model.Exame;

@Repository
public interface ExameRepository extends JpaRepository<Exame, Long> {

	List<Exame> findByCodigoExame(Long codigoExame);
	Exame save(Exame exame);
}
