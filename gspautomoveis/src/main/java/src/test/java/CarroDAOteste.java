package src.test.java;

import static org.junit.Assert.assertEquals;

import org.junit.jupiter.api.Test;

import controle.CarroDAO;
import modelo.Carro;

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
		carro.setQuilometragem(null);
		carro.setCor("preto");
		carro.setPotencia("344325");
		//carro.setFornecedor(null);
		carro.setAbs(true);
		carro.setAbs(true);
		carro.setId_carro(56);
		
		CarroDAO dao = new CarroDAO();
		Integer inseriuOk = dao.inserir(null);
		assertEquals(false, inseriuOk);
	}
}
