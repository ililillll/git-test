package com.board;

import java.util.List;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import com.board.domain.DeptDTO;
import com.board.domain.EmployeeDTO;
import com.board.domain.WorkDTO;
import com.board.mapper.EmployeeMapper;
import com.board.mapper.WorkMapper;

@SpringBootTest
class MapperTests {

  @Autowired
  private EmployeeMapper em;

  @Test
  public void testDept() {
	  DeptDTO params = new DeptDTO();
	  params.setDepNo(3);
	  params.setDepName("테스트");
	  params.setJikup("테스트");
	  
	  em.insertDept(params);
  }
  
  @Test
  public void selectEmployee() {
	  EmployeeDTO params = new EmployeeDTO();
	  em.selectEmployeeList(params);
  }
  
  @Test
  public void selectEmployee2() {
	  EmployeeDTO params = new EmployeeDTO();
	  List<EmployeeDTO> dto = em.selectEmployeeList(params);
  }
  
  @Test
  public void testEmployee() {
	  EmployeeDTO params = new EmployeeDTO();
	  params.setDep("test");
	  params.setName("test");
	  params.setJumin("000000000000");
	  params.setTel("0000000000000");
	  params.setEmail("abc@korea.com");
	  em.insertEmployee(params);
  }
  
  
//--------------------------------------------------------------------------
  @Autowired
  private WorkMapper wm;
  
  @Test
  public void testSelectEmp() {
	  WorkDTO params = new WorkDTO();
	  params.setName("홍길동");
	  params.setJumin("1234567890123");
	  wm.selectEmp(params);
  }
  
  @Test
  public void testWorkOn() {
	  WorkDTO params = new WorkDTO();
	  params.setName("홍길동");
	  params.setJumin("1234567890123");
	  wm.insertWork(params);
  }
  @Test
  public void testWorkOff() {
	  WorkDTO params = new WorkDTO();
	  params.setName("test");
	  params.setJumin("000000000000 ");
	  wm.updateWork(params);
  }
  
  @Test
  public void testWorkList() {
	  WorkDTO params = new WorkDTO();
	  List<WorkDTO> workList = wm.selectWorkList(params);
	  
      for (WorkDTO work : workList) {
        System.out.println("=========================");
        System.out.println(work.getNum());
        System.out.println(work.getNo());
        System.out.println(work.getName());
        System.out.println(work.getWorkDate());
        System.out.println(work.getWorkOn());
        System.out.println(work.getWorkOff());
        System.out.println(work.getWorkTime());
        System.out.println("=========================");
      }
  }
  @Test
  public void testWorkList2() {
	  WorkDTO params = new WorkDTO();
	  params.setNo(15);
	  List<WorkDTO> workList = wm.selectWorkList2(params);
	  
	  for (WorkDTO work : workList) {
		  System.out.println("=========================");
		  System.out.println(work.getNum());
		  System.out.println(work.getNo());
		  System.out.println(work.getName());
		  System.out.println(work.getWorkDate());
		  System.out.println(work.getWorkOn());
		  System.out.println(work.getWorkOff());
		  System.out.println(work.getWorkTime());
		  System.out.println("=========================");
	  }
  }
  @Test
  public void testWork() {
	  WorkDTO params = new WorkDTO();
	  WorkDTO result = wm.selectWork(params);
	  
		  System.out.println("=========================");
		  System.out.println(result.getNo());
		  System.out.println(result.getWorkOn());
		  System.out.println(result.getWorkOff());
		  System.out.println("=========================");
	  }
  
//  @Test
//  public void testWork() {
//	  WorkDTO params = new WorkDTO();
//	  WorkDTO workList = wm.selectWork(params);
//	  
//	  for (WorkDTO work : workList) {
//		  System.out.println("=========================");
//		  System.out.println(work.getNo());
//		  System.out.println(work.getWorkOn());
//		  System.out.println(work.getWorkOff());
//		  System.out.println("=========================");
//	  }
//  }
//  
  
  
//  @Test
//  public void testSelectList() {
//    Criteria criteria = new Criteria();
//    criteria.setCurrentPageNo(3);
//    criteria.setRecordsPerPage(10);
//    criteria.setPageSize(10);
//
//    PaginationInfo paginationInfo = new PaginationInfo(criteria);
//
//    WorkDTO workDTO = new WorkDTO();
//    workDTO.setPaginationInfo(paginationInfo);
//
//    System.out.println("=========================");
//    System.out.println("CurrentPageNo=" + workDTO.getCurrentPageNo());
//    System.out.println("RecordsPerPage=" + workDTO.getRecordsPerPage());
//    System.out.println("PageSize=" + workDTO.getPageSize());
//
//    int workTotalCount = wm.selectWorkTotalCount(workDTO);
//
//    System.out.println("workTotalCount=" + workTotalCount);
//    System.out.println("=========================");
//
//    paginationInfo.setTotalRecordCount(workTotalCount);
//    workDTO.setPaginationInfo(paginationInfo);
//
//    if (workTotalCount > 0) {
//      List<WorkDTO> workList = wm.selectWorkList(workDTO);
//      if (CollectionUtils.isEmpty(workList) == false) {
//        for (WorkDTO work : workList) {
//          System.out.println("=========================");
//          System.out.println(work.getEmpNo());
//          System.out.println(work.getName());
//          System.out.println(work.getWorkDate());
//          System.out.println(work.getWorkOn());
//          System.out.println(work.getWorkOff());
//          System.out.println(work.getWorkTime());
//          System.out.println("=========================");
//        }
//      }
//    }
//  }
//
  
}
