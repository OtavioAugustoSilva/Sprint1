package classe;

import java.io.Serializable;

public class Usuario implements Serializable{

	
	private String login;
	private String senha;

	public Usuario(String login, String senha) {
		super();
		this.login = login;
		this.senha = senha;
	}

	public String getLogin() {
		return login;
	}

	public String getSenha() {
		return senha;
	}
}


