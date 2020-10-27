package br.com.fiore.webservice.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import br.com.fiore.webservice.model.Dentista;

public interface DentistaRepository extends JpaRepository<Dentista, Long> {

	//* teste
	Dentista findByNome(String nome);
	Dentista findByCro(String cro);
	
}
