package controle;

import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.time.LocalDate;
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
			ps.setDate(5, Date.valueOf(v.getDataVenda()));
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
	public boolean atualizar() {
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

		Conexao c = Conexao.getInstancia();

		Connection con = c.conectar();

		ArrayList<Venda> Vendas = new ArrayList();

		String Query = "SELECT * FROM Vendas";

		try {
			PreparedStatement ps = con.prepareStatement(Query);

			ResultSet rs = ps.executeQuery();

			while (rs.next()) {

				String NomeCliente = rs.getString("NomeCliente");
				Long CpfCliente = rs.getLong("CpfCliente");
				Long TelefoneCliente = rs.getLong("TelefoneCliente");
				String EnderecoCliente = rs.getString("EnderecoCliente");
				Date DataVenda = rs.getDate("DataVenda");
				Double PrecoVenda = rs.getDouble("Precovenda");

				Venda V = new Venda();

				V.setNomeCliente(NomeCliente);
				V.setCpfCliente(CpfCliente);
				V.setTelefoneCliente(TelefoneCliente);
				V.setEnderecoCliente(EnderecoCliente);
				V.setDataVenda(LocalDate.of(DataVenda.getYear(), DataVenda.getMonth(), DataVenda.getDay()));
				V.setPrecoVenda(PrecoVenda);

				Vendas.add(V);

			}
		} catch (SQLException e) {
			e.printStackTrace();
		}

		c.fecharConexao();

		return Vendas;
	}

}
