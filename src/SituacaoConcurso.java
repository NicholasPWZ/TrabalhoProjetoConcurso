
public class SituacaoConcurso {
	private Concurso concurso;
	private Situacao situacao;
	private int nota;
	private SituacaoPagamento situacaoPagamento;

	public SituacaoConcurso(Concurso concurso, Situacao situacao, int nota, SituacaoPagamento situacaoPagamento) {
		validar();
		this.concurso = concurso;
		this.situacao = situacao;
		this.nota = nota;
		this.situacaoPagamento = situacaoPagamento;
	}

	private void validar() {
		if (situacao == null) {
			throw new IllegalArgumentException("Situação é obrigatória");
		}
	}

	public Concurso getConcurso() {
		return concurso;
	}

	public Situacao getSituacao() {
		return situacao;
	}

	public int getNota() {
		return nota;
	}

	public SituacaoPagamento getSituacaoPagamento() {
		return situacaoPagamento;
	}

}
