package controle;

import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

import modelo.Endereco;
import modelo.Funcionario;
import modelo.IFuncionarioDAO;
import modelo.Venda;

public class FuncionarioDAO implements IFuncionarioDAO {

	private static FuncionarioDAO instancia;

	public static FuncionarioDAO getInstancia() {
		if (instancia == null) {
			instancia = new FuncionarioDAO();
		}
		return instancia;
	}

	public Funcionario funcAchado = null;

	public Integer inserir(Funcionario f) {

		Conexao c = Conexao.getInstancia();

		Connection con = c.conectar();

		String query = "INSERT INTO funcionarios " + "(nome, " + "cpf, " + "telefone, " + "email, " + "dataDeNasc, "
				+ "usuario, " + "senha, " + "NivelCargo, " + "salario, " + "comissao, " + "validado, " + "enderecos_id_endereco) "
				+ "values (?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?)";

		try {
			PreparedStatement ps = con.prepareStatement(query, Statement.RETURN_GENERATED_KEYS);

			ps.setString(1, f.getNome());
			ps.setLong(2, f.getCpf());
			ps.setLong(3, f.getTelefone());
			ps.setString(4, f.getEmail());
			ps.setDate(5, Date.valueOf(f.getDataDeNasc()));
			ps.setString(6, f.getUsuario());
			ps.setString(7, f.getSenha());
			ps.setString(8, f.getNivelCargo());
			ps.setDouble(9, f.getSalario());
			ps.setBoolean(10, false);
			ps.setDouble(11, f.getComissao());
			if(f.getEndereco()==null) {
				throw new SQLException("Erro SQL endereço null");
			}
			ps.setInt(12, f.getEndereco().getIdEndereco());

			ps.executeUpdate();
			try (ResultSet generatedKeys = ps.getGeneratedKeys()) {
				if (generatedKeys.next()) {
					return generatedKeys.getInt(1);
				} else {
					throw new SQLException("Creating user failed, no ID obtained.");
				}
			}

		} catch (SQLException e) {
			e.printStackTrace();
			
		} finally {
			c.fecharConexao();
		}

		return 0;

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
				
				java.sql.Date DataDeNasc = rs.getDate("DataDeNasc");
				LocalDate localDate = DataDeNasc.toLocalDate();
				
				String Usuario = rs.getString("Usuario");
				String Senha = rs.getString("Senha");
				String NivelCargo = rs.getString("NivelCargo");
				Double Salario = rs.getDouble("Salario");
				Double Comissao = rs.getDouble("Comissao");
				Boolean Validado = rs.getBoolean("validado");
				Integer endFunc = rs.getInt("enderecos_id_endereco");

				Funcionario F = new Funcionario();

				F.setMatricula(matricula);
				F.setNome(Nome);
				F.setCpf(Cpf);
				F.setTelefone(Telefone);
				F.setEmail(Email);
				F.setDataDeNasc(localDate);
				F.setUsuario(Usuario);
				F.setSenha(Senha);
				F.setNivelCargo(NivelCargo);
				F.setSalario(Salario);
				F.setComissao(Comissao);
				Endereco end = new Endereco();
				end.setIdEndereco(endFunc);
				F.setEndereco(end);
				F.setValidado(Validado);

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
		Conexao c = Conexao.getInstancia();

		Connection con = c.conectar();

		Funcionario F = new Funcionario();

		String Query = "SELECT * FROM funcionarios WHERE matricula = ?";

		try {
			PreparedStatement ps = con.prepareStatement(Query);

			ps.setInt(1, f);

			ResultSet rs = ps.executeQuery();

			while (rs.next()) {

				Integer matricula = rs.getInt("matricula");
				String Nome = rs.getString("Nome");
				Long Cpf = rs.getLong("Cpf");
				Long Telefone = rs.getLong("Telefone");
				String Email = rs.getString("Email");
				
				java.sql.Date DataDeNasc = rs.getDate("DataDeNasc");
				LocalDate localDate = DataDeNasc.toLocalDate();
				
				String Usuario = rs.getString("Usuario");
				String Senha = rs.getString("Senha");
				String NivelCargo = rs.getString("NivelCargo");
				Double Salario = rs.getDouble("Salario");
				Double Comissao = rs.getDouble("Comissao");
				Integer endFunc = rs.getInt("enderecos_id_endereco");

				F.setMatricula(matricula);
				F.setNome(Nome);
				F.setCpf(Cpf);
				F.setTelefone(Telefone);
				F.setEmail(Email);
				F.setDataDeNasc(localDate);
				F.setUsuario(Usuario);
				F.setSenha(Senha);
				F.setNivelCargo(NivelCargo);
				F.setSalario(Salario);
				F.setComissao(Comissao);
				Endereco end = new Endereco();
				end.setIdEndereco(endFunc);
				F.setEndereco(end);

			}

		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			c.fecharConexao();
		}

		return F;
	}

	public Funcionario ListarUsuarios(String string) {

		Conexao c = Conexao.getInstancia();

		Connection con = c.conectar();

		Funcionario F = new Funcionario();

		String Query = "SELECT usuario FROM funcionarios WHERE usuario = ?";

		try {
			PreparedStatement ps = con.prepareStatement(Query);
			
			ps.setString(1, string);

			ResultSet rs = ps.executeQuery();

			while (rs.next()) {

				Integer matricula = rs.getInt("matricula");
				String Nome = rs.getString("Nome");
				Long Cpf = rs.getLong("Cpf");
				Long Telefone = rs.getLong("Telefone");
				String Email = rs.getString("Email");
				
				java.sql.Date DataDeNasc = rs.getDate("DataDeNasc");
				LocalDate localDate = DataDeNasc.toLocalDate();
				
				String Usuario = rs.getString("Usuario");
				String Senha = rs.getString("Senha");
				String NivelCargo = rs.getString("NivelCargo");
				Double Salario = rs.getDouble("Salario");
				Double Comissao = rs.getDouble("Comissao");
				Boolean Validado = rs.getBoolean("validado");
				Integer endFunc = rs.getInt("enderecos_id_endereco");

				F.setMatricula(matricula);
				F.setNome(Nome);
				F.setCpf(Cpf);
				F.setTelefone(Telefone);
				F.setEmail(Email);
				F.setDataDeNasc(localDate);
				F.setUsuario(Usuario);
				F.setSenha(Senha);
				F.setNivelCargo(NivelCargo);
				F.setSalario(Salario);
				F.setComissao(Comissao);
				Endereco end = new Endereco();
				end.setIdEndereco(endFunc);
				F.setEndereco(end);
				F.setValidado(Validado);
				
				return F;
			}

		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			c.fecharConexao();
		}

		return null;
	}
	
	public boolean validar() {
		Conexao c = Conexao.getInstancia();

		Connection con = c.conectar();

		String query = "UPDATE funcionarios SET validado = ? WHERE matricula = ?";

		try {
			PreparedStatement ps = con.prepareStatement(query);

			ps.setBoolean(1, true);
			ps.setLong(2, passaLogado().getMatricula());

			ps.executeUpdate();

			return true;

		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			c.fecharConexao();
		}

		return false;
	}

	public List<Funcionario> buscaPorPalavra(String palavra) {
		Conexao c = Conexao.getInstancia();

		Connection con = c.conectar();

		List<Funcionario> Funcionarios = new ArrayList<>();

		int i = 0;

		String query = "SELECT * FROM Funcionarios WHERE" + " nome LIKE ? " + "OR cpf LIKE ? "
				+ "OR telefone LIKE ? " + "OR email LIKE ? " + "OR dataDeNasc LIKE ? "
				+ "OR usuario LIKE ? " + "OR nivelCargo LIKE ? " + "OR salario LIKE ? "
				+ "OR comissao LIKE ?";

		try {
			PreparedStatement ps = con.prepareStatement(query);

			ps.setString(1, "%" + palavra + "%");
			ps.setString(2, "%" + palavra + "%");
			ps.setString(3, "%" + palavra + "%");
			ps.setString(4, "%" + palavra + "%");
			ps.setString(5, "%" + palavra + "%");
			ps.setString(6, "%" + palavra + "%");
			ps.setString(7, "%" + palavra + "%");
			ps.setString(8, "%" + palavra + "%");
			ps.setString(9, "%" + palavra + "%");

			ResultSet rs = ps.executeQuery();

			while (rs.next()) {
				Integer matricula = rs.getInt("matricula");
				String nome = rs.getString("nome");
				Long cpf = rs.getLong("cpf");
				Long telefone = rs.getLong("telefone");
				String email = rs.getString("email");
				java.sql.Date dataNasc = rs.getDate("dataDeNasc");
				LocalDate localDate = dataNasc.toLocalDate();
				String usuario = rs.getString("usuario");
				String nivelCargo = rs.getString("nivelCargo");
				Double salario = rs.getDouble("salario");
				Double comissao = rs.getDouble("comissao");

				Funcionario F = new Funcionario();

				F.setMatricula(matricula);
				F.setNome(nome);
				F.setCpf(cpf);
				F.setTelefone(telefone);
				F.setEmail(email);
				F.setDataDeNasc(localDate);
				F.setUsuario(usuario);
				F.setNivelCargo(nivelCargo);
				F.setSalario(salario);
				F.setComissao(comissao);

				Funcionarios.add(F);

			}
		} catch (SQLException e) {

			e.printStackTrace();
		} finally {
			c.fecharConexao();
		}

		return Funcionarios;
	}

}
