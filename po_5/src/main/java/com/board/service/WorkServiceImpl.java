package com.board.service;

import java.util.Collections;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.board.domain.WorkDTO;
import com.board.mapper.WorkMapper;
import com.board.paging.PaginationInfo;

@Service
@Transactional
public class WorkServiceImpl implements WorkService {

  @Autowired
  private WorkMapper wm;
  
  @Override
  public boolean registerWork(WorkDTO params) {
	  int queryResult = 0;
	  if (wm.selectEmp(params)==null) {return false;}
	  
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
    int workTotalCount = wm.selectWorkTotalCount(params);
    
    PaginationInfo paginationInfo = new PaginationInfo(params);
    paginationInfo.setTotalRecordCount(workTotalCount);
   
    params.setPaginationInfo(paginationInfo);

    if (workTotalCount > 0) {
      workList = wm.selectWorkList3(params);
    }
    return workList;
  }
//  @Override
//  public List<WorkDTO> getWorkList2(WorkDTO params) { //사용자
//	  List<WorkDTO> workList = Collections.emptyList();
//	  workList = wm.selectWorkList2(params);
//	  return workList;
//  }
	@Override
	public boolean selectEmp(WorkDTO params) {
		WorkDTO result = wm.selectEmp(params);
		
		if(result == null) {return false;}
		else {return true;}
	}

  
}