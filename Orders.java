package bb_management;

import java.sql.*;
import java.util.*;

public class Orders implements User {
	private Connection connect = null;
    private Statement statement = null;
    private PreparedStatement preparedStatement = null;
    private ResultSet resultSet = null;
    Scanner obj = new Scanner(System.in);
    public void add() throws Exception {
		try {
        	Class.forName("org.postgresql.Driver");
        	connect = DriverManager.getConnection("jdbc:postgresql://localhost:5432/BLOODBANKMANAGEMENTSYSTEM", "postgres", "amma1234");
    		preparedStatement = connect.prepareStatement("INSERT INTO ORDERS VALUES (?, ?, ?)");
    		System.out.println("Enter hospital id: ");
    		String hid = obj.next();
    		System.out.println("Enter blood bank number: ");
    		String bno = obj.next();
    		System.out.println("Enter hphone: ");
    		String hphone = obj.next();
    		preparedStatement.setString(1, hid);
    		preparedStatement.setString(2, bno);
    		preparedStatement.setString(3, hphone);
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
    		preparedStatement = connect.prepareStatement("DELETE FROM ORDERS WHERE HID = ?");
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
    		preparedStatement = connect.prepareStatement("UPDATE ORDERS SET BNO = ?, HPHONE = ? "
    				+ "WHERE HID = ?");
    		preparedStatement.setString(3, hid);
    		System.out.println("Enter blood bank number: ");
    		String bno = obj.next();
    		System.out.println("Enter hphone: ");
    		String hphone = obj.next();
    		preparedStatement.setString(1, bno);
    		preparedStatement.setString(2, hphone);
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
    		preparedStatement = connect.prepareStatement("SELECT * FROM ORDERS WHERE HID = ?");
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
            String hid = resultSet.getString("HID");
            String bno = resultSet.getString("BNO");
            String phone = resultSet.getString("HPHONE");
            System.out.println("HOSPITAL ID: " + hid);
            System.out.println("BLOODBANK NUMBER: " + bno);
            System.out.println("HOSPITAL PHONE NO: " + phone);
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
