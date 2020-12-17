package bb_management;

import java.sql.*;
import java.util.*;

public class Stores implements User {
	private Connection connect = null;
    private Statement statement = null;
    private PreparedStatement preparedStatement = null;
    private ResultSet resultSet = null;
    Scanner obj = new Scanner(System.in);
    public void add() throws Exception {
		try {
        	Class.forName("org.postgresql.Driver");
        	connect = DriverManager.getConnection("jdbc:postgresql://localhost:5432/BLOODBANKMANAGEMENTSYSTEM", "postgres", "amma1234");
    		preparedStatement = connect.prepareStatement("INSERT INTO STORES VALUES (?, ?)");
    		System.out.println("Enter blood bank no: ");
    		String bno = obj.next();
    		System.out.println("Enter bloodtype: ");
    		String bloodtype = obj.next();
    		preparedStatement.setString(1, bno);
    		preparedStatement.setString(2, bloodtype);
    		preparedStatement.executeUpdate();
        } catch (Exception e) {
            throw e;
        } finally {
            close();
        }
	}
	public void delete(String bno) throws Exception {
		try {
        	Class.forName("org.postgresql.Driver");
        	connect = DriverManager.getConnection("jdbc:postgresql://localhost:5432/BLOODBANKMANAGEMENTSYSTEM", "postgres", "amma1234");
    		preparedStatement = connect.prepareStatement("DELETE FROM STORES WHERE BNO = ?");
    		preparedStatement.setString(1, bno);
    		preparedStatement.executeUpdate();
        } catch (Exception e) {
            throw e;
        } finally {
            close();
        }
	}
	public void edit(String bno) throws Exception {
		try {
			Class.forName("org.postgresql.Driver");
        	connect = DriverManager.getConnection("jdbc:postgresql://localhost:5432/BLOODBANKMANAGEMENTSYSTEM", "postgres", "amma1234");
    		preparedStatement = connect.prepareStatement("UPDATE STORES SET BLOODTYPE = ? WHERE BNO = ?");
    		preparedStatement.setString(2, bno);
    		System.out.println("Enter bloodtype: ");
    		String bloodtype = obj.next();
    		preparedStatement.setString(1, bloodtype);
    		preparedStatement.executeUpdate();
        } catch (Exception e) {
            throw e;
        } finally {
            close();
        }
	}
	public void search(String bno) throws Exception {
		try {
        	Class.forName("org.postgresql.Driver");
        	connect = DriverManager.getConnection("jdbc:postgresql://localhost:5432/BLOODBANKMANAGEMENTSYSTEM", "postgres", "amma1234");
    		preparedStatement = connect.prepareStatement("SELECT * FROM STORES WHERE BNO = ?");
    		preparedStatement.setString(1, bno);
    		resultSet = preparedStatement.executeQuery();
            writeResultSet(resultSet);
        } catch (Exception e) {
            throw e;
        } finally {
            close();
        }
	}
	private void writeResultSet(ResultSet resultSet) throws SQLException {
        while (resultSet.next()) {
            String bno = resultSet.getString("BNO");
            String bloodtype = resultSet.getString("BLOODTYPE");
            System.out.println("BLOODBANK NUMBER: " + bno);
            System.out.println("BLOODTYPE: " + bloodtype);
        }
    }
	private void close() throws SQLException {
		if (resultSet != null) {
    		resultSet.close();
    	}
    	if (preparedStatement != null) {
    		preparedStatement.close();
    	}
    	if (statement != null) {
    		statement.close();
    	}
    	if (connect != null) {
    		connect.close();
    	}
    }

}
