package test;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

/**
 * Created by peter on 29/12/14.
 */
public class MainServlet extends HttpServlet {

	String header = "<html>\n" +
			"<head>\n" +
			"    <title>MemTest</title>\n" +
			"</head>\n" +
			"<body>";

	String footer = "<form action=\"/\" method=\"get\">\n" +
			"    <div><input type=\"text\" name=\"add\" value=\"100\"/></div>\n" +
			"    <div><input type=\"submit\" value=\"Add\"/></div>\n" +
			"</form>\n" +
			"\n" +
			"\n" +
			"<form action=\"/\" method=\"get\">\n" +
			"    <div><input type=\"hidden\" name=\"clear\" value=\"true\"/></div>\n" +
			"    <div><input type=\"submit\" value=\"Clear\"/></div>\n" +
			"</form>\n" +
			"\n" +
			"\n" +
			"<form action=\"/\" method=\"get\">\n" +
			"    <div><input type=\"hidden\" name=\"dumpHeap\" value=\"true\"/></div>\n" +
			"    <div><input type=\"submit\" value=\"Dump heap\"/></div>\n" +
			"</body>\n" +
			"</html>";

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		PrintWriter out = response.getWriter();
		out.append(header);

		int added = 0;
		String addCmd = request.getParameter("add");
		String dumpHeapCmd = request.getParameter("dumpHeap");
		if (addCmd != null) {
			int add = Integer.valueOf(addCmd);
			Main.instance().add(1000 * add);
			added = 1000 * add;
		}

		String clearCmd = request.getParameter("clear");
		if (addCmd != null && "true".equals(clearCmd)) {
			Main.instance().clear();
		}
		if (dumpHeapCmd != null && "true".equals(dumpHeapCmd)) {
			HeapDumper.dumpHeap("heap.dump", false);
		}

		out.append("<br/>Added = " + added);
		out.append("<br/>Instances = " + Main.instance().list());
		out.append("<br/>Free memory = " + (Runtime.getRuntime().freeMemory() / (1024 * 1024)));
//		out.append("<br/>Instance = ")
//				.append(ModulesServiceFactory.getModulesService().getCurrentModule()).append(":")
//				.append(ModulesServiceFactory.getModulesService().getCurrentVersion()).append(":")
//				.append(ModulesServiceFactory.getModulesService().getCurrentInstanceId());

		out.append(footer);
		out.flush();
		out.close();

	}
}
