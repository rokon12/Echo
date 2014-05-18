package edu.univdhaka.iit.echo.dao;

import java.util.List;

import edu.univdhaka.iit.echo.domain.UserAccount;

public interface UserDao {

    public void createNewUser(UserAccount user);

    public void deleteUser(int id);

    public UserAccount findByEmail(String emailAdress);

    public UserAccount findByUserName(String userName);

    public List<UserAccount> getAllUserInfo();

    public void updateUser(UserAccount user, int id);

}
