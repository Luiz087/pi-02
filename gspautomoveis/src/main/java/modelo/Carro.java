package modelo;

public class Carro {

	private Integer idCarro;
	private String modelo;
	private String marca;
	private Integer ano;
	private Boolean novo;
	private String tipo;
	private String combustivel;
	private String potencia;
	private String cor;
	private Boolean abs;
	private Double precoCarro;
	private Long quilometragem;
	private Boolean promocao;

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

	public String getTipo() {
		return tipo;
	}

	public void setTipo(String tipo) {
		this.tipo = tipo;
	}

	public String getCombustivel() {
		return combustivel;
	}

	public void setCombustivel(String combustivel) {
		this.combustivel = combustivel;
	}

	public String getPotencia() {
		return potencia;
	}

	public void setPotencia(String potencia) {
		this.potencia = potencia;
	}

	public Boolean getAbs() {
		return abs;
	}

	public void setAbs(Boolean abs) {
		this.abs = abs;
	}

	public String getCor() {
		return cor;
	}

	public void setCor(String cor) {
		this.cor = cor;
	}


	public Long getQuilometragem() {
		return quilometragem;
	}

	public void setQuilometragem(Long quilometragem) {
		this.quilometragem = quilometragem;
	}

	public Boolean getPromocao() {
		return promocao;
	}

	public void setPromocao(Boolean promocao) {
		this.promocao = promocao;
	}

	public Double getPrecoCarro() {
		return precoCarro;
	}

	public void setPrecoCarro(Double precoCarro) {
		this.precoCarro = precoCarro;
	}

	public Integer getId_carro() {
		return idCarro;
	}

	public void setId_carro(Integer id_carro) {
		this.idCarro = id_carro;
	}

}
