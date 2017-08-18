package com.example.SignUpForm;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

import javax.jdo.PersistenceManager;
import javax.jdo.Query;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

public class update extends HttpServlet {
	@SuppressWarnings({ "null", "unchecked" })
	public void doPost(HttpServletRequest req, HttpServletResponse resp) throws IOException, ServletException {
		resp.setContentType("text/html");
		PrintWriter out = resp.getWriter();
		String name = req.getParameter("option");
		String newvalue = req.getParameter("newvalue");
		// String userPass = request.getParameter("userPass");
		HttpSession session = req.getSession(false);
		String email = session.getAttribute("email").toString();
		// String email = request.getParameter("email");
		System.out.println(email);

		// String phonenumber = request.getParameter("phonenumber");
		PersistenceManager pm = PMF.get().getPersistenceManager();
		SignUpFormjdo signupformobjectjdo = new SignUpFormjdo();
		signupformobjectjdo.setuserName(name);
		signupformobjectjdo.setemail(email);
		Query query = pm.newQuery(SignUpFormjdo.class);
		query.setFilter("email == email1");
		query.declareParameters("String email1");
		SignUpFormServlet obj = new SignUpFormServlet();

		try {
			List<SignUpFormjdo> results = (List<SignUpFormjdo>) query.execute(signupformobjectjdo.getemail());

			if (!results.isEmpty()) {

				for (SignUpFormjdo updateObject : results) {
					if (name.equals("name")) {
						updateObject.setuserName(newvalue);
						pm.makePersistent(updateObject);
						out.println("name updated successfully..");
					}

					if (name.equals("password")) {

						if (obj.checkPassword(newvalue).equals("ok")) {

							updateObject.setuserPass(newvalue);
							pm.makePersistent(updateObject);
							out.println("password updated successfully..");
						} else {
							out.println("set password correctly");
						}
					}
					if (name.equals("phonenumber")) {
						if (obj.checkPhonenumber(newvalue).equals("ok")) {
							updateObject.setphonenumber(newvalue);
							pm.makePersistent(updateObject);
							out.println("phone number updated successfully...");

						} else {
							out.println("set phonenumber correctly ");
						}
					}

				}

			} else {
				out.print("not success");
			}
		} finally {
			pm.close();
		}
	}
}