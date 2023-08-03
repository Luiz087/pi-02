package modelo;

public class Funcionario extends Pessoa {

	private Double salario;
	private String funcao;
	private Integer nivelCargo;

	public Double getSalario() {
		return salario;
	}

	public void setSalario(Double salario) {
		this.salario = salario;
	}

	public String getFuncao() {
		return funcao;
	}

	public void setFuncao(String funcao) {
		this.funcao = funcao;
	}

	public Integer getNivelCargo() {
		return nivelCargo;
	}

	public void setNivelCargo(Integer nivelCargo) {
		this.nivelCargo = nivelCargo;
	}
}
