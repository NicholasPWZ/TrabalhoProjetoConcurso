import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

public class Concurso {

	private String local;
	private int identificador;
	private String empresa;
	private LocalDateTime dataHora;
	private String regras;
	private List<Concursado> participantes = new ArrayList<Concursado>();

	public int getIdentificador() {
		return identificador;
	}

	public void setIdentificador(int identificador) {
		if (identificador > 0) {
			this.identificador = identificador;
		} else {
			throw new IllegalArgumentException("Informe identificador positivo.");
		}
	}

	public String getLocal() {
		return local;
	}

	public void setLocal(String local) {
		this.local = local;
	}

	public String getEmpresa() {
		return empresa;
	}

	public void setEmpresa(String empresa) {
		this.empresa = empresa;
	}

	public LocalDateTime getDataHora() {
		return dataHora;
	}

	public void setDataHora(LocalDateTime dataHora) {
		if (dataHora.isAfter(LocalDateTime.now())) {
			this.dataHora = dataHora;
		} else {
			throw new IllegalArgumentException("Informe uma data no futuro");
		}
	}

	public String getRegras() {
		return regras;
	}

	public void adicionarParticipante(Concursado novoParticipante) {

		for (Concursado participanteJaSalvo : participantes) {
			if (participanteJaSalvo.getCpf().equals(novoParticipante.getCpf())) {
				throw new IllegalArgumentException("Participante ja cadastrado");
			}
		}
		this.participantes.add(novoParticipante);

	}

	public void setRegras(String regras) {
		this.regras = regras;
	}

	public List<Concursado> getParticipantes() {
		return participantes;
	}

}
