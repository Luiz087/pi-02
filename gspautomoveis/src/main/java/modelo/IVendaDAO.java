package modelo;

import java.util.ArrayList;

public interface IVendaDAO {
	
	public boolean inserir(Venda v);

	public boolean alterar();

	public boolean excluir();

	public ArrayList<Venda> ListarVendas();

}
