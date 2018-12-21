package advertiser.Mangement.advertiser;

import java.net.URI;
import java.net.URISyntaxException;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.context.annotation.PropertySource;
import org.springframework.http.ResponseEntity;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.web.client.RestTemplate;

@RunWith(SpringRunner.class)
@SpringBootTest
@PropertySource("application.properties")

public class AdvertiserApplicationTests {

	@Test
	public void whenFindById() throws URISyntaxException {
		{
			RestTemplate restTemplate = new RestTemplate();
			final String baseUrl = "http://localhost:8089/advertiser/getAdvertiser/1";
			URI uri = new URI(baseUrl);
			ResponseEntity<String> result = restTemplate.getForEntity(uri, String.class);

			// Verify request succeed
			// Assert.assertEquals(200, result.getStatusCodeValue());
			// Assert.assertEquals(true, result.getBody().contains("advertiser"));
		}
	}

}
