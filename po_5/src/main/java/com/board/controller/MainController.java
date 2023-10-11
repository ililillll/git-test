package com.board.controller;

import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;

import com.board.domain.EmployeeDTO;
import com.board.domain.UserDTO;
import com.board.paging.Criteria;
import com.board.service.EmployeeService;

@Controller
public class MainController {
	static boolean value; 
	
//	Main------------------------------------------------------------  
  @GetMapping("/main") 
  public String main(Model model, HttpSession session){
	  UserDTO loggedInUser = (UserDTO)session.getAttribute("loggedInUser");
	  model.addAttribute("user", loggedInUser);
	
	  return "project/공통/메인";
  }
  @GetMapping("/myInfo") 
  public String myInfo(Model model, HttpSession session){
	  UserDTO loggedInUser = (UserDTO)session.getAttribute("loggedInUser");
	  model.addAttribute("user", loggedInUser);
	
	  return "project/공통/내정보";
  }
  
//  Board--------------------------------------------------------------------  
  @GetMapping("/board") 
  public String board(){
	  return "project/공통/게시판";
  }
  @GetMapping("/write") 
  public String write(){
	  return "project/공통/게시글작성";
  }

// --------------------------------------------------------------------  
  public Map<String, Object> getPagingParams(Criteria criteria) {

    Map<String, Object> params = new LinkedHashMap<>();
    params.put("currentPageNo", criteria.getCurrentPageNo());
    params.put("recordsPerPage", criteria.getRecordsPerPage());
    params.put("pageSize", criteria.getPageSize());
    params.put("searchType", criteria.getSearchType());
    params.put("searchKeyword", criteria.getSearchKeyword());

    return params;
  }

}