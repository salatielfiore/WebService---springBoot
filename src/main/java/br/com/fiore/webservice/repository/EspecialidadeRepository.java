package br.com.fiore.webservice.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import br.com.fiore.webservice.model.Especialidade;

public interface EspecialidadeRepository
	extends JpaRepository<Especialidade, Long>{

}
