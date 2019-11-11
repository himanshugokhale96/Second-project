package com.katta.suma;

import org.springframework.beans.factory.annotation.Autowired;

public class EmployeeManager {

@Autowired EmployeeDAO employeeDAO;	
public int validate(String userName , String password)
{

	String uname="sahana";
	String passwd="sahana12";
	if((userName.compareTo(uname)==0)&&(password.compareTo(passwd)==0))
	{
		return 1;
	}
	else 
	{
		return 0;
	}
}

}
