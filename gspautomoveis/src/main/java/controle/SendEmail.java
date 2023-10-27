package controle;

import org.apache.commons.mail.DefaultAuthenticator;
import org.apache.commons.mail.Email;
import org.apache.commons.mail.SimpleEmail;

public class SendEmail {

	public static void MandarEmail(String emailRecebido, String funcCad) {
		try {
			Email email = new SimpleEmail();
			email.setHostName("smtp.gmail.com");
			email.setSmtpPort(587);
			email.setAuthenticator(new DefaultAuthenticator("automoveisgsp@gmail.com", "qudtfujtvmmicplb"));
			email.setStartTLSRequired(true);
			email.setFrom("automoveisgsp@gmail.com");
			email.setSubject("Bem-Vindo, " + funcCad);
			email.setMsg("Olá, " + funcCad
					+ ". Essa é uma mensagem automática informando que você acaba de ser registrado como nosso mais novo funcionário! Ficamos felizes em tê-lo conosco em nosso time!!!");
			email.addTo(emailRecebido);
			email.send();
			System.out.println("Email sent successfully!");
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}
