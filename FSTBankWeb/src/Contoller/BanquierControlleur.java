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

import EjbBean.BanquierBean;
import EjbBean.BanquierRemote;
import EjbEntity.Banquier;



@WebServlet("/BanquierControlleur")
public class BanquierControlleur extends HttpServlet {
	private static final long serialVersionUID = 1L;
	
	@EJB
	private BanquierRemote cr;

	public BanquierControlleur() {
		super();
		// TODO Auto-generated constructor stub
	}

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		
		//BanquierBean clr = new BanquierBean();
		
		List<Banquier> list = cr.afficher();
		request.setAttribute("banquiers", list);
		this.getServletContext().getRequestDispatcher("/banquier.jsp").forward(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		Banquier bn = new Banquier();
	
		bn.setMail(request.getParameter("mail"));
		bn.setMdp(request.getParameter("mdp"));
		bn.setNom(request.getParameter("nom"));
		bn.setPrenom(request.getParameter("prenom"));
		
		cr.ajouter(bn);
		
		doGet(request, response);

	}

}
