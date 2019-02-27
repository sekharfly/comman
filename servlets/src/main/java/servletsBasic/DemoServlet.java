package servletsBasic;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.xml.ws.Response;

public class DemoServlet extends HttpServlet {

	public void doGet(HttpServletRequest req, HttpServletResponse res) throws IOException {

		res.setContentType("text/html");
		PrintWriter pw = res.getWriter();

		String name = req.getParameter("name");// will return value
		pw.println("Welcome " + name);
		
		
		Cookie cookie = new Cookie("name", name);
		res.addCookie(cookie);
		

		pw.close();

	}

}
