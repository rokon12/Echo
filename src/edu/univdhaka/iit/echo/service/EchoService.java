package edu.univdhaka.iit.echo.service;

import java.util.List;

import edu.univdhaka.iit.echo.domain.Echo;
import edu.univdhaka.iit.echo.domain.UserAccount;

public interface EchoService {
	
	  public boolean postEcho(String postedText, UserAccount postedBy);
	  
	  public List<Echo> findAllEcho(UserAccount user);
}
