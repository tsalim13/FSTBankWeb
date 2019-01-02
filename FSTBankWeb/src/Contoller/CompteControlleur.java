package Contoller;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


@WebServlet("/CompteControlleur")
public class CompteControlleur extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private int idClient =0;
       
  
    public CompteControlleur() {
        super();
       
    }


	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setAttribute("idClient", idClient);		
		this.getServletContext().getRequestDispatcher("/compte.jsp").forward(request, response);
	}


	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		idClient = Integer.valueOf(request.getParameter("id"));
		doGet(request, response);
	}

}
