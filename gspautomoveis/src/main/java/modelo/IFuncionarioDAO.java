package modelo;

import java.util.ArrayList;

public interface IFuncionarioDAO {

	public boolean inserir(Funcionario f);

	public boolean atualizar(Funcionario f);

	public boolean excluir(Funcionario f);

	public ArrayList<Funcionario> ListarFuncionarios();
}
