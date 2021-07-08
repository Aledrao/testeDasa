package br.com.dasa.testeDasa.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import br.com.dasa.testeDasa.model.Laboratorio;

@Repository
public interface LaboratorioRepository extends JpaRepository<Laboratorio, Long> {
	
	List<Laboratorio> findByCodigoLaboratorio(Long codigoLaboratorio);
	
	Laboratorio save(Laboratorio laboratorio);
}
