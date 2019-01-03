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







@WebServlet("/ClientControlleur")
public class ClientControlleur extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
	@EJB
	private ClientRemote cr;
	
    public ClientControlleur() {
        super();
    }

	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		List<EjbEntity.Client> list = cr.afficher();
		request.setAttribute("clients", list);
		this.getServletContext().getRequestDispatcher("/client.jsp").forward(request, response);

	}

	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		EjbEntity.Client bn = new EjbEntity.Client();
		
		bn.setMail(request.getParameter("mail"));
		bn.setMdp(request.getParameter("mdp"));
		bn.setNom(request.getParameter("nom"));
		bn.setPrenom(request.getParameter("prenom"));
		cr.ajouter(bn);
		
		doGet(request, response);
		
		
	}

}
