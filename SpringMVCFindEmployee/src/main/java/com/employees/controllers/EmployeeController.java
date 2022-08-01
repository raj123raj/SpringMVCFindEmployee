package com.employees.controllers;

import java.sql.SQLException;
import java.util.StringTokenizer;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.SessionAttributes;
import org.springframework.web.servlet.ModelAndView;

import com.employees.beans.Employee;
import com.employees.dao.EmployeeDao;

@Controller
@SessionAttributes("employee")
public class EmployeeController {
	// @Autowired
	EmployeeDao dao;// will inject dao from xml file

	@Autowired
	public EmployeeController(EmployeeDao dao) {
		this.dao = dao;
	}
	
	@ModelAttribute("employee")
    public Employee getEmployee() {
        return new Employee();

    }

	// for searchform
	@RequestMapping("/employeesearchform")
	public String searchform(Model m) {
		m.addAttribute("command", new Employee());
		return "employeesearchform";
	}



	/* It provides search of employees in model object */
	@RequestMapping(value = "/searchEmployee", method = RequestMethod.POST)
	public ModelAndView searchEmployee(@ModelAttribute("employee") Employee employee) {

		ModelAndView mav = null;
		Employee employee1;
		try {
			employee1 = dao.getEmployeesByNameAndLocation(employee.getName(),employee.getLocation());
			mav = new ModelAndView("welcome");
			if (null != employee1) {
				System.out.println(employee1.getId() + "..." + employee1.getName() + ".." + employee1.getAvailableDays()
				+ "..chosen location.." + employee.getLocation());
				StringTokenizer st = new StringTokenizer(employee1.getAvailableDays(), ",");
				boolean isAvailable = false;
				while (st.hasMoreTokens()) {
					// System.out.println(st.nextToken());
					//if (st.nextToken().equalsIgnoreCase(employee.getAvailableDays())) {
						isAvailable = true;
						break;
					//}
				}
				
				mav.addObject("firstname", employee1.getName());
				if (isAvailable) {
					mav.addObject("availablity", "Available on");
				} else {
					mav.addObject("availablity", "Not Available on");
				}
				mav.addObject("day", employee1.getAvailableDays());
				mav.addObject("location", employee.getLocation());
			}
		else {
			mav.addObject("firstname", employee.getName());
			mav.addObject("availablity", "Not Available ");
			mav.addObject("location", employee.getLocation());
		}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		return mav;
	}

}