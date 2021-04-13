package com.example.demo.controladores;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.dto.DisciplinaDTO;
import com.example.demo.entidades.Disciplina;
import com.example.demo.servicos.ServicoDeDisciplinas;

@RestController
public class ControladorDisciplina {
	
	@Autowired
	private ServicoDeDisciplinas servicoDeDisciplinas;
	

	public ControladorDisciplina(ServicoDeDisciplinas servicoDeDisciplinas) {
		super();
		this.servicoDeDisciplinas = servicoDeDisciplinas;
	}


	@PostMapping("/v1/api/disciplinas")
	public ResponseEntity<Disciplina> adicionaDisciplina(@RequestBody DisciplinaDTO disciplinaDto){		
		return new ResponseEntity<Disciplina>(servicoDeDisciplinas.adicionaDisciplina(disciplinaDto),
				HttpStatus.CREATED);
	}

	@GetMapping("/v1/api/disciplinas")
	public ResponseEntity<List<Disciplina>> todasDisciplinas(){
		return new ResponseEntity<List<Disciplina>>(servicoDeDisciplinas.todasDisciplinas(), HttpStatus.OK);
	}
	
	@PostMapping("/v1/api/disciplinas/{id}")
	public ResponseEntity<Disciplina> verDisciplina(@PathVariable int id){
		try {
			return new ResponseEntity<Disciplina>(servicoDeDisciplinas.verDisciplina(id), HttpStatus.OK);
		}catch(Exception e) {
			return new ResponseEntity<Disciplina>(HttpStatus.NOT_FOUND);
		}
	}
	
	@PostMapping("/v1/api/disciplinas/{id}/nome")
	public ResponseEntity<Disciplina> atualizarNome(@PathVariable int id, @RequestBody DisciplinaDTO disciplinaDto){	
		return new ResponseEntity<Disciplina>(servicoDeDisciplinas.atualizarNome(id, disciplinaDto), HttpStatus.OK);
	}
	
	@PostMapping("/v1/api/disciplinas/{id}/nota")
	public ResponseEntity<Disciplina> atualizarNota(@PathVariable int id, @RequestBody DisciplinaDTO disciplinaDto){	
		return new ResponseEntity<Disciplina>(servicoDeDisciplinas.atualizarNota(id, disciplinaDto), HttpStatus.OK);
	}
	
	@DeleteMapping("/v1/api/disciplinas/{id}")
	public ResponseEntity<Disciplina> removerDisciplina(@PathVariable int id){
		try {
			return new ResponseEntity<Disciplina>(servicoDeDisciplinas.removerDisciplina(id), HttpStatus.OK);
		}catch(Exception e) {
			return new ResponseEntity<Disciplina>(HttpStatus.NOT_FOUND);
		}

	}

	@GetMapping("/v1/api/disciplinas/ranking")
	public ResponseEntity<List<Disciplina>> ranking(){
		return new ResponseEntity<List<Disciplina>>(servicoDeDisciplinas.ranking(), HttpStatus.OK);
	}
	
}
