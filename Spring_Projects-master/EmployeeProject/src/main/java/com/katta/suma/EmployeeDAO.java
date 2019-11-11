package com.katta.suma;

//import java.awt.List;
import java.util.List;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;

public class EmployeeDAO {
	@Autowired
	   private JdbcTemplate jdbcTemplateObject;
	   
		
	public int insert(Employee ee)
	{
		String sql = Sqls.INSERT_INTO_TABLE;
		return jdbcTemplateObject.update(sql,ee.getName(),ee.getAge(),ee.getExperience(),ee.getAddress(),ee.getEmail(),ee.getPhno(),1);

	}
	public int create(Education e,String name)
	{
		String sql = Sqls.INSERT_INTO_TABLE1;
		return jdbcTemplateObject.update(sql,name,e.getTenth(),e.getInter(),e.getBtech());
	
	}
	public JdbcTemplate getJdbcTemplateObject() {
		return jdbcTemplateObject;
	}
	public Education select(String name)
	{
		String sql = Sqls.SELECT_EDU;
		Education edu = jdbcTemplateObject.queryForObject(sql, 
		         new Object[]{name}, new BeanPropertyRowMapper<Education>(Education.class));
		return edu;
		
	}

	public void setJdbcTemplateObject(JdbcTemplate jdbcTemplateObject) {
		this.jdbcTemplateObject = jdbcTemplateObject;
		
	}

	public Employee getEmployee(String name) {
	      String sql = Sqls.SELECT_AN_EMPLOYEE;
	      Employee employee = jdbcTemplateObject.queryForObject(sql, 
	         new Object[]{name}, new BeanPropertyRowMapper<Employee>(Employee.class));
	      
	      return employee;
	   }
	   public List<Employee> listEmployees() {
	      String sql = Sqls.SELECT_ALL_THE_EMPLOYEES;
	      List <Employee> employees = jdbcTemplateObject.query(sql, new BeanPropertyRowMapper<Employee>(Employee.class));
	      return employees;
	   }
	   public List<Employee> listAllEmployees() {
		      String sql = Sqls.SELECT_ALL_EMPLOYEES;
		      List <Employee> employees = jdbcTemplateObject.query(sql, new BeanPropertyRowMapper<Employee>(Employee.class));
		      return employees;
		   }
	   public List<Employee> listDEmployees() {
		      String sql = Sqls.SELECT_ALL_THE_DEMPLOYEES;
		      List <Employee> employees = jdbcTemplateObject.query(sql, new BeanPropertyRowMapper<Employee>(Employee.class));
		      return employees;
		   }
	   public int delete(String  name){    
		    String sql= Sqls.UPDATE_AN_EMPLOYEE;    
		    return jdbcTemplateObject.update(sql,0,name);    
		}  
	   public int activate(String  name){    
		    String sql= Sqls.UPDATE_AN_EMPLOYEE;    
		    return jdbcTemplateObject.update(sql,1,name);    
		}  
	   public int update(Employee p){  
		    String sql="update Employee set age= ?, address= ?, experience= ?, modifiedTime= CURRENT_TIME where name= ?";  
		    return jdbcTemplateObject.update(sql,p.getAge(),p.getAddress(),p.getExperience(),p.getName());
	   }
	   public int drop(String name)
	   {
		   String sql = Sqls.DROP_AN_EMPLOYEE;
		   return jdbcTemplateObject.update(sql,name);
	   }

}
