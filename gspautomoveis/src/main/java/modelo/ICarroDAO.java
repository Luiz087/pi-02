package modelo;

import java.util.ArrayList;

public interface ICarroDAO {

	public Integer inserir(Carro ca);

	public boolean atualizar(Carro ca);

	public boolean excluir(Integer ca);

	public ArrayList<Carro> ListarCarros();
	
	public Carro clicado(Integer id); 

}
