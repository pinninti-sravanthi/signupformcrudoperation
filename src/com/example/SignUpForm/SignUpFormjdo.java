package com.example.SignUpForm;

import javax.jdo.annotations.PersistenceCapable;
import javax.jdo.annotations.Persistent;

@PersistenceCapable
public class SignUpFormjdo {
@Persistent
private String userName;

@Persistent
private String email ;

@Persistent
private String userPass;
@Persistent
private String phonenumber;
public String getuserName() {
	return userName;
}

public void setuserName(String userName) {
	this.userName = userName;
}
public String getemail() {
    return email;
}
public void setemail(String email)
{
 this.email=email;
}
public String getuserPass() {
	return userPass;
}

public void setuserPass(String userPass) {
	this.userPass = userPass;
}
public String getphonenumber() {
	return phonenumber;
}

public void setphonenumber(String phonenumber) {
	this.phonenumber = phonenumber;
}	
}
