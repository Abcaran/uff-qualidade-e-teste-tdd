import java.util.Date;

public class Pagamento {

	private Date date;
	private long valorTotal;
	private MeioDePagamento meioDePagamento;

	public Pagamento(long total, Date date, MeioDePagamento meioDePagamento) {
		this.valorTotal = total;
		this.date = date;
		this.meioDePagamento = meioDePagamento;
	}
	
	public long getValorTotal() {
		return this.valorTotal;
	}

}
