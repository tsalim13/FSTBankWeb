package Contoller;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

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

@WebServlet("/CompteParticulierPartage")
public class CompteParticulierPartage extends HttpServlet {
	private static final long serialVersionUID = 1L;
	@EJB
	private ComptePartageRemote cp;
	@EJB
	private ClientRemote cr;

	public CompteParticulierPartage() {
		super();
	}

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		List list = cp.listComptes();
		if (request.getParameter("addClient") != null) {
			// récupéré le mail du client ajouter
			String mail = request.getParameter("addClient");
			System.out.println("mail client = "+mail);
			// traitement . . . 
			
		}

		request.setAttribute("list", list);

		this.getServletContext().getRequestDispatcher("/compteParticulierPartage.jsp").forward(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		int  id = Integer.parseInt(request.getParameter("cll"));
		ArrayList<Client> liste = cp.findClientByCompte(id);
		List<EjbEntity.Client> list = cr.afficher();
		

		request.setAttribute("list", list);
		request.setAttribute("liste", liste);
		this.getServletContext().getRequestDispatcher("/clientt.jsp").forward(request, response);
	}

}
