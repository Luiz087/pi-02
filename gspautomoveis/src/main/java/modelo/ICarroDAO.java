package modelo;

import java.util.ArrayList;

public interface ICarroDAO {
	
	public boolean inserir(Carro ca);
	
	public boolean alterar();
	
	public boolean excluir();
	
	public ArrayList<Carro> ListarCarros();

}
