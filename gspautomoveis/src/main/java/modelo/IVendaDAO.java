package modelo;

import java.util.ArrayList;

public interface IVendaDAO {
	
	public boolean inserir(Venda v);

	public boolean atualizar();

	public boolean excluir();

	public ArrayList<Venda> ListarVendas();

}
