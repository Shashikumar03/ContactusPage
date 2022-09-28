package com.servlet;

import java.io.IOException;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.database.RequestDao;
import com.model.Request;

@WebServlet("/contactus")
public class ContactUsServlet extends HttpServlet {

	protected void doGet(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
		req.getRequestDispatcher("contactus.jsp").forward(req, res);

	}

	protected void doPost(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
		String name = req.getParameter("name");
		String email = req.getParameter("email");
		String message = req.getParameter("message");
		
		if (req.getParameter("submit") != null) {
			Request request = new Request();
			request.setName(name);
			request.setEmail(email);
			request.setMessage(message);

			RequestDao requestDao = new RequestDao();
			if (requestDao.saveRequest(request)) {
				doGet(req, res);

			}

		}
	}

}
