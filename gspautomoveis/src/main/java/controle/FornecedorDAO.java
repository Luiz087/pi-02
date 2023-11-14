package controle;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

import modelo.Endereco;
import modelo.Fornecedor;
import modelo.Funcionario;
import modelo.IFornecedorDAO;

public class FornecedorDAO implements IFornecedorDAO {

	private static FornecedorDAO instancia;

	public static FornecedorDAO getInstancia() {
		if (instancia == null) {
			instancia = new FornecedorDAO();
		}
		return instancia;
	}

	public Integer inserir(Fornecedor f) {

		Conexao c = Conexao.getInstancia();

		Connection con = c.conectar();

		String query = "INSERT INTO fornecedores (nomeFornecedor, cnpjFornecedor, telefoneFornecedor, empresa, marca, enderecos_id_endereco) values (?, ?, ?, ?, ?, ?)";

		try {
			PreparedStatement ps = con.prepareStatement(query, Statement.RETURN_GENERATED_KEYS);

			ps.setString(1, f.getNomeFornecedor());
			ps.setLong(2, f.getCnpjfornecedor());
			ps.setLong(3, f.getTelefoneFornecedor());
			ps.setString(4, f.getEmpresa());
			ps.setString(5, f.getMarca());
			ps.setInt(6, f.getEndereco().getIdEndereco());

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

	public boolean atualizar(Fornecedor f) {

		Conexao c = Conexao.getInstancia();

		Connection con = c.conectar();

		String query = "UPDATE fornecedores SET nomeFornecedor = ?," + "cnpjFornecedor = ?," + "telefoneFornecedor = ?,"
				+ "empresa = ?," + "marca = ? WHERE id_fornecedor = ?";

		try {
			PreparedStatement ps = con.prepareStatement(query);

			ps.setString(1, f.getNomeFornecedor());
			ps.setLong(2, f.getCnpjfornecedor());
			ps.setLong(3, f.getTelefoneFornecedor());
			ps.setString(4, f.getEmpresa());
			ps.setString(5, f.getMarca());
			ps.setInt(6, f.getIdFornecedor());

			ps.executeUpdate();

			return true;
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			c.fecharConexao();
		}

		return false;
	}

	public boolean excluir(Integer f) {

		Conexao c = Conexao.getInstancia();

		Connection con = c.conectar();

		String query = "DELETE FROM fornecedores WHERE id_fornecedor = ?";

		try {
			PreparedStatement ps = con.prepareStatement(query);

			ps.setInt(1, f);

			ps.executeUpdate();

			return true;
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			c.fecharConexao();
		}

		return false;
	}

	@Override
	public ArrayList<Fornecedor> ListarFornecedores() {

		Conexao c = Conexao.getInstancia();

		Connection con = c.conectar();

		ArrayList<Fornecedor> Fornecedores = new ArrayList<>();

		String Query = "SELECT * FROM fornecedores";

		try {
			PreparedStatement ps = con.prepareStatement(Query);

			ResultSet rs = ps.executeQuery();

			while (rs.next()) {
				Integer idFornecedor = rs.getInt("id_fornecedor");
				String NomeFornecedor = rs.getString("NomeFornecedor");
				Long cnpjFornecedor = rs.getLong("cnpjFornecedor");
				Long telefoneFornecedor = rs.getLong("telefoneFornecedor");
				String Empresa = rs.getString("Empresa");
				String Marca = rs.getString("Marca");
				Integer endFunc = rs.getInt("enderecos_id_endereco");

				Fornecedor F = new Fornecedor();

				F.setIdFornecedor(idFornecedor);
				F.setNomeFornecedor(NomeFornecedor);
				F.setCnpjfornecedor(cnpjFornecedor);
				F.setTelefoneFornecedor(telefoneFornecedor);
				F.setEmpresa(Empresa);
				F.setMarca(Marca);
				Endereco end = new Endereco();
				end.setIdEndereco(endFunc);
				F.setEndereco(end);

				Fornecedores.add(F);

			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			c.fecharConexao();
		}

		return Fornecedores;
	}

	public Fornecedor pegarForn(String fornecedor) {
		Conexao c = Conexao.getInstancia();

		Connection con = c.conectar();

		Fornecedor F = new Fornecedor();

		String Query = "SELECT * FROM fornecedores WHERE nomeFornecedor = ?";

		try {
			PreparedStatement ps = con.prepareStatement(Query);

			ps.setString(1, fornecedor);

			ResultSet rs = ps.executeQuery();

			while (rs.next()) {
				Integer idFornecedor = rs.getInt("id_fornecedor");
				String NomeFornecedor = rs.getString("NomeFornecedor");
				Long cnpjFornecedor = rs.getLong("cnpjFornecedor");
				Long telefoneFornecedor = rs.getLong("telefoneFornecedor");
				String Empresa = rs.getString("Empresa");
				String Marca = rs.getString("Marca");
				Integer endFunc = rs.getInt("enderecos_id_endereco");

				F.setIdFornecedor(idFornecedor);
				F.setNomeFornecedor(NomeFornecedor);
				F.setCnpjfornecedor(cnpjFornecedor);
				F.setTelefoneFornecedor(telefoneFornecedor);
				F.setEmpresa(Empresa);
				F.setMarca(Marca);
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

	public Fornecedor buscaFornecedor(Fornecedor fornecedor) {
		Conexao c = Conexao.getInstancia();
		Connection con = c.conectar();

		String query = "SELECT * FROM fornecedores WHERE id_fornecedor = ?";
		try {
			PreparedStatement ps = con.prepareStatement(query);
			ps.setInt(1, fornecedor.getIdFornecedor());

			ResultSet rs = ps.executeQuery();
			while (rs.next()) {
				Long cnpj = rs.getLong("cnpjFornecedor");
				String empresa = rs.getString("empresa");
				Integer idEnd = rs.getInt("enderecos_id_endereco");
				Integer idForn = rs.getInt("id_fornecedor");
				String marca = rs.getString("marca");
				String nomeForn = rs.getString("nomeFornecedor");
				Long telefone = rs.getLong("telefoneFornecedor");

				Endereco end = new Endereco();
				end.setIdEndereco(idEnd);
				Fornecedor F = new Fornecedor();
				F.setCnpjfornecedor(cnpj);
				F.setEmpresa(empresa);
				F.setEndereco(end);
				F.setIdFornecedor(idForn);
				F.setMarca(marca);
				F.setNomeFornecedor(nomeForn);
				F.setTelefoneFornecedor(telefone);
				return F;
			}
		} catch (SQLException e) {

			e.printStackTrace();
		} finally {
			c.fecharConexao();
		}

		return null;
	}

	public ArrayList<Fornecedor> ListarCNPJ(Long cnpj) {

		Conexao c = Conexao.getInstancia();

		Connection con = c.conectar();

		ArrayList<Fornecedor> Fornecedores = new ArrayList<>();

		String Query = "SELECT cnpjFornecedor FROM fornecedores WHERE cnpjFornecedor = ?";

		try {
			PreparedStatement ps = con.prepareStatement(Query);
			ps.setLong(1, cnpj);

			ResultSet rs = ps.executeQuery();

			while (rs.next()) {

				String Cpnj = rs.getString("cnpjFornecedor");

				Fornecedor F = new Fornecedor();

				F.setCnpjfornecedor(Long.valueOf(Cpnj));

				Fornecedores.add(F);
			}

		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			c.fecharConexao();
		}

		return Fornecedores;
	}

}
