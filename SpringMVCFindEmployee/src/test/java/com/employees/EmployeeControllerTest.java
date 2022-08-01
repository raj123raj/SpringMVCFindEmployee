package com.employees;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.MockitoAnnotations;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.web.WebAppConfiguration;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;
import org.springframework.web.context.WebApplicationContext;

import com.employees.beans.Employee;
import com.employees.controllers.EmployeeController;
import com.employees.dao.EmployeeDao;
@ContextConfiguration(locations = { "file:src/main/webapp/WEB-INF/spring-servlet.xml" })


@RunWith(SpringJUnit4ClassRunner.class)
@WebAppConfiguration
public class EmployeeControllerTest {
	@InjectMocks
    private EmployeeController employeeController;
 
    private MockMvc mockMvc;

    @Autowired
    private EmployeeDao dao;
    
    @Autowired
    WebApplicationContext webApplicationContext;

    
    @Before
    public void setup() {
        MockitoAnnotations.initMocks(this);
        this.mockMvc = MockMvcBuilders.standaloneSetup(employeeController).build();
        
    }
 
    @Test
    //404 error thrown when coming from invalid resources
    public void testCreateSearchEmployeesPageFormInvalidUser() throws Exception {
        this.mockMvc.perform(get("/"))
        .andExpect(status().isNotFound());
    }
   
    	
	  @Test 
	  //positive testcase
	  public void testSearchEmployeesByNameAndCheckAvailability() throws Exception { 
		  Employee employee = new Employee(); 
		  employee.setName("EmployeeA"); 
		  employee.setLocation("Location1"); 
		  employee = dao.getEmployeesByNameAndLocation(employee.getName(),employee.getLocation());
		  Assert.assertEquals(1, employee.getId());
		  Assert.assertEquals("Monday,Tuesday,Friday", employee.getAvailableDays());
	  }
	  @Test 
	  //Negative testcase
	  public void testSearchEmployeesByNameAndCheckAvailabilityWithNotEqualsValues() throws Exception { 
		  Employee employee = new Employee(); 
		  employee.setName("EmployeeA"); 
		  employee.setLocation("Location2"); 
		  employee = dao.getEmployeesByNameAndLocation(employee.getName(),employee.getLocation());
		  Assert.assertNotEquals(10, employee.getId());
		  Assert.assertNotEquals("Tuesday,Thursday", employee.getAvailableDays());
	  }

	  @Test 
	  //Negative  testcase i.e. Given gender as Male and available days as Saturday
	  public void testSearchEmployeesByGender() throws Exception { 
		  Employee employee = new Employee(); 
		  employee.setGender("Male"); 
		  employee.setAvailableDays("Saturday,Sunday"); 
		  employee = dao.getEmployeesByGender(employee.getGender(),employee.getAvailableDays());
		  Assert.assertEquals(4, employee.getId());
		  Assert.assertNotEquals("EmployeeB", employee.getName());
		  Assert.assertNotEquals(1, employee.getExperience());
	  }
	  
	  @Test 
	  //Negative  testcase i.e. Given gender as Male and available days as Saturday
	  public void testSearchEmployeesByGenderWithCorrectResults() throws Exception { 
		  Employee employee = new Employee(); 
		  employee.setGender("Male"); 
		  employee.setAvailableDays("Saturday,Sunday"); 
		  employee = dao.getEmployeesByGender(employee.getGender(),employee.getAvailableDays());
		  Assert.assertEquals(4, employee.getId());
		  Assert.assertNotEquals("EmployeeB", employee.getName());
		  Assert.assertNotEquals(1, employee.getExperience());
	  }
	  
	  @Test 
	  //Negative  testcase i.e. giving experience as 4 years and checking
	  //as the name of the doctor to be DoctorE instead of DoctorD 
	  public void testSearchEmployeesByExperience() throws Exception { 
		  Employee employee = new Employee(); 
		  employee.setExperience(4); 
		  employee = dao.getEmployeesByExperience(employee.getExperience());
		  Assert.assertEquals(4, employee.getId());
		  Assert.assertNotEquals("EmployeeF", employee.getName());
	  }
	  
	  @Test 
	  public void testSearchEmployeesByQualification() throws Exception { 
		  Employee employee = new Employee(); 
		  employee.setQualification("MBA"); 
		  employee.setAvailableDays("Saturday,Sunday"); 
		  employee = dao.getEmployeesByQualification(employee.getQualification(),employee.getAvailableDays());
		  Assert.assertEquals(4, employee.getId());
		  Assert.assertEquals("EmployeeD", employee.getName());
		  Assert.assertNotEquals(15, employee.getExperience());
	  }
	  

	 
    	
    }
	


