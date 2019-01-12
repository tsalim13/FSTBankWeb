package Contoller;

import java.io.IOException;
import java.util.List;

import javax.ejb.EJB;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import EjbBean.ComptePriveRemote;
import EjbEntity.CParticulierPrive;

@WebServlet("/CompteParticulierPrive")
public class CompteParticulierPrive extends HttpServlet {
	private static final long serialVersionUID = 1L;
	@EJB
	private ComptePriveRemote cp;
       
    
    public CompteParticulierPrive() {
        super();  
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		List<CParticulierPrive> list = cp.listComptes();
		request.setAttribute("list", list);
		
		this.getServletContext().getRequestDispatcher("/compteParticulierPrive.jsp").forward(request, response);
	}


	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		doGet(request, response);
	}

}
