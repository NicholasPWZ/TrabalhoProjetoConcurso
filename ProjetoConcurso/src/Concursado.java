
public class Concursado {

	private String nome;

	private int idade;

	private String cpf;

	private double nota;

	private String email;

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public int getIdade() {
		return idade;
	}

	public void setIdade(int idade) {
		this.idade = idade;
	}

	public String getCpf() {
		return cpf;
	}

	public void setCpf(String cpf) {
		if (cpf.length() == 11) {
			this.cpf = cpf;
		} else {
			throw new IllegalArgumentException("Informe um CPF valido.");
		}
	}

	public double getNota() {
		return nota;
	}

	public void setNota(double nota) {
		if (nota <= 10) {
			this.nota = nota;
		} else {
			throw new IllegalArgumentException("Digite uma nota valida");
		}
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		if (email.contains("@")) {
			this.email = email;
		} else {
			throw new IllegalArgumentException("Digite um email valido");
		}

	}
}
