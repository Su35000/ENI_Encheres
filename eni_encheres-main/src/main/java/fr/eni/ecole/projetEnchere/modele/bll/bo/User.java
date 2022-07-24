package fr.eni.ecole.projetEnchere.modele.bll.bo;

public class User {
	private Integer id;
	private String username;
	private String name;
	private String firstName;
	private String email;
	private String phoneNumber;
	private String street;
	private String postalCode;
	private String city;
	private String password;
	private Integer credit;
	private Boolean admin;

	public User() {
		this.id = 0; // id 0 est impossible en sql = utilisateur vide
	}

	public User(String username, String name, String firstName, String email, String phoneNumber, String street,
			String postalCode, String city, String password) {
		super();
		this.username = username;
		this.name = name;
		this.firstName = firstName;
		this.email = email;
		this.phoneNumber = phoneNumber;
		this.street = street;
		this.postalCode = postalCode;
		this.city = city;
		this.password = password;
		this.credit = 100;
		this.admin = false;
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getFirstName() {
		return firstName;
	}

	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getPhoneNumber() {
		return phoneNumber;
	}

	public void setPhoneNumber(String phoneNumber) {
		this.phoneNumber = phoneNumber;
	}

	public String getStreet() {
		return street;
	}

	public void setStreet(String street) {
		this.street = street;
	}

	public String getPostalCode() {
		return postalCode;
	}

	public void setPostalCode(String postalCode) {
		this.postalCode = postalCode;
	}

	public String getCity() {
		return city;
	}

	public void setCity(String city) {
		this.city = city;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public Integer getCredit() {
		return credit;
	}

	public void setCredit(Integer credit) {
		this.credit = credit;
	}

	public Boolean getAdmin() {
		return admin;
	}

	public void setAdmin(Boolean admin) {
		this.admin = admin;
	}

	@Override
	public String toString() {
		return "User [id=" + id + ", username=" + username + ", name=" + name + ", firstName=" + firstName + ", email="
				+ email + ", phoneNumber=" + phoneNumber + ", street=" + street + ", postalCode=" + postalCode
				+ ", city=" + city + ", password=" + password + ", credit=" + credit + ", admin=" + admin + "]";
	}

}
