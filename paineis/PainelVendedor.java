package paineis;

import java.awt.Color;
import java.awt.Font;

import javax.swing.ImageIcon;
import javax.swing.JLabel;
import javax.swing.JPanel;

public class PainelVendedor extends JPanel {

	private JLabel jlTitulo, jlTitulo2, jlText, jlText2, jlText3, jlLogo, jlImagem;

	public PainelVendedor() {
		super();

		setSize(600, 450);
		setLayout(null);
		setBackground(new Color(173,216,230));
		
		iniciarComponentes();
	}

	private void iniciarComponentes() {

		Font fonte = new Font("Serif", Font.BOLD, 30);		
		 
		 Font fonte2 = new Font("Serif", Font.BOLD, 20);
	        
	        jlTitulo = new JLabel("Olá vendedor!");
	        jlTitulo.setFont(fonte);
	        jlTitulo.setForeground(Color.black);
	        
	        jlTitulo2 = new JLabel("Boas vendas!");
	        jlTitulo2.setFont(fonte);
	        jlTitulo2.setForeground(Color.black);
		
		jlText = new JLabel("Tenha um bom trabalho!");
		
		jlText.setFont(fonte2);
		
		jlText2 = new JLabel("Não se esqueça de ser gentil com os clientes"); 
		
		jlText2.setFont(fonte2);
		
		jlText3 = new JLabel("para que eles se sintam bem recebidos.");
		
		jlText3.setFont(fonte2);
		
		jlLogo = new JLabel(new ImageIcon(getClass().getClassLoader().getResource("imagens/logotipoOK.png")));
		
		jlImagem = new JLabel(new ImageIcon(getClass().getClassLoader().getResource("imagens/emojinew.png")));
		
		//adicionar

		add(jlText);
		add(jlTitulo);
		add(jlLogo);
		add(jlText2);
		add(jlText3);
		add(jlTitulo2);
		add(jlImagem);
		
		//dimensionar componentes
		
		jlLogo.setBounds(0, 90, 210, 210);
		
		jlTitulo.setBounds(310, -140, 400, 400);
		
		jlText.setBounds(295, -100, 400, 400);
		
		jlText2.setBounds(210, -75, 400, 400);
		
		jlText3.setBounds(240, -55, 400, 400);
		
		jlTitulo2.setBounds(310, 0, 400, 400);
		
		jlImagem.setBounds(280, 220, 210, 100);
		
	}
}