package br.uerj.eng.desc;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.*;

public class Janela extends JFrame implements ActionListener{
	private static final long serialVersionUID = 1L;
	
	private static Controle controller = new Controle();
	
	JButton jbDisciplina = new JButton("Cadastrar Disciplina");
	JButton jbAluno = new JButton("Cadastrar Aluno");
	JButton jbSair = new JButton("Sair");
	
	JButton jbCadastrarDisciplina = new JButton("Cadastrar");
	JButton jbCadastrarAluno = new JButton("Cadastrar");
	
	JButton jbImprimirAluno = new JButton("Imprimir Aluno");
	JButton jbImprimirDisciplinas = new JButton("Imprimir Disciplinas");
	
	JTextField disciplinaText = new JTextField(20);
	JTextField blocoText = new JTextField(20);
	JTextField numeroSalaText = new JTextField(20);
	
	JTextField alunoText = new JTextField(20);
	JTextField disciplina1Text = new JTextField(20);
	JTextField disciplina2Text = new JTextField(20);
	JTextField disciplina3Text = new JTextField(20);
	
	public void actionPerformed(ActionEvent e) {	
		if(e.getSource()==jbDisciplina) {
			CriarFrameCadastroDisciplina();
		}
		
		if(e.getSource() == jbCadastrarDisciplina) {
			try {
			controller.CadastrarDisciplina(disciplinaText.getText(), blocoText.getText(), Integer.parseInt(numeroSalaText.getText()));
			JOptionPane.showMessageDialog(null, "Disciplina Cadastrada!!");
			} catch(Exception ex){
				JOptionPane.showMessageDialog(null,"Ocorreu um erro!! :( " + ex.getMessage());
			}
		}
		
		if(e.getSource()==jbImprimirDisciplinas){
			try {
				controller.ImprimirDisciplinas();
				JOptionPane.showMessageDialog(null, "Disciplinas Impressas!!");
			} catch(Exception ex){
				JOptionPane.showMessageDialog(null,"Ocorreu um erro!! :( " + ex.getMessage());
			}
		}
		
		if(e.getSource()== jbAluno) {
			CriarFrameCadastroAluno();
		}
		
		if(e.getSource() == jbCadastrarAluno) {
			try {
			controller.CadastrarAluno(alunoText.getText(), disciplina1Text.getText(), disciplina2Text.getText(), disciplina3Text.getText());
			JOptionPane.showMessageDialog(null, "Aluno Cadastrado!!");
			} catch(Exception ex){
				JOptionPane.showMessageDialog(null,"Ocorreu um erro!! :( " + ex.getMessage());
			}
		}
		
		if(e.getSource()==jbImprimirAluno){
			try {
				controller.ImprimirAlunos();
				JOptionPane.showMessageDialog(null, "Alunos Impressos!!");
			} catch(Exception ex){
				JOptionPane.showMessageDialog(null,"Ocorreu um erro!! :( " + ex.getMessage());
			}
		}
				
		if(e.getSource()==jbSair){
			System.exit(0);
		}		
	}
	
	public Janela() {		
		jbDisciplina.addActionListener(this);
		jbAluno.addActionListener(this);
		jbImprimirAluno.addActionListener(this);
		jbImprimirDisciplinas.addActionListener(this);
		jbSair.addActionListener(this);
		
		setLayout(null);
		
		jbDisciplina.setBounds(40,30,200,35);
		jbAluno.setBounds(40,70,200,35);
		jbImprimirAluno.setBounds(40,110,200,35);	
		jbImprimirDisciplinas.setBounds(40,150,200,35);
		jbSair.setBounds(100,300,80,35);
		
		add(jbDisciplina);
		add(jbAluno);
		add(jbImprimirAluno);
		add(jbImprimirDisciplinas);
		add(jbSair);
		
		setTitle("Ambiente DESC");
		setSize(300, 400);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setLocationRelativeTo(null);
		setResizable(false);
		setVisible(true);
	}
	
	private void CriarFrameCadastroDisciplina() {
		JPanel panel = new JPanel();
		JFrame frame = new JFrame();
		frame.setSize(430, 200);
		frame.setTitle("Cadastrar Disciplina");
		frame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		frame.add(panel);
		
		panel.setLayout(null);
		
		JLabel disciplinaLabel = new JLabel("Insira o nome da Disciplina: ");
		disciplinaLabel.setBounds(10,20,180,25);
		panel.add(disciplinaLabel);				 
		disciplinaText.setBounds(220,20,180,25);
		panel.add(disciplinaText);
		  
		JLabel blocoLabel = new JLabel("Insira o bloco da Disciplina (A até F): ");
		blocoLabel.setBounds(10,50,250,25); 
		panel.add(blocoLabel);  
		blocoText.setBounds(220,50,180,25);
		panel.add(blocoText);
		  
		JLabel numeroSalaLabel = new JLabel("Insira o número da sala: ");
		numeroSalaLabel.setBounds(10,80,180,25); 
		panel.add(numeroSalaLabel);
		numeroSalaText.setBounds(220,80,180,25); 
		panel.add(numeroSalaText);
			
		jbCadastrarDisciplina.setBounds(140,120,120,30);
		jbCadastrarDisciplina.addActionListener(this);
			
		panel.add(jbCadastrarDisciplina);
		 
		frame.setVisible(true);	
	}
	
	private void CriarFrameCadastroAluno() {
		JPanel panel = new JPanel();
		JFrame frame = new JFrame();
		frame.setSize(440, 250);
		frame.setTitle("Cadastrar Aluno");
		frame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		frame.add(panel);
		
		panel.setLayout(null);
		
		JLabel alunoLabel = new JLabel("Insira o nome do Aluno: ");
		alunoLabel.setBounds(10,20,200,25);
		panel.add(alunoLabel);				 
		alunoText.setBounds(220,20,165,25);
		panel.add(alunoText);
		  
		JLabel disciplina1Label = new JLabel("Insira uma Disciplina para Cursar: ");
		disciplina1Label.setBounds(10,50,200,25); 
		panel.add(disciplina1Label);  
		disciplina1Text.setBounds(220,50,165,25);
		panel.add(disciplina1Text);
		
		JLabel disciplina2Label = new JLabel("Insira uma Disciplina para Cursar: ");
		disciplina2Label.setBounds(10,80,200,25); 
		panel.add(disciplina2Label);  
		disciplina2Text.setBounds(220,80,165,25);
		panel.add(disciplina2Text);
		
		JLabel disciplina3Label = new JLabel("Insira uma Disciplina para Cursar: ");
		disciplina3Label.setBounds(10,110,200,25); 
		panel.add(disciplina3Label);  
		disciplina3Text.setBounds(220,110,165,25);
		panel.add(disciplina3Text);
			
		jbCadastrarAluno.setBounds(140,160,120,30);
		jbCadastrarAluno.addActionListener(this);
			
		panel.add(jbCadastrarAluno);
		 
		frame.setVisible(true);	
	}

}
