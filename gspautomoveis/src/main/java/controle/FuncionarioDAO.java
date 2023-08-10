package controle;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.ArrayList;

import modelo.Funcionario;
import modelo.IFuncionarioDAO;

public class FuncionarioDAO implements IFuncionarioDAO {

	public boolean inserir(Funcionario f) {

		Conexao c = Conexao.getInstancia();

		Connection con = c.conectar();

		String query = "INSET INTO funcionarios (nome, cpf, telefone, email, dataDeNasc, usuario, senha, NivelCargo, salario, comissao, enderecos_cep) values ('?', ?, ?, '?', ?, '?', '?', ?, ?, ?, ?)";

		try {
			PreparedStatement ps = con.prepareStatement(query);

			ps.setString(1, f.getNome());
			ps.setLong(2, f.getCpf());
			ps.setLong(3, f.getTelefone());
			ps.setString(4, f.getEmail());
			ps.setDate(5, f.getDataDeNasc());
			ps.setString(6, f.getUsuario());
			ps.setString(7, f.getSenha());
			ps.setInt(8, f.getNivelCargo());
			ps.setDouble(9, f.getSalario());
			ps.setDouble(10, f.getComissao());

			ps.executeUpdate();

			c.fecharConexao();

			return true;

		} catch (SQLException e) {
			e.printStackTrace();
		}

		return false;

	}

	@Override
	public boolean alterar() {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean excluir() {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public ArrayList<Funcionario> ListarFuncionarios() {
		// TODO Auto-generated method stub
		return null;
	}

}
