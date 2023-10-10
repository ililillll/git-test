package com.board.service;

import java.util.Collections;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.board.domain.WorkDTO;
import com.board.mapper.WorkMapper;

@Service
@Transactional
public class WorkServiceImpl implements WorkService {

  @Autowired
  private WorkMapper wm;
  
  @Override
  public boolean registerWork(WorkDTO params) {
	  int queryResult = 0;
	  if (wm.selectEmployee(params)==null) {return false;}
	  
	  WorkDTO result = wm.selectWork(params);
	  
	  if (result == null) {queryResult = wm.insertWork(params);
	  } else {
		  if (result.getWorkOff() == null) {
			  queryResult = wm.updateWork(params);
		  } else {
			  queryResult = wm.insertWork(params);
		  }
	  }		  
	  return (queryResult == 1) ? true : false;
  }
  
  @Override
  public List<WorkDTO> getWorkList(WorkDTO params) { //관리자
    List<WorkDTO> workList = Collections.emptyList();
    workList = wm.selectWorkList(params);
    return workList;
  }
  @Override
  public List<WorkDTO> getWorkList2(WorkDTO params) { //사용자
	  List<WorkDTO> workList = Collections.emptyList();
	  workList = wm.selectWorkList2(params);
	  return workList;
  }

	@Override
	public boolean selectEmployee(WorkDTO params) {
		WorkDTO result = wm.selectEmployee(params);
		
		if(result == null) {return false;}
		else {return true;}
	}

  
}