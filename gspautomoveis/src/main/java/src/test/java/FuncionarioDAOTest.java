package src.test.java;

import static org.junit.Assert.assertNotNull;

import org.junit.jupiter.api.Test;

import controle.FuncionarioDAO;
import modelo.Funcionario;

public class FuncionarioDAOTest {
	
	@Test
	public void testListarFuncionarios() {
		
		Funcionario func = new Funcionario();
		func.setNome("Cleyton");
		func.setEmail("funcionario@gmail.com");
		
		FuncionarioDAO dao = new FuncionarioDAO();
		Integer fInserido = dao.inserir(func);
		
		assertNotNull(fInserido);
		
	}

}
