package com.database;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import javax.swing.JOptionPane;
import org.apache.catalina.connector.Response;

import com.servlet.DashboardServlet;
import com.model.Request;

public class RequestDao {

	public Connection databaseConnection() {
		String url = "jdbc:postgresql://localhost:5432/javawebpage";
		String userName = "postgres";
		String password = "Shashi@123";
		Connection connection = null;

		try {
			Class.forName("org.postgresql.Driver");
			connection = DriverManager.getConnection(url, userName, password);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		return connection;

	}

	public boolean saveRequest(Request requestData) {

		try {

			Connection connectionn = databaseConnection();
			PreparedStatement prepareStatement = connectionn
					.prepareStatement("insert into contactinfo(name,email,message) values(?,?,?)");
			prepareStatement.setString(1, requestData.getName());
			prepareStatement.setString(2, requestData.getEmail());
			prepareStatement.setString(3, requestData.getMessage());

			if (prepareStatement.executeUpdate() != 0) {
				JOptionPane.showMessageDialog(null, "Item Added Successfully");
				return true;
			}
			connectionn.close();

		} catch (Exception e) {

			JOptionPane.showMessageDialog(null, "Error : " + e);

		}
		return false;

	}

	public ArrayList<Request> fetchRequest() {

		ArrayList<Request> contactRequestList = new ArrayList<>();

		try {

			Connection connection = databaseConnection();
			PreparedStatement prepareStatement = connection.prepareStatement("select * from contactinfo ");
			ResultSet resultSet = prepareStatement.executeQuery();
			while (resultSet.next()) {
				Request request = new Request();
				request.setId(resultSet.getInt("id"));
				request.setName(resultSet.getString("name"));
				request.setEmail(resultSet.getString("email"));
				request.setMessage(resultSet.getString("message"));
				request.setStatus(resultSet.getString("status"));

				contactRequestList.add(request);
				connection.close();

			}

		} catch (Exception e) {

			JOptionPane.showMessageDialog(null, "Error : " + e);

		}
		return contactRequestList;
	}

	public void requestChange(String idNo) {

		int id = Integer.parseInt(idNo);

		try {

			Connection connection = databaseConnection();
			PreparedStatement prepareStatement = connection
					.prepareStatement("select status from contactinfo where id='" + id + "'");

			ResultSet resultSet = prepareStatement.executeQuery();
			if (resultSet.next()) {
				if (resultSet.getString("status").equals("active")) {

					PreparedStatement innerPreparestatement = connection
							.prepareStatement("update contactinfo set status='archive' where id='" + id + "'");
					innerPreparestatement.executeUpdate();
				} else {
					PreparedStatement innerPrepareStatement = connection
							.prepareStatement("update contactinfo set status='active' where id='" + id + "'");
					innerPrepareStatement.executeUpdate();
				}

			}
			connection.close();

		} catch (Exception e) {
			JOptionPane.showMessageDialog(null, e);
		}

	}

}
