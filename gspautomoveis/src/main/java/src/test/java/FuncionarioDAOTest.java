package src.test.java;

import static org.junit.Assert.assertNotNull;

import org.junit.jupiter.api.Test;

import controle.FuncionarioDAO;
import modelo.Endereco;
import modelo.Funcionario;

public class FuncionarioDAOTest {
	
	@Test
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

}
