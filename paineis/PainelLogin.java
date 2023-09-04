package paineis;

import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.List;

import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.JTextField;

import arquivos.LerEscreverObjeto;
import classe.Usuario;
import tela.TelaCadastro;

public class PainelLogin extends JPanel {

	private JLabel jlUsuario, jlSenha;
	private JTextField jtfUsuario;
	private JPasswordField jpfSenha;
	private JButton jbLogin, jbCadastrar;
	private List<Usuario> usuarios = new ArrayList<>();
	
	public PainelLogin(List<Usuario> usuarios) {
		super();

		this.usuarios = usuarios;
		setSize(600, 450);
		setLayout(null);
		setBackground(new Color(135,206,235));
		lerObjetosArquivos();
		iniciarComponentes();
		criarEventos();
		
	}

	private void lerObjetosArquivos() {
		
		LerEscreverObjeto objetos = new LerEscreverObjeto("Usuarios.bin");
		if (objetos.lerArquivoLista() != null) {
			usuarios = objetos.lerArquivoLista();
		} else {
			JOptionPane.showMessageDialog(null,
					"Ainda n„o h· usu·rio cadastrado",
					"Login", JOptionPane.WARNING_MESSAGE);
		}
		
	}

	private void iniciarComponentes() {

		jbLogin = new JButton("Login");
		
		jbCadastrar = new JButton("Cadastrar");
		
		jlUsuario = new JLabel("Usuario");
	
		jtfUsuario = new JTextField();
		
		jlSenha = new JLabel("Senha");
		
		jpfSenha = new JPasswordField();
		
		//adicionar componentes
		
		add(jbLogin);
		
		add(jbCadastrar);
		
		add(jlSenha);
		
		add(jlUsuario);
		
		add(jpfSenha);
		
		add(jtfUsuario);
		
		//dimensionar
		
		jlUsuario.setBounds(270, -40, 100, 200);
		
		jtfUsuario.setBounds(235, 80, 110, 20);
		
		jlSenha.setBounds(274, 20, 100, 200);
		
		jpfSenha.setBounds(235, 135, 110, 20);
		
		jbLogin.setBounds(240, 200, 100, 20);
		
		jbCadastrar.setBounds(240, 230, 100, 20);
		
		
	}

	private void criarEventos() {

		//evento bot√£o login
		
		jbLogin.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {

				String senha = String.valueOf(jpfSenha.getPassword());
				
		        String login = jtfUsuario.getText();

		        if (login.isEmpty() || senha.isEmpty()) {
		        	
		            JOptionPane.showMessageDialog(null, "Preencha todos os campos", "ERRO", JOptionPane.WARNING_MESSAGE);
		            
		        } else {
		        	
		            boolean usuarioEncontrado = false;
		            
		            for (Usuario usuario : usuarios) {
		            	
		                if (usuario.getLogin().equals(login)) {
		                	
		                    usuarioEncontrado = true;
		                    
		                    if (usuario.getSenha().equals(senha)) {
		                    	
		                        PainelVendedor vendedor = new PainelVendedor();
		                        
		                        JPanel parentPanel = (JPanel) getParent();
		                        
		                        parentPanel.removeAll();
		                        
		                        parentPanel.add(vendedor);
		                        
		                        parentPanel.revalidate();
		                        
		                        parentPanel.repaint();
		                        
		                    } else {
		                    	
		                        JOptionPane.showMessageDialog(null, "Senha inv·lida", "ERRO", JOptionPane.ERROR_MESSAGE);
		                        
		                    }
		                    
		                    break;
		                }
		            }

		            if (!usuarioEncontrado) {
		            	
		                JOptionPane.showMessageDialog(null, "Usu·rio inv·lido", "ERRO", JOptionPane.ERROR_MESSAGE);
		                
		            }
		        }
		    }
		});
		
		//evento bot√£o cadastrar
		
		jbCadastrar.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {

				TelaCadastro cadastro = new TelaCadastro("Cadastro", usuarios);
				
				cadastro.setVisible(true);
				
			}
		});
		
		
		
	}
	
}
