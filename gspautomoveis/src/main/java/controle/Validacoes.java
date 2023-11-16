package controle;

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
			System.out.println("Erro ao converter para Long: " + e.getMessage());
			return null;
		}

	}

	public static Long validaTelefone(String telefone) {

		try {
			String telefoneErrado = telefone.replaceAll("[()\\s-]+", "");

			String telefoneLimpo = telefoneErrado.trim();

			if (telefoneLimpo.matches("\\d{10,11}")) {
				telefone = telefoneLimpo;
			} else {
				System.out.println("Número de telefone inválido");
				return null;
			}
			Long telefone2 = Long.valueOf(telefoneLimpo);
			return telefone2;
		} catch (NumberFormatException e1) {
			System.out.println("Erro ao converter para Long: " + e1.getMessage());

		}
		return null;
	}
}
