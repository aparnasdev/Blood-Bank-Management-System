package bb_management;

import java.util.*;
import java.sql.*;

public class Hospital implements User{
	private Connection connect = null;
    private Statement statement = null;
    private PreparedStatement preparedStatement = null;
    private ResultSet resultSet = null;
    Scanner obj = new Scanner(System.in);
    public void add() throws Exception {
		try {
        	Class.forName("org.postgresql.Driver");
        	connect = DriverManager.getConnection("jdbc:postgresql://localhost:5432/BLOODBANKMANAGEMENTSYSTEM", "postgres", "amma1234");
    		preparedStatement = connect.prepareStatement("INSERT INTO HOSPITAL VALUES (?, ?, ?, ?)");
    		System.out.println("Enter hospital id: ");
    		String hid = obj.next();
    		System.out.println("Enter hospital name: ");
    		String hname = obj.next();
    		System.out.println("Enter hospital street: ");
    		String hstreet = obj.next();
    		System.out.println("Enter hospital city: ");
    		String hcity = obj.next();
    		preparedStatement.setString(1, hid);
    		preparedStatement.setString(2, hname);
    		preparedStatement.setString(3, hstreet);
    		preparedStatement.setString(4, hcity);
    		preparedStatement.executeUpdate();
        } catch (Exception e) {
            throw e;
        } finally {
            close();
        }
	}
	public void delete(String hid) throws Exception {
		try {
        	Class.forName("org.postgresql.Driver");
        	connect = DriverManager.getConnection("jdbc:postgresql://localhost:5432/BLOODBANKMANAGEMENTSYSTEM", "postgres", "amma1234");
    		preparedStatement = connect.prepareStatement("DELETE FROM HOSPITAL WHERE HID = ?");
    		preparedStatement.setString(1, hid);
    		preparedStatement.executeUpdate();
        } catch (Exception e) {
            throw e;
        } finally {
            close();
        }
	}
	public void edit(String hid) throws Exception {
		try {
			Class.forName("org.postgresql.Driver");
        	connect = DriverManager.getConnection("jdbc:postgresql://localhost:5432/BLOODBANKMANAGEMENTSYSTEM", "postgres", "amma1234");
    		preparedStatement = connect.prepareStatement("UPDATE HOSPITAL SET HNAME = ?, HSTREET = ?, HCITY = ? WHERE HID = ?");
    		preparedStatement.setString(4, hid);
    		System.out.println("Enter hospital name: ");
    		String hname = obj.next();
    		System.out.println("Enter hospital street: ");
    		String hstreet = obj.next();
    		System.out.println("Enter hospital city: ");
    		String hcity = obj.next();
    		preparedStatement.setString(1, hname);
    		preparedStatement.setString(2, hstreet);
    		preparedStatement.setString(3, hcity);
    		preparedStatement.executeUpdate();
        } catch (Exception e) {
            throw e;
        } finally {
            close();
        }
	}
	public void search(String hid) throws Exception {
		try {
        	Class.forName("org.postgresql.Driver");
        	connect = DriverManager.getConnection("jdbc:postgresql://localhost:5432/BLOODBANKMANAGEMENTSYSTEM", "postgres", "amma1234");
    		preparedStatement = connect.prepareStatement("SELECT * FROM HOSPITAL WHERE HID = ?");
    		preparedStatement.setString(1, hid);
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
            String id = resultSet.getString("HID");
            String name = resultSet.getString("HNAME");
            String street = resultSet.getString("HSTREET");
            String city = resultSet.getString("HCITY");
            System.out.println("ID: " + id);
            System.out.println("NAME: " + name);
            System.out.println("STREET: " + street);
            System.out.println("CITY: " + city);
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
