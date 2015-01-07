package test;

import javax.servlet.*;
import java.io.IOException;
import java.util.logging.Logger;

public class ErrorFilter implements Filter {

	private static final Logger log = Logger.getLogger(ErrorFilter.class.getName());

	public void destroy() {
	}

	public void doFilter(ServletRequest req, ServletResponse resp, FilterChain chain) throws ServletException, IOException {

		try {
			log.info("filtered..");
			chain.doFilter(req, resp);
		} catch (Error err) {
			log.severe("Fatal error: " + err.getMessage());
			throw new Error(err);
		}
	}

	public void init(FilterConfig config) throws ServletException {

	}

}
