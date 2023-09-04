package tela;

import java.awt.Color;
import java.awt.Font;
import java.awt.HeadlessException;
import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.List;

import javax.swing.*;// * importa todas as classes do pacote

import arquivos.LerEscreverObjeto;
import classe.Cliente;
import classe.Produto;
import classe.Usuario;
import paineis.PainelCadastroCliente;
import paineis.PainelCadastroProduto;
import paineis.PainelLogin;
import paineis.PainelMostrarCadastroCliente;

public class TelaLojinha extends JFrame{
	
	private JMenuBar jmbBarra;
	private JMenu jmArquivo, jmCadastro, jmSobre, jmMostrar, jmEntrar;
	private JMenuItem jmiSair, jmiEquipe, jmiPrograma, jmiCliente, jmiLogin, jmiMostrarCliente, jmiProduto;
	private JLabel jlTitulo, jlText, jlText2, jlText3, jlLogo;
	private List<Cliente> clientes = new ArrayList<>();
	private List<Produto> produtos = new ArrayList<>(); 
	private List<Usuario> usuarios = new ArrayList<>();
	

	public TelaLojinha(String title) throws HeadlessException {
		super(title);
		
		setSize(600, 450);
		setLayout(null);
		setResizable(false);
		setLocationRelativeTo(this);
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		getContentPane().setBackground(new Color(30,144,255));
		lerObjetosArquivos();
		iniciarComponentes();
		criarEventos();;
	}

	private void lerObjetosArquivos() {

		LerEscreverObjeto objetos = new LerEscreverObjeto("Usuarios.bin");
		if (objetos.lerArquivoLista() != null) {
			usuarios = objetos.lerArquivoLista();
		} else {
			JOptionPane.showMessageDialog(null,
					"Ainda não há usuário cadastrado",
					"Login", JOptionPane.WARNING_MESSAGE);
		}
		
		LerEscreverObjeto objetosCliente = new LerEscreverObjeto("Clientes.bin");
		if (objetosCliente.lerArquivoListaCliente() != null) {
			clientes = objetosCliente.lerArquivoListaCliente();
		} else {
			JOptionPane.showMessageDialog(null,
					"Ainda não há cliente cadastrado",
					"Cliente", JOptionPane.WARNING_MESSAGE);
		}
		
		LerEscreverObjeto objetosProduto = new LerEscreverObjeto("Produtos.bin");
		if (objetosProduto.lerArquivoListaProduto() != null) {
			produtos = objetosProduto.lerArquivoListaProduto();
		} else {
			JOptionPane.showMessageDialog(null,
					"Ainda não há produto cadastrado",
					"Cliente", JOptionPane.WARNING_MESSAGE);
		}
		
	}


	private void iniciarComponentes() {

		//objeto
		
		
		 Font fonte = new Font("Serif", Font.BOLD, 30);		
		 
		 Font fonte2 = new Font("Serif", Font.BOLD, 20);
	        
	        jlTitulo = new JLabel("Bem-Vindo a Alians Tech!");
	        jlTitulo.setFont(fonte);
	        jlTitulo.setForeground(Color.black);
		
		jlText = new JLabel("A empresa perfeita para quem busca as");
		
		jlText.setFont(fonte2);
		
		jlText2 = new JLabel("melhores máquinas e periféricos"); 
		
		jlText2.setFont(fonte2);
		
		jlText3 = new JLabel("por um preço acessível.");
		
		jlText3.setFont(fonte2);
		
		jlLogo = new JLabel(new ImageIcon(getClass().getClassLoader().getResource("imagens/logotipoOK.png")));
		
		jmbBarra = new JMenuBar();
		jmbBarra.setBackground(new Color(100,149,237));
		
		jmArquivo = new JMenu("Arquivo");
		
		jmiSair = new JMenuItem("Sair");
		
		jmCadastro = new JMenu("Cadastro");
		
		jmMostrar = new JMenu("Mostrar");
		
		jmSobre = new JMenu("Sobre");
		
		jmiEquipe = new JMenuItem("Equipe");
		
		jmiPrograma = new JMenuItem("Programa");
		
		jmiCliente = new JMenuItem("Cliente");
		
		jmiLogin = new JMenuItem("Login");
		
		jmiMostrarCliente = new JMenuItem("Cadastros");
		
		jmiProduto = new JMenuItem("Produto");
				
		jmEntrar = new JMenu("Entrar");
		
		 ImageIcon icon = new ImageIcon(getClass().getClassLoader().getResource("imagens/logotipoOK.png"));
		 
		 Image image = icon.getImage();

		    setIconImage(image);
		
		
		
		
		//adicionar

		setJMenuBar(jmbBarra);
		
		jmbBarra.add(jmArquivo);
		jmbBarra.add(jmCadastro);
		jmbBarra.add(jmMostrar);
		jmbBarra.add(jmSobre);
		jmbBarra.add(Box.createHorizontalGlue());
		jmbBarra.add(jmEntrar);
		jmArquivo.add(jmiSair);
		jmSobre.add(jmiEquipe);
		jmSobre.add(jmiPrograma);
		jmCadastro.add(jmiCliente);
		jmCadastro.add(jmiProduto);
		jmEntrar.add(jmiLogin);
		jmMostrar.add(jmiMostrarCliente);
		
		add(jlText);
		add(jlTitulo);
		add(jlLogo);
		add(jlText2);
		add(jlText3);
		
		//dimensionar componentes
		
		jlLogo.setBounds(30, 90, 210, 210);
		
		jlTitulo.setBounds(240, -80, 400, 400);
		
		jlText.setBounds(240, -40, 400, 400);
		
		jlText2.setBounds(240, -20, 400, 400);
		
		jlText3.setBounds(240, 0, 400, 400);
		
	}

	private void criarEventos() {
		
		jmiLogin.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {

				PainelLogin usuario = new PainelLogin(usuarios);
		        getContentPane().removeAll(); // Remove todos os componentes da tela
		        getContentPane().add(usuario); // Adiciona o painel
		        getContentPane().validate(); // Valida todos os componentes
		        getContentPane().repaint(); // Redesenha a tela
				
				
				
			}
		});

		jmiSair.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {

				dispose();
				
			}
		});
		
		jmCadastro.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				
			}
		});
		
		jmSobre.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				
			}
		});
		
		jmMostrar.addActionListener(new ActionListener() {
			//evento Barra Mostrar
			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				
			}
		});
		//evento SObre Equipe
		jmiEquipe.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {

				JOptionPane.showMessageDialog(null, "A Alians Tech é uma empresa criada por Matheus, Otávio, \nMariel e Samuel, com o intuito de oferecer os melhores produtos"
						+ " \ntecnológicos do mercado por um preço acessível para todos.", "Nossa Equipe", JOptionPane.INFORMATION_MESSAGE, new ImageIcon(getClass().getClassLoader().getResource("imagens/logotipoOK.png")));
				
			}
		});
		//evento Sobre Programa
		jmiPrograma.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {

				JOptionPane.showMessageDialog(null, "O Programa Alians Tech é um projeto que criamos para testar \ne aprimorar nossos conhecimento de DS e ir desenvolvendo nossas \nhabilidades"
						+ " cada vez mais, para nos beneficiarmos no futuro.", "Programa", JOptionPane.INFORMATION_MESSAGE);
				
			}
		});
		//evento Cadastrar Cliente
		jmiCliente.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				
				 PainelCadastroCliente cliente = new PainelCadastroCliente(clientes);
			        getContentPane().removeAll(); // Remove todos os componentes da tela
			        getContentPane().add(cliente); // Adiciona o painel
			        getContentPane().validate(); // Valida todos os componentes
			        getContentPane().repaint(); // Redesenha a tela
				
			}
		});
		
		//evento Mostrar Cadastro Cliente
		
		jmiMostrarCliente.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {

				 PainelMostrarCadastroCliente mostrar = new PainelMostrarCadastroCliente(clientes, produtos);
			        getContentPane().removeAll(); // Remove todos os componentes da tela
			        getContentPane().add(mostrar); // Adiciona o painel
			        getContentPane().validate(); // Valida todos os componentes
			        getContentPane().repaint(); // Redesenha a tela
				
			}
		});
		
		//evento cadastrar produto
		
		jmiProduto.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {

				PainelCadastroProduto mostrarProduto = new PainelCadastroProduto(produtos);
		        getContentPane().removeAll(); // Remove todos os componentes da tela
		        getContentPane().add(mostrarProduto); // Adiciona o painel
		        getContentPane().validate(); // Valida todos os componentes
		        getContentPane().repaint(); // Redesenha a tela
			}
		});
		
	}

	public static void main(String[] args) {
        TelaLojinha tela = new TelaLojinha("Alians Tech");
        tela.setVisible(true);
	
}
	}
