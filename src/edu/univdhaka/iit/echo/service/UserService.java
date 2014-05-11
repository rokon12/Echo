package edu.univdhaka.iit.echo.service;

import java.util.List;

import edu.univdhaka.iit.echo.domain.UserAccount;

public interface UserService {
	
	  public boolean createNewUser(UserAccount user);
	  
	  public List<UserAccount> findAllUser();
}
