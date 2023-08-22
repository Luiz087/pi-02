package modelo;

import java.util.ArrayList;

public interface IFornecedorDAO {

	public boolean inserir(Fornecedor f);

	public boolean atualizar(Fornecedor f);

	public boolean excluir(Fornecedor f);

	public ArrayList<Fornecedor> ListarFornecedores();

}
