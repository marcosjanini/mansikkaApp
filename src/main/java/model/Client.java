package model;

public class Client {
	private int id;
	private String firstname;
	private String lastname;
	private String phone;
	private String email;
	private String taxId;
	private String streetaddress;
	private String postcode;
	private String city;

	public Client() {
		id = -1;
		firstname = "";
		lastname = "";
		phone = "";
		email = "";
		taxId = "";
		streetaddress = "";
		postcode = "";
		city = "";
	}

	public Client(int id, String firstname, String lastname, String phone, String email, String taxId,
			String streetaddress, String postcode, String city) {
		this.id = id;
		this.firstname = firstname;
		this.lastname = lastname;
		this.phone = phone;
		this.email = email;
		this.taxId = taxId;
		this.streetaddress = streetaddress;
		this.postcode = postcode;
		this.city = city;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getFirstname() {
		return firstname;
	}

	public void setFirstname(String firstname) {
		this.firstname = firstname;
	}

	public String getLastname() {
		return lastname;
	}

	public void setLastname(String lastname) {
		this.lastname = lastname;
	}

	public String getPhone() {
		return phone;
	}

	public void setPhone(String phone) {
		this.phone = phone;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getTaxId() {
		return taxId;
	}

	public void setTaxId(String taxId) {
		this.taxId = taxId;
	}

	public String getStreetaddress() {
		return streetaddress;
	}

	public void setStreetaddress(String streetaddress) {
		this.streetaddress = streetaddress;
	}

	public String getPostcode() {
		return postcode;
	}

	public void setPostcode(String postcode) {
		this.postcode = postcode;
	}

	public String getCity() {
		return city;
	}

	public void setCity(String city) {
		this.city = city;
	}

	@Override
	public String toString() {
		return id + ": " + firstname + " " + lastname + ", Phone: " + phone + " Email" + email;
	}

}
