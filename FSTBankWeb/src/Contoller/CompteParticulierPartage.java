package Contoller;

import java.io.IOException;
import java.util.List;

import javax.ejb.EJB;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import EjbBean.ComptePartageRemote;
import EjbBean.ComptePriveRemote;
import EjbBean.CompteProRemote;
import EjbEntity.CParticulierPartage;
import EjbEntity.CParticulierPrive;
import EjbEntity.CProfessionnel;

@WebServlet("/CompteParticulierPartage")
public class CompteParticulierPartage extends HttpServlet {
	private static final long serialVersionUID = 1L;
	@EJB
	private ComptePartageRemote cp;
       
    
    public CompteParticulierPartage() {
        super();  
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		List<CParticulierPartage> list = cp.listComptes();
		request.setAttribute("list", list);
		
		this.getServletContext().getRequestDispatcher("/compteParticulierPartage.jsp").forward(request, response);
	}


	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		doGet(request, response);
	}

}
