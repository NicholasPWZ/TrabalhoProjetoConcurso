import java.util.ArrayList;
import java.util.List;

public class Concursado extends Pessoa {
	
	private List<String>concursos;	
	
	public Concursado(String nome, int idade, String cpf, String email) {
		super(nome, idade, cpf, email);
		this.concursos = new ArrayList<String>();
		validar();
	}
	public void addConcurso(String concurso) {
		this.concursos.add(concurso);
	}
	
	protected void validar() {
		List<String> mensagens = new ArrayList<String>();
		if (cpf == null || cpf.isBlank()) {
			mensagens.add("CPF deve ser informado");
		}
		if (nome == null || nome.isBlank()) {
			mensagens.add("Nome deve ser informado");
		}
		if (idade < 15 || idade > 65) {
			mensagens.add("Idade não é valida para inscrição");
		}
		if (email.isBlank() || email == null) {
			mensagens.add("Email deve ser informado");
		}
		if (!email.contains("@")) {
			mensagens.add("Email inválido");
		}
		if (cpf != null && cpf.length() != 11) {
			mensagens.add("CPF informado é inválido");
		}
		if (!mensagens.isEmpty()) {
			throw new IllegalArgumentException(mensagens.toString());
		}
	}
}
