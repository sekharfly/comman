package jayakrishna;

import javax.ws.rs.client.Client;
import javax.ws.rs.client.ClientBuilder;
import javax.ws.rs.client.Entity;
import javax.ws.rs.client.Invocation.Builder;
import javax.ws.rs.client.WebTarget;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

import org.json.JSONObject;

public class Demo {
	static String str = "https://api.surveymonkey.net/v3/";

	public static String doGet(String ant, String url) {
		Client newClient = ClientBuilder.newClient();
		WebTarget target = newClient.target(url);
		Builder request = target.request();
		request.header("Authorization", "bearer " + ant);
		Response response = request.get();
		String readEntity = response.readEntity(String.class);
		return readEntity;
	}

	public static String doPost(String ant, String body, String url) {
		Client newClient = ClientBuilder.newClient();
		WebTarget target = newClient.target(url);
		Builder request = target.request();
		request.header("Authorization", "bearer " + ant);
		Response response = request.post(Entity.entity(body, MediaType.APPLICATION_JSON));
		String readEntity = response.readEntity(String.class);
		return readEntity;
	}

	public JSONObject jsonValidation(String json) throws UserdefinedException {
		try {
			JSONObject jsonObject = new JSONObject(json);

			if (jsonObject.equals(null)) {
				throw new UserdefinedException("json is empty");
			} else if (jsonObject.length() == 0) {
				throw new UserdefinedException("json is empty");
			} else if (jsonObject.equals(" ")) {
				throw new UserdefinedException("json is em");
			} else {
				return jsonObject;
			}
		} catch (Exception e) {
			throw new UserdefinedException("A JSONObject text must begin with '{ Required data}");
		}

	}
}
