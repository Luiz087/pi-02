package src.test.java;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertNull;
import static org.junit.Assert.assertThrows;
import static org.junit.Assert.assertTrue;

import java.sql.SQLException;
import java.sql.SQLIntegrityConstraintViolationException;
import java.time.LocalDate;
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
	public void testInserirFuncionarios() { // Inserir

		Funcionario func = new Funcionario();
		func.setNome("Cleyton");
		func.setEmail("funcionario@gmail.com");
		func.setComissao(1.6);
		func.setCpf(53296126082l);
		
		/*String DataDeNasc = "2005-09-08";
		LocalDate DataNasc = LocalDate.parse(DataDeNasc);
		*/
		
		String dataNascimento = "05/08/2005";

		String primeiroParte = dataNascimento.substring(0, 2);
		String segundaParte = dataNascimento.substring(3, 5);
		String terceiroParte = dataNascimento.substring(6, 10);

		LocalDate dataNascimentoCorreta = LocalDate.of(Integer.valueOf(terceiroParte),
				Integer.valueOf(segundaParte), Integer.valueOf(primeiroParte));
		
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
		end.setIdEndereco(56666666);
		func.setEndereco(end);

		FuncionarioDAO dao = new FuncionarioDAO();
		Integer fInserido = dao.inserir(func);

		assertNotNull(fInserido);

	}

	@Test
	@Order(2)
	public void testListarFuncionarios() { // Listar
		FuncionarioDAO dao = new FuncionarioDAO();

		ArrayList<Funcionario> funcList = dao.ListarFuncionarios();

		assertNotNull(funcList);

	}

	@Test
	@Order(3)
	public void testProcurarFuncionario() { // Clicado
		FuncionarioDAO dao = new FuncionarioDAO();

		Funcionario retorno = dao.clicado(56666666);

		assertNotNull(retorno);
	}

	@Test
	@Order(4)
	public void testLoginFuncionario() { // Login
		FuncionarioDAO dao = new FuncionarioDAO();
		Funcionario func = new Funcionario();
		func.setNome("Cleyton");
		func.setEmail("funcionario@gmail.com");
		func.setComissao(1.6);
		func.setCpf(53296126082l);
		String dataNascimento = "05/08/2005";

		String primeiroParte = dataNascimento.substring(0, 2);
		String segundaParte = dataNascimento.substring(3, 5);
		String terceiroParte = dataNascimento.substring(6, 10);

		LocalDate dataNascimentoCorreta = LocalDate.of(Integer.valueOf(terceiroParte),
				Integer.valueOf(segundaParte), Integer.valueOf(primeiroParte));
		
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

		Funcionario retorno = dao.login(func);

		assertNotNull(retorno);
	}

	@Test
	@Order(5)
	public void testLoginErroFuncionario() { // Login
		FuncionarioDAO dao = new FuncionarioDAO();
		Funcionario f = new Funcionario();
		f.setUsuario("Cleytin");

		Funcionario retorno = dao.login(f);

		assertNull(retorno);
	}

	@Test
	@Order(6)
	public void testLogoffFuncionario() { // Logoff
		FuncionarioDAO dao = new FuncionarioDAO();
		Funcionario retorno = dao.logoff();

		assertNull(retorno);
	}

	@Test
	@Order(7)
	public void testAtualizarFuncionario() { // AtualizarFunc
		Funcionario func = new Funcionario();
		func.setMatricula(90);
		func.setNome("Carlos");
		func.setEmail("Carlos@gmail.com");
		func.setComissao(1.2);
		func.setCpf(53296126034l);
		String dataNascimento = "05/08/2005";

		String primeiroParte = dataNascimento.substring(0, 2);
		String segundaParte = dataNascimento.substring(3, 5);
		String terceiroParte = dataNascimento.substring(6, 10);

		LocalDate dataNascimentoCorreta = LocalDate.of(Integer.valueOf(terceiroParte),
				Integer.valueOf(segundaParte), Integer.valueOf(primeiroParte));
		
		func.setDataDeNasc(dataNascimentoCorreta);
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
		boolean fAtualizado = dao.atualizarFunc(func);

		assertEquals(true, fAtualizado);
	}

	@Test
	@Order(8)
	public void testProcurarErroFuncionario() { // Clicado
		FuncionarioDAO dao = new FuncionarioDAO();

		Funcionario retorno = dao.clicado(90);

		assertNull(retorno.getMatricula());
	}
	
	@Test
	@Order(9)
	public void testAualizarFunc() { // Atualizar
		Funcionario func = new Funcionario();
		func.setMatricula(90);
		func.setNome("Carlos");
		func.setEmail("Carlos@gmail.com");
		func.setComissao(1.2);
		func.setCpf(53296126034l);
		String dataNascimento = "05/08/2005";

		String primeiroParte = dataNascimento.substring(0, 2);
		String segundaParte = dataNascimento.substring(3, 5);
		String terceiroParte = dataNascimento.substring(6, 10);

		LocalDate dataNascimentoCorreta = LocalDate.of(Integer.valueOf(terceiroParte),
				Integer.valueOf(segundaParte), Integer.valueOf(primeiroParte));
		
		func.setDataDeNasc(dataNascimentoCorreta);
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
	@Order(10)
	public void testPasaLogado() {
		FuncionarioDAO dao = new FuncionarioDAO();
		assertNull(dao.passaLogado());
	}
	
	
	@Test
	@Order(11)
	public void testDeleteFuncionario() { // Delete
		FuncionarioDAO dao = new FuncionarioDAO();
		Funcionario func = new Funcionario();
		func.setMatricula(90);
		func.setNome("Carlos");
		func.setEmail("Carlos@gmail.com");
		func.setComissao(1.2);
		func.setCpf(53296126034l);
		String dataNascimento = "05/08/2005";

		String primeiroParte = dataNascimento.substring(0, 2);
		String segundaParte = dataNascimento.substring(3, 5);
		String terceiroParte = dataNascimento.substring(6, 10);

		LocalDate dataNascimentoCorreta = LocalDate.of(Integer.valueOf(terceiroParte),
				Integer.valueOf(segundaParte), Integer.valueOf(primeiroParte));
		
		func.setDataDeNasc(dataNascimentoCorreta);
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
	
	@Test
	@Order(12)
	public void testListarUsuarios() { // Listar
		FuncionarioDAO dao = new FuncionarioDAO();

		Funcionario funcList = dao.ListarUsuarios("jose");

		assertNotNull(funcList);

	}

}
