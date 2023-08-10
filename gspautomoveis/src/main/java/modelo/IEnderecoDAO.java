package modelo;

import java.util.ArrayList;

public interface IEnderecoDAO {
	
	public boolean inserir(Endereco e);

	public boolean alterar();

	public boolean excluir();

	public ArrayList<Endereco> ListarEnderecos();

}
