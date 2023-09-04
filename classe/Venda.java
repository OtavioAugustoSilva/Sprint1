package classe;

import java.io.Serializable;

public class Venda implements Serializable{

	private String data;
	private String quantidade;
	private int totalVenda;
	
	public Venda(String data, String quantidade) {
		super();
		this.data = data;
		this.quantidade = quantidade;
	}
	
	Produto produto = new Produto(data, quantidade, data);
	
	Cliente cliente = new Cliente(data, data, data, data, data);
	
	
	//m�todos
	
	public void totalVenda() {
		
		totalVenda = Integer.parseInt(produto.getPreco()) * Integer.parseInt(quantidade);
		
		
	}
	
	public String recibo() {
		return "Comprador: " + cliente.getNome()
				+ "\nData: " + data
				+ "\n" + produto.mostrarDados()
				+"\nQuantidade: " + quantidade
				+"Total Venda: " + totalVenda;
	}
}
