package controle;

import com.sinch.xms.*;
import com.sinch.xms.api.*;

public class SendSMS {
	private static final String SERVICE_PLAN_ID = "df3eb8765f3744bd83df18f92fcab950";
	private static final String TOKEN = "0eadb61c74cb428ba7c1cb2eada218f8";
	private static ApiConnection conn;

	public static void mandarSMS(String nome, Long numero, Integer opcao, Integer cgdValidacao) {
		String SENDER = "447520662431";
		String[] RECIPIENTS = { "55" + numero };

		ApiConnection conn = ApiConnection.builder().servicePlanId(SERVICE_PLAN_ID).token(TOKEN).start();
		MtBatchTextSmsCreate message = SinchSMSApi.batchTextSms().sender(SENDER).addRecipient(RECIPIENTS)
				.body("GSPAutomoveis").build();
		
		if(opcao == 1) {
			message = SinchSMSApi.batchTextSms().sender(SENDER).addRecipient(RECIPIENTS).body("GSPAutomóveis\nCódigo de validação: " + cgdValidacao).build();
		}
		try {
			MtBatchTextSmsResult batch = conn.createBatch(message);
			System.out.println(batch.id());
		} catch (Exception e) {
			System.out.println(e.getMessage());
		}
		System.out.println("you sent:" + message.body());
	}
}