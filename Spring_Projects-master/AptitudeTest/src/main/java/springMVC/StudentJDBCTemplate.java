package springMVC;

import java.util.List;
import javax.sql.DataSource;
import org.springframework.jdbc.core.JdbcTemplate;
public class StudentJDBCTemplate  implements StudentDAO{
	 private DataSource dataSource;
	   private JdbcTemplate jdbcTemplateObject;
	   
	   public void setDataSource(DataSource dataSource) {
	      this.dataSource = dataSource;
	      this.jdbcTemplateObject = new JdbcTemplate(dataSource);
	   }
	   public void create(String name, Integer marks) {
	      String SQL = "insert into Student (name, marks) values (?, ?)";
	      int update = jdbcTemplateObject.update( SQL, name, marks);
	      //System.out.println("Created Record Name = " + name + " Marks = " + marks);
	      return;
	   }
	   public Student getStudent(String name) {
	      String SQL = "select * from Student where name = ?";
	      Student student = jdbcTemplateObject.queryForObject(SQL, 
	         new Object[]{name}, new StudentMapper());
	      
	      return student;
	   }
	   public List<Student> listStudents() {
	      String SQL = "select * from Student";
	      List <Student> students = jdbcTemplateObject.query(SQL, new StudentMapper());
	      return students;
	   }
	   public void delete(Integer id) {
	      String SQL = "delete from Student where id = ?";
	      jdbcTemplateObject.update(SQL, id);
	      System.out.println("Deleted Record with ID = " + id );
	      return;
	   }
	   public void update(Integer id, Integer marks){
	      String SQL = "update Student set marks = ? where id = ?";
	      int update = jdbcTemplateObject.update(SQL, marks, id);
	      System.out.println("Updated Record with ID = " + id );
	      return;
	   }
}
