import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

public class Concurso {

	private String local;
	private String empresa;
	private LocalDateTime dataHora;
	private String regras;
	private List<Concursado> participantes = new ArrayList<Concursado>();
	private LocalDateTime dataHoraMaxima;
	

	public Concurso(String local, String empresa, LocalDateTime dataHora, String regras, LocalDateTime dataHoraMaxima) {
		this.local = local;
		this.empresa = empresa;
		this.dataHora = dataHora;
		this.regras = regras;
		this.dataHoraMaxima = dataHoraMaxima;
	}

	public LocalDateTime getDataHoraMaxima() {
		return dataHoraMaxima;
	}

	public String getLocal() {
		return local;
	}

	public String getEmpresa() {
		return empresa;
	}

	public LocalDateTime getDataHora() {
		return dataHora;
	}

	public String getRegras() {
		return regras;
	}

	public void inscreverConcursado(Concursado novoParticipante) {

		for (Concursado participanteJaSalvo : participantes) {
			if (participanteJaSalvo.getCpf().equals(novoParticipante.getCpf())) {
				throw new IllegalArgumentException("Participante ja cadastrado");
			}
		}
		this.participantes.add(novoParticipante);

	}

	public List<Concursado> getParticipantes() {
		return participantes;
	}

}
