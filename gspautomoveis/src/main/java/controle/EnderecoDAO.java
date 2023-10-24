package controle;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

import modelo.Endereco;
import modelo.IEnderecoDAO;

public class EnderecoDAO implements IEnderecoDAO {

	private static EnderecoDAO instancia;

	public static EnderecoDAO getInstancia() {
		if (instancia == null) {
			instancia = new EnderecoDAO();
		}
		return instancia;
	}

	public Integer inserir(Endereco e) {

		Conexao c = Conexao.getInstancia();

		Connection con = c.conectar();

		String query = "insert into enderecos (cep, rua, bairro, cidade, estado) values (?, ?, ?, ?, ?)";

		try {
			PreparedStatement ps = con.prepareStatement(query, Statement.RETURN_GENERATED_KEYS);

			ps.setLong(1, e.getCep());
			ps.setString(2, e.getRua());
			ps.setString(3, e.getBairro());
			ps.setString(4, e.getCidade());
			ps.setString(5, e.getEstado());

			ps.executeUpdate();
			try (ResultSet generatedKeys = ps.getGeneratedKeys()) {
				if (generatedKeys.next()) {
					return generatedKeys.getInt(1);
				} else {
					throw new SQLException("Creating user failed, no ID obtained.");
				}
			}

		} catch (SQLException e1) {
			e1.printStackTrace();
		} finally {
			c.fecharConexao();
		}

		return 0;

	}

	public boolean atualizar(Endereco e) {

		Conexao c = Conexao.getInstancia();

		Connection con = c.conectar();

		String query = "UPDATE enderecos SET cep = ?, rua = ?, bairro = ?, cidade = ?,"
				+ " estado = ? WHERE id_endereco = ?";

		try {
			PreparedStatement ps = con.prepareStatement(query);

			ps.setLong(1, e.getCep());
			ps.setString(2, e.getRua());
			ps.setString(3, e.getBairro());
			ps.setString(4, e.getCidade());
			ps.setString(5, e.getEstado());
			ps.setInt(6, e.getIdEndereco());

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

	public Endereco buscaEndereco(Integer integer) {
		Conexao c = Conexao.getInstancia();
		Connection con = c.conectar();
		Endereco E = new Endereco();
		String query = "SELECT * FROM enderecos WHERE id_endereco = ?";
		try {
			PreparedStatement ps = con.prepareStatement(query);
			ps.setInt(1, integer);

			ResultSet rs = ps.executeQuery();
			while (rs.next()) {
				Long Cep = rs.getLong("Cep");
				String Rua = rs.getString("Rua");
				String Bairro = rs.getString("Bairro");
				String Cidade = rs.getString("Cidade");
				String Estado = rs.getString("Estado");
				Integer IdEndereco = rs.getInt("id_endereco");

				E.setCep(Cep);
				E.setRua(Rua);
				E.setBairro(Bairro);
				E.setCidade(Cidade);
				E.setEstado(Estado);
				E.setIdEndereco(IdEndereco);
				return E;
			}
		} catch (SQLException e) {

			e.printStackTrace();
		} finally {
			c.fecharConexao();
		}

		return E;
	}

	public Endereco buscaEnderecoByAtributo(Endereco end) {
		Conexao c = Conexao.getInstancia();
		Connection con = c.conectar();
		Endereco E = new Endereco();
		String query = "SELECT * FROM enderecos WHERE id_endereco = ?";
		try {
			PreparedStatement ps = con.prepareStatement(query);
			ps.setLong(1, end.getCep());

			ResultSet rs = ps.executeQuery();
			while (rs.next()) {
				Long Cep = rs.getLong("Cep");
				String Rua = rs.getString("Rua");
				String Bairro = rs.getString("Bairro");
				String Cidade = rs.getString("Cidade");
				String Estado = rs.getString("Estado");
				Integer IdEndereco = rs.getInt("id_endereco");

				E.setCep(Cep);
				E.setRua(Rua);
				E.setBairro(Bairro);
				E.setCidade(Cidade);
				E.setEstado(Estado);
				E.setIdEndereco(IdEndereco);
				return E;
			}
		} catch (SQLException e) {

			e.printStackTrace();
		} finally {
			c.fecharConexao();
		}

		return E;
	}
}
