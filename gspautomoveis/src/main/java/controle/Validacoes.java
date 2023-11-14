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

}
