package modelo;

import java.util.ArrayList;

public interface IFornecedorDAO {

	public boolean inserir(Fornecedor f);

	public boolean alterar();

	public boolean excluir();

	public ArrayList<Fornecedor> ListarFornecedores();

}
