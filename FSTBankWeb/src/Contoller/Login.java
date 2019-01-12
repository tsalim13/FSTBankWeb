package Contoller;

import java.io.IOException;

import javax.ejb.EJB;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import EjbBean.BanquierRemote;
import EjbBean.ClientRemote;
import EjbEntity.Banquier;
import EjbEntity.Client;

/**
 * Servlet implementation class Login
 */
@WebServlet("/Login")
public class Login extends HttpServlet {
	private static final long serialVersionUID = 1L;
	@EJB
	private BanquierRemote bnqBean;
	@EJB
	private ClientRemote cltBean;

	public Login() {
		super();

	}

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		this.getServletContext().getRequestDispatcher("/login.jsp").forward(request, response);

	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		String mail = request.getParameter("username");
		String mdp = request.getParameter("password");

		Banquier bnqLog = bnqBean.banquierLogin(mail, mdp);

		if (bnqLog != null) {
			System.out.println("baaannquierr :  " + bnqLog.getMail());
			request.getSession().setAttribute("banquierId", bnqLog.getId());
			request.getSession().setAttribute("banquierNom", bnqLog.getNom());
			request.getSession().setAttribute("banquierPrenom", bnqLog.getPrenom());
			request.getSession().setAttribute("banquierMail", bnqLog.getMail());
			this.getServletContext().getRequestDispatcher("/DashBanquier").forward(request, response);
		} else {
			Client cltLog = cltBean.clientLogin(mail, mdp);
			if (cltLog != null) {
				System.out.println("cliennnnnttttt :  " + cltLog.getMail());
				request.getSession().setAttribute("clientId", cltLog.getId());
				response.sendRedirect(request.getContextPath() + "/DashClientPrive");
			}
			else {
				// pour dire que mail ou mdp incorrect
				request.setAttribute("err", true);
				this.getServletContext().getRequestDispatcher("/login.jsp").forward(request, response);
			}
		}

	}

}
