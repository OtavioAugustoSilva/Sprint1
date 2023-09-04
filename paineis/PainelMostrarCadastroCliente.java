package paineis;

import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import javax.swing.ButtonGroup;
import javax.swing.JButton;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JRadioButton;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;

import classe.Cliente;
import classe.Produto;

public class PainelMostrarCadastroCliente extends JPanel {

	private JScrollPane jspMostrar;
	private JTextArea jtaMostrar;
	private JButton jbMostrar;
	private JRadioButton jrbClientes;
	private JRadioButton jrbProdutos;
	private ButtonGroup bgCadastro;
	private List<Cliente> clientes = new ArrayList<>();
	private List<Produto> produtos = new ArrayList<>();

	public PainelMostrarCadastroCliente(List<Cliente> clientes, List<Produto> produtos) {
		super();

		this.produtos = produtos;
		this.clientes = clientes;
		setSize(600, 450);
		setLayout(null);
		setBackground(new Color(176,196,222));

		iniciarComponentes();
		criarEventos();

	}

	private void iniciarComponentes() {

		bgCadastro = new ButtonGroup();

		jbMostrar = new JButton("Mostrar");

		jtaMostrar = new JTextArea();

		jspMostrar = new JScrollPane(jtaMostrar);

		jrbClientes = new JRadioButton("Clientes");

		jrbProdutos = new JRadioButton("Produtos");

		// Adicionar componentes
		add(jbMostrar);

		add(jspMostrar);

		add(jrbClientes);

		add(jrbProdutos);

		//dimensionar

		jbMostrar.setBounds(200, 40, 110, 20);

		jspMostrar.setBounds(100, 80, 380,250);

		bgCadastro.add(jrbClientes);

		bgCadastro.add(jrbProdutos);

		jrbClientes.setBounds(320, 30, 80, 20);

		jrbClientes.setOpaque(false);

		jrbProdutos.setBounds(320, 50, 80, 20);

		jrbProdutos.setOpaque(false);

		jtaMostrar.setText("                                                 CADASTROS                 \n");

	}

	private void criarEventos() {

		jbMostrar.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {

				jtaMostrar.setText("");

				if (jrbClientes.isSelected()) {

					if (clientes.isEmpty()) {

						JOptionPane.showMessageDialog(null, "Nenhum cliente cadastrado", "ERRO", JOptionPane.ERROR_MESSAGE);

					} else {

						for (Cliente cliente : clientes) {

							jtaMostrar.append(cliente.mostrarDados() + "\n" + "\n");
						}
					}
				} else {


					if (jrbProdutos.isSelected()) {

						if (!produtos.isEmpty()) {

							for (Produto produto : produtos) {

								jtaMostrar.append(produto.mostrarDados() + "\n" + "\n");
							}

						} else {

							JOptionPane.showMessageDialog(null, "Nenhum produto cadastrado", "ERRO", JOptionPane.ERROR_MESSAGE);

						}

					} else {

						JOptionPane.showMessageDialog(null, "Selecione uma opção", "ERRO", JOptionPane.ERROR_MESSAGE);
					}
				}  
			}
		});



	}

}


