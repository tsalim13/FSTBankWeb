
package Contoller;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.ejb.EJB;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import EjbBean.ClientRemote;
import EjbBean.ComptePartageBean;
import EjbBean.ComptePartageRemote;
import EjbBean.ComptePriveBean;
import EjbBean.ComptePriveRemote;
import EjbBean.CompteProRemote;
import EjbEntity.CParticulierPrive;
import EjbEntity.Client;
import EjbEntity.Compte;

@WebServlet("/DashClient")
public class DashClient extends HttpServlet {
	private static final long serialVersionUID = 1L;
	@EJB
	private ClientRemote cr;
	@EJB
	private ComptePriveRemote cpPrive;
	@EJB
	private ComptePartageRemote cpPartage;
	@EJB
	private CompteProRemote cpPro;

	private boolean cptValide = true;
	private ArrayList<Compte> allCompteClient = new ArrayList<Compte>();

	public DashClient() {
		super();
	}

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// récupérer id du client . . .

		// récupérer les comptes du client
		ArrayList<CParticulierPrive> c = null;
		c = cpPrive.findCompteByClient(1);
		if (c != null) {
			System.out.println("yesssssssssssssssssss");
			System.out.println(c);
		} else
			System.out.println("non :/");

		request.setAttribute("cptValide", cptValide);
		this.getServletContext().getRequestDispatcher("/dashClient.jsp").forward(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		if (request.getParameter("form1") != null) {
			Client client = cr.findByMail(request.getParameter("mail"));
			if (client != null) {
				System.out.println(client.getNom() + client.getPrenom());
			} else {
				cptValide = false;
				doGet(request, response);
				cptValide = true;
			}
		} else {
			System.out.println(request.getParameter("soldee"));

		}

		// doGet(request, response);
	}

}
