package com.board.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataAccessException;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

import com.board.domain.EmployeeDTO;
import com.board.domain.UserDTO;
import com.board.service.EmployeeService;

@Controller
public class EmployeeController {
	
	@Autowired
	EmployeeService employeeService;
	
	@GetMapping("/HRM") 
	public String hrm(@ModelAttribute("employee") EmployeeDTO employee, Model model){
		  List<EmployeeDTO> employeeList = employeeService.getEmployeeList(employee);
		  model.addAttribute("employeeList", employeeList);
		  return "project/관리자/인사관리";
	}
	
	@GetMapping("/employee/add")
	public String employeeAdd() {
		return "project/관리자/직원추가";
	}
	
	@PostMapping("/employee/add") 
	public String employeeAdd(@ModelAttribute("employee") final EmployeeDTO employee, Model model){
	  try {
		  employeeService.insertEmployee(employee);
	    } catch (DataAccessException e) {
	    } catch (Exception e) {
	    }
	    return "redirect:/HRM";
	  }
	  
}
