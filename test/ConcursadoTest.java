import org.junit.Assert;
import org.junit.jupiter.api.Test;

public class ConcursadoTest {

	@Test
	public void deveCriarUmConcursadoComSucesso() throws IllegalAccessException {
		Concursado joao = new Concursado("Joao pereira", 16, "12345678912", "emaildojoao@joao.com");

		Assert.assertEquals("Joao pereira", joao.getNome());
		Assert.assertEquals("12345678912", joao.getCpf());
		Assert.assertEquals(16, joao.getIdade());
		Assert.assertEquals("emaildojoao@joao.com", joao.getEmail());
	}

	@Test
	public void deveValidarCpfDoConcursado() {
		try {
			Concursado joao = new Concursado("Joao pereira", 16, "1234567891", "emaildojoao@joao.com");
			Assert.assertEquals(joao.getCpf(), "1234567891");
		} catch (Exception exception) {
			Assert.assertEquals("[CPF informado é inválido]", exception.getMessage());
		}
	}

	@Test
	public void deveValidarEmailDoConcursado() {
		try {
			Concursado joao = new Concursado("Joao pereira", 16, "12345678912", "emaildojoaojoao.com");
			Assert.assertEquals(joao.getEmail(), "emaildojoaojoao.com");
		} catch (Exception exception) {
			Assert.assertEquals("[Email inválido]", exception.getMessage());
		}
	}

	@Test
	public void deveValidarIdadeDoConcursado() {
		try {
			Concursado joao = new Concursado("Joao pereira", 68, "12345678912", "emaildo@joaojoao.com");
			Assert.assertEquals(joao.getIdade(), 68);
		} catch (Exception e) {
			Assert.assertEquals("[Idade não é valida para inscrição]", e.getMessage());
		}
	}
}
