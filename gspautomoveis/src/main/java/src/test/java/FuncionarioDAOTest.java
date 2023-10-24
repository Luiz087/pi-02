package src.test.java;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;

import java.util.ArrayList;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestMethodOrder;
import org.junit.jupiter.api.MethodOrderer.OrderAnnotation;
import org.junit.jupiter.api.Order;

import controle.FuncionarioDAO;
import modelo.Endereco;
import modelo.Funcionario;

@TestMethodOrder(OrderAnnotation.class)
public class FuncionarioDAOTest {
	private static StringBuilder output = new StringBuilder("");

	@Test
	@Order(1)
	public void testInserirFuncionarios() {

		Funcionario func = new Funcionario();
		func.setNome("Cleyton");
		func.setEmail("funcionario@gmail.com");
		func.setComissao(1.6);
		func.setCpf(53296126082l);
		func.setDataDeNasc("08/09/2005");
		func.setNivelCargo("Gerente de Vendas");
		func.setSalario(123123.9);
		func.setSenha("234");
		func.setTelefone(47999999999l);
		func.setUsuario("Cleytin");
		Endereco end = new Endereco();
		end.setBairro("Figueira");
		end.setRua("Rua da Felicidade");
		end.setCidade("Gaspar");
		end.setEstado("Santa Catarina");
		end.setCep((long) 12312123);
		end.setIdEndereco(56666666);
		func.setEndereco(end);

		FuncionarioDAO dao = new FuncionarioDAO();
		Integer fInserido = dao.inserir(func);

		assertNotNull(fInserido);

	}

	@Test
	@Order(2)
	public void testListarFuncionarios() {
		FuncionarioDAO dao = new FuncionarioDAO();

		ArrayList<Funcionario> funcList = dao.ListarFuncionarios();

		assertNotNull(funcList);

	}

	@Test
	public void testProcurarFuncionario() {

	}

	@Test
	public void testAtualizarFuncionario() {
		Funcionario func = new Funcionario();
		func.setMatricula(90);
		func.setNome("Carlos");
		func.setEmail("Carlos@gmail.com");
		func.setComissao(1.2);
		func.setCpf(53296126034l);
		func.setDataDeNasc("08/10/2005");
		func.setNivelCargo("Vendedor");
		func.setSalario(12323.9);
		func.setSenha("2346");
		func.setTelefone(47888999999l);
		func.setUsuario("carlao");
		Endereco end = new Endereco();
		end.setBairro("Macuco");
		end.setRua("Rua da Tristeza");
		end.setCidade("Blumenau");
		end.setEstado("Santa Catarina");
		end.setCep((long) 123175123);
		end.setIdEndereco(567);
		func.setEndereco(end);

		FuncionarioDAO dao = new FuncionarioDAO();
		boolean fAtualizado = dao.atualizar(func);

		assertEquals(true, fAtualizado);
	}

	@Test
	@Order(4)
	public void testAualizarFunc() {
		Funcionario func = new Funcionario();
		func.setMatricula(90);
		func.setNome("Carlos");
		func.setEmail("Carlos@gmail.com");
		func.setComissao(1.2);
		func.setCpf(53296126034l);
		func.setDataDeNasc("08/10/2005");
		func.setNivelCargo("Vendedor");
		func.setSalario(12323.9);
		func.setSenha("2346");
		func.setTelefone(47888999999l);
		func.setUsuario("carlao");
		Endereco end = new Endereco();
		end.setBairro("Macuco");
		end.setRua("Rua da Tristeza");
		end.setCidade("Blumenau");
		end.setEstado("Santa Catarina");
		end.setCep((long) 123175123);
		end.setIdEndereco(567);
		func.setEndereco(end);

		FuncionarioDAO dao = new FuncionarioDAO();
		boolean fAtualizado = dao.atualizar(func);

		assertEquals(true, fAtualizado);
	}

	@Test
	@Order(5)
	public void testDeleteFuncionario() {
		FuncionarioDAO dao = new FuncionarioDAO();
		Funcionario func = new Funcionario();
		func.setMatricula(90);
		func.setNome("Carlos");
		func.setEmail("Carlos@gmail.com");
		func.setComissao(1.2);
		func.setCpf(53296126034l);
		func.setDataDeNasc("08/10/2005");
		func.setNivelCargo("Vendedor");
		func.setSalario(12323.9);
		func.setSenha("2346");
		func.setTelefone(47888999999l);
		func.setUsuario("carlao");
		Endereco end = new Endereco();
		end.setBairro("Macuco");
		end.setRua("Rua da Tristeza");
		end.setCidade("Blumenau");
		end.setEstado("Santa Catarina");
		end.setCep((long) 123175123);
		end.setIdEndereco(567);
		func.setEndereco(end);

		boolean fDeletado = dao.excluir(func);

		assertEquals(true, fDeletado);
	}

}
