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

/**
 * Servlet implementation class HistControlleur
 */
@WebServlet("/HistControlleur")
public class HistControlleur extends HttpServlet {
	private static final long serialVersionUID = 1L;
	@EJB
	HistRemote his;
	private boolean trouve = false;
	ArrayList<EjbEntity.Historique> liste = null;

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
		
		request.setAttribute("trouve", trouve);
		trouve = false;
		request.setAttribute("liste", liste);
		this.getServletContext().getRequestDispatcher("/hist.jsp").forward(request, response);

	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		doGet(request, response);
	}

}
