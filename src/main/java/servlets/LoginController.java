package servlets;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import dao.LoginRepository;
import model.User;

/**
 * Servlet implementation class Login
 */
@WebServlet(name = "login", value = "/login")
public class LoginController extends HttpServlet {
	private static final long serialVersionUID = 1L;
	
	private LoginRepository loginRepository = new LoginRepository();
	
	public LoginController() {
	}

	@Override
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		 String acao = request.getParameter("acao");
		 
		 if (acao != null && !acao.isEmpty() && acao.equalsIgnoreCase("logout")) {
			 request.getSession().invalidate();
			 RequestDispatcher redirecionar = request.getRequestDispatcher("/index.jsp");
			 redirecionar.forward(request, response);
		 }else {
		  doPost(request, response);
		 }
	}

	@Override
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		try {
			String login = request.getParameter("login");
			String password = request.getParameter("password");
			
			if (login != null && !login.isEmpty() && password != null && !password.isEmpty()) {
				
				User modelLogin = User.getLoginDataLogin(login, password);
				
				if(loginRepository.validarLogin(modelLogin)) {
					request.getSession().setAttribute("login", login);
					
					
					request.getRequestDispatcher("/dashboard.jsp").forward(request, response);
				}else {
					customDispatcherWithMessage(request, response, "Login falhou", "Os dados informados estão incorretos");
				}				
			}else {
				RequestDispatcher redirecionar = request.getRequestDispatcher("index.jsp");
			
				redirecionar.forward(request, response);
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
