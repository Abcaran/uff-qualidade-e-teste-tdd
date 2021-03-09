import java.util.Date;
import java.util.List;

public class OperacoesDeBoleto {

	public Pagamento gerarPagamento(List<Boleto> boletos) {
		long total = boletos
			.stream()
			.mapToLong(boleto -> boleto.getValorPago())
			.reduce(0, (subtotal, valor) -> subtotal + valor);
		return new Pagamento(total, new Date(), MeioDePagamento.BOLETO);
	}

}
