package control;

public class Login {
	
	public static String usuario;
	public static String senha;
	public static int nivel;
	public static int cadastro;
	public static int idEnd;
	
	public static int getCadastro() {
		return cadastro;
	}
	public static int getIdEnd() {
		return idEnd;
	}
	public static void setIdEnd(int idEnd) {
		Login.idEnd = idEnd;
	}
	public static void setCadastro(int cadastro) {
		Login.cadastro = cadastro;
	}
	public static String getUsuario() {
		return usuario;
	}
	public static void setUsuario(String usuario) {
		Login.usuario = usuario;
	}
	public static String getSenha() {
		return senha;
	}
	public static void setSenha(String senha) {
		Login.senha = senha;
	}
	public static int getNivel() {
		return nivel;
	}
	public static void setNivel(int nivel) {
		Login.nivel = nivel;
	}
	
	

}
