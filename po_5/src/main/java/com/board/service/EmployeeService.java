package com.board.service;

import java.util.List;

import com.board.domain.EmployeeDTO;
import com.board.domain.WorkDTO;

public interface EmployeeService {
	public List<EmployeeDTO> getEmployeeList(EmployeeDTO params);
	public boolean insertEmployee(EmployeeDTO params);
}
