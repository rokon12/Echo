package edu.univdhaka.iit.echo.domain;

import java.util.List;
import java.util.Set;

public class UserAccount {
	private int id;
	private int version;

	private String firstName;
	private String lastName;
	private String gender;
	private String emailAddress;
	private String userName;
	private String password;
	private List<Echo> allEchos;

	private Set<Authority> authorities;
	private boolean accountNonExpired;
	private boolean accountNonLocked;
	private boolean enabled;
	private boolean credentialsNonExpired;

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

	public String getGender() {
		return gender;
	}

	public void setGender(String gender) {
		this.gender = gender;
	}

	public String getEmailAddress() {
		return emailAddress;
	}

	public void setEmailAddress(String emailAddress) {
		this.emailAddress = emailAddress;
	}

	public String getUserName() {
		return userName;
	}

	public void setUserName(String userName) {
		this.userName = userName;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public List<Echo> getAllEchos() {
		return allEchos;
	}

	public void setAllEchos(List<Echo> allEchos) {
		this.allEchos = allEchos;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public int getVersion() {
		return version;
	}

	public void setVersion(int version) {
		this.version = version;
	}

	public Set<Authority> getAuthorities() {
		return authorities;
	}

	public void setAuthorities(Set<Authority> authorities) {
		this.authorities = authorities;
	}

	public boolean isAccountNonExpired() {
		return accountNonExpired;
	}

	public void setAccountNonExpired(boolean accountNonExpired) {
		this.accountNonExpired = accountNonExpired;
	}

	public boolean isAccountNonLocked() {
		return accountNonLocked;
	}

	public void setAccountNonLocked(boolean accountNonLocked) {
		this.accountNonLocked = accountNonLocked;
	}

	public boolean isEnabled() {
		return enabled;
	}

	public void setEnabled(boolean enabled) {
		this.enabled = enabled;
	}

	public boolean isCredentialsNonExpired() {
		return credentialsNonExpired;
	}

	public void setCredentialsNonExpired(boolean credentialsNonExpired) {
		this.credentialsNonExpired = credentialsNonExpired;
	}

	public String getFullName() {
		return firstName + " " + lastName;
	}

	@Override
	public String toString() {
		return "User{" + "id=" + id + ", firstName='" + firstName + '\''
				+ ", lastName='" + lastName + '\'' + ", emailAddress='"
				+ emailAddress + '\'' + ", gender='" + gender + '\''
				+ ", userName='" + userName + '\'' + ", password='" + password
				+ '\'' + '}';
	}

	@Override
	public boolean equals(Object o) {
		if (this == o)
			return true;
		if (o == null || getClass() != o.getClass())
			return false;

		UserAccount user = (UserAccount) o;

		if (id != user.id)
			return false;
		if (allEchos != null ? !allEchos.equals(user.allEchos)
				: user.allEchos != null)
			return false;
		if (emailAddress != null ? !emailAddress.equals(user.emailAddress)
				: user.emailAddress != null)
			return false;
		if (firstName != null ? !firstName.equals(user.firstName)
				: user.firstName != null)
			return false;
		if (lastName != null ? !lastName.equals(user.lastName)
				: user.lastName != null)
			return false;
		if (gender != null ? !gender.equals(user.gender) : user.gender != null)
			return false;
		if (userName != null ? !userName.equals(user.userName)
				: user.userName != null)
			return false;
		if (password != null ? !password.equals(user.password)
				: user.password != null)
			return false;

		return true;
	}

	@Override
	public int hashCode() {
		int result = id;
		result = 31 * result + (firstName != null ? firstName.hashCode() : 0);
		result = 31 * result + (lastName != null ? lastName.hashCode() : 0);
		result = 31 * result
				+ (emailAddress != null ? emailAddress.hashCode() : 0);
		result = 31 * result + (password != null ? password.hashCode() : 0);
		result = 31 * result + (allEchos != null ? allEchos.hashCode() : 0);
		return result;
	}
}