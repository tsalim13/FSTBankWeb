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

import EjbBean.HistRemote;
import EjbEntity.Historique;

@WebServlet("/HistControlleur")
public class HistControlleur extends HttpServlet {
	private static final long serialVersionUID = 1L;
	@EJB
	HistRemote his;
	private boolean trouve = false;
	ArrayList<EjbEntity.Historique> liste = null;
	
	private boolean trouveR = false;
	ArrayList<EjbEntity.Historique> listeR = null;

	public HistControlleur() {
		super();

	}

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// récupéré iban code privé
	
			liste = (ArrayList<Historique>) his.afficher(request.getParameter("iban"));
			System.out.println("liste = "+liste);
			if (liste.size() != 0) {
				trouve = true;
			} else
				trouve = false;
			
			
			listeR = (ArrayList<Historique>) his.afficherR(request.getParameter("iban"));
			System.out.println("listeR = "+listeR);
			if (listeR.size() != 0) {
				trouveR = true;
			} else
				trouveR = false;
		
		request.setAttribute("trouve", trouve);
		request.setAttribute("trouveR", trouveR);
		trouve = false;
		trouveR = false;
		request.setAttribute("liste", liste);
		request.setAttribute("listeR", listeR);
		this.getServletContext().getRequestDispatcher("/hist.jsp").forward(request, response);

	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		doGet(request, response);
	}

}
