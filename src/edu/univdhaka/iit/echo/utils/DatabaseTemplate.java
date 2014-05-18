package edu.univdhaka.iit.echo.utils;

import java.sql.Blob;
import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class DatabaseTemplate {

    private static final Logger log = LoggerFactory
	    .getLogger(DatabaseTemplate.class);

    public static void execute(String query) {
	log.debug("execute() query ={}", query);
	Connection conToUse = null;
	Statement stmt = null;
	try {
	    conToUse = DatabaseConnectionPool.getConnection();
	    conToUse.setAutoCommit(false);
	    stmt = conToUse.createStatement();
	    stmt.executeQuery(query);
	} catch (SQLException e) {
	    if (conToUse != null) {
		try {
		    conToUse.rollback();
		} catch (SQLException e1) {
		    e1.printStackTrace();
		}
	    }
	    throw new RuntimeException(e);
	} finally {

	    try {
		stmt.close();
		conToUse.setAutoCommit(false);
	    } catch (SQLException e) {
		releaseConnection(conToUse);
		throw new RuntimeException(e);
	    }
	}
    }

    public static void executeDeleteQuery(String query, int id)
	    throws SQLException {
	log.debug("executeDeleteQuery() query ={}, id ={}", query, id);

	Connection conToUse = null;
	PreparedStatement preparedStatement = null;
	try {
	    conToUse = DatabaseConnectionPool.getConnection();
	    conToUse.setAutoCommit(false);
	    preparedStatement = conToUse.prepareStatement(query);
	    preparedStatement.setInt(1, id);

	    log.debug("Executing prepared SQL statement [{}]",
		    preparedStatement.toString());
	    preparedStatement.executeUpdate();
	    int rows = preparedStatement.executeUpdate();
	    log.debug("SQL update affected " + rows + " rows");
	} catch (SQLException e) {
	    conToUse.rollback();
	    throw new RuntimeException(e);
	} finally {

	    try {
		preparedStatement.close();
		conToUse.setAutoCommit(true);
	    } catch (SQLException e) {
		releaseConnection(conToUse);
		throw new RuntimeException(e);
	    }
	}
    }

    public static void executeInsertQuery(String query, Object... parameters)
	    throws SQLException {
	log.debug("executeInsertQuery() query ={} parameters ={}", query,
		Arrays.toString(parameters));
	Connection conToUse = null;
	PreparedStatement preparedStatement = null;
	try {
	    conToUse = DatabaseConnectionPool.getConnection();
	    conToUse.setAutoCommit(false);
	    preparedStatement = conToUse.prepareStatement(query);

	    int i = 1;
	    for (Object parameter : parameters) {
		if (parameter instanceof String) {
		    preparedStatement.setString(i, (String) parameter);
		} else if (parameter instanceof Integer) {
		    preparedStatement.setInt(i, (Integer) parameter);
		} else if (parameter instanceof Long) {
		    preparedStatement.setLong(i, (Long) parameter);
		} else if (parameter instanceof Float) {
		    preparedStatement.setFloat(i, (Float) parameter);
		} else if (parameter instanceof Double) {
		    preparedStatement.setDouble(i, (Double) parameter);
		} else if (parameter instanceof Date) {
		    preparedStatement.setDate(i, (Date) parameter);
		} else if (parameter instanceof Blob) {
		    preparedStatement.setBlob(i, (Blob) parameter);
		}
		i++;
	    }

	    log.debug("Executing prepared SQL statement [{}]",
		    preparedStatement.toString());
	    preparedStatement.executeUpdate();
	    int rows = preparedStatement.executeUpdate();
	    log.debug("SQL update affected " + rows + " rows");

	} catch (SQLException e) {
	    conToUse.rollback();
	    throw new RuntimeException(e);
	} finally {

	    try {
		preparedStatement.close();
		conToUse.setAutoCommit(true);
	    } catch (SQLException e) {
		releaseConnection(conToUse);
		throw new RuntimeException(e);
	    }
	}
    }

    public static void executeUpdateQuery(String query, Object... parameters)
	    throws SQLException {
	log.debug("executeUpdateQuery() query ={} parameters ={}", query,
		Arrays.toString(parameters));

	Connection conToUse = null;
	PreparedStatement preparedStatement = null;
	try {
	    conToUse = DatabaseConnectionPool.getConnection();
	    conToUse.setAutoCommit(false);
	    preparedStatement = conToUse.prepareStatement(query);

	    int i = 1;
	    for (Object parameter : parameters) {
		if (parameter instanceof String) {
		    preparedStatement.setString(i, (String) parameter);
		} else if (parameter instanceof Integer) {
		    preparedStatement.setInt(i, (Integer) parameter);
		} else if (parameter instanceof Long) {
		    preparedStatement.setLong(i, (Long) parameter);
		} else if (parameter instanceof Float) {
		    preparedStatement.setFloat(i, (Float) parameter);
		} else if (parameter instanceof Double) {
		    preparedStatement.setDouble(i, (Double) parameter);
		} else if (parameter instanceof Date) {
		    preparedStatement.setDate(i, (Date) parameter);
		} else if (parameter instanceof Blob) {
		    preparedStatement.setBlob(i, (Blob) parameter);
		}
		i++;
	    }

	    log.debug("Executing prepared SQL statement [ {} ]",
		    preparedStatement.toString());
	    int rows = preparedStatement.executeUpdate();
	    log.debug("SQL update affected " + rows + " rows");

	} catch (SQLException e) {
	    log.error(
		    "unable to execute update operation, so rollback initiated",
		    e);
	    conToUse.rollback();
	    throw new RuntimeException(e);
	} finally {

	    try {
		preparedStatement.close();
		conToUse.setAutoCommit(true);
	    } catch (SQLException e) {
		releaseConnection(conToUse);
		throw new RuntimeException(e);
	    }
	}
    }

    public static <E> List<E> queryForObject(String query,
	    ObjectRowMapper<E> objectRowMapper) {
	Connection conToUse = null;
	Statement stmt = null;
	ResultSet resultSet = null;
	List<E> listOfE = new ArrayList<E>();
	try {
	    conToUse = DatabaseConnectionPool.getConnection();
	    stmt = conToUse.createStatement();
	    resultSet = stmt.executeQuery(query);
	    while (resultSet.next()) {
		listOfE.add(objectRowMapper.mapRowToObject(resultSet));
	    }
	} catch (SQLException e) {
	    throw new RuntimeException(e);
	} finally {

	    try {
		resultSet.close();
		stmt.close();
	    } catch (SQLException e) {
		releaseConnection(conToUse);
		throw new RuntimeException(e);
	    }

	}
	return listOfE;
    }

    private static void releaseConnection(Connection conToClose) {
	try {
	    conToClose.close();
	} catch (SQLException e) {
	    log.error("Could not close JDBC Connection", e);
	}
    }
}
