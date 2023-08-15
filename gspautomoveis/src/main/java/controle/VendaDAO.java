package controle;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.ArrayList;

import modelo.IVendaDAO;
import modelo.Venda;

public class VendaDAO implements IVendaDAO {

	public boolean inserir(Venda v) {

		Conexao c = Conexao.getInstancia();

		Connection con = c.conectar();

		String query = "INSERT INTO Vendas (nomeCliente, cpfCliente, telefoneCliente, enderecoCliente, dataVenda, precoVenda, funcionarios_matricula, Carros_id_carro) values ('?', ?, ?, ?, '?', ?, ?, ?)";

		try {

			PreparedStatement ps = con.prepareStatement(query);

			ps.setString(1, v.getNomeCliente());
			ps.setLong(2, v.getCpfCliente());
			ps.setLong(3, v.getTelefoneCliente());
			ps.setString(4, v.getEnderecoCliente());
			ps.setDate(5, v.getDataVenda());
			ps.setDouble(6, v.getPrecoVenda());

			ps.executeUpdate();

			c.fecharConexao();

			return false;

		} catch (SQLException e) {
			e.printStackTrace();
		}

		return true;
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
	public ArrayList<Venda> ListarVendas() {
		// TODO Auto-generated method stub
		return null;
	}

}
