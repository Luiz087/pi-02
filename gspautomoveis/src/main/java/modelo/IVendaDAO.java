package modelo;

import java.util.ArrayList;

public interface IVendaDAO {
	
	public Integer inserir(Venda v);

	public boolean atualizar(Venda v);

	public boolean excluir(Venda v);

	public ArrayList<Venda> ListarVendas();

}
