package model;


public class Usuario {
	
	private String login;
	private String senha;
	private String nome;
	private double avaliacao = 5;
	private int contadorAvaliacao = 1; //Quantas avaliações já teve, pra calcular a média após nova avaliação
	private Localizacao localizacao = new Localizacao();
	
	public String getLogin() {
		return login;
	}

	public void setLogin(String login) {
		this.login = login;
	}

	public String getSenha() {
		return senha;
	}

	public void setSenha(String senha) {
		this.senha = senha;
	}
	
	public String getNome() {
		return nome;
	}
	
	public void setNome(String nome) {
		this.nome = nome;
	}
        
        public void setContadorAvaliacao(Integer contadorAvaliacao){
            this.contadorAvaliacao = contadorAvaliacao;
        }
        
        public Integer getContadorAvaliacao(){
            return this.contadorAvaliacao;
        }

	public void setAvaliacao(double avaliacao) {
		double avaliacao_aux = this.avaliacao * contadorAvaliacao;
		this.avaliacao = (avaliacao+avaliacao_aux)/contadorAvaliacao;
	}
	
	public double getAvaliacao() {
		return avaliacao;
	}
	
	public Localizacao getLocalizacao() {
		return this.localizacao;
	}
	
}
