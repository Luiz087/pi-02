package modelo;

import java.util.ArrayList;

public interface IFuncionarioDAO {

	public boolean inserir(Funcionario f);

	public boolean atualizar();

	public boolean excluir();

	public ArrayList<Funcionario> ListarFuncionarios();
}
