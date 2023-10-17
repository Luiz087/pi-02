package modelo;

import java.util.ArrayList;

public interface IEnderecoDAO {

	public Integer inserir(Endereco e);

	public boolean atualizar(Endereco e);

	public boolean excluir(Endereco ed);

	public ArrayList<Endereco> ListarEnderecos();
	
	public Endereco buscaEndereco(Integer integer);
	
	public Endereco buscaEnderecoByAtributo(Endereco end);

}
