package advertiser.Mangement.advertiser;

import static org.junit.Assert.assertEquals;

import java.util.Date;
import java.util.Optional;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mockito;
import org.skyscreamer.jsonassert.JSONAssert;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.boot.web.server.LocalServerPort;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.mock.web.MockHttpServletResponse;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.MvcResult;
import org.springframework.test.web.servlet.RequestBuilder;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;

import com.google.gson.Gson;

import advertiser.Mangement.advertiser.Controller.AdvertiserController;
import advertiser.Mangement.advertiser.model.Advertiser;
import advertiser.Mangement.advertiser.repo.AdvertiserRepo;

@RunWith(SpringRunner.class)
@WebMvcTest(value = AdvertiserController.class)
public class AdvertiserApplicationTests {

	@LocalServerPort
	String randomServerPort;
	
	@Autowired
	Gson gson;

	@Autowired
	private MockMvc mockMvc;

	@MockBean
	private AdvertiserRepo studentService;

	@Test
	public void findById() throws Exception {
		Advertiser advertiser = new Advertiser(1l, "vinay", "vinay r", "100",new Date());
		Optional<Advertiser> of = Optional.of(advertiser);
		Mockito.<Optional<Advertiser>>when(studentService.findById(Mockito.any())).thenReturn(of);
		RequestBuilder requestBuilder = MockMvcRequestBuilders.get("/advertiser/getAdvertiser/1")
				.accept(MediaType.APPLICATION_JSON);

		MvcResult result = mockMvc.perform(requestBuilder).andReturn();

		System.out.println(result.getResponse().getContentAsString());
		String expected = "{\"id\":1,\"advertiserName\":\"vinay\",\"advertiserContactName\":\"vinay r\",\"advertiserCreditLimit\":\"100\"}";

		JSONAssert.assertEquals(expected, result.getResponse().getContentAsString(), false);
	}

/*	@Test
	public void newAdvertiser() throws URISyntaxException {
		System.out.println(randomServerPort);
		RestTemplate restTemplate = new RestTemplate();
		String valueOf = String.valueOf(randomServerPort);
		final String baseUrl = "http://localhost:" + valueOf + "/advertiser/newAdvertiser";
		URI uri = new URI(baseUrl);
		Advertiser employee = new Advertiser(1, "Adam", "Gilly", "10");

		HttpHeaders headers = new HttpHeaders();
		headers.add("Content-Type", "application/json");
		HttpEntity<Advertiser> request = new HttpEntity<>(employee, headers);

		try {
			restTemplate.postForEntity(uri, request, String.class);
			Assert.fail();
		} catch (Exception ex) {
			// Verify bad request and missing header
			// Assert.assertEquals(400, ex.getRawStatusCode());
			// Assert.assertEquals(true, ex.getResponseBodyAsString().contains("Missing
			// request header"));
			ex.printStackTrace();

		}*/
		
		
	@Test
	public void newAdvertiser() throws Exception {
		Advertiser advertiser = new Advertiser(1l, "vinay", "vinay r", "100",new Date());
		// studentService.addCourse to respond back with mockCourse
		Mockito.when(studentService.save(Mockito.any())).thenReturn(advertiser);
		// Send course as body to /students/Student1/courses
		RequestBuilder requestBuilder = MockMvcRequestBuilders.post("/advertiser/newAdvertiser")
				.accept(MediaType.APPLICATION_JSON).content(gson.toJson(advertiser))
				.contentType(MediaType.APPLICATION_JSON);

		MvcResult result = mockMvc.perform(requestBuilder).andReturn();

		MockHttpServletResponse response = result.getResponse();

		assertEquals(HttpStatus.OK.value(), response.getStatus());
	}	
}


