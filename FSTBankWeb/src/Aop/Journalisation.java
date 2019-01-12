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

			// cr�er le fichier s'il n'existe pas
			if (!file.exists()) {
				file.createNewFile();
			}
			System.out.println("Chemin absolu du fichier : " + file.getAbsolutePath());
			FileWriter fw = new FileWriter(file.getAbsoluteFile(), true);
			BufferedWriter bw = new BufferedWriter(fw);
			PrintWriter out = new PrintWriter(bw);
			//if (ctx.getMethod().getName().equals("retirer")) {
				out.println("Action= " + ctx.getMethod().getName() + "parametre= "+ctx.getParameters().toString());

			//}
				System.out.println("parametre = " + ctx.getMethod().getParameters());

			bw.close();

			System.out.println("Modification termin�e!");

		} catch (IOException e) {
			e.printStackTrace();
		}

		Object result = ctx.proceed();

		return result;
	}
}