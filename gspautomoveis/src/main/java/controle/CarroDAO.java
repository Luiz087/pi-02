package controle;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.ArrayList;

import modelo.Carro;
import modelo.ICarroDAO;

public class CarroDAO implements ICarroDAO {

	@Override
	public boolean inserir(Carro ca) {
		Conexao c = Conexao.getInstancia();

		Connection con = c.conectar();

		String query = "INSERT INTO Carros (marca, modelo, novo, ano, cor, tipo, combustivel, quilometragem, potencia, abs, precoCarro, promocao, fornecedor_id_fornecedor) values ('?', '?', '?', ?, '?', '?,' '?', ?, '?', ?, ?, ?, ?);";

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
			ps.setDouble(11, ca.getPreco());
			ps.setBoolean(12, ca.getPromocao());

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
	public ArrayList<Carro> ListarCarros() {
		// TODO Auto-generated method stub
		return null;
	}

}
