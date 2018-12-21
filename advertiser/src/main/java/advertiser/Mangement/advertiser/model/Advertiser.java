package advertiser.Mangement.advertiser.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

@Entity(name="advertiser")

public class Advertiser {
	
	@Id
	@GeneratedValue
	private long id;
	
	private String advertiserName;

	private String advertiserContactName; 
	
	private String advertiserCreditLimit;
	
	public Advertiser(long id, String advertiserName, String advertiserContactName, String advertiserCreditLimit) {
		super();
		this.id = id;
		this.advertiserName = advertiserName;
		this.advertiserContactName = advertiserContactName;
		this.advertiserCreditLimit = advertiserCreditLimit;
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
	
	
}
