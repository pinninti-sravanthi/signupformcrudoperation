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

public class delete extends HttpServlet {
	@SuppressWarnings({ "null", "unchecked" })
	public void doPost(HttpServletRequest req, HttpServletResponse resp) throws IOException, ServletException {
		resp.setContentType("text/html");
		PrintWriter out = resp.getWriter();
		String email = req.getParameter("email");
		SignUpFormjdo signupformobjectjdo = new SignUpFormjdo();
		PersistenceManager pm = PMF.get().getPersistenceManager();
		signupformobjectjdo.setemail(email);

		Query query = pm.newQuery(SignUpFormjdo.class);
		query.setFilter("email==email1");
		query.declareParameters("String email1");
		try {
			List<SignUpFormjdo> results = (List<SignUpFormjdo>) query.execute(email);
			if (!results.isEmpty()) {

				for (SignUpFormjdo deleteObject : results) {
					if (email.equals(email))
						pm.deletePersistent(deleteObject);
					out.print("success");
				}
			} else {
				out.print("not success");
			}
		} finally {
			pm.close();
		}
	}
}
