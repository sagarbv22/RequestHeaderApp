package in.ineuron.controller;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.Enumeration;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/test")
public class RequestHeaderServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		PrintWriter out = response.getWriter();
		out.println("<body>");
		out.println("<center>");

		Enumeration<String> headerNames = request.getHeaderNames();
		out.println("<h1 style = 'color:red; text-align:center;'>Request Header Information...</h1>");
		out.println("<table border='1'>");
		out.println("<tr><th>HeaderName</th><th>HeaderValue</th></tr>");

		while (headerNames.hasMoreElements()) {
			String headername = (String) headerNames.nextElement();
			String headerValue = (String) request.getHeader(headername);
			out.println("<tr>");
			out.println("<td>" + headername + "</td>");
			out.println("<td>" + headerValue + "</td>");
			out.println("</tr>");
		}

		out.println("</table>");

		out.println("</center>");
		out.println("</body>");

		out.close();

	}

}
