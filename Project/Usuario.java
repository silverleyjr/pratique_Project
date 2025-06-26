public class Usuario {
	String nome;
	String email;
	String cidade;
	String login;

	public Usuario(String nomeDoUsuario, String EmailDoUsuario, String CidadeDoUsuario, String loginDoUsuario) {
		nome = nomeDoUsuario;
		email = EmailDoUsuario;
		cidade = CidadeDoUsuario;
		login = loginDoUsuario;
	}

	@Override
	public String toString() {
		return String.format(
				"\n%s | %s | %s | %s", login, nome, email, cidade);
	}

	public String getLogin() {
		return login;
	}

	public String getEmail() {
		return email;
	}

	public String getNome() {
		return nome;
	}

	public String getNomeSeparado() {
		String nomeSeparado = (" | "+ nome + " | ");
		return nomeSeparado;
	}
}
