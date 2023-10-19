package src.test.java;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;

import java.util.ArrayList;

import org.junit.Test;
import org.junit.jupiter.api.Order;
import org.junit.jupiter.api.TestMethodOrder;
import org.junit.jupiter.api.MethodOrderer.OrderAnnotation;

import controle.CarroDAO;
import controle.FornecedorDAO;
import controle.FuncionarioDAO;
import modelo.Carro;
import modelo.Endereco;
import modelo.Fornecedor;

@TestMethodOrder(OrderAnnotation.class)

public class FornecedorDAOTest {
    private static StringBuilder output = new StringBuilder("");

	@Test
	@Order(1)
	public void testInserir() {
		Endereco end = new Endereco();
		Fornecedor forn = new Fornecedor();
		forn.setCnpjfornecedor(43242343432222l);
		forn.setEmpresa("GS");
		end.setBairro("Santa");
		end.setCep(234234234l);
		end.setCidade("Bruxque");
		end.setEstado("Flamengo");
		end.setIdEndereco(12);
		end.setRua("Cesar Blank");
		forn.setEndereco(end);
		forn.setMarca("Hotwells");
		forn.setNomeFornecedor("Luquinha");
		forn.setTelefoneFornecedor(99633328787l);
		
		FornecedorDAO dao = new FornecedorDAO();
		Integer fornInserido = dao.inserir(forn);
		
		assertNotNull(fornInserido);
	}
	
	@Test
	@Order(2)
	public void testAtualizar() {
		Fornecedor forn = new Fornecedor();
		Endereco end = new Endereco();
		forn.setCnpjfornecedor(234432543452345l);
		forn.setEmpresa("GP");
		end.setBairro("Sete");
		end.setCep(2344324565l);
		end.setCidade("Taió");
		end.setEstado("Chorintians");
		end.setIdEndereco(23);
		end.setRua("Rua Poffo");
		forn.setEndereco(end);
		forn.setMarca("Fiat");
		forn.setNomeFornecedor("Matheus");
		forn.setTelefoneFornecedor(99345432334l);
		forn.setIdFornecedor(23);
		
		FornecedorDAO dao = new FornecedorDAO();
		boolean ForAtualizado = dao.atualizar(forn);
		
		assertEquals(true, ForAtualizado);
	}
	
	@Test
	@Order(3)
	public void listarForne() {
		FornecedorDAO dao = new FornecedorDAO();
		ArrayList<Fornecedor> FornList = dao.ListarFornecedores();
		assertNotNull(FornList);
	}
	
	@Test
	@Order(4)
	public void pegarForn() {
		FornecedorDAO dao = new FornecedorDAO();

		Fornecedor FornList = dao.pegarForn("Sula");

		assertNotNull(FornList);
	}
	
	@Test
	@Order(5)
	public void testDelete() {
		Fornecedor forn = new Fornecedor();
		Endereco end = new Endereco();
		forn.setCnpjfornecedor(234432543452345l);
		forn.setEmpresa("GP");
		end.setBairro("Sete");
		end.setCep(2344324565l);
		end.setCidade("Taió");
		end.setEstado("Chorintians");
		end.setIdEndereco(23);
		end.setRua("Rua Poffo");
		forn.setEndereco(end);
		forn.setMarca("Fiat");
		forn.setNomeFornecedor("Matheus");
		forn.setTelefoneFornecedor(99345432334l);
		forn.setIdFornecedor(23);
		
		FornecedorDAO dao = new FornecedorDAO();
		boolean ForDeletado = dao.atualizar(forn);
		
		assertEquals(true, ForDeletado);
	}	
}
