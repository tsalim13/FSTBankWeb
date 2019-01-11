package Contoller;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 * Servlet implementation class Login
 */
@WebServlet("/Login")
public class Login extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public Login() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		/*HttpSession session = request.getSession();
		session.setAttribute("user", null);*/
		
		this.getServletContext().getRequestDispatcher("/login.jsp").forward(request, response);

		
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String username = request.getParameter("username");
        String password = request.getParameter("password");
        
        if(username.equals(password))
        {
        	request.getSession().setAttribute("user", "Saliiiiimmm");
        	response.sendRedirect(request.getContextPath() + "/ClientControlleur");
        	return;
        }
        else
        {
        	// Recupere la session
    		HttpSession session = request.getSession(true); 
    		//Détruire la session 
    		session.invalidate();
    		System.out.println("invalidaaaaaaate");
        	this.getServletContext().getRequestDispatcher("/login.jsp").forward(request, response);
        }
	}

}
