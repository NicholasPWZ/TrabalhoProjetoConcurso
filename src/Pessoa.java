
public abstract class Pessoa {
	protected String nome;
	protected int idade;
	protected String cpf;
	protected String email;

	public Pessoa(String nome, int idade, String cpf, String email) {

		this.nome = nome;
		this.idade = idade;
		this.cpf = cpf;
		this.email = email;
	}

	protected abstract void validar();

	public String getNome() {
		return nome;
	}

	public int getIdade() {
		return idade;
	}

	public String getCpf() {
		return cpf;
	}

	public String getEmail() {
		return email;
	}

}
