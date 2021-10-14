import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

public class BancoDeDados {

	private List<Concursado> concursados = new ArrayList<Concursado>();

	private List<Concurso> concursos = new ArrayList<Concurso>();

	public List<Concurso> getConcursos() {
		return concursos;
	}

	public void salvarConcurso(Concurso novoConcurso) {
		for (Concurso concursoJaSalvo : concursos) {
			if (novoConcurso.getIdentificador() == concursoJaSalvo.getIdentificador()) {
				throw new IllegalArgumentException("Concurso ja cadastrado");
			}
		}
		this.concursos.add(novoConcurso);
	}

	public void salvarConcursado(Concursado novoConcursado) {
		for (Concursado concursadoJaSalvo : concursados) {
			if (novoConcursado.getCpf().equals(concursadoJaSalvo.getCpf())) {
				throw new IllegalArgumentException("Concursado ja cadastrado.");
			}
		}
		this.concursados.add(novoConcursado);

	}

	public List<Concurso> filtrarConcursoPorCidade(String cidade) {
		List<Concurso> concursosFiltrados = new ArrayList<Concurso>();
		for (Concurso concursoJaSalvo : concursos) {
			if (concursoJaSalvo.getLocal().contains(cidade)) {
				concursosFiltrados.add(concursoJaSalvo);
			}
		}
		return concursosFiltrados;

	}

	public List<Concurso> filtrarPorPeriodo(LocalDateTime dataInicial, LocalDateTime dataFinal) {
		List<Concurso> concursoFiltrado = new ArrayList<Concurso>();
		for (Concurso concursoJaSalvo : concursos) {
			if (concursoJaSalvo.getDataHora().isAfter(dataInicial)
					&& concursoJaSalvo.getDataHora().isBefore(dataFinal)) {
				concursoFiltrado.add(concursoJaSalvo);
			}
		}
		return concursoFiltrado;
	}

	public List<Concurso> filtrarConcursoPorEmpresa(String empresa) {
		List<Concurso> filtradosPorEmpresa = new ArrayList<Concurso>();
		for (Concurso concursoJaSalvo : concursos) {
			if (concursoJaSalvo.getEmpresa().contains(empresa)) {
				filtradosPorEmpresa.add(concursoJaSalvo);
			}
		}
		return filtradosPorEmpresa;
	}

	public List<Concursado> filtrarReprovados() {
		List<Concursado> concursadosReprovados = new ArrayList<Concursado>();
		for (Concurso concursoJaSalvo : concursos) {
			List<Concursado> participantes = concursoJaSalvo.getParticipantes();
			for (Concursado concursadoJaSalvo : participantes) {
				if (concursadoJaSalvo.getNota() < 7) {
					concursadosReprovados.add(concursadoJaSalvo);
				}
			}
		}
		return concursadosReprovados;
	}
	
	public List<Concursado> getConcursados() {
		return concursados;
	}

}
