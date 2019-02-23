package jayakrishna;

import java.net.URI;

import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.HeaderParam;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.QueryParam;
import javax.ws.rs.client.Client;
import javax.ws.rs.client.ClientBuilder;
import javax.ws.rs.client.Entity;
import javax.ws.rs.client.Invocation;
import javax.ws.rs.client.WebTarget;
import javax.ws.rs.core.Form;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import javax.ws.rs.core.UriBuilder;

import org.json.JSONException;
import org.json.JSONObject;

@Path("/demo")
public class DemoMonkeysurvey {
	
	
	@GET
	@Path("/oauth")
	@Produces(MediaType.APPLICATION_JSON)
	public Response redirectTosurveyDetails()
	{
	URI uri = UriBuilder.fromUri("https://api.surveymonkey.net/oauth/authorize"
			+ "?response_type=code&redirect_uri=http://localhost:8082/WebService/sekhar/demo/redirect&client_id=OtTE1HWlQIqHy6hLjPTHNQ").build();
	return Response.temporaryRedirect(uri).build();
	}
	
    @GET
    @Path("redirect")
    @Produces(MediaType.APPLICATION_JSON)
    public String getAuthorizationCode(@QueryParam("code") String code) throws JSONException
    {
    	String authorizationCode = code;
    	
		String accessString = getAccessToken(authorizationCode);
		JSONObject json = new JSONObject(accessString);
		String accessToken = json.getString("access_token");
		System.out.println(accessToken);
		return accessToken;	
    }
    public String getAccessToken(String code){
		Client client = ClientBuilder.newClient();
		
		WebTarget target = client.target(UriBuilder.fromUri("https://api.surveymonkey.net/oauth/token").build());
		Form form = new Form();
		form.param("code",code);
		form.param("client_secret", "61271252731618164361541625808205992879");
		form.param("redirect_uri","http://localhost:8082/WebService/sekhar/demo/redirect");
		form.param("grant_type", "authorization_code");
		form.param("client_id", "OtTE1HWlQIqHy6hLjPTHNQ");
		Invocation.Builder invocationBuilder = target.request();
		invocationBuilder.header("Content-Type", MediaType.APPLICATION_FORM_URLENCODED);
		Response response = invocationBuilder.post(Entity.entity(form, MediaType.APPLICATION_FORM_URLENCODED));
		System.out.println(response.toString());
		String s = response.readEntity(String.class);
		System.out.println(s);
		return s;
	}

	
	@GET
	@Path("/me")
	@Consumes(MediaType.APPLICATION_JSON)
	@Produces(MediaType.APPLICATION_JSON)

	public Response users_me(@HeaderParam("Authorization") String ant, String json) {
		Response build = null;
		try {
			String doGet = Demo.doGet(ant, Demo.str + "users/me");
			build = Response.status(200).entity(doGet).build();

		} catch (Exception e) {
			return Response.status(400).entity(e.getMessage()).build();
		}
		return build;
	}

	@POST
	@Path("/surveys")
	@Consumes(MediaType.APPLICATION_JSON)
	@Produces(MediaType.APPLICATION_JSON)

	public Response surveys(@HeaderParam("Authorization") String ant, String json) {
		Response build = null;
		Demo demo =  new Demo();
		try {
			JSONObject jsonValidation = demo.jsonValidation(json);
			String doPost = Demo.doPost(ant, json, Demo.str + "surveys");
			build = Response.status(200).entity(doPost).build();

		} catch (Exception e) {
			return Response.status(400).entity(e.getMessage()).build();
		}
		return build;
	}

	@GET
	@Path("/sign")
	@Consumes(MediaType.APPLICATION_JSON)
	@Produces(MediaType.APPLICATION_JSON)

	public Response signin(@HeaderParam("Authorization") String ant, String json) {
		Response build = null;
		try {
			String doGet = Demo.doGet(ant,
					"https://api.surveymonkey.net/oauth/authorize?response_type=code&redirect_uri=https://www.surveymonkey.comclient_id=sGYxj_gJRNK4CvWTgkPRgg");
			build = Response.status(200).entity(doGet).build();

		} catch (Exception e) {
			return Response.status(400).entity(e.getMessage()).build();
		}
		return build;
	}

	@GET
	@Path("/groups")
	@Consumes(MediaType.APPLICATION_JSON)
	@Produces(MediaType.APPLICATION_JSON)

	public Response logtoken(@HeaderParam("Authorization") String ant, String json) {
		Response build = null;
		try {
			String doGet = Demo.doGet(ant, Demo.str + "groups");
			build = Response.status(200).entity(doGet).build();

		} catch (Exception e) {
			return Response.status(400).entity(e.getMessage()).build();
		}
		return build;
	}

	@GET
	@Path("/survey_categories")
	@Consumes(MediaType.APPLICATION_JSON)
	@Produces(MediaType.APPLICATION_JSON)

	public Response categories(@HeaderParam("Authorization") String ant, String json) {
		Response build = null;
		try {
			String doGet = Demo.doGet(ant, Demo.str + "survey_categories");
			build = Response.status(200).entity(doGet).build();

		} catch (Exception e) {
			e.printStackTrace();
		}
		return build;
	}

	@GET
	@Path("/survey_templates")
	@Consumes(MediaType.APPLICATION_JSON)
	@Produces(MediaType.APPLICATION_JSON)

	public Response templates(@HeaderParam("Authorization") String ant, String json) {
		Response build = null;
		try {
			String doGet = Demo.doGet(ant, Demo.str + "survey_templates");
			build = Response.status(200).entity(doGet).build();

		} catch (Exception e) {
			e.printStackTrace();
		}
		return build;
	}

	@POST
	@Path("/pages")
	@Consumes(MediaType.APPLICATION_JSON)
	@Produces(MediaType.APPLICATION_JSON)

	public Response pages(@HeaderParam("Authorization") String ant, String json) {
		Response build = null;
		Demo demo = new Demo();
		try {
			JSONObject jsonValidation = demo.jsonValidation(json);
			String doPost = Demo.doPost(ant, json, Demo.str+"surveys/120467009/pages");
			build = Response.status(200).entity(doPost).build();

		} catch (Exception e) {
			build = Response.status(404).entity(e.getMessage()).build();
		}
		return build;
	}

	@GET
	@Path("/pages_id")
	@Consumes(MediaType.APPLICATION_JSON)
	@Produces(MediaType.APPLICATION_JSON)

	public Response id(@HeaderParam("Authorization") String ant, String json) {
		String doGet = Demo.doGet(ant, Demo.str + "surveys/120467009/pages/45278878");
		Response build = Response.status(200).entity(doGet).build();
		return build;
	}

	@POST
	@Path("/contact_lists")
	@Consumes(MediaType.APPLICATION_JSON)
	@Produces(MediaType.APPLICATION_JSON)

	public Response contact_lists(@HeaderParam("Authorization") String ant, String json) {
		Response build = null;
		Demo demo = new Demo();
		try {
			JSONObject jsonValidation = demo.jsonValidation(json);
			String doPost = Demo.doPost(ant, json, Demo.str + "contact_lists");
			build = Response.status(200).entity(doPost).build();
		} catch (UserdefinedException e) {
			build = Response.status(404).entity(e.getMessage()).build();
		}
		return build;
	}

	@GET
	@Path("/contact_lists_id")
	@Consumes(MediaType.APPLICATION_JSON)
	@Produces(MediaType.APPLICATION_JSON)

	public Response contact_lists_id(@HeaderParam("Authorization") String ant, String json) {
		String doGet = Demo.doGet(ant, Demo.str + "contact_lists/88083615");
		Response build = Response.status(200).entity(doGet).build();
		return build;
	}

	@POST
	@Path("/contact_lists_copy")
	@Consumes(MediaType.APPLICATION_JSON)
	@Produces(MediaType.APPLICATION_JSON)

	public Response contact_lists_copy(@HeaderParam("Authorization") String ant, String json) {
		Response build = null;
		Demo demo = new Demo();
		try {
			JSONObject jsonValidation = demo.jsonValidation(json);
			String doPost = Demo.doPost(ant, json, Demo.str + "contact_lists/88083615/copy");
			build = Response.status(200).entity(doPost).build();
		} catch (UserdefinedException e) {
			build = Response.status(200).entity(e.getMessage()).build();
		}
		return build;
	}

	@POST
	@Path("/contact_body")
	@Consumes(MediaType.APPLICATION_JSON)
	@Produces(MediaType.APPLICATION_JSON)

	public Response contact_body(@HeaderParam("Authorization") String ant, String json) {
		Response build = null;
		Demo demo = new Demo();
		try {
			JSONObject jsonValidation = demo.jsonValidation(json);
			String doPost = Demo.doPost(ant, json, Demo.str + "contact_lists/88084024/contacts");
			build = Response.status(200).entity(doPost).build();
		} catch (UserdefinedException e) {
			build = Response.status(200).entity(e.getMessage()).build();
		}
		return build;
	}

	@POST
	@Path("/contact_bulk")
	@Consumes(MediaType.APPLICATION_JSON)
	@Produces(MediaType.APPLICATION_JSON)

	public Response contact_bulk(@HeaderParam("Authorization") String ant, String json) {
		Response build = null;
		Demo demo = new Demo();
		try {
			JSONObject jsonValidation = demo.jsonValidation(json);
			String doPost = Demo.doPost(ant, json, Demo.str + "contact_lists/88093265/contacts/bulk");
			build = Response.status(200).entity(doPost).build();
		} catch (UserdefinedException e) {
			build = Response.status(200).entity(e.getMessage()).build();
		}
		return build;
	}

	@POST
	@Path("/contactsss")
	@Consumes(MediaType.APPLICATION_JSON)
	@Produces(MediaType.APPLICATION_JSON)

	public Response contactsss(@HeaderParam("Authorization") String ant, String json) {
		Response build = null;
		Demo demo = new Demo();
		try {
			JSONObject jsonValidation = demo.jsonValidation(json);
			String doPost = Demo.doPost(ant, json, Demo.str + "contacts");
			build = Response.status(200).entity(doPost).build();
		} catch (UserdefinedException e) {
			build = Response.status(200).entity(e.getMessage()).build();
		}
		return build;
	}

	@GET
	@Path("/bulk_id")
	@Consumes(MediaType.APPLICATION_JSON)
	@Produces(MediaType.APPLICATION_JSON)

	public Response bulk_id(@HeaderParam("Authorization") String ant, String json) {
		String doGet = Demo.doGet(ant, Demo.str + "contacts/2002788017");
		Response build = Response.status(200).entity(doGet).build();
		return build;
	}

	@GET
	@Path("/contact_fields")
	@Consumes(MediaType.APPLICATION_JSON)
	@Produces(MediaType.APPLICATION_JSON)

	public Response contact_fields(@HeaderParam("Authorization") String ant, String json) {
		String doGet = Demo.doGet(ant, Demo.str + "contact_fields");
		Response build = Response.status(200).entity(doGet).build();
		return build;
	}

	@POST
	@Path("/collectors")
	@Consumes(MediaType.APPLICATION_JSON)
	@Produces(MediaType.APPLICATION_JSON)

	public Response collectors(@HeaderParam("Authorization") String ant, String json) {
		Response build = null;
		Demo demo = new Demo();
		try {
			JSONObject jsonValidation = demo.jsonValidation(json);
			String doPost = Demo.doPost(ant, json, Demo.str + "surveys/120477237/collectors");
			build = Response.status(200).entity(doPost).build();
		} catch (UserdefinedException e) {
			build = Response.status(200).entity(e.getMessage()).build();
		}
		return build;
	}

	@GET
	@Path("/collectors_id")
	@Consumes(MediaType.APPLICATION_JSON)
	@Produces(MediaType.APPLICATION_JSON)

	public Response collectors_id(@HeaderParam("Authorization") String ant, String json) {
		String doGet = Demo.doGet(ant, Demo.str + "collectors/160179599");
		Response build = Response.status(200).entity(doGet).build();
		return build;
	}

	@POST
	@Path("/messages")
	@Consumes(MediaType.APPLICATION_JSON)
	@Produces(MediaType.APPLICATION_JSON)

	public Response messages(@HeaderParam("Authorization") String ant, String json) {

		Response build = null;
		Demo demo = new Demo();
		try {
			JSONObject jsonValidation = demo.jsonValidation(json);
			String doPost = Demo.doPost(ant, json, Demo.str + "collectors/160180816/messages");
			build = Response.status(200).entity(doPost).build();
		} catch (UserdefinedException e) {
			build = Response.status(200).entity(e.getMessage()).build();
		}
		return build;

	}

	@GET
	@Path("/messages_id")
	@Consumes(MediaType.APPLICATION_JSON)
	@Produces(MediaType.APPLICATION_JSON)

	public Response messages_id(@HeaderParam("Authorization") String ant, String json) {
		String doGet = Demo.doGet(ant, Demo.str + "collectors/160180816/messages/40092159");
		Response build = Response.status(200).entity(doGet).build();
		return build;

	}

	@GET
	@Path("/response")
	@Consumes(MediaType.APPLICATION_JSON)
	@Produces(MediaType.APPLICATION_JSON)

	public Response response(@HeaderParam("Authorization") String ant, String json) {
		String doGet = Demo.doGet(ant, Demo.str + "surveys/120480410/responses");
		Response build = Response.status(200).entity(doGet).build();
		return build;
	}
}
