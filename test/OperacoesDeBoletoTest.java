import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

class OperacoesDeBoletoTest {

	private OperacoesDeBoleto operacao;

	@BeforeEach()
	public void init() {
		operacao = new OperacoesDeBoleto();
	}

	@Test
	@DisplayName("Teste para boletos com valor igual a fatura e pagos resultam em fatura paga")
	void TesteFaturaPagaBoletos() {
		Fatura fatura = new Fatura(new Date(), 5000, "Caco Antibes");
		Boleto boletoA = new Boleto(new Date(), 3000);
		Boleto boletoB = new Boleto(new Date(), 2000);

		List<Boleto> boletos = new ArrayList<Boleto>();

		boletos.add(boletoA);
		boletos.add(boletoB);

		Pagamento pagamento = operacao.gerarPagamento(boletos);
		fatura.pagarfatura(pagamento);

		Assertions.assertEquals(fatura.getStatus(), FaturaStatus.PAGA);
	}

	@Test
	@DisplayName("Teste para boletos com valor superior a fatura e pagos resultam em fatura paga")
	void TestaFaturaPagaMaiorBoletos() {
		Assertions.fail();
	}

	@Test
	@DisplayName("Teste para boletos com valor inferior a fatura e pagos resultam em fatura pendente")
	void TestaFaturaPagaMenorBoletos() {
		Assertions.fail();
	}
	
	@Test
	@DisplayName("Teste tipo de pagamento correto")
	void TestaTipoDePagamento() {
		Assertions.fail();
	}

}
