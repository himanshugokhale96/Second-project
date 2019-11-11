package com.katta.suma;




import java.io.IOException;
import java.io.BufferedOutputStream;
import java.io.File;
import java.io.FileOutputStream;
import java.io.OutputStream;
import java.util.ArrayList;
import java.util.List;
import java.util.Locale;

import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.commons.CommonsMultipartFile;

import jxl.Cell;
import jxl.CellView;
import jxl.Sheet;
import jxl.Workbook;
import jxl.WorkbookSettings;
import jxl.read.biff.BiffException;
import jxl.write.Colour;
import jxl.write.Label;
import jxl.write.Number;
import jxl.write.WritableCell;
import jxl.write.WritableCellFormat;
import jxl.write.WritableFont;
import jxl.write.WritableSheet;
import jxl.write.WritableWorkbook;
import jxl.write.WriteException;



@Controller
public class HomeController {
	private static final String EXCEL_FILE_LOCATION = "C:\\temp\\Employee.xls";
	String empName;
	@Autowired
	EmployeeDAO employeeDAO;
	@Autowired EmployeeManager employeeManager;
	
	@RequestMapping(value = "/", method = RequestMethod.GET)
	public String home() {
		System.out.println("inhome");
	
		
		return "home";
	}
	@RequestMapping("/signin")
	public String signin(@RequestParam("userName") String userName,@RequestParam("password") String password)
	{ 
		int i = employeeManager.validate(userName, password);
		if(i==1)
		{
			return "homepage";
		}
		else
			return "error";
			
		
							
	}
	
	@RequestMapping("/home")
	public String home2()
	{
		return "homepage";
	}
	
	@RequestMapping(value = "/sign", method = RequestMethod.GET)
	public String sign() {
	
		
		return "signin";
	}
	
	@RequestMapping(value = "/error", method = RequestMethod.GET)
	public String error() {
		
		return "signin";
	}
	@RequestMapping("/education")
	public String next(@ModelAttribute("education") Education e)
	{
		//System.out.println(em.getName());
		String employeeName=empName;
		employeeDAO.create(e,employeeName);
		return "redirect:/home";
	}
	
	
	@RequestMapping("/addEmp")    
    public String showform(Model m){    
        m.addAttribute("command", new Employee());  
        return "addEmpForm";   
    }    
	
	@RequestMapping("/addEmpForm")
	public String addEmpForm(@ModelAttribute("employee") Employee empl)
	{
		empName=empl.getName();
		employeeDAO.insert(empl);
		//return "redirect:/allEmp";
		return "education";

	}
	@RequestMapping("/viewEmp")
	public String viewEmp()
	{
		return "viewEmpForm";
	}
	@RequestMapping("/viewEmpForm")
	public String viewEmpForm(@RequestParam("empName") String name, Model mv)
	{
		
		Employee ee = employeeDAO.getEmployee(name);
		mv.addAttribute("employee",ee);
		return "details";

	}
	@RequestMapping("/viewDeactivated")
	public String viewDeactivated(Model mv)
	{
		List<Employee> dlist = employeeDAO.listDEmployees();   
        mv.addAttribute("dlist",dlist); 
		return "deactivated";
	}
	@RequestMapping("/activate/{name}")
	public String activate(@PathVariable String name)
	{
		employeeDAO.activate(name);
		return "redirect:/trial";
		//return "redirect:/allEmp";
	}
	
	@RequestMapping(value="/editemp/{name}")    
    public String edit(@PathVariable String name, Model m){
	
		Employee emp = employeeDAO.getEmployee(name);
		m.addAttribute("command",emp);
		return "empeditform";
    }    
	
	@RequestMapping(value="/save",method = RequestMethod.POST)    
    public String saveEmp(@ModelAttribute("emp") Employee emp) {
		employeeDAO.update(emp); 
        return "redirect:/allEmp";
    } 
       
	@RequestMapping("/viewAll")
	public String viewAll(Model mv)
	{
		 List<Employee> list=employeeDAO.listEmployees();    
	        mv.addAttribute("list",list);  
	        return "allEmployees";

	}
	@RequestMapping("/edu/{name}")
	public String educationDetails(@PathVariable String name,Model mv)
	{
		try {
		Education edu = employeeDAO.select(name);
		mv.addAttribute("edu", edu);
		}
		catch(Exception e)
		{
			mv.addAttribute("error", 1);
			return "edudisplay";
		}
		mv.addAttribute("error", 0);
		return "edudisplay";
	}
	@RequestMapping("/allEmp")
	public String allEmp(Model mv)
	{
		List<Employee> list=employeeDAO.listAllEmployees();  
        mv.addAttribute("list",list);
        return "allEmp";
	}
	@RequestMapping("/importPage")
	public String page(Model m)
	{
		int i=1;
		m.addAttribute("display",i);
		return "importPage";
	}
	@RequestMapping("/downloadTemp")
	public String importPage(HttpServletResponse response) throws IOException 
	{
		WritableWorkbook myFirstWbook = null;
		OutputStream out = response.getOutputStream();
		//1. Create an Excel file
		try {
		response.setHeader("Content-Disposition","attachment; filename=\"Employee_List_Template.xls\";");
		// response.setHeader("Content-Length", file.length()+"");
		
		response.setContentType("application/vnd.ms-excel");
		WorkbookSettings wbSettings = new WorkbookSettings();
		wbSettings.setLocale(new Locale("en", "EN"));
		myFirstWbook = Workbook.createWorkbook(out, wbSettings); 
		WritableSheet excelSheet = myFirstWbook.createSheet("Sheet 1", 0);
		 
		 WritableFont cellFont = new WritableFont(WritableFont.TIMES, 16);
        cellFont.setBoldStyle(WritableFont.BOLD);
        
        WritableCellFormat cellFormat = new WritableCellFormat(cellFont);
        
        //Table Columns
        WritableFont cellFont1 = new WritableFont(WritableFont.TIMES, 12);
        cellFont1.setBoldStyle(WritableFont.BOLD);
        
        WritableCell c = excelSheet.getWritableCell(0,0);
        WritableCellFormat cellFormat1 = new WritableCellFormat(cellFont1);
        cellFormat1.setBackground(Colour.YELLOW);
        c.setCellFormat(cellFormat1);
        
        // create an Excel sheet
		 
        Label label = new Label(0, 1, "EmpName",cellFormat1);
        excelSheet.addCell(label);
        label = new Label(1, 1, "EmpPhno",cellFormat1);
        excelSheet.addCell(label);
        label = new Label(2, 1, "EmpEmail",cellFormat1);
        excelSheet.addCell(label);
        label = new Label(3, 1, "EmpAge",cellFormat1);
        excelSheet.addCell(label);
        label = new Label(4, 1, "EmpExperience",cellFormat1);
        excelSheet.addCell(label);
        label = new Label(5, 1, "EmpAddress",cellFormat1);
        excelSheet.addCell(label);
        
        
        // autofiting the columns
        
        for(int x=0;x<7;x++)
        {
            CellView cell=excelSheet.getColumnView(x);
            cell.setAutosize(true);
            excelSheet.setColumnView(x, cell);
        }
        myFirstWbook.write();
		out.flush();
	    

	        } catch (IOException e) {
	            e.printStackTrace();
	        } catch (WriteException e) {
	            e.printStackTrace();
	        } finally {

	            if (myFirstWbook != null) {
	                try {
	                    myFirstWbook.close();
	                    out.close();
	                } catch (IOException e) {
	                    e.printStackTrace();
	                } catch (WriteException e) {
	                    e.printStackTrace();
	                }
	            }


	        }


	return "importPage";
	}
	@RequestMapping("/export")
	public String export(HttpServletResponse response) throws IOException
	{
		
		List<Employee> list=employeeDAO.listAllEmployees();  
		WritableWorkbook myFirstWbook = null;
		OutputStream out = response.getOutputStream();
		//1. Create an Excel file
		try {
			
			 response.setHeader("Content-Disposition","attachment; filename=\"Employee_List.xls\";");
				//	 response.setHeader("Content-Length", file.length()+"");
					
					//response.setContentType("application/vnd.ms-excel");
					response.setContentType("application/vnd.ms-excel");
					WorkbookSettings wbSettings = new WorkbookSettings();
					wbSettings.setLocale(new Locale("en", "EN"));
					myFirstWbook = Workbook.createWorkbook(out, wbSettings); 

		int i=2;
		 //myFirstWbook = Workbook.createWorkbook(new File(EXCEL_FILE_LOCATION));
         // create an Excel sheet
		 WritableSheet excelSheet = myFirstWbook.createSheet("Sheet 1", 0);
		 
		 WritableFont cellFont = new WritableFont(WritableFont.TIMES, 16);
         cellFont.setBoldStyle(WritableFont.BOLD);
         
         WritableCellFormat cellFormat = new WritableCellFormat(cellFont);
         
         //Table Columns
         WritableFont cellFont1 = new WritableFont(WritableFont.TIMES, 12);
         cellFont1.setBoldStyle(WritableFont.BOLD);
         
         WritableCell c = excelSheet.getWritableCell(0,0);
         WritableCellFormat cellFormat1 = new WritableCellFormat(cellFont1);
         cellFormat1.setBackground(Colour.YELLOW);
         c.setCellFormat(cellFormat1);
         
         // create an Excel sheet
		 
         Label label = new Label(0, 1, "EmpName",cellFormat1);
         excelSheet.addCell(label);
         label = new Label(1, 1, "EmpPhno",cellFormat1);
         excelSheet.addCell(label);
         label = new Label(2, 1, "EmpEmail",cellFormat1);
         excelSheet.addCell(label);
         label = new Label(3, 1, "EmpAge",cellFormat1);
         excelSheet.addCell(label);
         label = new Label(4, 1, "EmpExperience",cellFormat1);
         excelSheet.addCell(label);
         label = new Label(5, 1, "EmpAddress",cellFormat1);
         excelSheet.addCell(label);
         label = new Label(6, 1, "EmpCreatedTime",cellFormat1);
         excelSheet.addCell(label);
         label = new Label(7, 1, "EmpModifiedTime",cellFormat1);
         excelSheet.addCell(label);
         
         // autofiting the columns
         
         for(int x=0;x<8;x++)
         {
             CellView cell=excelSheet.getColumnView(x);
             cell.setAutosize(true);
             excelSheet.setColumnView(x, cell);
         }
          
		for (Employee record : list) {
	         
			        
			int col1 = 3;
        	int col2 = 5;
        	int row1 = 0;
        	int row2 = 0;

        	
	        	// add something into the Excel sheet
	            
			excelSheet.mergeCells(col1,row1,col2,row2); 
			excelSheet.addCell(new Label(col1,row1,"Employees List",cellFormat));

	            label = new Label(0, i, record.getName());
	            excelSheet.addCell(label);


	            
	            Number num = new Number(1, i, record.getPhno());
	            excelSheet.addCell(num);
	            
	            
	            label = new Label(2, i, record.getEmail());
	            excelSheet.addCell(label);
	            
	            num = new Number(3, i, record.getAge());
	            excelSheet.addCell(num);
	            
	            num = new Number(4, i, record.getExperience());
	            excelSheet.addCell(num);
	            
	            label = new Label(5, i, record.getAddress());
	            excelSheet.addCell(label);
	            
	            label = new Label(6, i, record.getCreatedTime());
	            excelSheet.addCell(label);
	            
	            label = new Label(7, i, record.getModifiedTime());
	            excelSheet.addCell(label);
	            
	            
            
	            i++;        
		}
		myFirstWbook.write();
		out.flush();
	    

	        } catch (IOException e) {
	            e.printStackTrace();
	        } catch (WriteException e) {
	            e.printStackTrace();
	        } finally {

	            if (myFirstWbook != null) {
	                try {
	                    myFirstWbook.close();
	                    out.close();
	                } catch (IOException e) {
	                    e.printStackTrace();
	                } catch (WriteException e) {
	                    e.printStackTrace();
	                }
	            }


	        }

	    
	

		return "null";
	}
	@RequestMapping("/trial")
	public String trial()
	{
		return "redirect:/allEmp";
	}
	@RequestMapping("delete")
	public String delete()
	{
		return "deleteEmp";
	}
	@RequestMapping("/deleteEmp")
	public String deleteEmp(@RequestParam("empName") String name)
	{
    employeeDAO.drop(name);
	return "redirect:/home";
	}
	@RequestMapping(value="/deleteemp/{name}",method = RequestMethod.GET)    
    public String delete(@PathVariable String name,Model mv){ 
		/* Date date = new Date();
		SimpleDateFormat dateFormat2 = new SimpleDateFormat("yyyy-MM-dd hh:mm:ss");
        String modifiedTime = dateFormat2.format(date);
        */
        employeeDAO.delete(name);    
        List<Employee> list=employeeDAO.listEmployees();    
        mv.addAttribute("list",list);
        //return "redirect:/viewDeactivated"; 
        return "redirect:/trial";
    }     
	@RequestMapping("/import")
	public String imprt(@RequestParam("file") String name,Model m)
	{
		Workbook workbook = null;
		String fname = "C:\\Users\\welcome\\Downloads\\"+name;
		  try
		  {
			  int flag;
            workbook = Workbook.getWorkbook(new File(fname));

            Sheet sheet = workbook.getSheet(0);
            
            List<Employee> list = new ArrayList<Employee>();
            
            for(int j=2;j<sheet.getRows();j++)
            {
            	Employee em = new Employee();
		        for(int i=0;i<sheet.getColumns();i++)
		        {
		        	//m.addAttribute("at",5);
		        	if(i==0)
		        	{
		        		Cell cell1 = sheet.getCell(i,j);
		        		em.setName(cell1.getContents());
		        		 if(em.getName().length()==0 || em.getName().isEmpty())  
		        		 {
		        			 m.addAttribute("null",0);
		        			 
		        		 }
		        		m.addAttribute("at",0);
		        	}
		        	if(i==1)
		        	{
		        		Cell cell1 = sheet.getCell(i,j);
		        		em.setPhno(Long.parseLong(cell1.getContents()));
		        		m.addAttribute("at",1);
		        	}
		        	if(i==2)
		        	{
		        		Cell cell1 = sheet.getCell(i,j);
		        		em.setEmail(cell1.getContents());
		        		m.addAttribute("at",2);
		        	}
		        	if(i==3)
		        	{
		        		Cell cell1 = sheet.getCell(i,j);
		        		em.setAge(Integer.parseInt(cell1.getContents()));
		        		m.addAttribute("at",3);
		        	}
		        	if(i==4)
		        	{
		        		Cell cell1 = sheet.getCell(i,j);
		        		em.setExperience(Integer.parseInt(cell1.getContents()));
		        		m.addAttribute("at",4);
		        	}
		        	if(i==5)
		        	{
		        		Cell cell1 = sheet.getCell(i,j);
		        		em.setAddress(cell1.getContents());
		        		m.addAttribute("at",5);
		        	}
		        	
			         
			     }
		        try
		        {
		        employeeDAO.insert(em);
		        list.add(em);
		        }
		        catch(Exception e)
		        {
		        	
		        }
	}
       m.addAttribute("list",list);
       m.addAttribute("success",1);
       m.addAttribute("display",1);
     
		}
		catch (Exception e) {
            e.printStackTrace();
            m.addAttribute("success",0);
        } /*catch (BiffException e) {
            e.printStackTrace();
        }*/ finally {

            if (workbook != null) {
                workbook.close();
            }

        }
		return "importPage";
	}

}  

