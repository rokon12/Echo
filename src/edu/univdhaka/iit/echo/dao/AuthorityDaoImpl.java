package edu.univdhaka.iit.echo.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import edu.univdhaka.iit.echo.domain.Authority;

public class AuthorityDaoImpl implements AuthorityDao{

	DatabaseConnector db = new DatabaseConnector();
	Connection connection = db.openConnection();
	
	@Override
	public void insert(Authority authority) {
		try {
			String query = "INSERT INTO authority (version, name)" 
					 + "VALUES(?, ?)";

			PreparedStatement preparedStatement = null;
			try {
				preparedStatement = connection.prepareStatement(query);
				
				preparedStatement.setInt(1, authority.getVersion());
				preparedStatement.setString(2, authority.getName());
				
				preparedStatement.execute();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		} catch (Exception e) {
		
		} finally {
			db.closeConnection();
		}	
	}

	@Override
	public List<Authority> getAllAuthorityInfo() {
		String query = "SELECT * FROM authority";
		List<Authority> list = new ArrayList<Authority>();
		try {
			try {
				Statement statement = connection.createStatement();
				ResultSet rs = statement.executeQuery(query);
				while (rs.next()) {
					Authority authority = new Authority();
					
					authority.setId(rs.getInt("id"));
					authority.setVersion(rs.getInt("version"));
					authority.setName(rs.getString("name"));
			
					list.add(authority);
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
			String query = "DELETE FROM authority WHERE id  = ?";
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
	public void update(Authority authority, int id) {
		try{
			String query = "UPDATE authority SET version = ?, name = ? WHERE id = ?";
			PreparedStatement preparedStatement = null;
			try {
				preparedStatement = connection.prepareStatement(query);
				
				preparedStatement.setInt(1, authority.getVersion());
				preparedStatement.setString(2, authority.getName());
				preparedStatement.setInt(3, id);
				
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
	public Authority select(int id) {
		Authority authority = new Authority();
		try{
			String query = "SELECT * FROM authority WHERE id  = ?";
			PreparedStatement preparedStatement = null;
			try {
				preparedStatement = connection.prepareStatement(query);
				preparedStatement.setInt(1, id);
				ResultSet rs = preparedStatement.executeQuery();
				boolean flag = false;
				while (rs.next()) {
					flag = true;
					
					authority.setId(rs.getInt("id"));
					authority.setVersion(rs.getInt("version"));
					authority.setName(rs.getString("name"));
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
		return authority;
	}
}
