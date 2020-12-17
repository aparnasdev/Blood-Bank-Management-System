package bb_management;

import java.sql.*;
import java.util.*;

public class BloodBank implements User {
	private Connection connect = null;
    private Statement statement = null;
    private PreparedStatement preparedStatement = null;
    private ResultSet resultSet = null;
    Scanner obj = new Scanner(System.in);
    public void add() throws Exception {
		try {
        	Class.forName("org.postgresql.Driver");
        	connect = DriverManager.getConnection("jdbc:postgresql://localhost:5432/BLOODBANKMANAGEMENTSYSTEM", "postgres", "amma1234");
    		preparedStatement = connect.prepareStatement("INSERT INTO BLOODBANK VALUES (?, ?, ?, ?)");
    		System.out.println("Enter bloodbank number: ");
    		String bno = obj.next();
    		System.out.println("Enter bloodtype: ");
    		String bloodtype = obj.next();
    		System.out.println("Enter orders: ");
    		int orders = obj.nextInt();
    		System.out.println("Enter donor issues: ");
    		int issues = obj.nextInt();
    		preparedStatement.setString(1, bno);
    		preparedStatement.setString(2, bloodtype);
    		preparedStatement.setInt(3, orders);
    		preparedStatement.setInt(4, issues);
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
    		preparedStatement = connect.prepareStatement("DELETE FROM BLOODBANK WHERE BNO = ?");
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
    		preparedStatement = connect.prepareStatement("UPDATE DONOR SET BLOODTYPE = ?, ORDERS = ?, "
    				+ "ISSUES = ? WHERE BNO = ?");
    		preparedStatement.setString(4, bno);
    		System.out.println("Enter bloodtype: ");
    		String bloodtype = obj.next();
    		System.out.println("Enter orders: ");
    		int orders = obj.nextInt();
    		System.out.println("Enter donor issues: ");
    		int issues = obj.nextInt();
    		preparedStatement.setString(1, bloodtype);
    		preparedStatement.setInt(2, orders);
    		preparedStatement.setInt(3, issues);
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
    		preparedStatement = connect.prepareStatement("SELECT * FROM BLOODBANK WHERE BNO = ?");
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
            int orders = resultSet.getInt("ORDERS");
            int issues = resultSet.getInt("ISSUES");
            System.out.println("BLOODBANK NO: " + bno);
            System.out.println("BLOODTYPE: " + bloodtype);
            System.out.println("ORDERS: " + orders);
            System.out.println("ISSUES: " + issues);
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
