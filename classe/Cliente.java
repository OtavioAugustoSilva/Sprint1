package classe;

import java.io.Serializable;

public class Cliente implements Serializable{

	private String nome; 
	private String telefone; 
	private String email;
	private String genero;
	private String cpf;
	
	public Cliente(String nome, String telefone, String email, String genero, String cpf) {
		super();
		this.nome = nome;
		this.telefone = telefone;
		this.email = email;
		this.genero = genero;
		this.cpf = cpf;
	}
	
	//métodos 
	
	public String mostrarDados() {
		return "Nome: " + nome
				+ "\nTelefone: " + telefone
				+ "\nEmail: " + email
				+ "\nGênero: " + genero
				+ "\nCpf: " + cpf;
	}

	public String getNome() {
		return nome;
	}

	public String getTelefone() {
		return telefone;
	}

	public String getEmail() {
		return email;
	}

	public String getGenero() {
		return genero;
	}

	public String getCpf() {
		return cpf;
	}
}
