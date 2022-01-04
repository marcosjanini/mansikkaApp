package data_access;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

import java.util.ArrayList;

import model.Client;

/**
 * DAO class for accessing movies. NB! There should be NO user input/output in
 * this class! This class can be used in a stand-alone Java application or as a
 * part of the server-side implementation of a web application. => This code
 * works as it is with all major RDBMSes and SQLite, Excel etc.
 * 
 * @author Kari
 * @version 1.1 2019-11-03
 */
public class ClientDAO {

	public ClientDAO() {
		// In Tomcat 8 environment, the JDBC driver must be explicitly loaded as below
		try {
			Class.forName(ConnectionParameters.jdbcDriver);
		} catch (ClassNotFoundException cnfe) {
			System.out.println(cnfe.getMessage());
		}
	}

	/**
	 * Open a new database connection
	 * 
	 * @throws SQLException
	 */
	private Connection openConnection() throws SQLException {
		return DriverManager.getConnection(ConnectionParameters.connectionString, ConnectionParameters.username,
				ConnectionParameters.password);
	}

	/**
	 * Retrieve all movies from the database
	 * 
	 * @return List<Movie>
	 * @throws SQLException
	 */
	public List<Client> getAllClients() {
		Connection connection = null;
		PreparedStatement preparedStatement = null;
		ResultSet resultSet = null;
		List<Client> clientList = new ArrayList<Client>();

		try {
			connection = openConnection();

			String sqlText = "SELECT id, firstname, lastname, phone, email, taxId, streetaddress, postcode, city FROM Client ORDER BY id";

			preparedStatement = connection.prepareStatement(sqlText);

			resultSet = preparedStatement.executeQuery();

			while (resultSet.next()) {
				int id = resultSet.getInt("id");
				String firstname = resultSet.getString("firstname");
				String lastname = resultSet.getString("lastname");
				String phone = resultSet.getString("phone");
				String email = resultSet.getString("email");
				String taxId = resultSet.getString("taxId");				
				String streetaddress = resultSet.getString("streetaddress");
				String postcode = resultSet.getString("postcode");
				String city = resultSet.getString("city");

				clientList.add(new Client(id, firstname, lastname, phone, email, taxId, streetaddress, postcode, city));
			}

		} catch (SQLException sqle) {
			System.out.println("\n[ERROR] ClientDAO: getClient() failed. " + sqle.getMessage() + "\n");
			clientList = null;

		} finally {
			DbUtils.closeQuietly(resultSet, preparedStatement, connection);
		}

		return clientList;
	}

	public Client getClientId(int clientId) {
		Connection connection = null;
		PreparedStatement preparedStatement = null;
		ResultSet resultSet = null;
		Client client = new Client();

		try {
			connection = openConnection();

			String sqlText = "SELECT id, firstname, lastname, phone, email, taxId, streetaddress, postcode, city FROM Student WHERE id = ? ORDER BY lastname";

			// 3. Create a prepared statement based on the SQL query text
			preparedStatement = connection.prepareStatement(sqlText);

			// 4. Set the query parameter value(s) based on the place-holder number(s)
			preparedStatement.setInt(1, clientId);

			// 5. Execute the SQL query with the PreparedStatement object
			resultSet = preparedStatement.executeQuery();

			// 6. Iterate the results
			// NB! The next() method moves the cursor to the next available row in the
			// results. Initially, the cursor is 'before the first row'.
			// The next() method returns false if there are no more rows.
			boolean rowFound = false;

			while (resultSet.next()) {
				rowFound = true;

				// 7. Each column value has to be retrieved separately as below
				int id = resultSet.getInt("id");
				String firstname = resultSet.getString("firstname");
				String lastname = resultSet.getString("lastname");
				String phone = resultSet.getString("phone");
				String email = resultSet.getString("email");
				String taxId = resultSet.getString("taxId");				
				String streetaddress = resultSet.getString("streetaddress");
				String postcode = resultSet.getString("postcode");
				String city = resultSet.getString("city");
				client = new Client(id, firstname, lastname, phone, email, taxId, streetaddress, postcode, city);
			}

			if (rowFound == false) {
				return null;
			}

		} catch (SQLException sqle) {
			System.out.println("\n[ERROR] Database error. " + sqle.getMessage());

		} finally {
			DbUtils.closeQuietly(resultSet, preparedStatement, connection);
		}
		return client;

	}
	
	public int insertClient(Client client) {
		Connection connection = null;
		PreparedStatement preparedStatement = null;
		int id = client.getId();
		String firstname = client.getFirstname();
		String lastname = client.getLastname();
		String phone = client.getPhone();
		String email = client.getEmail();
		String taxId = client.getTaxId();		
		String streetaddress = client.getStreetaddress();
		String postcode = client.getPostcode();
		String city = client.getCity();

		try {
			connection = openConnection();

			String sqlText = "INSERT INTO Client (id, firstname, lastname, phone, email, taxId, streetaddress, postcode, city) VALUES (?, ?, ?, ?, ?, ?, ?, ?, ?)";

			preparedStatement = connection.prepareStatement(sqlText);
			preparedStatement.setInt(1, id);
			preparedStatement.setString(2, firstname);
			preparedStatement.setString(3, lastname);
			preparedStatement.setString(4, phone);
			preparedStatement.setString(5, email);
			preparedStatement.setString(6, taxId);
			preparedStatement.setString(7, streetaddress);
			preparedStatement.setString(8, postcode);
			preparedStatement.setString(9, city);

			preparedStatement.executeUpdate();
			return 0;

		} catch (SQLException sqle) {

			if (sqle.getErrorCode() == ConnectionParameters.PK_VIOLATION_ERROR) {
				return 1;
			} else {
				return -1;
			}
		} finally {
			DbUtils.closeQuietly(preparedStatement, connection);
		}

	}
	
	public int deleteClient(int clientId) {
		Connection connection = null;
		PreparedStatement preparedStatement = null;
		ResultSet resultSet = null;
		int idX = clientId;

		try {

			connection = DriverManager.getConnection(ConnectionParameters.connectionString,
					ConnectionParameters.username, ConnectionParameters.password);

			String sqlText = "DELETE FROM Client WHERE id = ?";

			preparedStatement = connection.prepareStatement(sqlText);
			preparedStatement.setInt(1, idX);
			int deleted = preparedStatement.executeUpdate();
			return deleted;
		} catch (SQLException sqle) {

			return -1;

		} finally {

			DbUtils.closeQuietly(resultSet, preparedStatement, connection);
		}

	}
	}
/*
public String getAllStudentsJSON() {
		Connection connection = null;
		PreparedStatement preparedStatement = null;
		ResultSet resultSet = null;
		List<Client> studentList = new ArrayList<Client>();

		try {
			connection = openConnection();

			String sqlText = "SELECT id, firstname, lastname, streetaddress, postcode, postoffice FROM Student ORDER BY lastname";

			preparedStatement = connection.prepareStatement(sqlText);

			resultSet = preparedStatement.executeQuery();

			while (resultSet.next()) {
				int id = resultSet.getInt("id");
				String firstname = resultSet.getString("firstname");
				String lastname = resultSet.getString("lastname");
				String streetaddress = resultSet.getString("streetaddress");
				int postcode = resultSet.getInt("postcode");
				String postoffice = resultSet.getString("postoffice");

				studentList.add(new Client(id, firstname, lastname, streetaddress, postcode, postoffice));
			}

		} catch (SQLException sqle) {
			System.out.println("\n[ERROR] StudentDAO: getStudent() failed. " + sqle.getMessage() + "\n");
			studentList = null;

		} finally {
			DbUtils.closeQuietly(resultSet, preparedStatement, connection);
		}

		Gson gson = new Gson();
		String jsonString = gson.toJson(studentList);
		return jsonString;
	}


	public int deleteStudent(int studentId) {
		Connection connection = null;
		PreparedStatement preparedStatement = null;
		ResultSet resultSet = null;
		int idX = studentId;

		try {

			connection = DriverManager.getConnection(ConnectionParameters.connectionString,
					ConnectionParameters.username, ConnectionParameters.password);

			String sqlText = "DELETE FROM Student WHERE id = ?";

			preparedStatement = connection.prepareStatement(sqlText);
			preparedStatement.setInt(1, idX);
			int deleted = preparedStatement.executeUpdate();
			return deleted;
		} catch (SQLException sqle) {

			return -1;

		} finally {

			DbUtils.closeQuietly(resultSet, preparedStatement, connection);
		}

	}

	public int updateStudent(Client student) {

		Connection connection = null;
		PreparedStatement preparedStatement = null;
		ResultSet resultSet = null;
		int result = 0;

		try {
			// 1. Open a database connection
			connection = openConnection();

			// String sqlText = "SELECT * FROM Student WHERE id =" + student.getid();
			String sqlText = "UPDATE Student SET firstname = ?, lastname =?,"
					+ "streetaddress=?, postcode=?, postoffice=? WHERE id = ?";

			preparedStatement = connection.prepareStatement(sqlText);

			preparedStatement.setString(1, student.getFirstname());
			preparedStatement.setString(2, student.getLastname());
			preparedStatement.setString(3, student.getStreetaddress());
			preparedStatement.setInt(4, student.getPostcode());
			preparedStatement.setString(5, student.getPostoffice());
			preparedStatement.setInt(6, student.getId());

			result = preparedStatement.executeUpdate();

		} catch (SQLException sqle) {
			System.out.println("\n[ERROR] Database error. " + sqle.getMessage());
			result = -1;
		} finally {
			DbUtils.closeQuietly(resultSet, preparedStatement, connection);
		}
		return result;

	}
}
*/