package paineis;

import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.text.ParseException;
import java.util.ArrayList;
import java.util.List;

import javax.swing.ButtonGroup;
import javax.swing.JButton;
import javax.swing.JFormattedTextField;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JRadioButton;
import javax.swing.JTextField;
import javax.swing.text.MaskFormatter;

import arquivos.LerEscreverObjeto;
import classe.Cliente;
import classe.Usuario;

public class PainelCadastroCliente extends JPanel {

	private JLabel jlNome, jlEmail, jlTelefone, jlCpf, jlGenero, jlTitulo;
	private JTextField jtfNome, jtfEmail;
	private JButton jbCadastrar;
	private JRadioButton jrbMasculino, jrbFeminino;
	private ButtonGroup bgGenero;
	private JFormattedTextField jtfCpf, jtfTelefone; 
	private MaskFormatter mkCpf, mkTelefone;
	private List<Cliente> clientes;
	
	public PainelCadastroCliente(List<Cliente> clientes) {
		super();

		this.clientes = clientes;
		setSize(600, 450);
		setLayout(null);
		setBackground(new Color(147,112,219));
		
		iniciarComponentes();
		criarEventos();
		
	}

	private void iniciarComponentes() {
		
		
		try {
			
			mkCpf = new MaskFormatter("###.###.###-##");
			mkTelefone = new MaskFormatter("(##)#####-####");
			
		} catch (ParseException e) {
			
			e.printStackTrace();
		}
		
		 Font fonte = new Font("Serif", Font.BOLD, 30);
		
		jlTitulo = new JLabel("Cadastrar Cliente");
		jlTitulo.setFont(fonte);
        jlTitulo.setForeground(Color.black);

		jlNome = new JLabel("Nome");
		jtfNome = new JTextField();
		
		jlEmail = new JLabel("Email");
		jtfEmail = new JTextField();
		
		jlTelefone = new JLabel("Telefone");
		jtfTelefone = new JFormattedTextField(mkTelefone);
		
		jlCpf = new JLabel("Cpf");
		jtfCpf = new JFormattedTextField(mkCpf);
		
		jbCadastrar = new JButton("Cadastrar");
		
		jlGenero = new JLabel("Gênero");
		
		bgGenero = new ButtonGroup();
		
		jrbMasculino = new JRadioButton("Masculino");
		jrbFeminino = new JRadioButton("Feminino");
		
		
		//adicionando componentes
		
		 add(jlTitulo);
		
		 add(jlNome);
	     add(jtfNome);
	        
	     add(jlEmail);
	     add(jtfEmail);
	        
	     add(jlCpf);
	     add(jtfCpf);
	        
	     add(jlTelefone);
	     add(jtfTelefone);
	     
	     add(jlGenero);
	        
	     add(jrbMasculino);
	     jrbMasculino.setOpaque(false);
	     add(jrbFeminino);
	     jrbFeminino.setOpaque(false);
	        
	     bgGenero.add(jrbMasculino);
	     bgGenero.add(jrbFeminino);
	        
	     add(jbCadastrar);
	     
	     //dimensionar componentes
	     
	     jlTitulo.setBounds(170, -60, 400, 200);
	     
	     jlNome.setBounds(120,80,100, 20);
		 jtfNome.setBounds(100,100,150, 20);

		 jlEmail.setBounds(120,120,100, 20);
		 jtfEmail.setBounds(100,140,150, 20);

			
		 jlCpf.setBounds(120, 160, 100, 20);
		 jtfCpf.setBounds(100, 180, 150, 20);
			

		 jlTelefone.setBounds(120, 200, 120, 20);
		 jtfTelefone.setBounds(100, 220, 150, 20);

		 jbCadastrar.setBounds(238,320, 100, 20);
			
	     jlGenero.setBounds(370, 160, 100, 20);
			
		 jrbMasculino.setBounds(345, 180, 100, 20);
		 jrbFeminino.setBounds(345, 200, 100, 20);
		
	}

	private void criarEventos() {

		jbCadastrar.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {

                String nome; 
                String email;
                String telefone; 
                String cpf; 
                String genero = null;
				
				nome = jtfNome.getText();

				email = jtfEmail.getText();
				
				telefone = jtfTelefone.getText();
				
				cpf = jtfCpf.getText();
				
				genero = jrbFeminino.isSelected() ? "Feminino" : "Masculino";
				
				
				if (!nome.isEmpty() && !email.isEmpty() && !cpf.isEmpty() && !telefone.isEmpty() && !genero.isEmpty()) {
					
				LerEscreverObjeto objetos = new LerEscreverObjeto("Clientes.bin");
				
				clientes.add(new Cliente(nome, telefone, email, genero, cpf));
				
				objetos.escreverObjetoCliente(clientes);
				
				jtfNome.setText("");	
				jtfEmail.setText("");
				jtfCpf.setText("");
				jtfTelefone.setText("");	
				
				} else {

					JOptionPane.showMessageDialog(null, "Preencha todos os campos", "Erro",  JOptionPane.WARNING_MESSAGE);
					
				}
				
			}
		});
		
	}

	
	
}
