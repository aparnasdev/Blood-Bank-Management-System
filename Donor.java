package bb_management;

import java.sql.*;
import java.util.*;

public class Donor implements User {
	private Connection connect = null;
    private Statement statement = null;
    private PreparedStatement preparedStatement = null;
    private ResultSet resultSet = null;
    Scanner obj = new Scanner(System.in);
	public void add() throws Exception {
		try {
        	Class.forName("org.postgresql.Driver");
        	connect = DriverManager.getConnection("jdbc:postgresql://localhost:5432/BLOODBANKMANAGEMENTSYSTEM", "postgres", "amma1234");
    		preparedStatement = connect.prepareStatement("INSERT INTO DONOR VALUES (?, ?, ?, ?, ?, ?)");
    		System.out.println("Enter donor id: ");
    		String did = obj.next();
    		System.out.println("Enter donor name: ");
    		String dname = obj.next();
    		System.out.println("Enter donor age: ");
    		int dage = obj.nextInt();
    		System.out.println("Enter donor sex: ");
    		String dsex = obj.next();
    		System.out.println("Enter donor street: ");
    		String dstreet = obj.next();
    		System.out.println("Enter donor city: ");
    		String dcity = obj.next();
    		preparedStatement.setString(1, did);
    		preparedStatement.setString(2, dname);
    		preparedStatement.setInt(3, dage);
    		preparedStatement.setString(4, dsex);
    		preparedStatement.setString(5, dstreet);
    		preparedStatement.setString(6, dcity);
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
    		preparedStatement = connect.prepareStatement("DELETE FROM DONOR WHERE DID = ?");
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
    		preparedStatement = connect.prepareStatement("UPDATE DONOR SET DNAME = ?, DAGE = ?, "
    				+ "DSEX = ?, DSTREET = ?, DCITY = ? WHERE DID = ?");
    		preparedStatement.setString(6, did);
    		System.out.println("Enter donor name: ");
    		String dname = obj.next();
    		System.out.println("Enter donor age: ");
    		int dage = obj.nextInt();
    		System.out.println("Enter donor sex: ");
    		String dsex = obj.next();
    		System.out.println("Enter donor street: ");
    		String dstreet = obj.next();
    		System.out.println("Enter donor city: ");
    		String dcity = obj.next();
    		preparedStatement.setString(1, dname);
    		preparedStatement.setInt(2, dage);
    		preparedStatement.setString(3, dsex);
    		preparedStatement.setString(4, dstreet);
    		preparedStatement.setString(5, dcity);
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
    		preparedStatement = connect.prepareStatement("SELECT * FROM DONOR WHERE DID = ?");
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
            String id = resultSet.getString("DID");
            String name = resultSet.getString("DNAME");
            int age = resultSet.getInt("DAGE");
            String sex = resultSet.getString("DSEX");
            String street = resultSet.getString("DSTREET");
            String city = resultSet.getString("DCITY");
            System.out.println("ID: " + id);
            System.out.println("NAME: " + name);
            System.out.println("AGE: " + age);
            System.out.println("SEX: " + sex);
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
