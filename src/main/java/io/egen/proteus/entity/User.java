package io.egen.proteus.entity;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

/**A class representing a user.
 * @author Pravin Umamaheswaran
 */
@Entity
@Table
public class User {
	
	private String firstName;
	
	private String lastName;
	
	@Id
	private String email;
	
	private String password;
	
	private String salt;
	
	private String role;
					
	public String getFirstName() {
		return firstName;
	}
	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}
	public String getLastName() {
		return lastName;
	}
	public void setLastName(String lastName) {
		this.lastName = lastName;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public String getSalt() {
		return salt;
	}
	public void setSalt(String salt) {
		this.salt = salt;
	}
	public String getRole() {
		return role;
	}
	public void setRole(String role) {
		this.role = role;
	}	
}
