package com.servlet;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.database.UserDao;
import com.model.User;

@WebServlet("/login")
public class LoginServlet extends HttpServlet {

	protected void doGet(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
		req.getRequestDispatcher("login.jsp").forward(req, res);
	}

	protected void doPost(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
		String userName = req.getParameter("username");
		String password = req.getParameter("password");

		User user = new User();
		user.setName(userName);
		user.setPassword(password);

		if (req.getParameter("submit") != null) {
			UserDao userDao = new UserDao();
			if (userDao.verifyPassword(user)) {
				res.sendRedirect("dashboard");

			} else {
				doGet(req, res);

			}

		} else {
			doGet(req, res);
		}

	}

}
