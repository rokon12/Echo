package edu.univdhaka.iit.echo.dao;

import java.util.List;

import edu.univdhaka.iit.echo.domain.UserAccount;

public interface UserDao {

	public void insertUser(UserAccount user);

	public List<UserAccount> getAllUserInfo();

	public void deleteUser(String userName);

	public void updateUser(UserAccount user, int id);

	public UserAccount findByUserName(String userName);

	public UserAccount findByEmail(String emailAdress);


}
