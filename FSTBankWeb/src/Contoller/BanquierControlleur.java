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
		Banquier bn = new Banquier();
		
		bn.setMail("banquierrrr");
		bn.setMdp("03428");
		bn.setNom("mail@maom==il");
		bn.setPrenom("defg");
		
		cr.ajouter(bn);
		
		
		List<Banquier> list = cr.afficher();
		System.out.println("liistee banquierr :::");
		Banquier bnnq = (Banquier)list.get(1);
		System.out.println(bnnq.getMail());
		
		
		request.setAttribute("banquiers", list);
		this.getServletContext().getRequestDispatcher("/banquier.jsp").forward(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

	}

}
