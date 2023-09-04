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

	import classe.Usuario;

	public class TelaLogin extends JFrame {

	private JLabel jlLogin, jlSenha;
	private JTextField jtfLogin;
	private JPasswordField jpSenha;
	private JButton jbEntrar, jbCadastrar;
	private List<Usuario> usuarios = new ArrayList<>(); //Matriz dinamica

	public TelaLogin(String title) throws HeadlessException {
		super(title);

		setSize(250, 250);
		setLayout(null);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		getContentPane().setBackground(new Color(135,206,250));
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
			jbEntrar = new JButton("Entrar");
			
			//adicionando componentes
			
			add(jlLogin);
			add(jtfLogin);
			
			add(jlSenha);
			add(jpSenha);
			
			add(jbEntrar);
			jbEntrar.setBackground(new Color(176,196,222));
			add(jbCadastrar);
			jbCadastrar.setBackground(new Color(176,196,222));
			
			//dimensionar componentes
			
			jlLogin.setBounds(100, 10, 50, 20);
			jtfLogin.setBounds(55, 30, 120, 20);
			
			jlSenha.setBounds(100, 50, 50, 20);
			jpSenha.setBounds(55, 70, 120, 20);
			
			jbEntrar.setBounds(65, 110, 100, 20);
			
			jbCadastrar.setBounds(65, 150, 100, 20);
			
		}



		private void criarEventos() {

			jbCadastrar.addActionListener(new ActionListener() {
				
				@Override
				public void actionPerformed(ActionEvent e) {

					TelaCadastro cadastro = new TelaCadastro("Cadastro", usuarios);
					
					cadastro.setVisible(true);
					
				}
			});
			
			jbEntrar.addActionListener(new ActionListener() {
				
				@Override
				public void actionPerformed(ActionEvent e) {

					if (!usuarios.isEmpty()) {
						
						for (Usuario usuario : usuarios) {
							
                        if (usuario.getLogin().equals(jtfLogin.getText()) && usuario.getSenha().equals(String.valueOf(jpSenha.getPassword()))) {
								
						TelaLojinha tela = new TelaLojinha("Login");
						
						tela.setVisible(true);;
						
						dispose();
						
						break;
						
						
						
                        }
						
					}
						
				} else {

						JOptionPane.showMessageDialog(null, "N�o h� nenhum usu�rio cadastrado", "Login", JOptionPane.WARNING_MESSAGE);
								
					}
					
				}
			});
			
		}



		public static void main(String[] args) {

			//objeto
			
			TelaLogin pet = new TelaLogin("Login");
			pet.setVisible(true);
			
		}
		
}
	

