package cookNserv;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/Serv2")
public class Serv2 extends HttpServlet {

	private static final long serialVersionUID = 1L;

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		resp.setContentType("text/html");
		PrintWriter out = resp.getWriter();

		out.println("<html>");
		out.println("<head>");
		out.println("<title>Cookies in Servlet");
		out.println("</title>");
		out.println("</head>");
		out.println("<body>");
//getting cookies
		Cookie[] ck = req.getCookies();
		boolean f = false;
		String name = "";
		if (ck == null) {
			out.println("<h2>You're a new user, go to homepage and submit your name</h2>");
			return;
		} else {
			for (Cookie c : ck) {
				String tname = c.getName();
				if (tname.equals("user-name")) {
					f = true;
					name = c.getValue();
				}
			}
		}
		if(f=true) {
		out.println("<h1>Hello " + name + " Welcome **again** to my Website... </h1>");
		}else {
			out.println("<h2> You're  new user , you need to register first</h2>");
		
		}
		out.println("<body>");
		out.println("<html>");
	}
}
