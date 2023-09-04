package paineis;

import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.text.ParseException;

import java.util.List;


import javax.swing.JButton;
import javax.swing.JFormattedTextField;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;

import javax.swing.JTextField;
import javax.swing.text.MaskFormatter;

import arquivos.LerEscreverObjeto;

import classe.Produto;

public class PainelCadastroProduto extends JPanel {

	private JLabel jlNome, jlPreco, jlTipo, jlTitulo;
	private JTextField jtfNome, jtfTipo;
	private JButton jbCadastrar;
	private JFormattedTextField jtfPreco; 
	private MaskFormatter mkPreco;
	private List<Produto> produtos;
	
	public PainelCadastroProduto(List<Produto> produtos) {
		super();

		this.produtos = produtos;
		setSize(600, 450);
		setLayout(null);
		setBackground(new Color(135,206,250));
		
		iniciarComponentes();
		criarEventos();
		
	}


	private void iniciarComponentes() {

        try {
			
			mkPreco = new MaskFormatter("R$ ********");
			
		} catch (ParseException e) {
			
			e.printStackTrace();
		}
        
        jlNome = new JLabel("Nome Do Produto");
        jtfNome = new JTextField();
        
        jlPreco = new JLabel("Preço");
        jtfPreco = new JFormattedTextField(mkPreco);
        
        jlTipo = new JLabel("Tipo de Produto");
        jtfTipo = new JTextField();
        
        jbCadastrar = new JButton("Cadastrar");
        
        jlTitulo = new JLabel("Cadastrar Produto");
        
        Font fonte = new Font("Serif", Font.BOLD, 30);
        jlTitulo.setFont(fonte);
        jlTitulo.setForeground(Color.black);
        
        //adicionar componentes
        
        add(jbCadastrar);
        
        add(jlNome);
        add(jtfNome);
        
        add(jlPreco);
        add(jtfPreco);
        
        add(jlTipo);
        add(jtfTipo);
        
        add(jlTitulo);
        
        //dimensionar componentes
        jlTitulo.setBounds(170, -80, 500, 200);
        
        jlNome.setBounds(235, 70, 100, 20);
        jtfNome.setBounds(210, 90, 150, 20);
        
        jlPreco.setBounds(270, 120, 100 , 20);
        jtfPreco.setBounds(210, 140, 150, 20);
        
        jlTipo.setBounds(240, 170, 100, 20);
        jtfTipo.setBounds(210, 190, 150, 20);
        
        jbCadastrar.setBounds(229, 250, 110, 20);
		
	}

	private void criarEventos() {

    jbCadastrar.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {

                String nome; 
                String tipo;
                String preco;
				
				nome = jtfNome.getText();

				preco = jtfPreco.getText();
				
				tipo = jtfTipo.getText();
				
				if (!nome.isEmpty() && !preco.isEmpty() && !tipo.isEmpty()) {
					
					LerEscreverObjeto objetos = new LerEscreverObjeto("Produtos.bin");
					
				produtos.add(new Produto(nome, tipo, preco)); 
					
					objetos.escreverObjetoProduto(produtos);
					
					jtfNome.setText("");
					jtfPreco.setText("");
					jtfTipo.setText("");
					
				} else {

					JOptionPane.showMessageDialog(null, "Preencha todos os campos", "Erro",  JOptionPane.WARNING_MESSAGE);
					
				}
				
			}
		});
		
	}
	
}
