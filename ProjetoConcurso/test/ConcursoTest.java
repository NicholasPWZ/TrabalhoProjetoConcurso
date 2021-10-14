import java.time.LocalDateTime;

import org.junit.Assert;
import org.junit.jupiter.api.Test;

public class ConcursoTest {

	@Test
	public void deveCriarUmConcursoValido() {
		LocalDateTime dataConcurso = LocalDateTime.now().plusMonths(1);
		Concurso procergs = new Concurso();
		procergs.setDataHora(dataConcurso);
		procergs.setEmpresa("Procergs");
		procergs.setIdentificador(1);
		procergs.setLocal("Porto Alegre");
		procergs.setRegras("Levar caneta preta e chegar 30 min antes.");

		Assert.assertEquals("Procergs", procergs.getEmpresa());
		Assert.assertEquals(1, procergs.getIdentificador());
		Assert.assertEquals("Porto Alegre", procergs.getLocal());
		Assert.assertEquals("Levar caneta preta e chegar 30 min antes.", procergs.getRegras());
		Assert.assertEquals(dataConcurso, procergs.getDataHora());

	}

	@Test
	public void deveValidarDataHoraDoConcurso() {
		try {
			LocalDateTime dataConcurso = LocalDateTime.now().minusMonths(1);

			Concurso procergs = new Concurso();
			procergs.setDataHora(dataConcurso);
			procergs.setEmpresa("Procergs");
			procergs.setIdentificador(1);
			procergs.setLocal("Porto Alegre");
			procergs.setRegras("Levar caneta preta e chegar 30 in antes.");
		} catch (Exception e) {
			Assert.assertEquals("Informe uma data no futuro", e.getMessage());
		}

	}

	@Test
	public void deveValidarIdentificadorValido() {

		try {
			Concurso procergs = new Concurso();
			procergs.setIdentificador(-1000);
		} catch (Exception e) {
			Assert.assertEquals("Informe identificador positivo.", e.getMessage());
		}
	}

	@Test
	public void deveValidarInscricaoDeParticipantesComSucesso() {

		BancoDeDados bancoDados = new BancoDeDados();
		LocalDateTime dataConcursoProcergs = LocalDateTime.now().plusMonths(1);

		Concurso procergs = new Concurso();
		procergs.setDataHora(dataConcursoProcergs);
		procergs.setEmpresa("Procergs");
		procergs.setIdentificador(2);
		procergs.setLocal("Porto Alegre");
		procergs.setRegras("Levar caneta preta");

		LocalDateTime dataConcursoProcempa = LocalDateTime.now().plusMonths(3);

		Concurso procempa = new Concurso();
		procempa.setDataHora(dataConcursoProcempa);
		procempa.setEmpresa("Procempa");
		procempa.setIdentificador(3);
		procempa.setLocal("Canoas");
		procempa.setRegras("Levar caneta azul");

		LocalDateTime dataConcursoBanrisul = LocalDateTime.now().plusMonths(1);

		Concurso banrisul = new Concurso();
		banrisul.setDataHora(dataConcursoBanrisul);
		banrisul.setEmpresa("Banrisul");
		banrisul.setIdentificador(4);
		banrisul.setLocal("Sao Leopoldo");
		banrisul.setRegras("Levar caneta verde");

		bancoDados.salvarConcurso(procempa);
		bancoDados.salvarConcurso(procergs);
		bancoDados.salvarConcurso(banrisul);

		Concursado joao = new Concursado();
		joao.setCpf("12345612318");
		joao.setEmail("joaozinho123@gmail.com");
		joao.setIdade(19);
		joao.setNome("Joao Pedro Pereira");
		joao.setNota(8.5);

		Concursado pedro = new Concursado();
		pedro.setCpf("12345612312");
		pedro.setEmail("pedropereira@gmail.com");
		pedro.setIdade(18);
		pedro.setNome("Pedro Pereira");
		pedro.setNota(9);

		Concursado mauricio = new Concursado();
		mauricio.setCpf("12345612319");
		mauricio.setEmail("mauricio123@gmail.com");
		mauricio.setIdade(17);
		mauricio.setNome("Mauricio Pereira");
		mauricio.setNota(6);

		procergs.adicionarParticipante(joao);
		procergs.adicionarParticipante(mauricio);
		procergs.adicionarParticipante(pedro);
		Assert.assertEquals(3, procergs.getParticipantes().size());

	}

	@Test
	public void deveValidarParticipanteJaCadastrado() {
		BancoDeDados bancoDados = new BancoDeDados();
		LocalDateTime dataConcursoProcergs = LocalDateTime.now().plusMonths(1);

		Concurso procergs = new Concurso();
		procergs.setDataHora(dataConcursoProcergs);
		procergs.setEmpresa("Procergs");
		procergs.setIdentificador(2);
		procergs.setLocal("Porto Alegre");
		procergs.setRegras("Levar caneta preta");

		LocalDateTime dataConcursoProcempa = LocalDateTime.now().plusMonths(3);

		Concurso procempa = new Concurso();
		procempa.setDataHora(dataConcursoProcempa);
		procempa.setEmpresa("Procempa");
		procempa.setIdentificador(3);
		procempa.setLocal("Canoas");
		procempa.setRegras("Levar caneta azul");

		LocalDateTime dataConcursoBanrisul = LocalDateTime.now().plusMonths(1);

		Concurso banrisul = new Concurso();
		banrisul.setDataHora(dataConcursoBanrisul);
		banrisul.setEmpresa("Banrisul");
		banrisul.setIdentificador(4);
		banrisul.setLocal("Sao Leopoldo");
		banrisul.setRegras("Levar caneta verde");

		bancoDados.salvarConcurso(procempa);
		bancoDados.salvarConcurso(procergs);
		bancoDados.salvarConcurso(banrisul);

		Concursado joao = new Concursado();
		joao.setCpf("12345612318");
		joao.setEmail("joaozinho123@gmail.com");
		joao.setIdade(19);
		joao.setNome("Joao Pedro Pereira");
		joao.setNota(8.5);

		Concursado pedro = new Concursado();
		pedro.setCpf("12345612312");
		pedro.setEmail("pedropereira@gmail.com");
		pedro.setIdade(18);
		pedro.setNome("Pedro Pereira");
		pedro.setNota(9);

		procergs.adicionarParticipante(joao);

		procergs.adicionarParticipante(pedro);
		try {
			Concursado mauricio = new Concursado();
			mauricio.setCpf("12345612318");
			mauricio.setEmail("mauricio123@gmail.com");
			mauricio.setIdade(17);
			mauricio.setNome("Mauricio Pereira");
			mauricio.setNota(6);
			procergs.adicionarParticipante(mauricio);
		} catch (Exception e) {
			Assert.assertEquals("Participante ja cadastrado", e.getMessage());
		}
	}
}
