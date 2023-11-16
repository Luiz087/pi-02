package controle;

import org.apache.commons.mail.DefaultAuthenticator;
import org.apache.commons.mail.Email;
import org.apache.commons.mail.SimpleEmail;

public class SendEmail {

	public static void MandarEmail(String emailRecebido, String nome, Integer opcao, StringBuilder codigo) {
		try {
			Email email = new SimpleEmail();
			email.setHostName("smtp.gmail.com");
			email.setSmtpPort(587);
			email.setAuthenticator(new DefaultAuthenticator("automoveisgsp@gmail.com", "qudtfujtvmmicplb"));
			email.setStartTLSRequired(true);
			email.setFrom("automoveisgsp@gmail.com");
			if (opcao == 1) {
				email.setSubject("Bem-Vindo, " + nome);

				email.setMsg("Olá, " + nome
						+ ".\n Essa é uma mensagem automática informando que você acaba de ser registrado como nosso mais novo funcionário! Ficamos felizes em tê-lo "
						+ "conosco em nosso time!!!");
			} else if (opcao == 2) {
				email.setSubject("BIBIIIIII, MOTORIZADO PORRA!");

				email.setMsg("Olá, " + nome
						+ ".\n Essa é uma mensagem automática informando que você acaba de comprar um veículo com a maior loja de veículos de Santa Catarina, a GSP "
						+ "Automóveis!\n\n Ficamos felizes por sua conquista e desejamos-lhe que desfrute sua nova conquista com responsabilidade e muito gosto!!!");
			} else if (opcao == 3) {
				email.setSubject("Código de Verificação");

				email.setMsg("Olá, " + nome
						+ ".\n Esse e-mail é referente ao seu código de validação. \n É de EXTREMA IMPORTÂNCIA que não o compartilhe com ninguém, apenas para validar sua conta. \n O código é: " + codigo);
			}
			email.addTo(emailRecebido);
			email.send();
			System.out.println("Email sent successfully!");
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}
