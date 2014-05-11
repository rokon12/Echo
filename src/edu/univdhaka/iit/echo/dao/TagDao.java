package edu.univdhaka.iit.echo.dao;

import java.util.List;

import edu.univdhaka.iit.echo.domain.Tag;

public interface TagDao {
	
	public void insert(Tag tag);

	public List<Tag> getAllTagInfo();

	public void delete(int id);

	public void update(Tag tag, int id);

	public Tag select(int id);
}