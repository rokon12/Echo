package edu.univdhaka.iit.echo.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

import edu.univdhaka.iit.echo.domain.Photo;

public class PhotoDaoImpl implements PhotoDao {

    DatabaseConnector db = new DatabaseConnector();
    Connection connection = db.openConnection();

    @Override
    public void delete(int id) {
	try {
	    String query = "DELETE FROM photo WHERE id = ?";
	    PreparedStatement preparedStatement = null;
	    try {
		preparedStatement = connection.prepareStatement(query);
		preparedStatement.setInt(1, id);
		preparedStatement.execute();
	    } catch (Exception e) {
		e.printStackTrace();
	    }
	} catch (Exception e) {

	} finally {
	    db.closeConnection();
	}

    }

    @Override
    public List<Photo> getAllPhotoInfo() {
	return null;
    }

    @Override
    public void insert(Photo photo) {
	try {
	    String query = "INSERT INTO photo (version, thumbnail, original, contentType)"
		    + "VALUES(?, ?, ?, ?)";

	    PreparedStatement preparedStatement = null;
	    try {
		preparedStatement = connection.prepareStatement(query);

		preparedStatement.setInt(1, photo.getVersion());
		preparedStatement.setBlob(2, photo.getThumbnail());
		preparedStatement.setBlob(3, photo.getOriginal());
		preparedStatement.setString(4, photo.getContentType());

		preparedStatement.execute();
	    } catch (Exception e) {
		e.printStackTrace();
	    }
	} catch (Exception e) {

	} finally {
	    db.closeConnection();
	}
    }

    @Override
    public Photo select(int id) {
	Photo photo = new Photo();
	try {
	    String query = "SELECT * FROM photo WHERE id = ?";
	    PreparedStatement preparedStatement = null;
	    try {
		preparedStatement = connection.prepareStatement(query);
		preparedStatement.setInt(1, id);
		ResultSet rs = preparedStatement.executeQuery();
		boolean flag = false;
		while (rs.next()) {
		    flag = true;
		    photo.setId(rs.getInt("id"));
		    photo.setVersion(rs.getInt("version"));
		    photo.setThumbnail(rs.getBlob("thumbnail"));
		    photo.setOriginal(rs.getBlob("original"));
		    photo.setContentType(rs.getString("contentType"));
		}
		if (!flag) {
		    return null;
		}
	    } catch (SQLException e) {
		e.printStackTrace();
	    }
	} catch (Exception e) {

	} finally {
	    db.closeConnection();
	}
	return photo;
    }

    @Override
    public void update(Photo photo, int id) {
	try {
	    String query = "UPDATE photo SET version = ?, thumbnail = ?, original = ?, "
		    + "contentType = ? WHERE id = ?";

	    PreparedStatement preparedStatement = null;
	    try {
		preparedStatement = connection.prepareStatement(query);

		preparedStatement.setInt(1, photo.getVersion());
		preparedStatement.setBlob(2, photo.getThumbnail());
		preparedStatement.setBlob(3, photo.getOriginal());
		preparedStatement.setString(4, photo.getContentType());

		preparedStatement.executeUpdate();

	    } catch (SQLException e) {
		e.printStackTrace();
	    }
	} catch (Exception e) {

	} finally {
	    db.closeConnection();
	}

    }
}
