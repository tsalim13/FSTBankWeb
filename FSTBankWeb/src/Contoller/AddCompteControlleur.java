package Contoller;

import java.io.IOException;
import java.util.HashSet;
import java.util.List;
import java.util.Random;
import java.util.Set;

import javax.ejb.EJB;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import EjbBean.ClientRemote;
import EjbBean.ComptePartageRemote;
import EjbBean.ComptePriveRemote;
import EjbBean.CompteProRemote;
import EjbEntity.CParticulierPartage;
import EjbEntity.CParticulierPrive;
import EjbEntity.CProfessionnel;
import EjbEntity.Client;

@WebServlet("/AddCompteControlleur")
public class AddCompteControlleur extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private int idClient = 0;
	private boolean done = false;

	@EJB
	private ClientRemote cr;
	@EJB
	private ComptePriveRemote cp;
	@EJB
	private ComptePartageRemote cpr;
	@EJB
	private CompteProRemote cpro;
	
	private Set<Client> listClients= new HashSet<Client>();

	public AddCompteControlleur() {
		super();

	}

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		List<Client> list = cr.afficher();
		Client cl = cr.find(idClient);

		String form = request.getParameter("form");

		request.setAttribute("clients", list);

		if (form != null) {
			if (form.equals("2")) {
				this.getServletContext().getRequestDispatcher("/AddComptePrive.jsp").forward(request, response);
			}
			else if (form.equals("1")) {
				this.getServletContext().getRequestDispatcher("/AddComptePartage.jsp").forward(request, response);
			}
			else if (form.equals("3")) {
				this.getServletContext().getRequestDispatcher("/AddCompteEntreprise.jsp").forward(request, response);
			}
			
		} else {
			request.setAttribute("cl", cl);
			
			
			this.getServletContext().getRequestDispatcher("/AddCompte.jsp").forward(request, response);
		}
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		
		String formNum = request.getParameter("fornNum");
		
		if (formNum != null) {
			if (formNum.equals("2")) {
				int client0 = Integer.valueOf(request.getParameter("client0"));
				
				Client clt = new Client();
				clt.setId(client0);
				
				CParticulierPrive cpp =new CParticulierPrive();
				cpp.setClient(clt);
				cpp.setCodeIBN(randomIban());
				cpp.setSolde(0);
				cp.addCompte(cpp);
				done = true;
				request.setAttribute("done", done);
				this.getServletContext().getRequestDispatcher("/AddComptePrive.jsp").forward(request, response);
				done =false;
			}
			else if (formNum.equals("1")) {
				String clients0 = request.getParameter("client0");
				if(clients0 != null)
				{
					int client0 = Integer.valueOf(clients0);
					Client clt0 = new Client();
					clt0.setId(client0);
					listClients.add(clt0);
				}
				
				String clients1 = request.getParameter("client1");
				if(clients1 != null )
				{
					int client1 = Integer.valueOf(clients1);
					Client clt1 = new Client();
					clt1.setId(client1);
					listClients.add(clt1);
				}
				
				String clients2 = request.getParameter("client2");
				if(clients2 != null )
				{
					int client2 = Integer.valueOf(clients2);
					Client clt2 = new Client();
					clt2.setId(client2);
					listClients.add(clt2);
				}
				
				String clients3 = request.getParameter("client3");
				if(clients3 != null)
				{
					int client3 = Integer.valueOf(clients3);
					Client clt3 = new Client();
					clt3.setId(client3);
					listClients.add(clt3);
				}
				
				String clients4 = request.getParameter("client4");
				if(clients4 != null )
				{
					int client4 = Integer.valueOf(clients4);
					Client clt4 = new Client();
					clt4.setId(client4);
					listClients.add(clt4);
				}
				
				String clients5 = request.getParameter("client5");
				if(clients5 != null )
				{
					int client5 = Integer.valueOf("clients5");
					Client clt5 = new Client();
					clt5.setId(client5);
					listClients.add(clt5);
				}
				

				CParticulierPartage cppr =new CParticulierPartage();
				cppr.Set(listClients);
				cppr.setCodeIBN(randomIban());
				cppr.setSolde(0);
				cpr.addCompte(cppr);
				done = true;
				request.setAttribute("done", done);
				this.getServletContext().getRequestDispatcher("/AddComptePartage.jsp").forward(request, response);
				done =false;
			}
			else if (formNum.equals("3")) {
				int client0 = Integer.valueOf(request.getParameter("client0"));
				String nom = request.getParameter("nom");
				String adresse = request.getParameter("adresse");
				String tel = request.getParameter("num");
				Client clt = new Client();
				clt.setId(client0);
				
				CProfessionnel cppro =new CProfessionnel();
				cppro.setClient(clt);
				cppro.setNomEntreprise(nom);
				cppro.setAdresse(adresse);
				cppro.setTel(tel);
				cppro.setCodeIBN(randomIban());
				cppro.setSolde(0);
				cpro.addCompte(cppro);
				done = true;
				request.setAttribute("done", done);
				this.getServletContext().getRequestDispatcher("/AddCompteEntreprise.jsp").forward(request, response);
				done =false;
			}
		}
		else
		{
			idClient = Integer.valueOf(request.getParameter("id"));
			doGet(request, response);
		}
		
		
	}

	public String randomIban() {
		int min = 1000000;
		int max = 9000000;
		Random random = new Random();
		int rnd = random.nextInt((max - min) + 1) + min;
		return "FST" + rnd;
	}

}
