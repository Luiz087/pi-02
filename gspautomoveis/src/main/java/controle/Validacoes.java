package controle;

import java.sql.Date;
import java.time.LocalDate;

import org.apache.commons.validator.routines.EmailValidator;

public class Validacoes {

	public static Long validaCNPJ(String cnpj) {

		try {
			String cnpjString = cnpj.replaceAll("/", "");
			cnpjString = cnpjString.replaceAll("-", "");
			cnpjString = cnpjString.replaceAll("\\.", "");
			cnpjString = cnpjString.trim();
			Long cnpj2 = Long.valueOf(cnpjString);
			return cnpj2;
		} catch (Exception e) {
			System.out.println("Erro ao converter cnpj para Long: " + e.getMessage());
			return null;
		}

	}

	public static Long validaCPF(String cpfR) {
		try {
			String cpfstring = cpfR.replaceAll("-", "");
			cpfstring = cpfstring.replaceAll("\\.", "");
			cpfstring = cpfstring.trim();
			Long cpf = Long.valueOf(cpfstring);
			return cpf;
		} catch (Exception e) {
			System.out.println("Erro ao converter cpf para Long: " + e.getMessage());
			return null;
		}

	}

	public static boolean validaEmail(String email) {
		return EmailValidator.getInstance().isValid(email);
	}

	public static Long validaTelefone(String tel) {
		try {
			String telefoneSting = tel;
			telefoneSting = telefoneSting.replaceAll("[()\\s-]+", "");
			telefoneSting = telefoneSting.trim();
			Long telefone = Long.valueOf(telefoneSting);
			return telefone;
		} catch (NumberFormatException e1) {
			System.out.println("Erro ao converter para Long: " + e1.getMessage());
			return null;
		}
	}

	public static LocalDate validaData(String data) {
		String primeiroParte = data.substring(0, 2);
		String segundaParte = data.substring(3, 5);
		String terceiroParte = data.substring(6, 10);

		LocalDate dataNascimentoCorreta = LocalDate.of(Integer.valueOf(terceiroParte), Integer.valueOf(segundaParte),
				Integer.valueOf(primeiroParte));
		return dataNascimentoCorreta;
	}
	
	public static Long validaCEP(String cepS) {
		try {
			String cepErrado = cepS;
			cepErrado = cepErrado.replaceAll("-", "");
			cepErrado = cepErrado.trim();
			Long cep = Long.valueOf(cepErrado);
			return cep;
		} catch (NumberFormatException e1) {
			System.out.println("Erro ao converter para Long: " + e1.getMessage());
			return null;
		}
	}
}
