package advertiser.Mangement.advertiser.Controller;

import java.sql.Timestamp;

import org.springframework.web.bind.annotation.RestController;

@RestController
public class MetaDataController {

	Timestamp timestamps = new Timestamp(System.currentTimeMillis());

	public void me() {
		System.out.println(timestamps.getTime());
	}
}
