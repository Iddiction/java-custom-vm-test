package test;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.Date;
import java.util.logging.Logger;

public class HealthCheckServlet extends HttpServlet {

	private static final Logger log = Logger.getLogger(HealthCheckServlet.class.getName());

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		long startTime = new Date().getTime();
		log.info("Custom Health request started: " + startTime);
		log.info("Free memory: " + (Runtime.getRuntime().freeMemory() / (1024 * 1024)) + "M");

		response.setStatus(HttpServletResponse.SC_OK);
		PrintWriter writer = response.getWriter();
		writer.write("ok");
		writer.flush();

		long finishTime = new Date().getTime();
		log.info("Custom Health request finished: " + finishTime + " Used time in ms: " + (finishTime - startTime));
	}
}
