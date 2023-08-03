package modelo;

public class Carro {

	private String modelo;
	private String marca;
	private Integer ano;
	private Boolean novo;
	private Boolean eletrico;
	private Boolean esportivo;
	private Boolean picape;
	private String cor;
	private Double preco;
	private Long quilometragem;

	public String getModelo() {
		return modelo;
	}

	public void setModelo(String modelo) {
		this.modelo = modelo;
	}

	public String getMarca() {
		return marca;
	}

	public void setMarca(String marca) {
		this.marca = marca;
	}

	public Integer getAno() {
		return ano;
	}

	public void setAno(Integer ano) {
		this.ano = ano;
	}

	public Boolean getNovo() {
		return novo;
	}

	public void setNovo(Boolean novo) {
		this.novo = novo;
	}

	public Boolean getEletrico() {
		return eletrico;
	}

	public void setEletrico(Boolean eletrico) {
		this.eletrico = eletrico;
	}

	public Boolean getEsportivo() {
		return esportivo;
	}

	public void setEsportivo(Boolean esportivo) {
		this.esportivo = esportivo;
	}

	public Boolean getPicape() {
		return picape;
	}

	public void setPicape(Boolean picape) {
		this.picape = picape;
	}

	public String getCor() {
		return cor;
	}

	public void setCor(String cor) {
		this.cor = cor;
	}

	public Double getPreco() {
		return preco;
	}

	public void setPreco(Double preco) {
		this.preco = preco;
	}

	public Long getQuilometragem() {
		return quilometragem;
	}

	public void setQuilometragem(Long quilometragem) {
		this.quilometragem = quilometragem;
	}

}
