package edu.univdhaka.iit.echo.dao;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import edu.univdhaka.iit.echo.domain.UserAccount;
import edu.univdhaka.iit.echo.utils.DatabaseTemplate;
import edu.univdhaka.iit.echo.utils.ObjectRowMapper;

public class UserDaoImpl implements UserDao {

    private static final Logger log = LoggerFactory
	    .getLogger(UserDaoImpl.class);

    @Override
    public void createNewUser(UserAccount user) {
	log.debug("createNewUser() > user ={}", user);

	String query = "INSERT INTO USER (version, firstName, lastName, gender, emailAddress,"
		+ "userName, password, accountNonExpired, accountNonLocked, enabled, credentialsNonExpired)"
		+ "VALUES(?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?)";

	try {
	    DatabaseTemplate.executeInsertQuery(query, user.getVersion(),
		    user.getFirstName(), user.getLastName(), user.getGender(),
		    user.getEmailAddress(), user.getUserName(),
		    user.getPassword(), user.isAccountNonExpired(),
		    user.isAccountNonLocked(), user.isEnabled(),
		    user.isCredentialsNonExpired());
	} catch (SQLException e) {
	    log.error("unable to insert new user", e);
	}
    }

    @Override
    public void deleteUser(int id) {
	log.debug("deleteUser() > id ={}", id);
	try {
	    String query = "DELETE FROM USER WHERE userName = ?";
	    DatabaseTemplate.executeDeleteQuery(query, id);
	} catch (Exception e) {
	    log.error("unable to delete user", e);
	}
    }

    @Override
    public UserAccount findByEmail(String emailAddress) {
	log.debug("findByEmail() > find the User from database using email");

	List<UserAccount> userAccounts = DatabaseTemplate
		.queryForObject("SELECT * FROM USER WHERE emailAddress ='"
			+ emailAddress + "'",
			new ObjectRowMapper<UserAccount>() {

			    @Override
			    public UserAccount mapRowToObject(ResultSet rs)
				    throws SQLException {
				UserAccount user = new UserAccount();

				user.setId(rs.getInt("id"));
				user.setVersion(rs.getInt("version"));
				user.setFirstName(rs.getString("firstName"));
				user.setLastName(rs.getString("lastName"));
				user.setGender(rs.getString("gender"));
				user.setUserName(rs.getString("userName"));
				user.setEmailAddress(rs
					.getString("emailAddress"));
				user.setPassword(rs.getString("password"));
				user.setAccountNonExpired(rs
					.getBoolean("accountNonExpired"));
				user.setAccountNonLocked(rs
					.getBoolean("accountNonLocked"));
				user.setEnabled(rs.getBoolean("enabled"));
				user.setCredentialsNonExpired(rs
					.getBoolean("credentialsNonExpired"));
				return user;
			    }
			});

	return ((userAccounts != null) && (userAccounts.size() > 0)) ? userAccounts
		.get(0) : null;
    }

    @Override
    public UserAccount findByUserName(String userName) {
	log.debug("findByUserName() > find the User from database using userName");

	List<UserAccount> userAccounts = DatabaseTemplate.queryForObject(
		"SELECT * FROM USER WHERE userName ='" + userName + "'",
		new ObjectRowMapper<UserAccount>() {

		    @Override
		    public UserAccount mapRowToObject(ResultSet rs)
			    throws SQLException {
			UserAccount user = new UserAccount();

			user.setId(rs.getInt("id"));
			user.setVersion(rs.getInt("version"));
			user.setFirstName(rs.getString("firstName"));
			user.setLastName(rs.getString("lastName"));
			user.setGender(rs.getString("gender"));
			user.setUserName(rs.getString("userName"));
			user.setEmailAddress(rs.getString("emailAddress"));
			user.setPassword(rs.getString("password"));
			user.setAccountNonExpired(rs
				.getBoolean("accountNonExpired"));
			user.setAccountNonLocked(rs
				.getBoolean("accountNonLocked"));
			user.setEnabled(rs.getBoolean("enabled"));
			user.setCredentialsNonExpired(rs
				.getBoolean("credentialsNonExpired"));
			return user;
		    }
		});

	return ((userAccounts != null) && (userAccounts.size() > 0)) ? userAccounts
		.get(0) : null;
    }

    @Override
    public List<UserAccount> getAllUserInfo() {
	log.debug("getAllUserInfo() > get all Users");

	return DatabaseTemplate.queryForObject("SELECT * FROM USER",
		new ObjectRowMapper<UserAccount>() {

		    @Override
		    public UserAccount mapRowToObject(ResultSet rs)
			    throws SQLException {
			UserAccount user = new UserAccount();
			user.setId(rs.getInt("id"));
			user.setVersion(rs.getInt("version"));
			user.setFirstName(rs.getString("firstName"));
			user.setLastName(rs.getString("lastName"));
			user.setGender(rs.getString("gender"));
			user.setUserName(rs.getString("userName"));
			user.setEmailAddress(rs.getString("emailAddress"));
			user.setPassword(rs.getString("password"));
			user.setAccountNonExpired(rs
				.getBoolean("accountNonExpired"));
			user.setAccountNonLocked(rs
				.getBoolean("accountNonLocked"));
			user.setEnabled(rs.getBoolean("enabled"));
			user.setCredentialsNonExpired(rs
				.getBoolean("credentialsNonExpired"));
			return user;
		    }
		});
    }

    @Override
    public void updateUser(UserAccount user, int id) {
	log.debug("updateUser() > user ={}, id ={}", user, id);

	String query = "UPDATE USER SET version = ?,firstName = ?, lastName = ?,gender = ?, "
		+ "userName = ?, password = ?, emailAddress = ?, accountNonExpired = ?, "
		+ "accountNonLocked = ?, enabled = ?, credentialsNonExpired = ? WHERE id = ?";

	try {
	    DatabaseTemplate.executeUpdateQuery(query, user.getVersion(),
		    user.getFirstName(), user.getLastName(), user.getGender(),
		    user.getEmailAddress(), user.getUserName(),
		    user.getPassword(), user.isAccountNonExpired(),
		    user.isAccountNonLocked(), user.isEnabled(),
		    user.isCredentialsNonExpired(), id);
	} catch (SQLException e) {
	    log.error("unable to insert new user", e);
	}
    }
}
