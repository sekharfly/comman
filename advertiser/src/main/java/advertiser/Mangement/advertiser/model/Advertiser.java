package advertiser.Mangement.advertiser.model;

import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

@Entity(name = "advertiser")

public class Advertiser {

	@Id
	@GeneratedValue
	private long id;

	private String advertiserName;

	private String advertiserContactName;

	private String advertiserCreditLimit;

	private Date date;

	private String image_url;

	private String tags;

	private String posted_at;

	

	public Advertiser(long id, String advertiserName, String advertiserContactName, String advertiserCreditLimit,
			Date date) {
		super();
		this.id = id;
		this.advertiserName = advertiserName;
		this.advertiserContactName = advertiserContactName;
		this.advertiserCreditLimit = advertiserCreditLimit;
		this.date = date;
	}

	public Advertiser() {
		// TODO Auto-generated constructor stub
	}

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public String getAdvertiserName() {
		return advertiserName;
	}

	public void setAdvertiserName(String advertiserName) {
		this.advertiserName = advertiserName;
	}

	public String getAdvertiserContactName() {
		return advertiserContactName;
	}

	public void setAdvertiserContactName(String advertiserContactName) {
		this.advertiserContactName = advertiserContactName;
	}

	public String getAdvertiserCreditLimit() {
		return advertiserCreditLimit;
	}

	public void setAdvertiserCreditLimit(String advertiserCreditLimit) {
		this.advertiserCreditLimit = advertiserCreditLimit;
	}

	public Date getDate() {
		return date;
	}

	public void setDate(Date date) {
		this.date = date;
	}

	public String getImage_url() {
		return image_url;
	}

	public void setImage_url(String image_url) {
		this.image_url = image_url;
	}

	public String getTags() {
		return tags;
	}

	public void setTags(String tags) {
		this.tags = tags;
	}

	public String getPosted_at() {
		return posted_at;
	}

	public void setPosted_at(String posted_at) {
		this.posted_at = posted_at;
	}

}
