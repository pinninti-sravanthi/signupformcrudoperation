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

@SuppressWarnings("serial")
public class SignUpFormServlet2 extends HttpServlet {
	@SuppressWarnings({ "null", "unchecked" })
	public void doPost(HttpServletRequest req, HttpServletResponse resp) throws IOException, ServletException {
		resp.setContentType("text/html");
		PrintWriter out = resp.getWriter();
		String userName = req.getParameter("userName");
		String email = req.getParameter("email");
		String userPass = req.getParameter("userPass");
		String phonenumber = req.getParameter("phonenumber");
		PersistenceManager pm = PMF.get().getPersistenceManager();
		SignUpFormjdo signupformobjectjdo = new SignUpFormjdo();
		
		signupformobjectjdo.setemail(email);
		 signupformobjectjdo.setuserName(userName);
		 signupformobjectjdo.setphonenumber(phonenumber);
		 signupformobjectjdo.setuserPass(userPass);
/*		Extent<SignUpFormjdo> extent = pm.getExtent(SignUpFormjdo.class, false);
		for (SignUpFormjdo p : extent) {
			if (p.getemail().equals(email)) {
				out.println("email already exists");
			} else {
				pm.makePersistent(signupformobjectjdo);
			}
		}

		extent.closeAll();
		*/
		 
		 
		 
	/*	 try{
			 if(pm.getObjectById(email) == null){
//			 	SignUpFormjdo pbj = pm.getObjectById(SignUpFormjdo.class, signupformobjectjdo.getemail());

//			 	if(email.equals(pm.getObjectById(SignUpFormjdo.class,email))){
//			 	if(email.equals(pbj)){
			 	out.println("email id already exists");
			 }
		 }
			 //}}
			 catch (Exception e) {
				// TODO: handle exception
				
				if(!e.equals(null))
				pm.makePersistent(signupformobjectjdo);
				
				}*/
		 List<SignUpFormjdo> results=null;
		 try {
			 
			 Query dataquery = pm.newQuery(SignUpFormjdo.class,("email == email1"));
			 dataquery.declareParameters("String email1");
			 
			 try{
				try{
					results = (List<SignUpFormjdo>) dataquery.execute(email);
				 if (results.isEmpty()||results.equals(null)) {
					 pm.makePersistent(signupformobjectjdo);
					 
					 out.println("registered success...");
					 out.println("<html>");
					 out.println("<body>");
					 out.println("<a href='login.html'>Please login</a>");	
					 out.println("</body>");
					 out.println("</html>");
				
				
			 }
			  else {
				 out.println("email already exists..");
				 }
				 }
				 catch(NullPointerException nullexception){

				 }
				 } finally {

				 }
				 } catch (Exception exception) {
					 exception.printStackTrace();
				 System.out.println("Exception occurs");

				 }
	
	}
}
