package servlets;

import java.io.IOException;

import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class Login
 */
@WebServlet(name = "login", value = "/login")
public class Login extends HttpServlet {
	private static final long serialVersionUID = 1L;
	
	public Login() {
		// TODO Auto-generated constructor stub
	}

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
//		 String acao = request.getParameter("acao");
//		 
//		 if (acao != null && !acao.isEmpty() && acao.equalsIgnoreCase("logout")) {
//			 request.getSession().invalidate();// invalida a sess�o
//			 RequestDispatcher redirecionar = request.getRequestDispatcher("index.jsp");
//			 redirecionar.forward(request, response);
//		 }else {
//		  doPost(request, response);
//		 }

		
		response.getWriter().append("Served at: ").append(request.getContextPath());
	}


	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		try {
			String login = request.getParameter("login");
			String password = request.getParameter("password");
			
			double c = 1 / 0;
			
		} catch (Exception e) {
			e.printStackTrace();
			request.setAttribute("msg",	e.getMessage());
			request.getRequestDispatcher("/error.jsp").forward(request, response);
			
		}
	}

}
