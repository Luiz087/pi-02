package src.test.java;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;

import java.time.LocalDate;
import java.util.ArrayList;

import org.junit.jupiter.api.Test;

import controle.FuncionarioDAO;
import controle.VendaDAO;
import modelo.Endereco;
import modelo.Venda;

public class VendaDAOTest {
	
	@Test
	public void testListarVendas(){

		VendaDAO dao = new VendaDAO();
		
		ArrayList<Venda> Vendas = new ArrayList<>();
		
		assertNotNull(dao);
	}
	
	@Test
	public void testInserirVendas() {
		Venda venda = new Venda();
		venda.setCpfCliente(123456789111l);
		String dataVenda = "05/08/2005";

		String primeiroParte = dataVenda.substring(0, 2);
		String segundaParte = dataVenda.substring(3, 5);
		String terceiroParte = dataVenda.substring(6, 10);

		LocalDate dataVendaCorreta = LocalDate.of(Integer.valueOf(terceiroParte),
				Integer.valueOf(segundaParte), Integer.valueOf(primeiroParte));
		
		venda.setDataVenda(dataVendaCorreta);		
		venda.setIdVenda(11111);
		venda.setNomeCliente("Gabriel reidelas");
		venda.setPrecoVenda(1.200000);
		venda.setTelefoneCliente(47999999999l);
		venda.setEnderecoCliente("Jose mondini 479");
		

		VendaDAO dao = new VendaDAO();
		Integer vInserido = dao.inserir(venda);
		
		assertNotNull(vInserido);
		
	}
	@Test
	public void testAtualizar() {
		Venda venda = new Venda();
		venda.setCpfCliente(98765432198l);
		String dataVenda = "05/08/2005";

		String primeiroParte = dataVenda.substring(0, 2);
		String segundaParte = dataVenda.substring(3, 5);
		String terceiroParte = dataVenda.substring(6, 10);

		LocalDate dataVendaCorreta = LocalDate.of(Integer.valueOf(terceiroParte),
				Integer.valueOf(segundaParte), Integer.valueOf(primeiroParte));
		
		venda.setDataVenda(dataVendaCorreta);		
		venda.setIdVenda(2222);
		venda.setNomeCliente("eric ");
		venda.setPrecoVenda(1.2002);
		venda.setTelefoneCliente(47888899999l);
		venda.setEnderecoCliente("Jose boanoite 69");
		
		VendaDAO dao = new VendaDAO();
		boolean vAtualizado = dao.atualizar(venda);
		
		assertEquals(true, vAtualizado);
	}
	@Test
	public void testInserir() {
		Venda venda = new Venda();
		venda.setCpfCliente(222222222222l);
		String dataVenda = "05/08/2005";

		String primeiroParte = dataVenda.substring(0, 2);
		String segundaParte = dataVenda.substring(3, 5);
		String terceiroParte = dataVenda.substring(6, 10);

		LocalDate dataVendaCorreta = LocalDate.of(Integer.valueOf(terceiroParte),
				Integer.valueOf(segundaParte), Integer.valueOf(primeiroParte));
		
		venda.setDataVenda(dataVendaCorreta);		
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
