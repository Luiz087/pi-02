package modelo;

import java.time.LocalDate;

public class Pagamento {

	private String formapagamento;
	private LocalDate dataPagamento;

	public String getFormapagamento() {
		return formapagamento;
	}

	public void setFormapagamento(String formapagamento) {
		this.formapagamento = formapagamento;
	}

	public LocalDate getDataPagamento() {
		return dataPagamento;
	}

	public void setDataPagamento(LocalDate dataPagamento) {
		this.dataPagamento = dataPagamento;
	}

}
