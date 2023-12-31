package controle;

import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

import modelo.Carro;
import modelo.Fornecedor;
import modelo.Funcionario;
import modelo.IVendaDAO;
import modelo.Venda;

public class VendaDAO implements IVendaDAO {

	private static VendaDAO instancia;

	public static VendaDAO getInstancia() {
		if (instancia == null) {
			instancia = new VendaDAO();
		}
		return instancia;
	}

	public Integer vendaS;
	
	public Integer inserir(Venda v) {

		Conexao c = Conexao.getInstancia();

		Connection con = c.conectar();

		String query = "INSERT INTO Vendas (nomeCliente, cpfCliente, telefoneCliente, enderecoCliente, dataVenda, precoVenda, formaPagamento, funcionarios_matricula, Carros_id_carro) values (?, ?, ?, ?, ?, ?, ?, ?, ?)";

		try {

			PreparedStatement ps = con.prepareStatement(query);

			ps.setString(1, v.getNomeCliente());
			ps.setLong(2, v.getCpfCliente());
			ps.setLong(3, v.getTelefoneCliente());
			ps.setString(4, v.getEnderecoCliente());
			ps.setDate(5, Date.valueOf(v.getDataVenda()));
			ps.setDouble(6, v.getPrecoVenda());
			ps.setString(7, v.getFormaPagamento());
			ps.setInt(8, v.getFunc().getMatricula());
			ps.setInt(9, v.getCarro().getIdCarro());

			ps.executeUpdate();

			return 1;

		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			c.fecharConexao();
		}

		return 0;
	}

	public boolean atualizar(Venda v) {
		Conexao c = Conexao.getInstancia();

		Connection con = c.conectar();

		String query = "UPDATE vendas SET nomeCliente = ?," + "cpfCliente = ?," + "telefoneCliente = ?,"
				+ "enderecoCliente = ?," + "dataVenda = ?," + "precoVenda = ?,"
				+ "formaPagamento = ?, funcionario_matricula = ?, Carros_id_carro = ? WHERE id_venda = ?";
		// chave estrangeira funcionarios_matricula
		// chave estrangeira Carros_id_carro

		try {
			PreparedStatement ps = con.prepareStatement(query);

			ps.setString(1, v.getNomeCliente());
			ps.setLong(2, v.getCpfCliente());
			ps.setLong(3, v.getTelefoneCliente());
			ps.setString(4, v.getEnderecoCliente());
			ps.setDate(5, Date.valueOf(v.getDataVenda()));
			ps.setDouble(6, v.getPrecoVenda());
			ps.setString(7, v.getFormaPagamento());
			ps.setInt(8, v.getFunc().getMatricula());
			ps.setInt(9, v.getCarro().getIdCarro());
			ps.setInt(10, v.getIdVenda());

			ps.executeUpdate();

			return true;
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			c.fecharConexao();
		}
		return false;
	}

	public boolean excluir(Venda v) {
		Conexao c = Conexao.getInstancia();

		Connection con = c.conectar();

		String query = "DELETE FROM Vendas WHERE id_venda = ?";

		try {
			PreparedStatement ps = con.prepareStatement(query);

			ps.setInt(1, v.getIdVenda());

			ps.executeUpdate();

			return true;
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			c.fecharConexao();
		}
		return false;
	}

	public ArrayList<Venda> ListarVendas() {

		Conexao c = Conexao.getInstancia();

		Connection con = c.conectar();

		ArrayList<Venda> Vendas = new ArrayList<>();

		String Query = "SELECT * FROM Vendas";

		try {
			PreparedStatement ps = con.prepareStatement(Query);

			ResultSet rs = ps.executeQuery();

			while (rs.next()) {

				Integer id = rs.getInt("id_venda");
				String NomeCliente = rs.getString("NomeCliente");
				Long CpfCliente = rs.getLong("CpfCliente");
				Long TelefoneCliente = rs.getLong("TelefoneCliente");
				String EnderecoCliente = rs.getString("EnderecoCliente");
				java.sql.Date DataVenda = rs.getDate("DataVenda");
				LocalDate localDate = DataVenda.toLocalDate();
				Double PrecoVenda = rs.getDouble("Precovenda");
				String formaPagamento = rs.getString("formaPagamento");

				Venda V = new Venda();

				V.setIdVenda(id);
				V.setNomeCliente(NomeCliente);
				V.setCpfCliente(CpfCliente);
				V.setTelefoneCliente(TelefoneCliente);
				V.setEnderecoCliente(EnderecoCliente);
				V.setDataVenda(localDate);
				V.setPrecoVenda(PrecoVenda);
				V.setFormaPagamento(formaPagamento);

				Vendas.add(V);

			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			c.fecharConexao();
		}

		return Vendas;
	}

	public Venda procuraVendaPorID(Integer idRecebido) {

		Conexao c = Conexao.getInstancia();

		Connection con = c.conectar();

		Venda venda = new Venda();

		String Query = "SELECT * FROM Vendas WHERE id_venda = ?";

		try {
			PreparedStatement ps = con.prepareStatement(Query);

			ps.setInt(1, idRecebido);

			ResultSet rs = ps.executeQuery();

			while (rs.next()) {

				Integer id = rs.getInt("id_venda");
				String NomeCliente = rs.getString("NomeCliente");
				Long CpfCliente = rs.getLong("CpfCliente");
				Long TelefoneCliente = rs.getLong("TelefoneCliente");
				String EnderecoCliente = rs.getString("EnderecoCliente");
				java.sql.Date DataVenda = rs.getDate("DataVenda");
				LocalDate localDate = DataVenda.toLocalDate();
				Double PrecoVenda = rs.getDouble("Precovenda");
				String formaPagamento = rs.getString("formaPagamento");
				Integer idCarro = rs.getInt("Carros_id_carro");
				Integer idFunc = rs.getInt("funcionarios_matricula");
				
				Carro carro = new Carro();
				Funcionario func = new Funcionario();
				
				carro.setIdCarro(idCarro);
				func.setMatricula(idFunc);

				venda.setIdVenda(id);
				venda.setNomeCliente(NomeCliente);
				venda.setCpfCliente(CpfCliente);
				venda.setTelefoneCliente(TelefoneCliente);
				venda.setEnderecoCliente(EnderecoCliente);
				venda.setDataVenda(localDate);
				venda.setPrecoVenda(PrecoVenda);
				venda.setFormaPagamento(formaPagamento);
				venda.setCarro(carro);
				venda.setFunc(func);

				return venda;

			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			c.fecharConexao();
		}

		return venda;
	}

	public List<Venda> buscaPorPalavra(String palavra) {
		Conexao c = Conexao.getInstancia();

		Connection con = c.conectar();

		List<Venda> Vendas = new ArrayList<>();

		int i = 0;

		String query = "SELECT * FROM Vendas WHERE" + " nomeCliente LIKE ? " + "OR cpfCliente LIKE ? "
				+ "OR telefoneCliente LIKE ? " + "OR enderecoCliente LIKE ? " + "OR dataVenda LIKE ? "
				+ "OR precoVenda LIKE ? " + "OR formaPagamento LIKE ? " + "OR funcionarios_matricula LIKE ? "
				+ "OR Carros_id_carro LIKE ?";

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
				Integer id = rs.getInt("id_venda");
				String NomeCliente = rs.getString("NomeCliente");
				Long CpfCliente = rs.getLong("CpfCliente");
				Long TelefoneCliente = rs.getLong("TelefoneCliente");
				String EnderecoCliente = rs.getString("EnderecoCliente");
				java.sql.Date DataVenda = rs.getDate("DataVenda");
				LocalDate localDate = DataVenda.toLocalDate();
				Double PrecoVenda = rs.getDouble("Precovenda");
				String formaPagamento = rs.getString("formaPagamento");

				Venda V = new Venda();

				V.setIdVenda(id);
				V.setNomeCliente(NomeCliente);
				V.setCpfCliente(CpfCliente);
				V.setTelefoneCliente(TelefoneCliente);
				V.setEnderecoCliente(EnderecoCliente);
				V.setDataVenda(localDate);
				V.setPrecoVenda(PrecoVenda);
				V.setFormaPagamento(formaPagamento);

				Vendas.add(V);

			}
		} catch (SQLException e) {

			e.printStackTrace();
		} finally {
			c.fecharConexao();
		}

		return Vendas;
	}

	public void vendaselecionada(int linha) {
		vendaS = linha+1;
	}

}
