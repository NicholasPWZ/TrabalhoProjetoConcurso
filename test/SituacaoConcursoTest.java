import java.time.LocalDateTime;

import org.junit.Assert;
import org.junit.jupiter.api.Test;

public class SituacaoConcursoTest {
	
	@Test
	public void deveCriarUmaSituacaoComSucesso(){
		Concurso procergs = new Concurso("Ufrgs", "Procergs", LocalDateTime.now().plusMonths(6), "Caneta preta", LocalDateTime.now().plusMonths(6).plusHours(6));
				SituacaoConcurso situacaoConcurso = new SituacaoConcurso(procergs, Situacao.APROVADO, 8, SituacaoPagamento.PAGO);
		Assert.assertEquals(procergs , situacaoConcurso.getConcurso());
		Assert.assertEquals("abacaxi" , situacaoConcurso.getSituacao());
		Assert.assertEquals(7 , situacaoConcurso.getNota());
		Assert.assertEquals("Pago"	, situacaoConcurso.getSituacaoPagamento());
		
	}
	
}
