package mvc.model;

public class Pessoas {
	private String usuario;
	private String senha;
	private String confirmarsenha;
	
	public String getSenha() {
		return senha;
	}
	public void setSenha(String senha) {
		this.senha = senha;
	}
	public String getUsuario() {
		return usuario;
	}
	public void setUsuario(String usuario) {
		this.usuario = usuario;
	}
	public String getConfirmarsenha() {
		return confirmarsenha;
	}
	public void setConfirmarsenha(String confirmarsenha) {
		this.confirmarsenha = confirmarsenha;
	}
	
}


