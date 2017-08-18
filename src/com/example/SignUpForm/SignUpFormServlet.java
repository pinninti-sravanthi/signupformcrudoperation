package com.example.SignUpForm;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@SuppressWarnings("serial")
public class SignUpFormServlet extends HttpServlet {

	public void doPost(HttpServletRequest req, HttpServletResponse resp) throws IOException, ServletException {
		String check;
		resp.setContentType("text/html");
		PrintWriter out = resp.getWriter();

		// String name = req.getParameter("userName");
		String email = req.getParameter("email");
		String userPass = req.getParameter("userPass");
		String phonenumber = req.getParameter("phonenumber");
		// out.println("welcome " + name);
		check = validation(email, userPass, phonenumber, out);
		if (check.equals("ok")) {
			req.getRequestDispatcher("/SignUpFormServlet2").forward(req, resp);

		} else
			out.print(check);

	}

	public String validation(String email, String userPass, String phonenumber, PrintWriter out) {
		try {

			String regex = "^[_A-Za-z0-9-\\+]+(\\.[_A-Za-z0-9-]+)*@"
					+ "[A-Za-z0-9-]+(\\.[A-Za-z0-9]+)*(\\.[A-Za-z]{2,})$";

			Pattern pattern = Pattern.compile(regex);

			Matcher matcher = pattern.matcher(email);

			String msg;

			if (!email.isEmpty() && email.length() > 0) {

				if (matcher.matches()) {
					msg = checkPassword(userPass);
					if (msg.equals("ok")) {
						msg = checkPhonenumber(phonenumber);
						return msg;
					} else
						return msg;

				} else {
					return "invalid email";
				}

			} else
				return "enter details";

			// HttpSession session = req.getSession();
			// session.setAttribute("name", name);
			// out.print("<a href='servlet2'>visit</a>");

		} catch (

		Exception e) {
			e.printStackTrace();
			System.out.println(e);

		}
		return "sorry";
	}

	public String checkPassword(String userPass) {
		String regex2 = "^.*(?=.{8,})(?=.*[a-z])(?=.*[A-Z])(?=.*[@#$%^&+=])[a-zA-Z0-9@#$%^&+=]*$";
		Pattern pattern2 = Pattern.compile(regex2);
		Matcher password = pattern2.matcher(userPass);
		if (!userPass.isEmpty()) {

			if (password.matches()) {
				return "ok";
			} else {
				return "password is invalid";
			}
		} else
			return "password should not be empty";

	}

	public String checkPhonenumber(String phonenumber) {
		String regex3 = "^(0|91)?[7-9][0-9]{9}$";
		Pattern pattern3 = Pattern.compile(regex3);
		Matcher phoneNumber = pattern3.matcher(phonenumber);
		if (!phonenumber.isEmpty()) {

			if (phoneNumber.matches()) {
				return "ok";
			} else {
				return "phonenumber is invalid";
			}
		} else {
			return "invalid phno";

		}

	}

}
