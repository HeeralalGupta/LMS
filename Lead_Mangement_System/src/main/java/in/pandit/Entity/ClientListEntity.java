package in.pandit.Entity;

import java.io.Serializable;
import java.util.Date;

public class ClientListEntity implements Serializable{
	private static final long serialVersionUID = 1L;
	 
	private String id;
	private String firstname;
	private String lastname;
	private String gender;
	private String dob;
	private String contact;
	private String email;
	private String address;
	 
	public ClientListEntity() {
		super();
	}

	public ClientListEntity(String id, String firstname, String lastname, String gender, String dob, String contact,
			String email, String address) {
		super();
		this.id = id;
		this.firstname = firstname;
		this.lastname = lastname;
		this.gender = gender;
		this.dob = dob;
		this.contact = contact;
		this.email = email;
		this.address = address;
	}

	public String getId() {
		return id;
	}

	public void setId(String id) {
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

	public String getGender() {
		return gender;
	}

	public void setGender(String gender) {
		this.gender = gender;
	}

	public String getDob() {
		return dob;
	}

	public void setDob(String dob) {
		this.dob = dob;
	}

	public String getContact() {
		return contact;
	}

	public void setContact(String contact) {
		this.contact = contact;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}
	 
	
}
