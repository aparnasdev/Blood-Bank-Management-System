package bb_management;

import java.sql.*;
import java.util.*;

public class BBmanager implements User {
	private Connection connect = null;
    private Statement statement = null;
    private PreparedStatement preparedStatement = null;
    private ResultSet resultSet = null;
    Scanner obj = new Scanner(System.in);
    public void add() throws Exception {
		try {
        	Class.forName("org.postgresql.Driver");
        	connect = DriverManager.getConnection("jdbc:postgresql://localhost:5432/BLOODBANKMANAGEMENTSYSTEM", "postgres", "amma1234");
    		preparedStatement = connect.prepareStatement("INSERT INTO BBMANAGER VALUES (?, ?, ?)");
    		System.out.println("Enter manager id: ");
    		String eid = obj.next();
    		System.out.println("Enter manager name: ");
    		String mname = obj.next();
    		System.out.println("Enter email: ");
    		String email = obj.next();
    		preparedStatement.setString(1, eid);
    		preparedStatement.setString(2, mname);
    		preparedStatement.setString(3, email);
    		preparedStatement.executeUpdate();
        } catch (Exception e) {
            throw e;
        } finally {
            close();
        }
	}
	public void delete(String eid) throws Exception {
		try {
        	Class.forName("org.postgresql.Driver");
        	connect = DriverManager.getConnection("jdbc:postgresql://localhost:5432/BLOODBANKMANAGEMENTSYSTEM", "postgres", "amma1234");
    		preparedStatement = connect.prepareStatement("DELETE FROM BBMANAGER WHERE EID = ?");
    		preparedStatement.setString(1, eid);
    		preparedStatement.executeUpdate();
        } catch (Exception e) {
            throw e;
        } finally {
            close();
        }
	}
	public void edit(String eid) throws Exception {
		try {
			Class.forName("org.postgresql.Driver");
        	connect = DriverManager.getConnection("jdbc:postgresql://localhost:5432/BLOODBANKMANAGEMENTSYSTEM", "postgres", "amma1234");
    		preparedStatement = connect.prepareStatement("UPDATE BBMANAGER SET MNAME = ?, EMAIL = ?, "
    				+ "WHERE EID = ?");
    		preparedStatement.setString(3, eid);
    		System.out.println("Enter manager name: ");
    		String mname = obj.next();
    		System.out.println("Enter email: ");
    		String email = obj.next();
    		preparedStatement.setString(1, mname);
    		preparedStatement.setString(2, email);
    		preparedStatement.executeUpdate();
        } catch (Exception e) {
            throw e;
        } finally {
            close();
        }
	}
	public void search(String eid) throws Exception {
		try {
        	Class.forName("org.postgresql.Driver");
        	connect = DriverManager.getConnection("jdbc:postgresql://localhost:5432/BLOODBANKMANAGEMENTSYSTEM", "postgres", "amma1234");
    		preparedStatement = connect.prepareStatement("SELECT * FROM BBMANAGER WHERE EID = ?");
    		preparedStatement.setString(1, eid);
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
            String id = resultSet.getString("EID");
            String name = resultSet.getString("MNAME");
            String email = resultSet.getString("EMAIL");
            System.out.println("ID: " + id);
            System.out.println("NAME: " + name);
            System.out.println("EMAIL: " + email);
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
