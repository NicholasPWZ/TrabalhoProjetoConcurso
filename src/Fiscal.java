import java.util.ArrayList;
import java.util.List;

public class Fiscal extends Pessoa {
	private String agencia;
	private String conta;
	private String pix;

	public Fiscal(String nome, int idade, String cpf, String email, String agencia, String conta, String pix) {
		super(nome, idade, cpf, email);
		this.agencia = agencia;
		this.conta = conta;
		this.pix = pix;
		validar();
	}
	
	protected void validar() {
		List<String>mensagens = new ArrayList<String>();
		if(nome == null || nome.isBlank()) {
			mensagens.add("Nome deve ser informado");			
		}
		if(cpf == null || cpf.isBlank()) {
			mensagens.add("CPF deve ser informado");
			}
		if(email == null || email.isBlank()) {
			mensagens.add("Email deve ser informado");
		}
		if(agencia == null || agencia.isBlank()) {
			mensagens.add("Agencia deve ser informada");
		}
		if(conta == null || conta.isBlank()) {
			mensagens.add("Conta deve ser informada");
		}
		if(pix == null || pix.isBlank()) {
			mensagens.add("Pix deve ser informado");
		}
		
	}
	public String getAgencia() {
		return agencia;
	}

	public String getConta() {
		return conta;
	}

	public String getPix() {
		return pix;
	}

}
