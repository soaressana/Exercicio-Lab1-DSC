package com.example.demo.entidades;

public class Disciplina implements Comparable<Disciplina> {

	private int id;
	private String nome;
	private double nota;
	
	public Disciplina() {
		super();
	}	
	public Disciplina(int id, String nome, double nota) {
		super();
		this.id = id;
		this.nome = nome;
		this.nota = nota;
	}
	
	public int getId() {
		return id;
	}
	public String getNome() {
		return nome;
	}
	public void setNome(String nome) {
		this.nome = nome;
	}
	public double getNota() {
		return nota;
	}
	public void setNota(double nota) {
		this.nota = nota;
	}
	
	@Override
	public int compareTo(Disciplina OutraDisciplina) {
		if(this.nota > OutraDisciplina.getNota()) { 
			return -1; 
		}
		if (this.nota < OutraDisciplina.getNota()) { 
		  return 1; 
		} 
		return 0; 
	}
	
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + id;
		return result;
	}
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Disciplina other = (Disciplina) obj;
		if (id != other.id)
			return false;
		return true;
	}	
}
