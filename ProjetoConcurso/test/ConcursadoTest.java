import org.junit.Assert;
import org.junit.jupiter.api.Test;

public class ConcursadoTest {

	@Test
	public void deveCriarUmConcursadoComSucesso() throws IllegalAccessException {
		Concursado joao = new Concursado();
		joao.setNome("Joao da Silva");
		joao.setCpf("13312312312");
		joao.setIdade(42);
		joao.setEmail("joaoDaSilva@hotmail.com");

		Assert.assertEquals("Joao da Silva", joao.getNome());
		Assert.assertEquals("13312312312", joao.getCpf());
		Assert.assertEquals(42, joao.getIdade());
		Assert.assertEquals("joaoDaSilva@hotmail.com", joao.getEmail());
	}

	@Test
	public void deveValidarCpfDoConcursado() {
		try {
			Concursado joao = new Concursado();
			joao.setCpf("123");
		} catch (Exception exception) {
			Assert.assertEquals("Informe um CPF valido.", exception.getMessage());
		}
	}

	@Test
	public void deveValidarEmailDoConcursado() {
		Concursado joao = new Concursado();
		try {
			joao.setEmail("joaoDaSilva123@hotmail.com");
		} catch (Exception exception) {
			Assert.assertEquals("Informe um email valido.", exception.getMessage());
		}
	}

	@Test
	public void deveValidarNotaDoConcursado() {
		Concursado joao = new Concursado();
		try {
			joao.setNota(7);
		} catch (Exception exception) {
			Assert.assertEquals("Digite uma nota valida", exception.getMessage());
		}
	}
}
