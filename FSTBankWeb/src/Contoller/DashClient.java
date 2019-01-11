
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
	private boolean trouve = false;
	private int soldeInsuffisant = 0;
	private ArrayList<Compte> allCompteClient = new ArrayList<Compte>();

	public DashClient() {
		super();
	}

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// récupérer id du client . . .

		// récupérer les comptes Particulier Prive du client
		ArrayList<CParticulierPrive> liste = null;
		liste = cpPrive.findCompteByClient(1);
		if (liste.size() != 0) {
			trouve = true;
		} else
			trouve = false;
		request.setAttribute("liste", liste);
		request.setAttribute("cptValide", cptValide);
		request.setAttribute("trouve", trouve);
		request.setAttribute("soldeInsuffisant", soldeInsuffisant);
		this.getServletContext().getRequestDispatcher("/dashClient.jsp").forward(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		if (request.getParameter("form1") != null) {
			// récupérer les valeur de form 1 . . .
			String iban = request.getParameter("iban");
			String iban2 = request.getParameter("iban2");
			String solde = request.getParameter("solde");


			// vérifier si iban2 existe . . .
			if (cpPrive.findIdByIBAN(iban2) != null) {
				if (cpPrive.virement(cpPrive.findIdByIBAN(iban).getId(), cpPrive.findIdByIBAN(iban2).getId(),
						Double.parseDouble(solde), "prive")) {
					soldeInsuffisant = 1;
					doGet(request, response);
					soldeInsuffisant = 0;
				} else {
					soldeInsuffisant = 2;
					doGet(request, response);
					soldeInsuffisant = 0;
				}

			} else {
				if (cpPro.findIdByIBAN(iban2) != null) {
					if (cpPro.virement(cpPrive.findIdByIBAN(iban).getId(), cpPro.findIdByIBAN(iban2).getId(),
							Double.parseDouble(solde), "prive")) {
						soldeInsuffisant = 1;
						doGet(request, response);
						soldeInsuffisant = 0;
					} else {
						soldeInsuffisant = 2;
						doGet(request, response);
						soldeInsuffisant = 0;
					}
				} else {
					if (cpPartage.findIdByIBAN(iban2) != null) {
						if (cpPartage.virement(cpPrive.findIdByIBAN(iban).getId(),
								cpPartage.findIdByIBAN(iban2).getId(), Double.parseDouble(solde), "prive")) {
							soldeInsuffisant = 1;
							doGet(request, response);
							soldeInsuffisant = 0;
						} else {
							soldeInsuffisant = 2;
							doGet(request, response);
							soldeInsuffisant = 0;
						}
					} else {
						cptValide = false;
						doGet(request, response);
						cptValide = true;
					}
				}
			}
		} else {
			// récupérer les valeur de form 2 . . .
			String iban = request.getParameter("iban");
			String solde = request.getParameter("soldee");

			if (cpPrive.retirer(cpPrive.findIdByIBAN(iban).getId(), Double.parseDouble(solde), "prive")) {
				soldeInsuffisant = 1;
				doGet(request, response);
				soldeInsuffisant = 0;
			} else {
				soldeInsuffisant = 2;
				doGet(request, response);
				soldeInsuffisant = 0;
			}

		}

	}

}
