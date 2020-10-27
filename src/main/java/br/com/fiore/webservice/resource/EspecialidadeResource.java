package br.com.fiore.webservice.resource;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import br.com.fiore.webservice.model.Especialidade;
import br.com.fiore.webservice.repository.EspecialidadeRepository;

@RestController
@RequestMapping("/odonto")
public class EspecialidadeResource {
	
	@Autowired
	private EspecialidadeRepository especialidadeRepository;
	
	@GetMapping("/especialidades")
	public List<Especialidade> getEspecialidades(){
		return especialidadeRepository.findAll();
	}

}
