package com.servlet;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.database.RequestDao;
import com.model.Request;

@WebServlet("/dashboard")
public class DashboardServlet extends HttpServlet {

	RequestDao requestDao = new RequestDao();

	protected void doGet(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
		ArrayList<Request> contactRequestList = requestDao.fetchRequest();
		req.setAttribute("dataBaseInfo", contactRequestList);
		req.getRequestDispatcher("dashboard.jsp").forward(req, res);

	}

	protected void doPost(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
		if (req.getParameter("button") != null) {
			requestDao.requestChange(req.getParameter("dataButton"));
			doGet(req, res);

		}
	}

}
