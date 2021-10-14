import java.util.ArrayList;
import java.util.List;

public class Navio {
	Tipo tipo;
	Modelo modelo;
	Navegacao navegacao;
	String nome;
	double capacidadeCarga;
	double cargaTotal = 0;

	public List<Container> containers = new ArrayList<Container>();

	public Tipo getTipo() {
		return tipo;
	}

	public void setTipo(Tipo tipo) {
		this.tipo = tipo;
	}

	public Modelo getModelo() {
		return modelo;
	}

	public void setModelo(Modelo modelo) {
		this.modelo = modelo;
	}

	public Navegacao getNavegacao() {
		return navegacao;
	}

	public void setNavegacao(Navegacao navegacao) {
		this.navegacao = navegacao;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public double getCapacidadeCarga() {
		return capacidadeCarga;
	}

	public void setCapacidadeCarga(double capacidadeCarga) {
		this.capacidadeCarga = capacidadeCarga;
	}

	public double getCargaTotal() {
		return cargaTotal;
	}

	public void setCargaTotal(double cargaTotal) {
		this.cargaTotal = cargaTotal;
	}

	public List<Container> getContainers() {
		return containers;
	}

	public void adicionarCarga(Container containers) {
		cargaTotal = cargaTotal + containers.getPeso();
		if (cargaTotal < capacidadeCarga) {
			this.containers.add(containers);
		} else {
			throw new IllegalArgumentException("Capacidade maxima atingida");
		}
	}

	public void removerCarga(Container containers) {
		this.containers.remove(containers);
	}

	public List<Container> filtrarContainersPorPeso(double peso) {
		List<Container> filtradosPeloPeso = new ArrayList<Container>();
		for (Container containersJaFiltrados : containers)
			if (containersJaFiltrados.getPeso() > peso) {
				filtradosPeloPeso.add(containersJaFiltrados);
			}
		return filtradosPeloPeso;
	}

	public double filtrarQuantidadePorPeso(double peso) {
		int qtdContainers = 0;
		for (Container containersJaFiltrados : containers)
			if (containersJaFiltrados.getPeso() > peso) {
				this.containers.add(containersJaFiltrados);
				qtdContainers++;
			}
		return qtdContainers;
	}
}
