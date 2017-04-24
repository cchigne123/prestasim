package pe.edu.upc.prestasim.beans;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonInclude.Include;

@JsonInclude(Include.NON_NULL)
public class Entities {

	private int id_entity;
	private String name;
	private String contact_name;
	private String email;
	private String phone_number;

	public Entities(){}

	public Entities(int idEntity){
		this.id_entity = idEntity;
	}

	public int getId_entity() {
		return id_entity;
	}
	public void setId_entity(int idEntity) {
		this.id_entity = idEntity;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getContact_name() {
		return contact_name;
	}
	public void setContact_name(String contactName) {
		this.contact_name = contactName;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getPhone_number() {
		return phone_number;
	}
	public void setPhone_number(String phoneNumber) {
		this.phone_number = phoneNumber;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + id_entity;
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Entities other = (Entities) obj;
		if (id_entity != other.id_entity)
			return false;
		return true;
	}

}
