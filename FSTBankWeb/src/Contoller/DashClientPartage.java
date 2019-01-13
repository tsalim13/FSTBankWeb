
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
import javax.servlet.http.HttpSession;

import EjbBean.ClientRemote;
import EjbBean.ComptePartageBean;
import EjbBean.ComptePartageRemote;
import EjbBean.ComptePriveBean;
import EjbBean.ComptePriveRemote;
import EjbBean.CompteProRemote;
import EjbEntity.CParticulierPartage;
import EjbEntity.CParticulierPrive;
import EjbEntity.CProfessionnel;
import EjbEntity.Client;
import EjbEntity.Compte;

@WebServlet("/DashClientPartage")
public class DashClientPartage extends HttpServlet {
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
	int idc ; 

	public DashClientPartage() {
		super();
	}

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// récupérer id du client . . .

		HttpSession session = request.getSession();
		 idc = (int) session.getAttribute("clientId");
		
		
		// récupérer les comptes Particulier partage du client
		ArrayList<CParticulierPartage> liste = null;
		liste = cpPartage.findCompteByClient(idc);
		System.out.println("listeee ="+liste);
		if (liste.size() != 0) {
			System.out.println("id code ===="+liste.get(0).getId());
			trouve = true;
		} else
			trouve = false;
		request.setAttribute("liste", liste);
		request.setAttribute("cptValide", cptValide);
		request.setAttribute("trouve", trouve);
		request.setAttribute("soldeInsuffisant", soldeInsuffisant);
		this.getServletContext().getRequestDispatcher("/dashClientPartage.jsp").forward(request, response);
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
				if (cpPrive.virement(cpPartage.findIdByIBAN(iban).getId(), cpPrive.findIdByIBAN(iban2).getId(),
						Double.parseDouble(solde), "partage",idc)) {
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
					if (cpPro.virement(cpPartage.findIdByIBAN(iban).getId(), cpPro.findIdByIBAN(iban2).getId(),
							Double.parseDouble(solde), "partage",idc)) {
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
						if (cpPartage.virement(cpPartage.findIdByIBAN(iban).getId(),
								cpPartage.findIdByIBAN(iban2).getId(), Double.parseDouble(solde), "partage",idc)) {
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

			if (cpPartage.retirer(cpPartage.findIdByIBAN(iban).getId(), Double.parseDouble(solde), "partage",idc)) {
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
