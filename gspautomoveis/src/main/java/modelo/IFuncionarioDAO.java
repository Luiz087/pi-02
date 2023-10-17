package modelo;

import java.util.ArrayList;

public interface IFuncionarioDAO {

	public Integer inserir(Funcionario f);

	public boolean atualizarFunc(Funcionario f);

	public boolean atualizar(Funcionario f);

	public boolean excluir(Funcionario f);

	public ArrayList<Funcionario> ListarFuncionarios();

	public Funcionario login(Funcionario f);

	public Funcionario logoff();

	public Funcionario passaLogado();

	public Funcionario clicado(Integer f);

}
