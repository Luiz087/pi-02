package modelo;

import java.util.ArrayList;

public interface ICarroDAO {

	public boolean inserir(Carro ca);

	public boolean atualizar(Carro ca);

	public boolean excluir(Carro ca);

	public ArrayList<Carro> ListarCarros();

}
