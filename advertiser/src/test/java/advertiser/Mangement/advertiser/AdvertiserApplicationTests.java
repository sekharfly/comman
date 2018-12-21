package advertiser.Mangement.advertiser;

import java.util.Optional;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mockito;
import org.skyscreamer.jsonassert.JSONAssert;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.MvcResult;
import org.springframework.test.web.servlet.RequestBuilder;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;

import advertiser.Mangement.advertiser.Controller.AdvertiserController;
import advertiser.Mangement.advertiser.model.Advertiser;
import advertiser.Mangement.advertiser.repo.AdvertiserRepo;

@RunWith(SpringRunner.class)
@WebMvcTest(value = AdvertiserController.class)
public class AdvertiserApplicationTests {

	@Autowired
	private MockMvc mockMvc;

	@MockBean
	private AdvertiserRepo studentService;

	
	@Test
	public void findById() throws Exception {
		Advertiser advertiser = new Advertiser(1l,"vinay","vinay r","100");
		Optional<Advertiser> of = Optional.of(advertiser);
		Mockito.<Optional<Advertiser>>when(studentService.findById(Mockito.any())).thenReturn(of);
		RequestBuilder requestBuilder = MockMvcRequestBuilders.get("/advertiser/getAdvertiser/1")
				.accept(MediaType.APPLICATION_JSON);

		MvcResult result = mockMvc.perform(requestBuilder).andReturn();

		System.out.println(result.getResponse().getContentAsString());
		String expected = "{\"id\":1,\"advertiserName\":\"vinay\",\"advertiserContactName\":\"vinay r\",\"advertiserCreditLimit\":\"100\"}";

		JSONAssert.assertEquals(expected, result.getResponse().getContentAsString(), false);
	}

}
