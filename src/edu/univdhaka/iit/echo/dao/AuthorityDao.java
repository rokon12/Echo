package edu.univdhaka.iit.echo.dao;

import java.util.List;

import edu.univdhaka.iit.echo.domain.Authority;

public interface AuthorityDao {
	
	public void insert(Authority authority);

	public List<Authority> getAllAuthorityInfo();

	public void delete(int id);

	public void update(Authority authority, int id);

	public Authority select(int id);
}