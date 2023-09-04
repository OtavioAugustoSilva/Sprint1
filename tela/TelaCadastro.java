package tela;

import javax.swing.JFrame;
import java.awt.Color;
import java.awt.HeadlessException;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.List;

import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPasswordField;
import javax.swing.JTextField;

import arquivos.LerEscreverObjeto;
import classe.Usuario;

public class TelaCadastro extends JFrame {

	private JLabel jlLogin, jlSenha;
	private JTextField jtfLogin;
	private JPasswordField jpSenha;
	private JButton jbCadastrar;
    private List<Usuario> usuarios; //guarda objeto de Usuario(Matriz)
	
	
	public TelaCadastro(String title, List<Usuario> usuarios) throws HeadlessException {
		super(title);

		this.usuarios = usuarios;
		setSize(250, 200);
		setLayout(null);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		getContentPane().setBackground(new Color(176,196,222));
		setLocationRelativeTo(null);
		iniciarComponentes();
		criarEventos();
		
	}



	private void iniciarComponentes() {

		//objetos
		
		jlLogin = new JLabel("Login");
		jtfLogin = new JTextField();
		
		jlSenha = new JLabel("Senha");
		jpSenha = new JPasswordField();
		
		jbCadastrar = new JButton("Cadastrar");
		
		//adicionando componentes
		
		add(jlLogin);
		add(jtfLogin);
		
		add(jlSenha);
		add(jpSenha);
		
		add(jbCadastrar);
		jbCadastrar.setBackground(new Color(169,169,169));
		
		//dimensionar componentes
		
		jlLogin.setBounds(100, 10, 50, 20);
		jtfLogin.setBounds(55, 30, 120, 20);
		
		jlSenha.setBounds(100, 50, 50, 20);
		jpSenha.setBounds(55, 70, 120, 20);
		
		jbCadastrar.setBounds(65, 120, 100, 20);
		
	}



	private void criarEventos() {

		jbCadastrar.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {

				String login,senha;
				
				login = jtfLogin.getText();
				
				senha = String.valueOf(jpSenha.getPassword()); //converte conjunto de caractere
				
				if (!login.isEmpty() && !senha.isEmpty()) {
				
					LerEscreverObjeto objetos = new LerEscreverObjeto("Usuarios.bin");
					
					usuarios.add(new Usuario(login, senha));
					
					objetos.escreverObjeto(usuarios);
					
					setVisible(false);
					
					
				} else {

					JOptionPane.showMessageDialog(null, "Preencha todos os campos", "Erro",  JOptionPane.WARNING_MESSAGE);
					
				}
				
				
			}
		});
	
}
	
	}
	

