package bb_management;

import java.sql.*;
import java.util.*;

public class Donates implements User {
	private Connection connect = null;
    private Statement statement = null;
    private PreparedStatement preparedStatement = null;
    private ResultSet resultSet = null;
    Scanner obj = new Scanner(System.in);
    public void add() throws Exception {
		try {
        	Class.forName("org.postgresql.Driver");
        	connect = DriverManager.getConnection("jdbc:postgresql://localhost:5432/BLOODBANKMANAGEMENTSYSTEM", "postgres", "amma1234");
    		preparedStatement = connect.prepareStatement("INSERT INTO DONATES VALUES (?, ?, ?, ?, ?)");
    		System.out.println("Enter donor id: ");
    		String did = obj.next();
    		System.out.println("Enter patient id: ");
    		String pid = obj.next();
    		System.out.println("Enter blood: ");
    		String blood = obj.next();
    		System.out.println("Enter donor phone number: ");
    		String dphone = obj.next();
    		System.out.println("Enter patient phone number: ");
    		String pphone = obj.next();
    		preparedStatement.setString(1, did);
    		preparedStatement.setString(2, pid);
    		preparedStatement.setString(3, blood);
    		preparedStatement.setString(4, dphone);
    		preparedStatement.setString(5, pphone);
    		preparedStatement.executeUpdate();
        } catch (Exception e) {
            throw e;
        } finally {
            close();
        }
	}
	public void delete(String did) throws Exception {
		try {
        	Class.forName("org.postgresql.Driver");
        	connect = DriverManager.getConnection("jdbc:postgresql://localhost:5432/BLOODBANKMANAGEMENTSYSTEM", "postgres", "amma1234");
    		preparedStatement = connect.prepareStatement("DELETE FROM DONATES WHERE DID = ?");
    		preparedStatement.setString(1, did);
    		preparedStatement.executeUpdate();
        } catch (Exception e) {
            throw e;
        } finally {
            close();
        }
	}
	public void edit(String did) throws Exception {
		try {
			Class.forName("org.postgresql.Driver");
        	connect = DriverManager.getConnection("jdbc:postgresql://localhost:5432/BLOODBANKMANAGEMENTSYSTEM", "postgres", "amma1234");
    		preparedStatement = connect.prepareStatement("UPDATE DONATES SET PID = ?, BLOOD = ?, "
    				+ "DPHONE = ?, PPHONE = ? WHERE DID = ?");
    		preparedStatement.setString(5, did);
    		System.out.println("Enter patient id: ");
    		String pid = obj.next();
    		System.out.println("Enter blood: ");
    		String blood = obj.next();
    		System.out.println("Enter donor phone number: ");
    		String dphone = obj.next();
    		System.out.println("Enter patient phone number: ");
    		String pphone = obj.next();
    		preparedStatement.setString(5, did);
    		preparedStatement.setString(1, pid);
    		preparedStatement.setString(2, blood);
    		preparedStatement.setString(3, dphone);
    		preparedStatement.setString(4, pphone);
    		preparedStatement.executeUpdate();
        } catch (Exception e) {
            throw e;
        } finally {
            close();
        }
	}
	public void search(String did) throws Exception {
		try {
        	Class.forName("org.postgresql.Driver");
        	connect = DriverManager.getConnection("jdbc:postgresql://localhost:5432/BLOODBANKMANAGEMENTSYSTEM", "postgres", "amma1234");
    		preparedStatement = connect.prepareStatement("SELECT * FROM DONATES WHERE DID = ?");
    		preparedStatement.setString(1, did);
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
            String did = resultSet.getString("DID");
            String pid = resultSet.getString("PID");
            String blood = resultSet.getString("BLOOD");
            String dphone = resultSet.getString("DPHONE");
            String pphone = resultSet.getString("PPHONE");
            System.out.println("DONOR ID: " + did);
            System.out.println("PATIENT ID: " + pid);
            System.out.println("BLOOD: " + blood);
            System.out.println("DONOR PHONE NO: " + dphone);
            System.out.println("PATIENT PHONE NO: " + pphone);
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
