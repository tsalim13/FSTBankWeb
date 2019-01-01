package Contoller;

import java.io.IOException;

import javax.ejb.EJB;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import EjbBean.ClientRemote;
import EjbBean.ComptePriveRemote;
import EjbEntity.CParticulierPrive;
import EjbEntity.Client;

/**
 * Servlet implementation class Test
 */
@WebServlet("/Test")
public class Test extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
	@EJB
	private ComptePriveRemote cr ;
	
	@EJB
	private ClientRemote clr ;
	
    /**
     * @see HttpServlet#HttpServlet()
     */
    public Test() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		
		CParticulierPrive cpp = new CParticulierPrive();
		Client cl = new Client();
		cl.setMail("gotlmmmm");
		cl.setMdp("123333");
		cl.setNom("aaaazzzz");
		cl.setPrenom("bbbbbbb");
		
		//cl.setId(2);
		Client cll= clr.ajouter(cl);
		System.out.println("id clieennnttt"+cll.getId());
		cpp.setClient(cll);
		cpp.setSolde(9560);
		
		cr.addCompte(cpp);
		System.out.println("doooneee");
		this.getServletContext().getRequestDispatcher("/blank.jsp").forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
