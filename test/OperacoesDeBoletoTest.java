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
		Fatura fatura = new Fatura(new Date(), 10000, "Caco Antibes");
		Boleto boletoA = new Boleto(new Date(), 10000);
		Boleto boletoB = new Boleto(new Date(), 5000);

		List<Boleto> boletos = new ArrayList<Boleto>();

		boletos.add(boletoA);
		boletos.add(boletoB);

		Pagamento pagamento = operacao.gerarPagamento(boletos);
		fatura.pagarfatura(pagamento);

		Assertions.assertEquals(fatura.getStatus(), FaturaStatus.PAGA);
	}

	@Test
	@DisplayName("Teste para boletos com valor inferior a fatura e pagos resultam em fatura pendente")
	void TestaFaturaPagaMenorBoletos() {
		Fatura fatura = new Fatura(new Date(), 5000, "Caco Antibes");
		Boleto boletoA = new Boleto(new Date(), 1000);
		Boleto boletoB = new Boleto(new Date(), 500);

		List<Boleto> boletos = new ArrayList<Boleto>();

		boletos.add(boletoA);
		boletos.add(boletoB);

		Pagamento pagamento = operacao.gerarPagamento(boletos);
		fatura.pagarfatura(pagamento);

		Assertions.assertEquals(fatura.getStatus(), FaturaStatus.PENDENTE);
	}

	@Test
	@DisplayName("Teste tipo de pagamento correto")
	void TestaTipoDePagamento() {
		Fatura fatura = new Fatura(new Date(), 4000, "Caco Antibes");
		Boleto boletoA = new Boleto(new Date(), 2000);

		List<Boleto> boletos = new ArrayList<Boleto>();

		boletos.add(boletoA);

		Pagamento pagamento = operacao.gerarPagamento(boletos);

		Assertions.assertEquals(pagamento.getMeioDePagamento(), MeioDePagamento.BOLETO);
		Assertions.assertNotEquals(pagamento.getMeioDePagamento(), MeioDePagamento.CARTAO);
	}

}
