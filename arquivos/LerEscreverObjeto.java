package arquivos;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.ArrayList;
import java.util.List;

import classe.Cliente;
import classe.Produto;
import classe.Usuario;

import javax.swing.JOptionPane;

public class LerEscreverObjeto {

	public String nomeArquivo;

	public LerEscreverObjeto(String nomeArquivo) {
		super();
		this.nomeArquivo = nomeArquivo;
	}

	public void escreverObjeto(List<Usuario> usuarios) {

		try {

			FileOutputStream fluxo = new FileOutputStream(nomeArquivo);

			ObjectOutputStream objeto = new ObjectOutputStream(fluxo);

			objeto.writeObject(usuarios);

			objeto.close();

			JOptionPane.showMessageDialog(null, "Arquivo gravado com sucesso");

		} catch (IOException e) {

			System.out.println("Erro ao gravar o arquivo: " + e.getMessage());

		}
	}

	public List<Usuario> lerArquivoLista() {

		List<Usuario> usuarios = null;

		try {

			FileInputStream fluxo = new FileInputStream(nomeArquivo);

			ObjectInputStream objeto = new ObjectInputStream(fluxo);

			usuarios = (List<Usuario>) objeto.readObject();

			objeto.close();

		} catch (FileNotFoundException e) {

			JOptionPane.showMessageDialog(null, "Arquivo n√£o encontrado");

		} catch (IOException e) {

			e.printStackTrace();

		} catch (ClassNotFoundException e) {

			JOptionPane.showMessageDialog(null, "Classe n√£o encontrada");

		}
		return usuarios;
	}

	// Cliente

	public void escreverObjetoCliente(List<Cliente> clientes) {
		FileOutputStream fluxo;
		try {
			fluxo = new FileOutputStream(nomeArquivo);
			ObjectOutputStream objeto = new ObjectOutputStream(fluxo);
			objeto.writeObject(clientes);
			objeto.close();
			JOptionPane.showMessageDialog(null, "Arquivo gravado com sucesso");
		} catch (Exception e) {
			System.out.println("[!]-----------------------------------------------------------[!]" + "\n" + e
					+ "\n[!]-----------------------------------------------------------[!]");
		}
	}

	public List<Cliente> lerArquivoListaCliente() {
		List<Cliente> clientes = null;
		try {
			FileInputStream fluxo = new FileInputStream(nomeArquivo);
			ObjectInputStream objeto = new ObjectInputStream(fluxo);

			clientes = (List<Cliente>) objeto.readObject();
			objeto.close();

		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			return new ArrayList<>();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			JOptionPane.showMessageDialog(null, "Classe n„o encontrada");
		}

		return clientes;
	}

	// Produto

	public void escreverObjetoProduto(List<Produto> produtos) {
		FileOutputStream fluxo;
		try {
			fluxo = new FileOutputStream(nomeArquivo);
			ObjectOutputStream objeto = new ObjectOutputStream(fluxo);
			objeto.writeObject(produtos);
			objeto.close();
			JOptionPane.showMessageDialog(null, "Arquivo gravado com sucesso");
		} catch (Exception e) {
			System.out.println("[!]-----------------------------------------------------------[!]" + "\n" + e
					+ "\n[!]-----------------------------------------------------------[!]");
		}
	}

	public List<Produto> lerArquivoListaProduto() {
		List<Produto> produtos = null;
		try {
			FileInputStream fluxo = new FileInputStream(nomeArquivo);
			ObjectInputStream objeto = new ObjectInputStream(fluxo);

			produtos = (List<Produto>) objeto.readObject();
			objeto.close();

		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			JOptionPane.showMessageDialog(null, "Arquivo n„o encontrado");
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			JOptionPane.showMessageDialog(null, "Classe n„o encontrada");
		}

		return produtos;
	}
}
