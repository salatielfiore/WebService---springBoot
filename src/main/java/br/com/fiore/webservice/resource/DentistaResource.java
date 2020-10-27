package br.com.fiore.webservice.resource;

import java.util.List;
import java.util.Optional;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import br.com.fiore.webservice.model.Dentista;
import br.com.fiore.webservice.repository.DentistaRepository;

@RestController
@RequestMapping("/odonto")
public class DentistaResource {
	
	@Autowired
	private DentistaRepository dentistaRepository;
	
//	@Autowired
//	private FireBaseStorageService firebase;
	
	@GetMapping("/dentistas")
	public List<Dentista> getDentistas(){
		return dentistaRepository.findAll();
	}
	
	@GetMapping("/dentistas/{codigo}")
	public ResponseEntity<?> getDentista(@PathVariable Long codigo) {
		Optional<?> dentistaProcurado = dentistaRepository.findById(codigo);
		return dentistaProcurado.isPresent() ? 
				ResponseEntity.ok(dentistaProcurado.get()) : 
				ResponseEntity.notFound().build();
	}
	
	@PostMapping("/dentistas")
	@ResponseStatus(HttpStatus.CREATED)
	public Dentista gravar(@Valid @RequestBody Dentista dentista) {
		return dentistaRepository.save(dentista);
	}
	
//	@PostMapping("/upload")
//	public ResponseEntity<FileUploadUrl> gravarFoto(@RequestBody FileUpload file) {
//		
//		FileUploadUrl url = new FileUploadUrl(firebase.upload(file));
//		
//		// fazer um update no cadastro do dentista
//		
//		return ResponseEntity.ok(url);
//	}
	
	@DeleteMapping("/dentistas/{codigo}")
	@ResponseStatus(HttpStatus.NO_CONTENT)
	public void excluir(@PathVariable Long codigo) {
		dentistaRepository.deleteById(codigo);
	}
	
	@PutMapping("/dentistas")
	public void atualizar(@Valid @RequestBody Dentista dentista) {
		dentistaRepository.save(dentista);
	}
	
}
