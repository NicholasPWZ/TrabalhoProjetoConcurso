import java.util.List;

import org.junit.Assert;
import org.junit.Test;

public class NavioTest {
	@Test
	public void deveCriarNavioComSucesso() {
		Navio navioA = new Navio();
		Navegacao navegacao = new Navegacao();
		navegacao.setOrigem("Porto Alegre");
		navegacao.setDestino("Macapa");
		Tipo tipo = new Tipo();
		tipo.setNome("cargueiro");
		Modelo modelo = new Modelo();
		modelo.setModelo("2005");
		navioA.setModelo(modelo);
		navioA.setNome("nomenavio");
		navioA.setTipo(tipo);
		navioA.setNavegacao(navegacao);
		navioA.setCapacidadeCarga(1500);

	}

	@Test
	public void deveAdicionarCargaComSucesso() {
		Navio navioA = new Navio();
		Navegacao navegacao = new Navegacao();
		navegacao.setOrigem("Porto Alegre");
		navegacao.setDestino("Macapa");
		Tipo tipo = new Tipo();
		tipo.setNome("cargueiro");
		Modelo modelo = new Modelo();
		modelo.setModelo("2005");
		navioA.setModelo(modelo);
		navioA.setNome("nomenavio");
		navioA.setTipo(tipo);
		navioA.setNavegacao(navegacao);
		navioA.setCapacidadeCarga(1500);
		Container container1 = new Container();
		container1.setPeso(150);
		navioA.adicionarCarga(container1);
		Assert.assertEquals(1, navioA.getContainers().size());

	}

	@Test
	public void deveImpedirQueACapacidadeMaximaSejaUltrapassada() {
		Navio navioA = new Navio();
		Navegacao navegacao = new Navegacao();
		navegacao.setOrigem("Porto Alegre");
		navegacao.setDestino("Macapa");
		Tipo tipo = new Tipo();
		tipo.setNome("cargueiro");
		Modelo modelo = new Modelo();
		modelo.setModelo("2005");
		navioA.setModelo(modelo);
		navioA.setNome("nomenavio");
		navioA.setTipo(tipo);
		navioA.setNavegacao(navegacao);
		navioA.setCapacidadeCarga(1500);
		Container container1 = new Container();
		container1.setPeso(1000);
		Container container2 = new Container();
		container2.setPeso(300);
		Container container3 = new Container();
		container3.setPeso(400);
		navioA.adicionarCarga(container3);
		navioA.adicionarCarga(container1);
		try {
			navioA.adicionarCarga(container2);
		} catch (Exception e) {
			Assert.assertEquals("Capacidade maxima atingida", e.getMessage());
		}
	}

	@Test
	public void DeveValidarOMetodoDeFiltroDaLista() {
		Navio navioA = new Navio();
		Navegacao navegacao = new Navegacao();
		navegacao.setOrigem("Porto Alegre");
		navegacao.setDestino("Macapa");
		Tipo tipo = new Tipo();
		tipo.setNome("cargueiro");
		Modelo modelo = new Modelo();
		modelo.setModelo("2005");
		navioA.setModelo(modelo);
		navioA.setNome("nomenavio");
		navioA.setTipo(tipo);
		navioA.setNavegacao(navegacao);
		navioA.setCapacidadeCarga(1500);
		Container container1 = new Container();
		container1.setPeso(1000);
		Container container2 = new Container();
		container2.setPeso(300);
		Container container3 = new Container();
		container3.setPeso(400);
		navioA.adicionarCarga(container3);
		navioA.adicionarCarga(container1);

		List<Container> filtrarPorPeso = navioA.filtrarContainersPorPeso(350);
		Assert.assertEquals(2, filtrarPorPeso.size());

	}

	@Test
	public void DeveValidarOMetodoDeFiltroDaQuantidade() {
		Navio navioA = new Navio();
		navioA.setCapacidadeCarga(1500);
		Container container1 = new Container();
		container1.setPeso(1000);
		Container container2 = new Container();
		container2.setPeso(300);
		Container container3 = new Container();
		container3.setPeso(400);
		navioA.adicionarCarga(container1);
		navioA.adicionarCarga(container2);

		List<Container> containers = navioA.filtrarQuantidadePorPeso(200);
		Assert.assertEquals(3, containers.size());

	}
}
