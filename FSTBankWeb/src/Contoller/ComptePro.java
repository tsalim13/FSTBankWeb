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
import EjbBean.CompteProRemote;
import EjbEntity.CParticulierPrive;
import EjbEntity.CProfessionnel;

@WebServlet("/ComptePro")
public class ComptePro extends HttpServlet {
	private static final long serialVersionUID = 1L;
	@EJB
	private CompteProRemote cp;
       
    
    public ComptePro() {
        super();  
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		List<CProfessionnel> list = cp.listComptes();
		request.setAttribute("list", list);
		
		this.getServletContext().getRequestDispatcher("/comptePro.jsp").forward(request, response);
	}


	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		doGet(request, response);
	}

}
