package controle;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import modelo.Fornecedor;
import modelo.IFornecedorDAO;

public class FornecedorDAO implements IFornecedorDAO {

	public boolean inserir(Fornecedor f) {

		Conexao c = Conexao.getInstancia();

		Connection con = c.conectar();

		String query = "INSERT INTO fornecedores (nomeFornecedor, cnpjFornecedor, telefoneFornecedor, empresa, marca, endereco_cep) values ('?', ?, ?, '?', '?', ?)";

		try {
			PreparedStatement ps = con.prepareStatement(query);

			ps.setString(1, f.getNomeFornecedor());
			ps.setLong(2, f.getCnpjfornecedor());
			ps.setLong(3, f.getTelefoneFornecedor());
			ps.setString(4, f.getEmpresa());
			ps.setString(5, f.getMarca());
			ps.setLong(6, f.getCep());

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
	public ArrayList<Fornecedor> ListarFornecedores() {

		Conexao c = Conexao.getInstancia();

		Connection con = c.conectar();

		ArrayList<Fornecedor> Fornecedores = new ArrayList();

		String Query = "SELECT * FROM fornecedores";

		try {
			PreparedStatement ps = con.prepareStatement(Query);

			ResultSet rs = ps.executeQuery();

			while (rs.next()) {
				String NomeFornecedor = rs.getString("NomeFornecedor");
				Long cnpjFornecedor = rs.getLong("cnpjFonecedor");
				Long telefoneFornecedor = rs.getLong("telefoneFornecedor");
				String Empresa = rs.getString("Empresa");
				String Marca = rs.getString("Marca");
				Long Cep = rs.getLong("Cep");

				Fornecedor F = new Fornecedor();

				F.setNomeFornecedor(NomeFornecedor);
				F.setCnpjfornecedor(cnpjFornecedor);
				F.setTelefoneFornecedor(telefoneFornecedor);
				F.setEmpresa(Empresa);
				F.setMarca(Marca);
				F.setCep(Cep);
				
				Fornecedores.add(F);

			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
		c.fecharConexao();

		return Fornecedores;
	}

}
