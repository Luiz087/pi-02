package src.test.java;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;

import java.util.ArrayList;

import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.MethodOrderer.OrderAnnotation;
import org.junit.jupiter.api.Order;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestMethodOrder;

import controle.CarroDAO;
import controle.FuncionarioDAO;
import modelo.Carro;
import modelo.Endereco;
import modelo.Fornecedor;
import modelo.Funcionario;


@TestMethodOrder(OrderAnnotation.class)
public class CarroDAOTest {
    private static StringBuilder output = new StringBuilder("");
	// annotation
	@Test
	@Order(1) 
	public void testinserircarro() {
		Carro carro = new Carro();
		carro.setMarca("ford");
		carro.setAno(2010);
		carro.setModelo("fiesta");
		carro.setNovo(true);
		carro.setTipo("sedã");
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
		carro.setIdCarro(56);

		CarroDAO dao = new CarroDAO();
		Integer inseriuOk = dao.inserir(carro);
		assertNotNull(inseriuOk);

	}

	@Test
	@Order(2) 
	public void testAtualizarCarro() {
		Carro carro = new Carro();
		carro.setMarca("chevrolet");
		carro.setAno(2016);
		carro.setModelo("prisma");
		carro.setNovo(false);
		carro.setTipo("picape");
		carro.setCombustivel("alcool");
		carro.setQuilometragem(544656l);
		carro.setCor("cinza");
		carro.setPrecoCarro(464.7);
		carro.setPotencia("64365");
		Fornecedor fnc = new Fornecedor();
		fnc.setIdFornecedor(8);
		carro.setFornecedor(fnc);
		carro.setAbs(false);
		carro.setPromocao(false);
		carro.setId_carro(56);

		CarroDAO dao = new CarroDAO();
		boolean cAtualizado = dao.atualizar(carro);

		assertEquals(true, cAtualizado);
	}

	@Test
	@Order(3) 
	public void testListarCarros() {
		CarroDAO dao = new CarroDAO();

		ArrayList<Carro> CarroList = dao.ListarCarros();

		assertNotNull(CarroList);
	}

	
	@Test
	@Order(4) 
	public void clicado() {
		CarroDAO dao = new CarroDAO();

		Carro CarroList = dao.clicado(5);

		assertNotNull(CarroList);
		
		
	}
	@Test
	@Order(5) 
	public void testDeleteCarro() {
		Carro carro = new Carro();
		carro.setMarca("chevrolet");
		carro.setAno(2016);
		carro.setModelo("prisma");
		carro.setNovo(false);
		carro.setTipo("picape");
		carro.setCombustivel("alcool");
		carro.setQuilometragem(544656l);
		carro.setCor("cinza");
		carro.setPrecoCarro(464.7);
		carro.setPotencia("64365");
		Fornecedor fnc = new Fornecedor();
		fnc.setIdFornecedor(8);
		carro.setFornecedor(fnc);
		carro.setAbs(false);
		carro.setPromocao(false);
		carro.setIdCarro(56);

		CarroDAO dao = new CarroDAO();
		boolean cDeletado = dao.excluir(carro.getIdCarro());

		assertEquals(true, cDeletado);
	}
}

