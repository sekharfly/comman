package jayakrishna;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.ws.rs.client.Client;
import javax.ws.rs.client.ClientBuilder;
import javax.ws.rs.client.Invocation.Builder;
import javax.ws.rs.client.WebTarget;
import javax.ws.rs.core.Response;

/**
 * Servlet implementation class Sample
 */
public class Sample extends HttpServlet {
	private static final long serialVersionUID = 1L;

	@Override
	public void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

		resp.setContentType("txt/html");
		PrintWriter writer=resp.getWriter();
		Client newClient = ClientBuilder.newClient();
		WebTarget target = newClient.target("https://api.surveymonkey.net/v3/surveys");
		Builder request = target.request();
		Response response = request.get();
		String readEntity = response.readEntity(String.class);
		System.out.println(readEntity);
		
	}
}
