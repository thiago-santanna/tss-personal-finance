package servlets;

import java.io.IOException;

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
			
			if(login.equalsIgnoreCase("admin") && password.equalsIgnoreCase("admin")) {
				request.getSession().setAttribute("login", login);
				
				
				request.getRequestDispatcher("/dashboard.jsp").forward(request, response);
			}else {
				customDispatcherWithMessage(request, response, "Login falhou", "Os dados informados estão incorretos");
			}
			
		} catch (Exception e) {
			e.printStackTrace();
			customDispatcherWithMessage(request, response, "Erro interno no servidor", e.getMessage());
			
		}
	}

	private void customDispatcherWithMessage(HttpServletRequest request, HttpServletResponse response, String subTitle, String message)
			throws ServletException, IOException {
		request.setAttribute("msg",	message);
		request.setAttribute("subTitle", subTitle);
		request.getRequestDispatcher("/error.jsp").forward(request, response);
	}

}
