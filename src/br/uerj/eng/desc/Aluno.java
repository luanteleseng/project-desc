package br.uerj.eng.desc;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.StandardOpenOption;
import java.util.LinkedList;
import java.util.List;

public class Aluno {
	private String nomeAluno;
	private List<Disciplina> disciplinas;
	
	public Aluno(String nomeAluno) {
		this.nomeAluno = nomeAluno;
		this.disciplinas = new LinkedList<Disciplina>();
	}
	
	public String getNomeAluno() {
		return nomeAluno;
	}

	public void setNomeAluno(String nomeAluno) {
		this.nomeAluno = nomeAluno;
	}
	
	public List<Disciplina> getDisciplinas() {
		return disciplinas;
	}

	public void setDisciplinas(List<Disciplina> disciplinas) {
		this.disciplinas = disciplinas;
	}

	// IMPRIMIR	SALVANDO EM ARQUIVO
	public void imprimir(){ 
		Path caminhoAluno = Paths.get("Aluno.txt");
		
	    String armazenaTexto1 = "----------------------------------------------\nAluno: " 
	    + this.nomeAluno + "\n\nDisciplinas Cadastradas:\n";
	    // System.out.println(armazenaTexto1);
	    
	    String armazenaTexto2 = "";
	    String armazenaTexto3 = "";
	    
	    if(this.disciplinas != null && this.disciplinas.size() != 0){
	        for(Disciplina d : this.disciplinas){
	            // System.out.println(d.getNomeDisciplina());
	            armazenaTexto2 += d.getNomeDisciplina() + "\n";
	        }
	    }else{
	    	// System.out.println("Nenhuma disciplina cadastrada!");
	        armazenaTexto3 = "Nenhuma disciplina cadastrada!\n";
	    }
	    
	    String textoCompleto = armazenaTexto1 + armazenaTexto2 + armazenaTexto3;
	    
	    byte[] textoEmByte = textoCompleto.getBytes();
	    
	    try{
	    	Files.write(caminhoAluno, textoEmByte, StandardOpenOption.CREATE, StandardOpenOption.APPEND);
	    }catch(IOException e){
	    	System.out.println("Erro ao escrever em arquivo.");
	    }  
	}
}
