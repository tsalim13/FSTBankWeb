package Contoller;

import java.io.IOException;
import java.util.ArrayList;

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
		ArrayList<Banquier> list = (ArrayList<Banquier>) cr.afficher();
		System.out.println("hahahahhahhahahhahhaha");
		System.out.println(list.get(0));

		this.getServletContext().getRequestDispatcher("/banquier.jsp").forward(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

	}

}
