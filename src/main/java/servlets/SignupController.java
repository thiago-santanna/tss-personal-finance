package servlets;

import java.io.IOException;
import java.util.Optional;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import dao.UserRepository;
import model.User;
import service.UserService;

@WebServlet(name = "signup", value = "/signup")
public class SignupController extends HttpServlet {
	private static final long serialVersionUID = -3141889427676477702L;
	
	private UserRepository signupRepository;
	
	private UserService signupService;
	
	public SignupController() {
		signupRepository = new UserRepository();
		signupService = new UserService(signupRepository);
	}
	
	@Override
	public void doPost(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException{

		String login = req.getParameter("login");
		String email = req.getParameter("email");
		String password = req.getParameter("password");
		User user = new User(login, email, password);
		
		try {
			Optional<User> optionalUser = signupService.saveUser(user);
			if(optionalUser.isPresent()) {
				User savedUser = optionalUser.get();
				req.setAttribute("msg", "Usuário " + savedUser.getLogin() + " pode entrar no sistema.");
				req.getRequestDispatcher("/index.jsp").forward(req, res);
			}
			
		} catch (Exception e) {
			e.printStackTrace();
			customDispatcherWithMessage(req, res, "Erro ao cadastrar", e.getMessage());
		}
		
	}
	
	private void customDispatcherWithMessage(HttpServletRequest request, HttpServletResponse response, String subTitle, String message)
			throws ServletException, IOException {
		
		request.setAttribute("msg",	message);
		request.setAttribute("subTitle", subTitle);
		request.getRequestDispatcher("/error.jsp").forward(request, response);
	}

}
