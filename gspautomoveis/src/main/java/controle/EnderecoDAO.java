package controle;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
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

			return true;

		} catch (SQLException e1) {
			e1.printStackTrace();
		} finally {
			c.fecharConexao();
		}

		return false;

	}

	public boolean atualizar(Endereco e) {

		Conexao c = Conexao.getInstancia();

		Connection con = c.conectar();

		String query = "UPDATE enderecos SET cep = ?" + "rua = ?" + "bairro = ?" + "cidade = ?"
				+ "estado = ? WHERE id_endereco = ?";

		try {
			PreparedStatement ps = con.prepareStatement(query);

			ps.setLong(1, e.getCep());
			ps.setString(2, e.getRua());
			ps.setString(3, e.getBairro());
			ps.setString(4, e.getCidade());
			ps.setString(5, e.getEstado());

			ps.executeUpdate();

			return true;

		} catch (SQLException e1) {
			e1.printStackTrace();
		} finally {
			c.fecharConexao();
		}

		return false;
	}

	public boolean excluir(Endereco ed) {

		Conexao c = Conexao.getInstancia();

		Connection con = c.conectar();

		String query = "DELETE FROM enderecos WHERE id_endereco = ?";

		try {
			PreparedStatement ps = con.prepareStatement(query);

			ps.setInt(1, ed.getIdEndereco());

			ps.executeUpdate();

			return true;
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			c.fecharConexao();
		}

		return false;
	}

	public ArrayList<Endereco> ListarEnderecos() {

		Conexao c = Conexao.getInstancia();

		Connection con = c.conectar();

		ArrayList<Endereco> Enderecos = new ArrayList<>();

		String query = "SELECT * FROM enderecos";

		try {
			PreparedStatement ps = con.prepareStatement(query);

			ResultSet rs = ps.executeQuery();

			while (rs.next()) {
				Long Cep = rs.getLong("Cep");
				String Rua = rs.getString("Rua");
				String Bairro = rs.getString("Bairro");
				String Cidade = rs.getString("Cidade");
				String Estado = rs.getString("Estado");

				Endereco E = new Endereco();

				E.setCep(Cep);
				E.setRua(Rua);
				E.setBairro(Bairro);
				E.setCidade(Cidade);
				E.setEstado(Estado);

				Enderecos.add(E);

			}
		} catch (SQLException e) {

			e.printStackTrace();
		} finally {
			c.fecharConexao();
		}

		return Enderecos;
	}
}
