import java.time.LocalDateTime;
import java.util.List;

import org.junit.Assert;
import org.junit.Test;

public class BancoDeDadosTest {

	@Test
	public void deveCadastrarUmConcursadoComSucesso() throws IllegalAccessException {
		Concursado jose = new Concursado();
		jose.setEmail("jose@hotmail.com");
		jose.setNome("Jose Bezerra");
		jose.setCpf("12312312312");

		BancoDeDados bancoDados = new BancoDeDados();
		bancoDados.salvarConcursado(jose);
		Assert.assertEquals(1, bancoDados.getConcursados().size());
	}

	@Test
	public void deveValidarAExistenciaDeUmConcursadoCadastrado() {
		BancoDeDados bancoDados = new BancoDeDados();
		Concursado jefferson = new Concursado();
		jefferson.setCpf("12312312311");
		jefferson.setEmail("jefin123@gmail.com");
		jefferson.setNome("jefferson siakam");

		bancoDados.salvarConcursado(jefferson);

		try {
			Concursado lucas = new Concursado();
			lucas.setCpf("12312312311");
			lucas.setEmail("jefin123@gmail.com");
			lucas.setNome("jefferson siakam");
			bancoDados.salvarConcursado(lucas);
		} catch (Exception e) {
			Assert.assertEquals("Concursado ja cadastrado.", e.getMessage());
		}
	}

	@Test
	public void deveCadastrarUmConcursoComSucesso() {
		LocalDateTime dataConcursoProcergs = LocalDateTime.now().plusMonths(1);

		Concurso procergs = new Concurso();
		procergs.setDataHora(dataConcursoProcergs);
		procergs.setEmpresa("Procergs");
		procergs.setIdentificador(2);
		procergs.setLocal("AV Ipiranga");
		procergs.setRegras("Levar caneta preta");

		LocalDateTime dataConcursoProcempa = LocalDateTime.now().plusMonths(3);

		Concurso procempa = new Concurso();
		procempa.setDataHora(dataConcursoProcempa);
		procempa.setEmpresa("Procempa");
		procempa.setIdentificador(3);
		procempa.setLocal("AV Ipiranga");
		procempa.setRegras("Levar caneta azul");

		BancoDeDados bancoDados = new BancoDeDados();
		bancoDados.salvarConcurso(procempa);
		bancoDados.salvarConcurso(procergs);

		Assert.assertEquals(2, bancoDados.getConcursos().size());
	}

	@Test
	public void deveValidarAExistenciaDeUmConcursoJaCadastrado() {
		LocalDateTime dataConcursoProcergs = LocalDateTime.now().plusMonths(1);

		Concurso procergs = new Concurso();
		procergs.setDataHora(dataConcursoProcergs);
		procergs.setEmpresa("Procergs");
		procergs.setIdentificador(2);
		procergs.setLocal("AV Ipiranga");
		procergs.setRegras("Levar caneta preta");

		BancoDeDados bancoDados = new BancoDeDados();
		bancoDados.salvarConcurso(procergs);
		try {
			bancoDados.salvarConcurso(procergs);
		} catch (Exception e) {
			Assert.assertEquals("Concurso ja cadastrado", e.getMessage());

		}
	}

	@Test
	public void deveFiltrarConcursosPorCidade() {
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

		bancoDados.salvarConcurso(procempa);
		bancoDados.salvarConcurso(procergs);

		List<Concurso> concursosFiltradosPorCidade = bancoDados.filtrarConcursoPorCidade("Canoas");
		Assert.assertEquals(1, concursosFiltradosPorCidade.size());
	}

	@Test
	public void naoDeveEncontrarConcursoNaCidade() {
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

		bancoDados.salvarConcurso(procempa);
		bancoDados.salvarConcurso(procergs);

		List<Concurso> concursosFiltradosPorCidade = bancoDados.filtrarConcursoPorCidade("Novo Hamburgo");
		Assert.assertEquals(0, concursosFiltradosPorCidade.size());
	}

	@Test
	public void deveFiltrarConcursosPorEmpresa() {
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

		bancoDados.salvarConcurso(procempa);
		bancoDados.salvarConcurso(procergs);

		List<Concurso> filtrarPorEmpresa = bancoDados.filtrarConcursoPorEmpresa("Procergs");
		Assert.assertEquals(1, filtrarPorEmpresa.size());
	}

	@Test
	public void naoDeveEncontrarConcursoDaEmpresa() {
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
		List<Concurso> filtrarPorEmpresa = bancoDados.filtrarConcursoPorEmpresa("EPTC");
		Assert.assertEquals(0, filtrarPorEmpresa.size());
	}

	@Test
	public void DeveFiltrarConcursoPorPeriodo() {

		Concurso procergs = new Concurso();
		procergs.setDataHora(LocalDateTime.of(2021, 8, 20, 9, 30));
		procergs.setEmpresa("Procergs");
		procergs.setIdentificador(2);
		procergs.setLocal("Porto Alegre");
		procergs.setRegras("Levar caneta preta");

		Concurso procempa = new Concurso();
		procempa.setDataHora(LocalDateTime.of(2021, 8, 15, 8, 15));
		procempa.setEmpresa("Procempa");
		procempa.setIdentificador(3);
		procempa.setLocal("Canoas");
		procempa.setRegras("Levar caneta azul");

		Concurso banrisul = new Concurso();
		banrisul.setDataHora(LocalDateTime.of(2021, 8, 6, 11, 30));
		banrisul.setEmpresa("Banrisul");
		banrisul.setIdentificador(4);
		banrisul.setLocal("Sao Leopoldo");
		banrisul.setRegras("Levar caneta verde");
		BancoDeDados bancoDados = new BancoDeDados();
		bancoDados.salvarConcurso(procempa);
		bancoDados.salvarConcurso(procergs);
		bancoDados.salvarConcurso(banrisul);

		LocalDateTime dataInicial = LocalDateTime.of(2020, 8, 1, 1, 0);
		LocalDateTime dataFinal = LocalDateTime.of(2022, 8, 31, 23, 59);
		List<Concurso> concursosDeAgosto = bancoDados.filtrarPorPeriodo(dataInicial, dataFinal);
		Assert.assertEquals(3, concursosDeAgosto.size());
	}

	@Test
	public void naoDeveEncontrarFiltradoPorPeriodo() {
		Concurso procergs = new Concurso();
		procergs.setDataHora(LocalDateTime.of(2021, 8, 20, 9, 30));
		procergs.setEmpresa("Procergs");
		procergs.setIdentificador(2);
		procergs.setLocal("Porto Alegre");
		procergs.setRegras("Levar caneta preta");

		Concurso procempa = new Concurso();
		procempa.setDataHora(LocalDateTime.of(2021, 8, 15, 8, 15));
		procempa.setEmpresa("Procempa");
		procempa.setIdentificador(3);
		procempa.setLocal("Canoas");
		procempa.setRegras("Levar caneta azul");

		Concurso banrisul = new Concurso();
		banrisul.setDataHora(LocalDateTime.of(2021, 8, 6, 11, 30));
		banrisul.setEmpresa("Banrisul");
		banrisul.setIdentificador(4);
		banrisul.setLocal("Sao Leopoldo");
		banrisul.setRegras("Levar caneta verde");
		BancoDeDados bancoDados = new BancoDeDados();
		bancoDados.salvarConcurso(procempa);
		bancoDados.salvarConcurso(procergs);
		bancoDados.salvarConcurso(banrisul);

		LocalDateTime dataInicial = LocalDateTime.of(2022, 8, 1, 1, 0);
		LocalDateTime dataFinal = LocalDateTime.of(2022, 8, 31, 23, 59);
		List<Concurso> concursosDe2022 = bancoDados.filtrarPorPeriodo(dataInicial, dataFinal);
		Assert.assertEquals(0, concursosDe2022.size());
	}

	@Test
	public void DeveFiltrarReprovados() {
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
		List<Concursado> filtrarReprovados = bancoDados.filtrarReprovados();
		Assert.assertEquals(1, filtrarReprovados.size());
	}

	public void naoDeveEncontrarReprovados() {
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
		mauricio.setNota(7);

		procergs.adicionarParticipante(joao);
		procergs.adicionarParticipante(mauricio);
		procergs.adicionarParticipante(pedro);
		List<Concursado> filtrarReprovados = bancoDados.filtrarReprovados();
		Assert.assertEquals(0, filtrarReprovados.size());
	}

	@Test
	public void deveEncontrarPorNumeroParticipantes() {
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
		List<Concursado> filtrarPorNumeroDeParticipantes = procergs.getParticipantes();
		Assert.assertEquals(3, filtrarPorNumeroDeParticipantes.size());
	}

	@Test
	public void naoDeveEncontrarPorNumeroDeParticipantes() {
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

		List<Concursado> filtrarPorNumeroDeParticipantes = procergs.getParticipantes();
		Assert.assertEquals(0, filtrarPorNumeroDeParticipantes.size());

	}
}
