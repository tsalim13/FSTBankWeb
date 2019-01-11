
package Contoller;

import java.io.IOException;

import javax.ejb.EJB;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import EjbBean.ClientRemote;
import EjbEntity.Client;

/**
 * Servlet implementation class DashClient
 */
@WebServlet("/DashClient")
public class DashClient extends HttpServlet {
	private static final long serialVersionUID = 1L;
	@EJB
	private ClientRemote cr;
	
	private boolean cptValide = true;

	public DashClient() {
		super();
		// TODO Auto-generated constructor stub
	}

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		
		request.setAttribute("cptValide", cptValide);	
		this.getServletContext().getRequestDispatcher("/dashClient.jsp").forward(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		if (request.getParameter("form1") != null) {
			Client client = cr.findByMail(request.getParameter("mail"));
			if (client != null ) {
				System.out.println(client.getNom()+ client.getPrenom());
			}
			else {
				cptValide = false;
				doGet(request, response);
				cptValide =true;
			}
		}
		else {
			System.out.println(request.getParameter("soldee"));
			
		}
		
		
		//doGet(request, response);
	}

}
