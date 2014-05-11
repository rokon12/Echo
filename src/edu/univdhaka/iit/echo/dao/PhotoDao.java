package edu.univdhaka.iit.echo.dao;

import java.util.List;

import edu.univdhaka.iit.echo.domain.Photo;

public interface PhotoDao {
	
	public void insert(Photo photo);

	public List<Photo> getAllPhotoInfo();

	public void delete(int id);

	public void update(Photo photo, int id);

	public Photo select(int id);
	
}
