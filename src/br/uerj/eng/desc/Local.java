package br.uerj.eng.desc;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.LinkedList;
import java.util.List;

public class Local {
	private String bloco;
	private int numeroSala;
	private List<Disciplina> disciplinas;
	
	public Local(String bloco, int numeroSala) {
		this.bloco = bloco;
		this.numeroSala = numeroSala;
		this.disciplinas = new LinkedList<Disciplina>();
	}
	
	public String getBloco() {
		return bloco;
	}
	public void setBloco(String bloco) {
		this.bloco = bloco;
	}
	public int getNumeroSala() {
		return numeroSala;
	}
	public void setNumeroSala(int numeroSala) {
		this.numeroSala = numeroSala;
	}
	
	public List<Disciplina> getDisciplinas() {
		return disciplinas;
	}

	public void setDisciplinas(List<Disciplina> disciplinas) {
		this.disciplinas = disciplinas;
	}

	// IMPRIMIR SALVANDO EM ARQUIVO
    public void imprimir(){
    	Path caminhoLocal = Paths.get("Local.txt");
    	
    	String armazenaTexto1 = "--------------------------------------------------------------------\nBloco: " 
    	+ this.bloco + " - Número da Sala: " + this.numeroSala;
    	
    	String armazenaTexto2, armazenaTexto3, armazenaTexto4;
    	armazenaTexto2 = armazenaTexto3 = armazenaTexto4 = "";
        
    	if(this.disciplinas != null && this.disciplinas.size() != 0){
    		armazenaTexto2 = "\n\nDisciplina Cadastrada no Local:\n";
	        for(Disciplina d : this.disciplinas){
	            armazenaTexto3 += d.getNomeDisciplina() + "\n";
	        }
	    }else{
	        armazenaTexto4 = "\nNenhuma disciplina cadastrada neste Local";
	    }
    	
    	String textoCompleto = armazenaTexto1 + armazenaTexto2 + armazenaTexto3 + armazenaTexto4;
    	System.out.println(textoCompleto);
    	
    	byte[] textoEmByte = textoCompleto.getBytes();
	    
	    try{
	    	Files.write(caminhoLocal, textoEmByte);
	    }catch(IOException e){
	    	System.out.println("Erro ao escrever em arquivo.");
	    }
       
    }
	
}
