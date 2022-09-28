package com.database;

import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import javax.swing.JOptionPane;

import org.apache.catalina.connector.Response;

import com.model.User;

public class UserDao {

	String url = "jdbc:postgresql://localhost:5432/javawebpage";
	String username = "postgres";
	String password = "Shashi@123";

	public boolean verifyPassword(User user) {

		String userName = user.getName();
		String userPassword = user.getPassword();
		try {
			Class.forName("org.postgresql.Driver");
			Connection connection = DriverManager.getConnection(url, username, password);
			PreparedStatement prepareStatement = connection.prepareStatement("select * from admininfo where username='" + userName
					+ "' and password='" + userPassword + "'");
			ResultSet resulSet = prepareStatement.executeQuery();
			if (resulSet.next()) {

				return true;
			} else {
				JOptionPane.showMessageDialog(null, "Email and password didnt matched", "Error",
						JOptionPane.ERROR_MESSAGE);
			}

		} catch (Exception e) {

			JOptionPane.showMessageDialog(null, "Error : " + e);
		}
		return false;
	}

}
