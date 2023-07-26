package cookNserv;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/s1")
public class serv1 extends HttpServlet {

	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		resp.setContentType("text/html");
		PrintWriter out = resp.getWriter();
		out.println("<html>");
		out.println("<head>");
		out.println("<title>Cookies in Servlet");
		out.println("</title>");
		out.println("</head>");
		out.println("<body>");

		String name = req.getParameter("name");
		out.println("<h1>Hello " + name + " Welcome to " + "my Website... </h1>");

//creating cookie
		Cookie c = new Cookie("user-name", name);
		resp.addCookie(c);

		out.println("<h2><a href='Serv2'>Go to Servlet2 </a></h2>");
		out.println("<body>");
		out.println("<html>");
//		RequestDispatcher rd = req.getRequestDispatcher("Serv2");
//		rd.forward(req, resp);
	}
}
