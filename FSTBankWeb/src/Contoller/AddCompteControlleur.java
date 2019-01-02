package Contoller;

import java.io.IOException;
import java.util.List;

import javax.ejb.EJB;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import EjbBean.ClientRemote;
import EjbEntity.Client;


@WebServlet("/AddCompteControlleur")
public class AddCompteControlleur extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private int idClient =0;
	@EJB
	private ClientRemote cr;   
  
    public AddCompteControlleur() {
        super();
       
    }


	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		List<Client> list = cr.afficher();
		request.setAttribute("clients", list);
		Client cl = cr.find(idClient);
		
		request.setAttribute("cl", cl);		
		this.getServletContext().getRequestDispatcher("/compte.jsp").forward(request, response);
	}


	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		idClient = Integer.valueOf(request.getParameter("id"));
		doGet(request, response);
	}

}
