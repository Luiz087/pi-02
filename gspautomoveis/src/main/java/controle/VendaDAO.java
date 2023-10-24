package controle;

import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.time.LocalDate;
import java.util.ArrayList;

import modelo.Carro;
import modelo.Fornecedor;
import modelo.IVendaDAO;
import modelo.Venda;

public class VendaDAO implements IVendaDAO {

	public Integer inserir(Venda v) {

		Conexao c = Conexao.getInstancia();

		Connection con = c.conectar();

		String query = "INSERT INTO Vendas (nomeCliente, cpfCliente, telefoneCliente, enderecoCliente, dataVenda, precoVenda, funcionarios_matricula, Carros_id_carro) values ('?', ?, ?, ?, '?', ?, ?, ?)";

		try {

			PreparedStatement ps = con.prepareStatement(query);

			ps.setString(1, v.getNomeCliente());
			ps.setLong(2, v.getCpfCliente());
			ps.setLong(3, v.getTelefoneCliente());
			ps.setString(4, v.getEnderecoCliente());
			ps.setString(5, v.getDataVenda());
			ps.setDouble(6, v.getPrecoVenda());

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

		String query = "UPDATE vendas SET nomeCliente = ?" + "cpfCliente = ?" + "telefoneCliente = ?"
				+ "enderecoCliente = ?" + "dataVenda = ? WHERE id_venda = ?";
		// chave estrangeira funcionarios_matricula
		// chave estrangeira Carros_id_carro

		try {
			PreparedStatement ps = con.prepareStatement(query);

			ps.setString(1, v.getNomeCliente());
			ps.setLong(2, v.getCpfCliente());
			ps.setLong(3, v.getTelefoneCliente());
			ps.setString(4, v.getEnderecoCliente());
			ps.setString(5, v.getDataVenda());
			ps.setInt(6, v.getIdVenda());

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

				String NomeCliente = rs.getString("NomeCliente");
				Long CpfCliente = rs.getLong("CpfCliente");
				Long TelefoneCliente = rs.getLong("TelefoneCliente");
				String EnderecoCliente = rs.getString("EnderecoCliente");
				String DataVenda = rs.getString("DataVenda");
				Double PrecoVenda = rs.getDouble("Precovenda");

				Venda V = new Venda();

				V.setNomeCliente(NomeCliente);
				V.setCpfCliente(CpfCliente);
				V.setTelefoneCliente(TelefoneCliente);
				V.setEnderecoCliente(EnderecoCliente);
				V.setDataVenda(DataVenda);
				V.setPrecoVenda(PrecoVenda);

				Vendas.add(V);

			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			c.fecharConexao();
		}

		return Vendas;
	}
	
	public ArrayList<Carro> marca(String selectedItem) {
		Conexao c = Conexao.getInstancia();

		Connection con = c.conectar();

		Carro C = new Carro();
		ArrayList<Carro> carros = new ArrayList<>();

		String query = "SELECT * FROM Carros WHERE marca = ?";

		try {
			PreparedStatement ps = con.prepareStatement(query);

			ps.setString(1, selectedItem);

			ResultSet rs = ps.executeQuery();

			while (rs.next()) {
				Integer idC = rs.getInt("id_carro");
				String marca = rs.getString("marca");
				String modelo = rs.getString("modelo");
				Boolean novo = rs.getBoolean("novo");
				Integer ano = rs.getInt("ano");
				String cor = rs.getString("cor");
				String tipo = rs.getString("tipo");
				String combustivel = rs.getString("combustivel");
				Long quilometragem = rs.getLong("quilometragem");
				String potencia = rs.getString("potencia");
				Boolean abs = rs.getBoolean("abs");
				Double precoCarro = rs.getDouble("precoCarro");
				Boolean promocao = rs.getBoolean("promocao");
				Integer idForn = rs.getInt("fornecedor_id_fornecedor");

				Fornecedor forn = new Fornecedor();
				forn.setIdFornecedor(idForn);
				C.setIdCarro(idC);
				C.setFornecedor(forn);
				C.setMarca(marca);
				C.setModelo(modelo);
				C.setNovo(novo);
				C.setAno(ano);
				C.setCor(cor);
				C.setTipo(tipo);
				C.setCombustivel(combustivel);
				C.setQuilometragem(quilometragem);
				C.setPotencia(potencia);
				C.setAbs(abs);
				C.setPrecoCarro(precoCarro);
				C.setPromocao(promocao);
				
				carros.add(C);

			}
		} catch (SQLException e) {

			e.printStackTrace();
		} finally {
			c.fecharConexao();

		}

		return carros;
	}

}
