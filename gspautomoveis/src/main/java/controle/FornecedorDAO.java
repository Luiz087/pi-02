package controle;

import java.sql.Connection;
import java.sql.PreparedStatement;
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
		// TODO Auto-generated method stub
		return null;
	}

}
