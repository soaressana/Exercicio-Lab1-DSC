package com.example.demo.servicos;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.client.HttpClientErrorException;

import com.example.demo.dto.DisciplinaDTO;
import com.example.demo.entidades.Disciplina;

@Service
public class ServicoDeDisciplinas {
	
	private List<Disciplina> disciplinas;
	private int proximoId = 0;
	
	public ServicoDeDisciplinas() {
		super();
		disciplinas = new ArrayList<Disciplina>();
	}
	
	/*
	 * CADASTRO DE NOVA DISCIPLINA
	 * */
	public Disciplina adicionaDisciplina(DisciplinaDTO disciplinaDto) {
		Disciplina disciplina = new Disciplina(
				proximoId++,
				disciplinaDto.getNome(), 
				disciplinaDto.getNota()
		);
		disciplinas.add(disciplina);
		
		return disciplina;
	}

	/*
	 * ATUALIZAR NOME DA DISCIPLINA
	 * */
	public Disciplina atualizarNome(int id, DisciplinaDTO disciplinaDto) {
		if(!existeDisciplina(id)) {
			throw new HttpClientErrorException(HttpStatus.NOT_FOUND);
		}
		
		Disciplina rtn = new Disciplina();
		for(Disciplina disciplina : disciplinas) {
			if(disciplina.getId() == id) {
				disciplina.setNome(disciplinaDto.getNome());
				rtn = disciplina;
			}
		} 
		return rtn;
	}

	/*
	 * ATUALIZAR NOTA DA DISCIPLINA
	 * */
	public Disciplina atualizarNota(int id, DisciplinaDTO disciplinaDto) {
		if(!existeDisciplina(id)) {
			throw new HttpClientErrorException(HttpStatus.NOT_FOUND);
		}
		
		Disciplina rtn = new Disciplina();
		for(Disciplina disciplina : disciplinas) {
			if(disciplina.getId() == id) {
				disciplina.setNota(disciplinaDto.getNota());
				rtn = disciplina;
			}
		} 
		return rtn;
	}

	/*
	 * REMOVER DISCIPLINA
	 * */
	public Disciplina removerDisciplina(int id) {
		if(!existeDisciplina(id)) {
			throw new HttpClientErrorException(HttpStatus.NOT_FOUND);
		}
		
		Disciplina rtn = new Disciplina();
		for(Disciplina disciplina : disciplinas) {
			if(disciplina.getId() == id) {
				rtn = disciplina;
				disciplinas.remove(disciplina);
			}
		} 
		return rtn;
	}

	/*
	 * LISTAR TODAS AS DISCIPLINAS
	 * */
	public List<Disciplina> todasDisciplinas(){
		return disciplinas;
	}

	/*
	 * ORDENAR DISCIPLINA - RANKING
	 * */
	public List<Disciplina> ranking(){
		Collections.sort(disciplinas);
		return disciplinas;
	}

	/*
	 * VER DISCIPLINA DETERMINADA
	 * */
	public Disciplina verDisciplina(int id) {
		if(!existeDisciplina(id)) {
			throw new HttpClientErrorException(HttpStatus.NOT_FOUND);
		}
		
		Disciplina rtn = new Disciplina();
		for(Disciplina disciplina : disciplinas) {
			if(disciplina.getId() == id) {
				rtn = disciplina;
			}
		} 
		return rtn;
	}

	/*
	 * AUXILIAR QUE VERIFICAR A EXISTÊNCIA DE UM ID
	 * */
	public boolean existeDisciplina(int id) {
		for(Disciplina disciplina : disciplinas) {
			if(disciplina.getId() == id) {
				return true;
			}
		}
		return false;
	}

}
