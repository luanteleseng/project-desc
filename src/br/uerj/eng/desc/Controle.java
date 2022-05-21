package br.uerj.eng.desc;

import java.util.LinkedList;
import java.util.List;

public class Controle {
	
	private static List<Aluno> alunos;
	private static List<Disciplina> disciplinas;
	private static List<Local> locais;
	
	public static void main(String[] args) {
		
		alunos = new LinkedList<Aluno>();
		disciplinas = new LinkedList<Disciplina>();
		locais = new LinkedList<Local>();
		
		new Janela();
	}
	
	public void CadastrarDisciplina(String nomeDisciplina, String bloco, int numeroSala){
		Disciplina disciplina = new Disciplina(nomeDisciplina);
		Local local = new Local(bloco, numeroSala);
		disciplina.setLocal(local);
		local.getDisciplinas().add(disciplina);
		disciplinas.add(disciplina);
		locais.add(local);
	}
	
	public void CadastrarAluno(String nomeAluno, String nomeDisciplina1, String nomeDisciplina2, String nomeDisciplina3) throws Exception{
		Disciplina disciplina1 = disciplinas.stream().filter(x -> nomeDisciplina1.equals(x.getNomeDisciplina())).findAny().orElse(null);
		Disciplina disciplina2 = disciplinas.stream().filter(x -> nomeDisciplina2.equals(x.getNomeDisciplina())).findAny().orElse(null);
		Disciplina disciplina3 = disciplinas.stream().filter(x -> nomeDisciplina3.equals(x.getNomeDisciplina())).findAny().orElse(null);
		
		if(disciplina1 == null && disciplina2 == null && disciplina3 == null){
			throw new Exception("Disciplina não encontrada.");
		}
		
		Aluno aluno = new Aluno(nomeAluno);
		if (disciplina1 != null) {
			aluno.getDisciplinas().add(disciplina1);
			disciplina1.getAlunos().add(aluno);
		} if (disciplina2 != null) {
			aluno.getDisciplinas().add(disciplina2);
			disciplina2.getAlunos().add(aluno);
		} if (disciplina3 != null) {
			aluno.getDisciplinas().add(disciplina3);
			disciplina3.getAlunos().add(aluno);
		}
		
		alunos.add(aluno);
	}	
	
	public void ImprimirAlunos() {
		for(Aluno a : alunos) {
			a.imprimir();
		}
	}
	
	public void ImprimirDisciplinas() {
		for(Disciplina d : disciplinas) {
			d.imprimir();
		}
	}
}
