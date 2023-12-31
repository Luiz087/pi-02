package modelo;

public class Fornecedor {
	
	private Integer idFornecedor;
	private String nomeFornecedor;
	private Long cnpjfornecedor;
	private Long telefoneFornecedor;
	private String marca;
	private String empresa;
	private Endereco endereco;

	public Endereco getEndereco() {
		return endereco;
	}

	public void setEndereco(Endereco endereco) {
		this.endereco = endereco;
	}

	public String getMarca() {
		return marca;
	}

	public void setMarca(String marca) {
		this.marca = marca;
	}

	public String getEmpresa() {
		return empresa;
	}

	public void setEmpresa(String empresa) {
		this.empresa = empresa;
	}

	public String getNomeFornecedor() {
		return nomeFornecedor;
	}

	public void setNomeFornecedor(String nomeFornecedor) {
		this.nomeFornecedor = nomeFornecedor;
	}

	public Long getCnpjfornecedor() {
		return cnpjfornecedor;
	}

	public void setCnpjfornecedor(Long cnpjfornecedor) {
		this.cnpjfornecedor = cnpjfornecedor;
	}

	public Long getTelefoneFornecedor() {
		return telefoneFornecedor;
	}

	public void setTelefoneFornecedor(Long telefoneFornecedor) {
		this.telefoneFornecedor = telefoneFornecedor;
	}

	public Integer getIdFornecedor() {
		return idFornecedor;
	}

	public void setIdFornecedor(Integer idFornecedor) {
		this.idFornecedor = idFornecedor;
	}

}
