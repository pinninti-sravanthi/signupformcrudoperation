package com.example.SignUpForm;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

import javax.jdo.PersistenceManager;
//import javax.jdo.annotations.Query;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

//import com.google.appengine.api.datastore.Query;

public class SignUpFormServlet21 extends HttpServlet {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	public void doPost(HttpServletRequest req, HttpServletResponse resp) throws IOException, ServletException {

		/*
		 * PrintWriter out = resp.getWriter(); HttpSession session =
		 * req.getSession(false); String n=(String)session.getAttribute("name");
		 * out.print("hello "+n);
		 * 
		 * 
		 * if (session != null) { session.invalidate();
		 */
		resp.setContentType("text/html");
		PrintWriter out = resp.getWriter();

		String userName = req.getParameter("userName");
		String email = req.getParameter("email");
		String userPass = req.getParameter("userPass");
		String phonenumber = req.getParameter("phonenumber");
		
		PersistenceManager pm = PMF.get().getPersistenceManager();
		SignUpFormjdo signupformobjectjdo = new SignUpFormjdo();

		// signupformobjectjdo.setemail(email);
		// signupformobjectjdo.setuserName(userName);
		// signupformobjectjdo.setphonenumber(phonenumber);
		// signupformobjectjdo.setuserPass(userPass);

		/*
		 * String str = ""; try {
		 * 
		 * 
		 * if(checkAssociation(email)){ out.println("imside if block"); }else {
		 * pm.makePersistent(signupformobjectjdo); }
		 * 
		 * 
		 * // if () { // out.println(emaiId); //
		 * out.println("email id already exists"); // // } else { //
		 * pm.makePersistent(signupformobjectjdo); // // } } catch
		 * (NullPointerException e) { out.println(e); } catch (Exception e) { //
		 * TODO Auto-generated catch block e.printStackTrace(); }
		 * 
		 * }
		 * 
		 * public boolean checkAssociation(String emailId) throws Exception {
		 * PersistenceManager pm = PMF.get().getPersistenceManager();
		 * SignUpFormjdo objSignUpFormjdo =
		 * pm.getObjectById(SignUpFormjdo.class, emailId); if(objSignUpFormjdo
		 * !=null){ return true; } else { return false; }
		 */

		javax.jdo.Query query = pm.newQuery(SignUpFormjdo.class);
		try {

			@SuppressWarnings("unchecked")
			List<SignUpFormjdo> results = (List<SignUpFormjdo>) query.execute("sravanthi@gmail.com");
			if (results.isEmpty()) {
				pm.makePersistent(signupformobjectjdo);
			}
			/*
			 * for (SignUpFormjdo p : results) if (p.getemail().equals(email)) {
			 * String id = p.getemail(); String name = p.getuserName(); String
			 * password = p.getuserPass(); String phonenumbers =
			 * p.getphonenumber(); }
			 * 
			 * } else { pm.makePersistent(signupformobjectjdo); }
			 */
		} finally {
			pm.close();
		}
	}
}