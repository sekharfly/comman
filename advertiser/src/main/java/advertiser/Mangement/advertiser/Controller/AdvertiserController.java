package advertiser.Mangement.advertiser.Controller;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.wordnik.swagger.annotations.Api;

import advertiser.Mangement.advertiser.model.Advertiser;
import advertiser.Mangement.advertiser.repo.AdvertiserRepo;

@RestController
@Api(value = "/advertiser", description = "Customer Profile", produces = "application/json")
@RequestMapping("/advertiser")
public class AdvertiserController {

	@Autowired
	public AdvertiserRepo repo;

	@RequestMapping(value = "/newAdvertiser", method = RequestMethod.POST, produces = MediaType.APPLICATION_JSON_VALUE)
	public Advertiser newAdvertiser(@RequestBody Advertiser json) {
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
	public ResponseEntity<Advertiser> getAdvertiser(@PathVariable("id") long id) {
		Optional<Advertiser> findById = repo.findById(id);
		if (findById.isPresent()) {
			return new ResponseEntity<Advertiser>(findById.get(), HttpStatus.OK);
		}
		return new ResponseEntity<Advertiser>(HttpStatus.NOT_FOUND);
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
}
