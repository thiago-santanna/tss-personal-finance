package filter;

import java.io.IOException;

import jakarta.servlet.Filter;
import jakarta.servlet.FilterChain;
import jakarta.servlet.FilterConfig;
import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.ServletRequest;
import jakarta.servlet.ServletResponse;
import jakarta.servlet.annotation.WebFilter;
import jakarta.servlet.http.HttpFilter;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpSession;

/**
 * Servlet Filter implementation class Autenticacao
 */
@WebFilter(urlPatterns = { "/*" })
public class Autenticacao extends HttpFilter implements Filter {

	private static final long serialVersionUID = -8082561315029569656L;

	public Autenticacao() {
	}

	public void destroy() {
	}

	public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain)
			throws IOException, ServletException {

		HttpServletRequest req = (HttpServletRequest) request;

		String urlParaAutenticar = req.getServletPath();
		System.out.println("URL  - " + urlParaAutenticar);

		HttpSession session = req.getSession();
		String usuarioLogado = (String) session.getAttribute("login");
		System.out.println("user - " + usuarioLogado);

		// chain.doFilter(request, response);

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

	public void init(FilterConfig fConfig) throws ServletException {
	}

	private boolean precisaAutenticarUrl(String url) {
		return !(url.contains("assets") || url.equalsIgnoreCase("/index.jsp") || url.equalsIgnoreCase("/login"));
	}

}