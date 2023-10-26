package src.test.java;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertNull;

import java.util.ArrayList;

import org.junit.Test;
import org.junit.jupiter.api.Order;

import controle.EnderecoDAO;
import modelo.Endereco;

public class EnderecoDAOTest {

	@Test
	@Order(1)
	public void TestInserirEnd() {

		Endereco end = new Endereco();

		end.setBairro("Bela Vista");
		end.setRua("Leo Rothermel");
		end.setCidade("Gaspar");
		end.setEstado("Santa Catarina");
		end.setCep((long) 89111146);
		end.setIdEndereco(77777777);

		EnderecoDAO dao = new EnderecoDAO();
		Integer EInserido = dao.inserir(end);

		assertNotNull(end);
	}

	@Test
	@Order(2)
	public void TestAtualizarEnd() {

		Endereco end = new Endereco();

		end.setBairro("Margem Esquerda");
		end.setRua("Ermenegildo Trindade");
		end.setCidade("Gaspar");
		end.setEstado("Santa Catarina");
		end.setCep((long) 89116115);
		end.setIdEndereco(2);

		EnderecoDAO dao = new EnderecoDAO();
		boolean EAtualizado = dao.atualizar(end);

		assertEquals(true, EAtualizado);

	}

	@Test
	@Order(3)
	public void TestDeleteEnd() {

		Endereco end = new Endereco();
		end.setBairro("Centro");
		end.setRua("7 de setembro");
		end.setCidade("Blumenau");
		end.setEstado("Santa Catarina");
		end.setCep((long) 89020006);
		end.setIdEndereco(2);

		EnderecoDAO dao = new EnderecoDAO();
		boolean EDeletado = dao.excluir(end);

		assertEquals(true, EDeletado);

	}

	@Test
	@Order(4)
	public void TestListarEnd() {

		EnderecoDAO dao = new EnderecoDAO();

		ArrayList<Endereco> end = new ArrayList<>();

		assertNotNull(end);
	}

	@Test
	@Order(5)
	public void TestBuscaEnd() {

		EnderecoDAO dao = new EnderecoDAO();

		Endereco Buscado = dao.buscaEndereco(2);

		assertNotNull(Buscado);

	}
	
	@Test
	@Order(6)
	public void TestbuscaEnderecoByAtributo() {
		
		EnderecoDAO dao = new EnderecoDAO();

		Endereco BuscadoByAtributo = dao.buscaEndereco(2);

		assertNotNull(BuscadoByAtributo);
		
	}
	

}
