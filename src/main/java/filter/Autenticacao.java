package filter;

import java.io.IOException;
import java.sql.Connection;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.HttpFilter;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import connection.SingletonConnectionDB;


/**
 * Servlet Filter implementation class Autenticacao
 */
@WebFilter(urlPatterns = { "/*" })
public class Autenticacao extends HttpFilter implements Filter {

	private static final long serialVersionUID = -8082561315029569656L;
	private static Connection connection;

	public Autenticacao() {
	}

	@Override
	public void destroy() {
		try {
			connection.close();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	@Override
	public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain)
			throws IOException, ServletException {

		HttpServletRequest req = (HttpServletRequest) request;

		String urlParaAutenticar = req.getServletPath();
		System.out.println("Filter URL  - " + urlParaAutenticar);

		HttpSession session = req.getSession();
		String usuarioLogado = (String) session.getAttribute("login");
		System.out.println("Filter user - " + usuarioLogado);

		// Garantir que nao possa escrever a URL
		if (usuarioLogado == null && precisaAutenticarUrl(urlParaAutenticar)) {

			RequestDispatcher redireciona = request.getRequestDispatcher("/index.jsp?url=" + urlParaAutenticar);
			request.setAttribute("msg", "Por favor realize o login!");
			redireciona.forward(request, response);
			return;

		} else {
			chain.doFilter(request, response);
		}
	}

	@Override
	public void init(FilterConfig fConfig) throws ServletException {
		connection = SingletonConnectionDB.getConnection();
	}

	private boolean precisaAutenticarUrl(String url) {
		return !(
				url.contains("assets") || 
				url.equalsIgnoreCase("/index.jsp") || 
				url.equalsIgnoreCase("/login") ||
				url.equalsIgnoreCase("/signup.jsp") ||
				url.equalsIgnoreCase("/signup") ||
				url.equalsIgnoreCase("/perfil.jsp")
				);
	}

}
