package edu.univdhaka.iit.echo.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import edu.univdhaka.iit.echo.domain.IssueCategory;

public class IssueCategoryDaoImpl implements IssueCategoryDao {
	
	DatabaseConnector db = new DatabaseConnector();
	Connection connection = db.openConnection();
	
	@Override
	public void insert(IssueCategory category) {
		try {
			String query = "INSERT INTO issue_category (version, createdDate, lastModifiedDate, isNew, title)" 
					 + "VALUES(?, ?, ?, ?, ?)";

			PreparedStatement preparedStatement = null;
			try {
				preparedStatement = connection.prepareStatement(query);
				
				preparedStatement.setInt(1, category.getVersion());
				preparedStatement.setDate(2, category.getCreatedDate());
				preparedStatement.setDate(3, category.getLastModifiedDate());
				preparedStatement.setBoolean(4, category.isNew());
				preparedStatement.setString(5, category.getTitle());
				
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
	public List<IssueCategory> getAllIssueCategoryInfo() {
		String query = "SELECT * FROM issue_category";
		List<IssueCategory> list = new ArrayList<IssueCategory>();
		try {
			try {
				Statement statement = connection.createStatement();
				ResultSet rs = statement.executeQuery(query);
				while (rs.next()) {
					IssueCategory category = new IssueCategory();
					
					category.setId(rs.getInt("id"));
					category.setVersion(rs.getInt("version"));
					category.setCreatedDate(rs.getDate("createdDate"));
					category.setLastModifiedDate(rs.getDate("lastModifiedDate"));
					category.setNew(rs.getBoolean("isNew"));
					category.setTitle(rs.getString("title"));
			
					list.add(category);
				}
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}catch (Exception e) {
			
		}finally{
			db.closeConnection();
		}
		return list;
	}

	@Override
	public void delete(int id) {
		try {
			String query = "DELETE FROM issue_category WHERE id = ?";
			PreparedStatement preparedStatement = null;
			try {
				preparedStatement = connection.prepareStatement(query);
				preparedStatement.setInt(1, id);
				preparedStatement.execute();
			} catch (Exception e) {
				e.printStackTrace();
			}
		}catch(Exception e) {
			
		}finally{
			db.closeConnection();
		}	
	}

	@Override
	public void update(IssueCategory category, int id) {
		try{
			String query = "UPDATE issue_category SET version = ?, "
							 +	"createdDate = ?, lastModifiedDate = ?, "
							 + "isNew = ?, title =  ? WHERE id = ?";
			PreparedStatement preparedStatement = null;
			try {
				preparedStatement = connection.prepareStatement(query);
				
				preparedStatement.setInt(1, category.getVersion());
				preparedStatement.setDate(2, category.getCreatedDate());
				preparedStatement.setDate(3, category.getLastModifiedDate());
				preparedStatement.setBoolean(4, category.isNew());
				preparedStatement.setString(5, category.getTitle());
				preparedStatement.setInt(6, id);
				
				
				preparedStatement.executeUpdate();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		} catch(Exception e){
			
		}finally{
			db.closeConnection();
		}
		
	}

	@Override
	public IssueCategory select(int id) {
		IssueCategory category = new IssueCategory();
		try{
			String query = "SELECT * FROM issue_category WHERE id = ?";
			PreparedStatement preparedStatement = null;
			try {
				preparedStatement = connection.prepareStatement(query);
				preparedStatement.setInt(1, id);
				ResultSet rs = preparedStatement.executeQuery();
				boolean flag = false;
				while (rs.next()) {
					flag = true;
					
					category.setId(rs.getInt("id"));
					category.setVersion(rs.getInt("version"));
					category.setCreatedDate(rs.getDate("createdDate"));
					category.setLastModifiedDate(rs.getDate("lastModifiedDate"));
					category.setNew(rs.getBoolean("isNew"));
					category.setTitle(rs.getString("title"));
				}
				if (!flag)
					return null;
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}catch (Exception e) {
			
		}finally {
			db.closeConnection();
		}
		return category;
	}

}
