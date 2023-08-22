package modelo;

import java.util.ArrayList;

public interface IEnderecoDAO {

	public boolean inserir(Endereco e);

	public boolean atualizar(Endereco e);

	public boolean excluir(Endereco ed);

	public ArrayList<Endereco> ListarEnderecos();

}
