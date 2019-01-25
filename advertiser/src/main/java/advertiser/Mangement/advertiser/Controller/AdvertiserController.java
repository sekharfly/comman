package advertiser.Mangement.advertiser.Controller;

import java.util.Date;
import java.util.Optional;
import java.util.UUID;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.google.gson.Gson;
import com.wordnik.swagger.annotations.Api;

import advertiser.Mangement.advertiser.model.Advertiser;
import advertiser.Mangement.advertiser.model.MetaData;
import advertiser.Mangement.advertiser.repo.AdvertiserRepo;

@RestController
@Api(value = "/advertiser", description = "Customer Profile", produces = "application/json")
@RequestMapping("/advertiser")
public class AdvertiserController {

	@Autowired
	public AdvertiserRepo repo;

	@Autowired
	Gson gson;

	@RequestMapping(value = "/newAdvertiser", method = RequestMethod.POST, produces = MediaType.APPLICATION_JSON_VALUE)
	public Advertiser newAdvertiser(@RequestBody Advertiser json) {
		json.setDate(new Date());
		Advertiser save = repo.save(json);
		System.out.println(save);
		return save;
	}

	@RequestMapping(value = "/iftt/actions/newAdvertiser", method = RequestMethod.POST, produces = MediaType.APPLICATION_JSON_VALUE)
	public Advertiser newAdvertisers(@RequestBody Advertiser json) {
		Advertiser save = repo.save(json);
		System.out.println(save);
		return save;
	}

	@RequestMapping(value = "/updateAdvertiser/{id}", method = RequestMethod.PUT, produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<Advertiser> updateAdvertiser(@RequestBody Advertiser json, @PathVariable("id") long id) {

		Optional<Advertiser> findById = repo.findById(id);
		if (findById.isPresent()) {
			Advertiser advertiser = findById.get();
			advertiser.setAdvertiserName(json.getAdvertiserName());
			advertiser.setAdvertiserContactName(json.getAdvertiserContactName());
			advertiser.setAdvertiserCreditLimit(json.getAdvertiserCreditLimit());
			Advertiser save = repo.save(advertiser);
			return new ResponseEntity<Advertiser>(save, HttpStatus.OK);
		}
		return new ResponseEntity<Advertiser>(HttpStatus.NOT_FOUND);
	}

	@RequestMapping(value = "/deleteAdvertiser/{id}", method = RequestMethod.DELETE, produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<Advertiser> deleteAdvertiser(@PathVariable("id") long id) {
		Optional<Advertiser> findById = repo.findById(id);
		if (findById.isPresent()) {
			repo.deleteById(id);
			return new ResponseEntity<Advertiser>(HttpStatus.OK);
		}
		return new ResponseEntity<Advertiser>(HttpStatus.NOT_FOUND);
	}

	@RequestMapping(value = "/getAdvertiser/{id}", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<String> getAdvertiser(@PathVariable("id") long id) {
		Optional<Advertiser> findById = repo.findById(id);
		if (findById.isPresent()) {
			return new ResponseEntity<String>(gson.toJson(findById.get()), HttpStatus.OK);
		}
		return new ResponseEntity<String>(HttpStatus.NOT_FOUND);
	}

	@RequestMapping(value = "/enoughCreditAdvertiser/{id}", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<Advertiser> enoughCreditAdvertiser(@PathVariable("id") long id) {
		Optional<Advertiser> findById = repo.findById(id);
		if (findById.isPresent()) {
			Advertiser advertiser = findById.get();
			String advertiserCreditLimit = advertiser.getAdvertiserCreditLimit();
			if (advertiserCreditLimit.equals("0")) {
				return new ResponseEntity<Advertiser>(HttpStatus.NOT_ACCEPTABLE);
			} else {
				return new ResponseEntity<Advertiser>(findById.get(), HttpStatus.OK);
			}
		}
		return new ResponseEntity<Advertiser>(HttpStatus.NOT_FOUND);
	}

	@RequestMapping(value = "/ifttt/v1/triggers/postAdvertiser", method = RequestMethod.POST, produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<String> getAllAdvertiser(@RequestBody String json,
			@RequestHeader("IFTTT-Service-Key") String IFTTTServiceKey) throws JSONException {

		JSONObject jsonObject = new JSONObject(json);

		String response = "{\"data\":[{\"image_url\":\"http://example.com/images/128\",\"tags\":\"banksy, brooklyn\",\"posted_at\":\"2013-11-04T09:23:00-07:00\",\"meta\":{\"id\":\"14b9-1fd2-acaa-5df5\",\"timestamp\":1383597288}},{\"image_url\":\"http://example.com/images/128\",\"tags\":\"banksy, brooklyn\",\"posted_at\":\"2013-11-04T09:23:00-07:00\",\"meta\":{\"id\":\"14b9-1fd2-acaa-5df5\",\"timestamp\":1383597277}},{\"image_url\":\"http://example.com/images/128\",\"tags\":\"banksy, brooklyn\",\"posted_at\":\"2013-11-04T09:23:00-07:00\",\"meta\":{\"id\":\"14b9-1fd2-acaa-5df5\",\"timestamp\":1383597267}},{\"image_url\":\"http://example.com/images/125\",\"tags\":\"banksy, nyc\",\"posted_at\":\"2013-11-04T03:23:00-07:00\",\"meta\":{\"id\":\"ffb27-a63e-18e0-18ad\",\"timestamp\":1383596355}},{\"image_url\":\"http://example.com/images/125\",\"tags\":\"banksy, nyc\",\"posted_at\":\"2013-11-04T03:23:00-07:00\",\"meta\":{\"id\":\"ffb27-a63e-18e0-18cr\",\"timestamp\":13835944}},{\"image_url\":\"http://example.com/images/128\",\"tags\":\"banksy, brooklyn\",\"posted_at\":\"2013-11-04T09:23:00-07:00\",\"meta\":{\"id\":\"14b9-1fd2-acaa-5df5\",\"timestamp\":1383597233}},]}";
		String error = "{\"errors\":[{\"message\":\"Something went wrong!\"}]}";

		if (jsonObject.has("limit")) {
			String limit = jsonObject.getString("limit");
			if (limit.equals("1")) {
				response = "{\"data\":[{\"image_url\":\"http://example.com/images/128\",\"tags\":\"banksy, brooklyn\",\"posted_at\":\"2013-11-04T09:23:00-07:00\",\"meta\":{\"id\":\"14b9-1fd2-acaa-5df5\",\"timestamp\":1383597267}}]}";
			} else if (limit.equals("0")) {
				response = "{\"data\":[]}";
			}
		}

		if (IFTTTServiceKey.equals("INVALID")) {
			return new ResponseEntity<String>(error, HttpStatus.UNAUTHORIZED);
		} else {
			return new ResponseEntity<String>(response, HttpStatus.OK);
		}
	}

	@RequestMapping(value = "/ifttt/v1/test/setup", method = RequestMethod.POST, produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<String> getAllAdvertiserstatus(@RequestHeader("IFTTT-Service-Key") String IFTTTServiceKey) {
		System.out.println("success");
		String json = "{\"data\": {}}";
		if (IFTTTServiceKey.equals("INVALID")) {
			return new ResponseEntity<String>("success", HttpStatus.UNAUTHORIZED);
		} else {
			return new ResponseEntity<String>(json, HttpStatus.OK);
		}

	}

	@RequestMapping(value = "/ifttt/v1/status", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<String> getAllAdvertisersetup(@RequestHeader("IFTTT-Service-Key") String IFTTTServiceKey) {
		System.out.println("success");
		if (IFTTTServiceKey.equals("INVALID")) {
			return new ResponseEntity<String>("success", HttpStatus.UNAUTHORIZED);
		} else {

			return new ResponseEntity<String>("success", HttpStatus.OK);
		}
	}

	@RequestMapping(value = "/ifttt/v1/triggers/getAdvertisers", method = RequestMethod.POST, produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<String> getAllAdvertisers(@RequestBody String json,
			@RequestHeader("IFTTT-Service-Key") String IFTTTServiceKey) throws JSONException {

		String error = "{\"errors\":[{\"message\":\"Something went wrong!\"}]}";
		String limit0 = "{\"data\":[]}";
		String limit1 = "{\"data\":[{\"id\":1,\"advertiserName\":\"sekhar\",\"advertiserContactName\":\"sekhar\",\"advertiserCreditLimit\":\"12345\",\"date\":\"2018-12-26T09:53:17.403+0000\"}]}";

		Iterable<Advertiser> findAll = repo.findAll();
		JSONArray jsonArray = new JSONArray();
		for (Advertiser advertiser : findAll) {
			JSONObject jsonObject = new JSONObject(gson.toJson(advertiser));
			MetaData metaData = new MetaData();
			metaData.setId(UUID.randomUUID().toString());
			Date date = new Date();
			metaData.setTimestamp(date.getSeconds());
			jsonObject.put("meta", new JSONObject(gson.toJson(metaData)));
			jsonArray.put(jsonObject);
		}

		JSONObject jsonObject = new JSONObject();
		jsonObject.put("data", jsonArray);

		JSONObject jsonbody = new JSONObject(json);

		if (jsonbody.has("limit")) {
			String limit = jsonbody.getString("limit");
			if (limit.equals("1")) {
				jsonObject = new JSONObject(limit1);
			} else if (limit.equals("0")) {
				jsonObject = new JSONObject(limit0);
			}
		}

		if (IFTTTServiceKey.equals("INVALID")) {
			return new ResponseEntity<String>(error, HttpStatus.UNAUTHORIZED);
		} else {
			return new ResponseEntity<String>(jsonObject.toString(), HttpStatus.OK);
		}
	}

	@RequestMapping(value = "/exportCSV", method = RequestMethod.GET)
	public String exportCSV() {
		Iterable<Advertiser> findAll = repo.findAll();
		return null;

	}

}
