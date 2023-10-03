package src.test.java;

import static org.junit.Assert.assertNotNull;

import org.junit.jupiter.api.Test;

import controle.VendaDAO;
import modelo.Venda;

public class VendaDAOTest {
	
	@Test
	public void testListarVendas(){
		Venda v = new Venda();
		v.setNomeCliente("jorginho");
		v.setTelefoneCliente(null);
		VendaDAO dao = new VendaDAO();
		Integer vInserido = dao.inserir(v);
		assertNotNull(vInserido);
	}

}
