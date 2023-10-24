package src.test.java;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;

import org.junit.jupiter.api.Test;

import controle.FuncionarioDAO;
import controle.VendaDAO;
import modelo.Endereco;
import modelo.Venda;

public class VendaDAOTest {
	
	@Test
	public void testListarVendas(){
		Venda venda = new Venda();
		venda.setCpfCliente(98765432199l);
		venda.setDataVenda("11111111");
		venda.setIdVenda(4444);
		venda.setNomeCliente("jorgringo reidelas");
		venda.setPrecoVenda(1.11111);
		venda.setTelefoneCliente(47666699999l);
		venda.setEnderecoCliente("bla vla 48");
		
		VendaDAO dao = new VendaDAO();
		Integer vInserido = dao.inserir(venda);
		assertNotNull(vInserido);
	}
	
	public void testInserirVendas() {
		Venda venda = new Venda();
		venda.setCpfCliente(123456789111l);
		venda.setDataVenda("09122005");
		venda.setIdVenda(11111);
		venda.setNomeCliente("Gabriel reidelas");
		venda.setPrecoVenda(1.200000);
		venda.setTelefoneCliente(47999999999l);
		venda.setEnderecoCliente("Jose mondini 479");
		

		VendaDAO dao = new VendaDAO();
		Integer vInserido = dao.inserir(venda);
		
		assertNotNull(vInserido);
		
	}
	
	public void testAtualizar() {
		Venda venda = new Venda();
		venda.setCpfCliente(98765432198l);
		venda.setDataVenda("05201209");
		venda.setIdVenda(2222);
		venda.setNomeCliente("eric ");
		venda.setPrecoVenda(1.2002);
		venda.setTelefoneCliente(47888899999l);
		venda.setEnderecoCliente("Jose boanoite 69");
		
		VendaDAO dao = new VendaDAO();
		boolean vAtualizado = dao.atualizar(venda);
		
		assertEquals(true, vAtualizado);
	}
	
	public void testInserir() {
		Venda venda = new Venda();
		venda.setCpfCliente(222222222222l);
		venda.setDataVenda("69696969");
		venda.setIdVenda(3333);
		venda.setNomeCliente("luiz ");
		venda.setPrecoVenda(7.0000);
		venda.setTelefoneCliente(47777799999l);
		venda.setEnderecoCliente("antonio santos 101");
		
		VendaDAO dao = new VendaDAO();
        boolean vDeletado = dao.excluir(venda);
		
		assertEquals(true, vDeletado);
	}

}
