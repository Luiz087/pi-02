package controle;

import java.sql.Connection;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import modelo.Endereco;
import modelo.Funcionario;
import modelo.IFuncionarioDAO;

public class FuncionarioDAO implements IFuncionarioDAO {

	private static FuncionarioDAO instancia;

	public static FuncionarioDAO getInstancia() {
		if (instancia == null) {
			instancia = new FuncionarioDAO();
		}
		return instancia;
	}

	public Funcionario funcAchado = null;

	public boolean inserir(Funcionario f) {

		Conexao c = Conexao.getInstancia();

		Connection con = c.conectar();

		String query = "INSERT INTO funcionarios " + "(nome, " + "cpf, " + "telefone, " + "email, " + "dataDeNasc, "
				+ "usuario, " + "senha, " + "NivelCargo, " + "salario, " + "comissao, " + "enderecos_id_endereco) "
				+ "values (?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?)";

		try {
			PreparedStatement ps = con.prepareStatement(query);

			ps.setString(1, f.getNome());
			ps.setLong(2, f.getCpf());
			ps.setLong(3, f.getTelefone());
			ps.setString(4, f.getEmail());
			ps.setString(5, f.getDataDeNasc());
			ps.setString(6, f.getUsuario());
			ps.setString(7, f.getSenha());
			ps.setString(8, f.getNivelCargo());
			ps.setDouble(9, f.getSalario());
			ps.setDouble(10, f.getComissao());
			ps.setInt(11, f.getEndereco().getIdEndereco());

			ps.executeUpdate();

			return true;

		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			c.fecharConexao();
		}

		return false;

	}

	public boolean atualizarFunc(Funcionario f) {
		Conexao c = Conexao.getInstancia();

		Connection con = c.conectar();

		String query = "UPDATE funcionarios SET telefone = ?," + "email = ?," + "usuario = ?," + "senha = ? "
				+ "WHERE matricula = ?";

		try {
			PreparedStatement ps = con.prepareStatement(query);

			ps.setLong(1, f.getTelefone());
			ps.setString(2, f.getEmail());
			ps.setString(3, f.getUsuario());
			ps.setString(4, f.getSenha());
			ps.setInt(5, f.getMatricula());

			ps.executeUpdate();

			return true;

		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			c.fecharConexao();
		}

		return false;
	}

	public boolean atualizar(Funcionario f) {

		Conexao c = Conexao.getInstancia();

		Connection con = c.conectar();

		String query = "UPDATE funcionarios SET nome = ?," + "telefone = ?," + "email = ?," + "usuario = ?,"
				+ "nivelCargo = ?," + "salario = ?," + "comissao = ? WHERE matricula = ?";

		try {
			PreparedStatement ps = con.prepareStatement(query);

			ps.setString(1, f.getNome());
			ps.setLong(2, f.getTelefone());
			ps.setString(3, f.getEmail());
			ps.setString(4, f.getUsuario());
			ps.setString(5, f.getNivelCargo());
			ps.setDouble(6, f.getSalario());
			ps.setDouble(7, f.getComissao());
			// chave estrangeira endereco_id_endereco
			ps.setInt(8, f.getMatricula());

			ps.executeUpdate();

			return true;

		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			c.fecharConexao();
		}

		return false;
	}

	public boolean excluir(Funcionario f) {
		Conexao c = Conexao.getInstancia();

		Connection con = c.conectar();

		String query = "DELETE FROM funcionarios WHERE matricula = ?";

		try {
			PreparedStatement ps = con.prepareStatement(query);

			ps.setInt(1, f.getMatricula());

			ps.executeUpdate();

			return true;
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			c.fecharConexao();
		}

		return false;
	}

	public ArrayList<Funcionario> ListarFuncionarios() {

		Conexao c = Conexao.getInstancia();

		Connection con = c.conectar();

		ArrayList<Funcionario> Funcionarios = new ArrayList<>();

		String Query = "SELECT * FROM funcionarios";

		try {
			PreparedStatement ps = con.prepareStatement(Query);

			ResultSet rs = ps.executeQuery();

			while (rs.next()) {

				Integer matricula = rs.getInt("matricula");
				String Nome = rs.getString("Nome");
				Long Cpf = rs.getLong("Cpf");
				Long Telefone = rs.getLong("Telefone");
				String Email = rs.getString("Email");
				String DataDeNasc = rs.getString("DataDeNasc");
				String Usuario = rs.getString("Usuario");
				String Senha = rs.getString("Senha");
				String NivelCargo = rs.getString("NivelCargo");
				Double Salario = rs.getDouble("Salario");
				Double Comissao = rs.getDouble("Comissao");
				Integer endFunc = rs.getInt("enderecos_id_endereco");

				Funcionario F = new Funcionario();

				F.setMatricula(matricula);
				F.setNome(Nome);
				F.setCpf(Cpf);
				F.setTelefone(Telefone);
				F.setEmail(Email);
				F.setDataDeNasc(DataDeNasc);
				F.setUsuario(Usuario);
				F.setSenha(Senha);
				F.setNivelCargo(NivelCargo);
				F.setSalario(Salario);
				F.setComissao(Comissao);
				Endereco end = new Endereco();
				end.setIdEndereco(endFunc);
				F.setEndereco(end);

				Funcionarios.add(F);
			}

		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			c.fecharConexao();
		}

		return Funcionarios;
	}

	public Funcionario login(Funcionario f) {
		funcAchado = null;
		for (Funcionario func : ListarFuncionarios()) {
			if (func.getUsuario().equals(f.getUsuario()) && func.getSenha().equals(f.getSenha())) {

				funcAchado = func;

				return funcAchado;
			}
		}
		return funcAchado;
	}

	public Funcionario logoff() {
		return funcAchado = null;
	}

	public Funcionario passaLogado() {
		return funcAchado;
	}

	public Funcionario clicado(Integer f) {
		Funcionario funcClicado = new Funcionario();
		for (Funcionario func : ListarFuncionarios()) {
			if (func.getMatricula().equals(f)) {

				funcClicado = func;

				return funcClicado;
			}
		}
		return funcClicado;
	}

}
