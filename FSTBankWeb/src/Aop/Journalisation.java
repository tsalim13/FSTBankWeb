package Aop;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;

import javax.interceptor.AroundInvoke;
import javax.interceptor.InvocationContext;

public class Journalisation {
	@AroundInvoke
	public Object methodInterceptor(InvocationContext ctx) throws Exception {

		try {

			File file = new File("jouralisation.txt");

			// créer le fichier s'il n'existe pas
			if (!file.exists()) {
				file.createNewFile();
			}
			System.out.println("Chemin absolu du fichier : " + file.getAbsolutePath());
			FileWriter fw = new FileWriter(file.getAbsoluteFile(), true);
			BufferedWriter bw = new BufferedWriter(fw);
			PrintWriter out = new PrintWriter(bw);
			// out.println(écrire id du client ->variable de session);
			if (ctx.getMethod().getName().equals("retirer")) {
				out.println("Action= " + ctx.getMethod().getName() + " ,solde = " + ctx.getParameters()[1]
						+ " ,Compte id= " + ctx.getParameters()[0] + " , type de compte= " + ctx.getParameters()[2]);
			} else
				out.println("Action= " + ctx.getMethod().getName() + " ,solde = " + ctx.getParameters()[2]
						+ " ,Compte id= " + ctx.getParameters()[0] + " , type de compte= " + ctx.getParameters()[3]
						+ " ,envoier vers compte id = " + ctx.getParameters()[1]);
			bw.close();

			System.out.println("Modification terminée!");

		} catch (IOException e) {
			e.printStackTrace();
		}

		Object result = ctx.proceed();

		return result;
	}
}