package edu.univdhaka.iit.echo.dao;

import java.util.List;

import edu.univdhaka.iit.echo.domain.Echo;

public interface EchoDao {
	
	public void insertEcho(Echo echo);
	
	public List<Echo> getAllEcho();
	
	public void deleteEcho(String text);

	public void updateEcho(Echo echo, String text);

	public Echo selectEcho(String text);

}
