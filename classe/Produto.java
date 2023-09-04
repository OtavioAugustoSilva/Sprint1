package classe;

import java.io.Serializable;

public class Produto implements Serializable{

	private String nome;
	private String tipo;
	private String preco;
	
	public Produto(String nome, String tipo, String preco) {
		super();
		this.nome = nome;
		this.tipo = tipo;
		this.preco = preco;
	}
	
	public String mostrarDados() {
		return "Produto: " + nome
				+"\nPreço: " + preco
				+"\nTipo: " + tipo;
		
	}

	public String getPreco() {
		return preco;
	}
}
