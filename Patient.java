package bb_management;

import java.sql.*;
import java.util.*;

public class Patient implements User {
	private Connection connect = null;
    private Statement statement = null;
    private PreparedStatement preparedStatement = null;
    private ResultSet resultSet = null;
    Scanner obj = new Scanner(System.in);
    public void add() throws Exception {
		try {
        	Class.forName("org.postgresql.Driver");
        	connect = DriverManager.getConnection("jdbc:postgresql://localhost:5432/BLOODBANKMANAGEMENTSYSTEM", "postgres", "amma1234");
    		preparedStatement = connect.prepareStatement("INSERT INTO PATIENT VALUES (?, ?, ?, ?, ?)");
    		System.out.println("Enter patient id: ");
    		String pid = obj.next();
    		System.out.println("Enter patient name: ");
    		String pname = obj.next();
    		System.out.println("Enter patient bloodgroup: ");
    		String bloodgroup = obj.next();
    		System.out.println("Enter page number: ");
    		int page = obj.nextInt();
    		System.out.println("Enter hospital id: ");
    		String hid = obj.next();
    		preparedStatement.setString(1, pid);
    		preparedStatement.setString(2, pname);
    		preparedStatement.setString(3, bloodgroup);
    		preparedStatement.setInt(4, page);
    		preparedStatement.setString(5, hid);
    		preparedStatement.executeUpdate();
        } catch (Exception e) {
            throw e;
        } finally {
            close();
        }
	}
	public void delete(String pid) throws Exception {
		try {
        	Class.forName("org.postgresql.Driver");
        	connect = DriverManager.getConnection("jdbc:postgresql://localhost:5432/BLOODBANKMANAGEMENTSYSTEM", "postgres", "amma1234");
    		preparedStatement = connect.prepareStatement("DELETE FROM PATIENT WHERE PID = ?");
    		preparedStatement.setString(1, pid);
    		preparedStatement.executeUpdate();
        } catch (Exception e) {
            throw e;
        } finally {
            close();
        }
	}
	public void edit(String pid) throws Exception {
		try {
			Class.forName("org.postgresql.Driver");
        	connect = DriverManager.getConnection("jdbc:postgresql://localhost:5432/BLOODBANKMANAGEMENTSYSTEM", "postgres", "amma1234");
    		preparedStatement = connect.prepareStatement("UPDATE PATIENT SET PNAME = ?, BLOODGROUP = ?, "
    				+ "PAGE = ?, HID = ? WHERE PID = ?");
    		preparedStatement.setString(5, pid);
    		System.out.println("Enter patient name: ");
    		String pname = obj.next();
    		System.out.println("Enter bloodgroup: ");
    		String bloodgroup = obj.next();
    		System.out.println("Enter page number: ");
    		int page = obj.nextInt();
    		System.out.println("Enter hospital id: ");
    		String hid = obj.next();
    		preparedStatement.setString(1, pname);
    		preparedStatement.setString(2, bloodgroup);
    		preparedStatement.setInt(3, page);
    		preparedStatement.setString(4, hid);
    		preparedStatement.executeUpdate();
        } catch (Exception e) {
            throw e;
        } finally {
            close();
        }
	}
	public void search(String pid) throws Exception {
		try {
        	Class.forName("org.postgresql.Driver");
        	connect = DriverManager.getConnection("jdbc:postgresql://localhost:5432/BLOODBANKMANAGEMENTSYSTEM", "postgres", "amma1234");
    		preparedStatement = connect.prepareStatement("SELECT * FROM PATIENT WHERE PID = ?");
    		preparedStatement.setString(1, pid);
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
            String id = resultSet.getString("PID");
            String name = resultSet.getString("PNAME");
            int page = resultSet.getInt("PAGE");
            String bloodgroup = resultSet.getString("BLOODGROUP");
            String hid = resultSet.getString("HID");
            System.out.println("ID: " + id);
            System.out.println("NAME: " + name);
            System.out.println("BLOODGROUP: " + bloodgroup);
            System.out.println("PAGE: " + page);
            System.out.println("HOSPITAL ID: " + hid);
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
