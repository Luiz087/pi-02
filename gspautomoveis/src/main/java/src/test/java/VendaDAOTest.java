package src.test.java;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;

import java.time.LocalDate;
import java.util.ArrayList;

import org.junit.jupiter.api.Test;

import controle.FuncionarioDAO;
import controle.VendaDAO;
import modelo.Carro;
import modelo.Endereco;
import modelo.Fornecedor;
import modelo.Funcionario;
import modelo.Venda;

public class VendaDAOTest {
	
	@Test
	public void testListarVendas(){

		VendaDAO dao = new VendaDAO();
		
		ArrayList<Venda> Vendas = dao.ListarVendas();
		
		assertNotNull(Vendas);
	}
	
	@Test
	public void testMarca(){

		VendaDAO dao = new VendaDAO();
		
		ArrayList<Carro> Vendas = dao.marca("chevrolet");
		
		assertNotNull(Vendas);
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
		venda.setFormaPagamento("pix");
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
		carro.setIdCarro(2222);
		Funcionario func = new Funcionario();
		func.setMatricula(2333);
		func.setNome("Cleyton");
		func.setEmail("funcionario@gmail.com");
		func.setComissao(1.6);
		func.setCpf(53296126082l);
		String dataNascimento = "05/08/2005";

		String PrimeiroParte = dataNascimento.substring(0, 2);
		String SegundaParte = dataNascimento.substring(3, 5);
		String TerceiroParte = dataNascimento.substring(6, 10);

		LocalDate dataNascimentoCorreta = LocalDate.of(Integer.valueOf(TerceiroParte),
				Integer.valueOf(SegundaParte), Integer.valueOf(PrimeiroParte));
		
		func.setDataDeNasc(dataNascimentoCorreta);
		func.setNivelCargo("Gerente de Vendas");
		func.setSalario(123123.9);
		func.setSenha("Luizz123");
		func.setTelefone(47999999999l);
		func.setUsuario("Luiz047");
		Endereco end = new Endereco();
		end.setBairro("Figueira");
		end.setRua("Rua da Felicidade");
		end.setCidade("Gaspar");
		end.setEstado("Santa Catarina");
		end.setCep((long) 12312123);
		end.setIdEndereco(12);
		func.setEndereco(end);

		venda.setCarro(carro);
		venda.setFunc(func);
		

		VendaDAO dao = new VendaDAO();
		Integer vInserido = dao.inserir(venda);
		
		assertNotNull(vInserido);
		
	}
	@Test
	public void testAtualizar() {
		Venda venda = new Venda();
		venda.setCpfCliente(123456789111l);
		String dataVenda = "05/08/2005";

		String primeiroParte = dataVenda.substring(0, 2);
		String segundaParte = dataVenda.substring(3, 5);
		String terceiroParte = dataVenda.substring(6, 10);

		LocalDate dataVendaCorreta = LocalDate.of(Integer.valueOf(terceiroParte),
				Integer.valueOf(segundaParte), Integer.valueOf(primeiroParte));
		
		venda.setDataVenda(dataVendaCorreta);		
		venda.setIdVenda(1);
		venda.setNomeCliente("Gabriel reidelas");
		venda.setPrecoVenda(1.200);
		venda.setTelefoneCliente(47999999999l);
		venda.setEnderecoCliente("Jose mondini 479");
		venda.setFormaPagamento("pix");
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
		carro.setIdCarro(13213231);
		Funcionario func = new Funcionario();
		func.setMatricula(2333);
		func.setNome("Cleyton");
		func.setEmail("funcionario@gmail.com");
		func.setComissao(1.6);
		func.setCpf(53296126082l);
		String dataNascimento = "05/08/2005";

		String PrimeiroParte = dataNascimento.substring(0, 2);
		String SegundaParte = dataNascimento.substring(3, 5);
		String TerceiroParte = dataNascimento.substring(6, 10);

		LocalDate dataNascimentoCorreta = LocalDate.of(Integer.valueOf(TerceiroParte),
				Integer.valueOf(SegundaParte), Integer.valueOf(PrimeiroParte));
		
		func.setDataDeNasc(dataNascimentoCorreta);
		func.setNivelCargo("Gerente de Vendas");
		func.setSalario(123123.9);
		func.setSenha("Luizz123");
		func.setTelefone(47999999999l);
		func.setUsuario("Luiz047");
		Endereco end = new Endereco();
		end.setBairro("Figueira");
		end.setRua("Rua da Felicidade");
		end.setCidade("Gaspar");
		end.setEstado("Santa Catarina");
		end.setCep((long) 12312123);
		end.setIdEndereco(1);
		func.setEndereco(end);

		venda.setCarro(carro);
		venda.setFunc(func);
		
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
