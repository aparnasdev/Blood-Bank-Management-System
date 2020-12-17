package bb_management;

import java.sql.*;
import java.util.*;

public class Blood implements User {
	private Connection connect = null;
    private Statement statement = null;
    private PreparedStatement preparedStatement = null;
    private ResultSet resultSet = null;
    Scanner obj = new Scanner(System.in);
    public void add() throws Exception {
		try {
        	Class.forName("org.postgresql.Driver");
        	connect = DriverManager.getConnection("jdbc:postgresql://localhost:5432/BLOODBANKMANAGEMENTSYSTEM", "postgres", "amma1234");
    		preparedStatement = connect.prepareStatement("INSERT INTO BLOOD VALUES (?, ?, ?)");
    		System.out.println("Enter bloodtype: ");
    		String bloodtype = obj.next();
    		System.out.println("Enter code: ");
    		String code = obj.next();
    		System.out.println("Enter cost: ");
    		int bcost = obj.nextInt();
    		preparedStatement.setString(1, bloodtype);
    		preparedStatement.setString(2, code);
    		preparedStatement.setInt(3, bcost);
    		preparedStatement.executeUpdate();
        } catch (Exception e) {
            throw e;
        } finally {
            close();
        }
	}
	public void delete(String bloodtype) throws Exception {
		try {
        	Class.forName("org.postgresql.Driver");
        	connect = DriverManager.getConnection("jdbc:postgresql://localhost:5432/BLOODBANKMANAGEMENTSYSTEM", "postgres", "amma1234");
    		preparedStatement = connect.prepareStatement("DELETE FROM BLOOD WHERE BLOODTYPE = ?");
    		preparedStatement.setString(1, bloodtype);
    		preparedStatement.executeUpdate();
        } catch (Exception e) {
            throw e;
        } finally {
            close();
        }
	}
	public void edit(String bloodtype) throws Exception {
		try {
			Class.forName("org.postgresql.Driver");
        	connect = DriverManager.getConnection("jdbc:postgresql://localhost:5432/BLOODBANKMANAGEMENTSYSTEM", "postgres", "amma1234");
    		preparedStatement = connect.prepareStatement("UPDATE BLOOD SET CODE = ?, BCOST = ? "
    				+ "WHERE BLOODTYPE = ?");
    		System.out.println("Enter code: ");
    		String code = obj.next();
    		System.out.println("Enter cost: ");
    		int bcost = obj.nextInt();
    		preparedStatement.setString(3, bloodtype);
    		preparedStatement.setString(1, code);
    		preparedStatement.setInt(2, bcost);
    		preparedStatement.executeUpdate();
        } catch (Exception e) {
            throw e;
        } finally {
            close();
        }
	}
	public void search(String bloodtype) throws Exception {
		try {
        	Class.forName("org.postgresql.Driver");
        	connect = DriverManager.getConnection("jdbc:postgresql://localhost:5432/BLOODBANKMANAGEMENTSYSTEM", "postgres", "amma1234");
    		preparedStatement = connect.prepareStatement("SELECT * FROM BLOOD WHERE BLOODTYPE = ?");
    		preparedStatement.setString(1, bloodtype);
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
            String bloodtype = resultSet.getString("BLOODTYPE");
            String code = resultSet.getString("CODE");
            int cost = resultSet.getInt("BCOST");
            System.out.println("BLOODTYPE: " + bloodtype);
            System.out.println("CODE: " + code);
            System.out.println("COST: " + cost);
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
