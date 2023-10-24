package controle;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

import modelo.Carro;
import modelo.Fornecedor;
import modelo.ICarroDAO;

public class CarroDAO implements ICarroDAO {

	private static CarroDAO instancia;

	public static CarroDAO getInstancia() {
		if (instancia == null) {
			instancia = new CarroDAO();
		}
		return instancia;
	}

	@Override
	public Integer inserir(Carro ca) {
		Conexao c = Conexao.getInstancia();

		Connection con = c.conectar();

		String query = "INSERT INTO Carros (marca, modelo, novo, ano, cor, tipo, combustivel, quilometragem, potencia, abs, precoCarro, promocao, fornecedor_id_fornecedor) values (?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?);";

		try {
			PreparedStatement ps = con.prepareStatement(query, Statement.RETURN_GENERATED_KEYS);

			ps.setString(1, ca.getMarca());
			ps.setString(2, ca.getModelo());
			ps.setBoolean(3, ca.getNovo());
			ps.setInt(4, ca.getAno());
			ps.setString(5, ca.getCor());
			ps.setString(6, ca.getTipo());
			ps.setString(7, ca.getCombustivel());
			ps.setLong(8, ca.getQuilometragem());
			ps.setString(9, ca.getPotencia());
			ps.setBoolean(10, ca.getAbs());
			ps.setDouble(11, ca.getPrecoCarro());
			ps.setBoolean(12, ca.getPromocao());
			ps.setInt(13, ca.getFornecedor().getIdFornecedor());

			ps.executeUpdate();

			// Retrieve the auto-generated keys (if any)
			try (ResultSet generatedKeys = ps.getGeneratedKeys()) {
				if (generatedKeys.next()) {
					// Return the generated ID
					return generatedKeys.getInt(1);
				} else {
					// If no ID was obtained, throw an exception
					throw new SQLException("Insertion failed, no ID obtained.");
				}
			} catch (SQLException e) {
				// Handle any exceptions that might occur while retrieving generated keys
				e.printStackTrace();
			}

		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			c.fecharConexao();
		}

		return 0;
	}

	public boolean atualizar(Carro ca) {
		Conexao c = Conexao.getInstancia();

		Connection con = c.conectar();

		String query = "UPDATE Carros SET marca = ?, " + "modelo = ?, " + "novo = ?, " + "ano = ?, " + "cor = ?, "
				+ "tipo = ?, " + "combustivel = ?, " + "quilometragem = ?, " + "potencia = ?, " + "abs = ?, "
				+ "precoCarro = ?, " + "promocao = ?," + "fornecedor_id_fornecedor = ? WHERE id_carro = ?";

		try {
			PreparedStatement ps = con.prepareStatement(query);

			ps.setString(1, ca.getMarca());
			ps.setString(2, ca.getModelo());
			ps.setBoolean(3, ca.getNovo());
			ps.setInt(4, ca.getAno());
			ps.setString(5, ca.getCor());
			ps.setString(6, ca.getTipo());
			ps.setString(7, ca.getCombustivel());
			ps.setLong(8, ca.getQuilometragem());
			ps.setString(9, ca.getPotencia());
			ps.setBoolean(10, ca.getAbs());
			ps.setDouble(11, ca.getPrecoCarro());
			ps.setBoolean(12, ca.getPromocao());
			ps.setInt(13, ca.getFornecedor().getIdFornecedor());
			ps.setInt(14, ca.getId_carro());

			ps.executeUpdate();

			return true;
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			c.fecharConexao();
		}

		return false;
	}

	public boolean excluir(Integer ca) {

		Conexao c = Conexao.getInstancia();

		Connection con = c.conectar();

		String query = "DELETE FROM Carros WHERE id_carro = ?";

		try {
			PreparedStatement ps = con.prepareStatement(query);

			ps.setInt(1, ca);

			ps.executeUpdate();

			return true;
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			c.fecharConexao();
		}

		return false;
	}

	public ArrayList<Carro> ListarCarros() {

		Conexao c = Conexao.getInstancia();

		Connection con = c.conectar();

		ArrayList<Carro> Carros = new ArrayList<>();

		String query = "SELECT * FROM Carros";

		try {
			PreparedStatement ps = con.prepareStatement(query);

			ResultSet rs = ps.executeQuery();

			while (rs.next()) {
				Integer id = rs.getInt("id_carro");
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

				Carro C = new Carro();
				Fornecedor forn = new Fornecedor();
				forn.setIdFornecedor(idForn);
				C.setIdCarro(id);
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

				Carros.add(C);

			}
		} catch (SQLException e) {

			e.printStackTrace();
		} finally {
			c.fecharConexao();

		}

		return Carros;
	}

	public Carro clicado(Integer id) {
		Conexao c = Conexao.getInstancia();

		Connection con = c.conectar();

		Carro C = new Carro();

		String query = "SELECT * FROM Carros WHERE id_carro = ?";

		try {
			PreparedStatement ps = con.prepareStatement(query);

			ps.setInt(1, id);

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

			}
		} catch (SQLException e) {

			e.printStackTrace();
		} finally {
			c.fecharConexao();

		}

		return C;
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
