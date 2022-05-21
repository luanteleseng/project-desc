package br.uerj.eng.desc;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.StandardOpenOption;
import java.util.LinkedList;
import java.util.List;

public class Disciplina {
	private String nomeDisciplina;
	private Local local;
	private List<Aluno> alunos;

	public Disciplina(String nomeDisciplina) {
		this.nomeDisciplina = nomeDisciplina;
		this.alunos = new LinkedList<Aluno>();
	}
	
	public String getNomeDisciplina() {
		return nomeDisciplina;
	}

	public void setNomeDisciplina(String nomeDisciplina) {
		this.nomeDisciplina = nomeDisciplina;
	}
	
	public Local getLocal() {
		return local;
	}

	public void setLocal(Local local) {
		this.local = local;
	}	

	public List<Aluno> getAlunos() {
		return alunos;
	}

	public void setAlunos(List<Aluno> alunos) {
		this.alunos = alunos;
	}

	// IMPRIMIR SALVANDO EM ARQUIVO
    public void imprimir(){
    	Path caminhoDisciplina = Paths.get("Disciplina.txt");
    	
    	String armazenaTexto1 = "--------------------------------------------------------------------\nNome da Disciplina: " 
    	+ this.nomeDisciplina + "\n"; 		    
    	String armazenaTexto2, armazenaTexto3, armazenaTexto4, armazenaTexto5, armazenaTexto6;
    	armazenaTexto2 = armazenaTexto3 = armazenaTexto4 = armazenaTexto5 = armazenaTexto6 = "";
        
        if(this.local != null){
        	armazenaTexto2 = "Bloco: " + this.local.getBloco() + " - Número da Sala: " + this.local.getNumeroSala() + "\n\n";
        }else{
        	armazenaTexto3 = "Nenhum disciplina ministrada nesse local.";
        }
        
        if(this.alunos != null && this.alunos.size() != 0){
        	armazenaTexto4 = "Alunos participantes:\n";
            for(Aluno aluno : this.alunos){
            	armazenaTexto5 += aluno.getNomeAluno() + "\n";
            }
        }else{
            armazenaTexto6 = "Nenhum aluno cadastrado na disciplina.\n";
        }
        
        String textoCompleto = armazenaTexto1 + armazenaTexto2 + armazenaTexto3 + armazenaTexto4 + armazenaTexto5 + armazenaTexto6;
	    
	    byte[] textoEmByte = textoCompleto.getBytes();
	    
	    try{
	    	Files.write(caminhoDisciplina, textoEmByte, StandardOpenOption.CREATE, StandardOpenOption.APPEND);
	    }catch(IOException e){
	    	System.out.println("Erro ao escrever em arquivo.");
	    }
    }
}
