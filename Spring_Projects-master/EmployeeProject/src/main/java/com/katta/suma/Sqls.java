package com.katta.suma;

public class Sqls {
	
	static final String INSERT_INTO_TABLE = "insert into Employee set name=?, age=?, experience=?, address=?,createdTime=CURRENT_TIME,modifiedTime=CURRENT_TIME,email=?,phno=?,Active=? on duplicate key update name=values(name), age = values(age),experience=values(experience), address=values(address),createdTime=values(createdTime),modifiedTime=values(modifiedTime),email=values(email),phno=values(phno),Active=values(Active)";
	static final String SELECT_AN_EMPLOYEE ="select * from Employee where name = ?";
	static final String SELECT_ALL_THE_EMPLOYEES = "select * from Employee where Active=1";
	static final String SELECT_ALL_EMPLOYEES = "select * from Employee order by modifiedTime DESC";
	static final String SELECT_ALL_THE_DEMPLOYEES = "select * from Employee where Active = 0";
	static final String UPDATE_AN_EMPLOYEE = "update Employee set Active = ?,modifiedTime = CURRENT_TIME where name = ?";
	static final String INSERT_INTO_TABLE1 = "insert into Education (name,tenth,inter,btech) values (?,?, ?, ?)";
	static final String SELECT_EDU = "select * from Education where name = ?";
	static final String DROP_AN_EMPLOYEE ="delete from Employee where name=?";
}
