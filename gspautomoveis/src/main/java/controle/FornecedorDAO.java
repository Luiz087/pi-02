package controle;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

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

	public boolean inserir(Fornecedor f) {

		Conexao c = Conexao.getInstancia();

		Connection con = c.conectar();

		String query = "INSERT INTO fornecedores (nomeFornecedor, cnpjFornecedor, telefoneFornecedor, empresa, marca, enderecos_id_endereco) values (?, ?, ?, ?, ?, ?)";

		try {
			PreparedStatement ps = con.prepareStatement(query);

			ps.setString(1, f.getNomeFornecedor());
			ps.setLong(2, f.getCnpjfornecedor());
			ps.setLong(3, f.getTelefoneFornecedor());
			ps.setString(4, f.getEmpresa());
			ps.setString(5, f.getMarca());
			ps.setInt(6, f.getEndereco().getIdEndereco());

			ps.executeUpdate();

			return true;

		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			c.fecharConexao();
		}

		return false;
	}

	public boolean atualizar(Fornecedor f) {

		Conexao c = Conexao.getInstancia();

		Connection con = c.conectar();

		String query = "UPDATE fornecedores SET nomeFornecedor = ?" + "cnpjFornecedor = ?" + "telefoneFornecedor = ?"
				+ "empresa = ?" + "marca = ? WHERE id_fornecedor = ?";
		// chave estrangeira + "Endereco_id_endereco";

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

	public boolean excluir(Fornecedor f) {

		Conexao c = Conexao.getInstancia();

		Connection con = c.conectar();

		String query = "DELETE FROM fornecedores WHERE id_fornecedor" +f.getIdFornecedor();

		try {
			PreparedStatement ps = con.prepareStatement(query);

			ps.setInt(1, f.getIdFornecedor());

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
				String NomeFornecedor = rs.getString("NomeFornecedor");
				Long cnpjFornecedor = rs.getLong("cnpjFornecedor");
				Long telefoneFornecedor = rs.getLong("telefoneFornecedor");
				String Empresa = rs.getString("Empresa");
				String Marca = rs.getString("Marca");
				String Endereco = rs.getString("Cidade");
				// Long Cep = rs.getLong("Cep");

				Fornecedor F = new Fornecedor();

				F.setNomeFornecedor(NomeFornecedor);
				F.setCnpjfornecedor(cnpjFornecedor);
				F.setTelefoneFornecedor(telefoneFornecedor);
				F.setEmpresa(Empresa);
				F.setMarca(Marca);
				//arrumar
				F.setEndereco(Endereco);
				// F.setCep(Cep);

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
		Fornecedor fornecedorPego = new Fornecedor();
		for (Fornecedor forn : ListarFornecedores()) {
			if(forn.getNomeFornecedor().equals(fornecedor)) {
				fornecedorPego = forn;
				return fornecedorPego;
			}
		}
		return fornecedorPego;
	}

	
	public Fornecedor clicado(Integer f) {
		Fornecedor fornClicado = new Fornecedor();
		for (Fornecedor forn : ListarFornecedores()) {
			if (forn.getMarca().equals(f)) {

				fornClicado = forn;

				return fornClicado;
			}
		}
		return fornClicado;
	}
	
}
