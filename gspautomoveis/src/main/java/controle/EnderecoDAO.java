package controle;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.ArrayList;

import modelo.Endereco;
import modelo.IEnderecoDAO;

public class EnderecoDAO implements IEnderecoDAO {

	public boolean inserir(Endereco e) {

		Conexao c = Conexao.getInstancia();

		Connection con = c.conectar();

		String query = "insert into enderecos (cep, rua, bairro, cidade, estado) values (?, '?', '?', '?', '?')";

		try {
			PreparedStatement ps = con.prepareStatement(query);

			ps.setLong(1, e.getCep());
			ps.setString(2, e.getRua());
			ps.setString(2, e.getBairro());
			ps.setString(2, e.getCidade());
			ps.setString(2, e.getEstado());

			ps.executeUpdate();

			c.fecharConexao();
			
			return true;

		} catch (SQLException e1) {
			e1.printStackTrace();
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
	public ArrayList<Endereco> ListarEnderecos() {
		// TODO Auto-generated method stub
		return null;
	}
}
