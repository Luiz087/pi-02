package src.test.java;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;

import org.junit.jupiter.api.Test;

import controle.CarroDAO;
import controle.FuncionarioDAO;
import modelo.Carro;
import modelo.Endereco;
import modelo.Fornecedor;

public class CarroDAOteste {

	//annotation
	@Test
	public void testinserircarro() {
		Carro carro = new Carro();
		carro.setMarca("ford");
		carro.setAno(2010);
		carro.setModelo("fiesta");
		carro.setNovo(true);
		carro.setCombustivel("gasolina");
		carro.setQuilometragem(54436l);
		carro.setCor("preto");
		carro.setPrecoCarro(456.6);
		carro.setPotencia("344325");
		Fornecedor fnc = new Fornecedor();
		fnc.setIdFornecedor(8);
		carro.setFornecedor(fnc);
		carro.setAbs(true);
		carro.setPromocao(true);
		carro.setId_carro(56);
		
		
		CarroDAO dao = new CarroDAO();
		Integer inseriuOk = dao.inserir(carro);
		assertNotNull(inseriuOk);
	}
}
