package modelo;

import java.util.ArrayList;

public interface IFornecedorDAO {

	public Integer inserir(Fornecedor f);

	public boolean atualizar(Fornecedor f);

	public boolean excluir(Integer f);

	public ArrayList<Fornecedor> ListarFornecedores();
	
	public Fornecedor pegarForn(String fornecedor);
	
	public Fornecedor buscaFornecedor(Fornecedor fornecedor);

}
