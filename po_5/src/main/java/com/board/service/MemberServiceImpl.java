package com.board.service;

import java.util.Collections;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.board.domain.MemberDTO;
import com.board.mapper.MemberMapper;
import com.board.paging.PaginationInfo;

@Service
public class MemberServiceImpl implements MemberService {

  @Autowired
  private MemberMapper mm;

  public List<MemberDTO>allMember(){
	  return mm.allMember();
  }
  
  @Override
  public boolean registerMember(MemberDTO params) {
    int queryResult = 0;

    if (params.getNo() == null) {
      queryResult = mm.insertMember(params);
    } else {
      queryResult = mm.updateMember(params);
    }
    return (queryResult == 1) ? true : false;
  }
  
  @Override
  public MemberDTO getMemberDetail(Long no) {
    return mm.selectMemberDetail(no);
  }

  @Override
  public boolean deleteMember(Long no) {
    int queryResult = 0;

    MemberDTO md = mm.selectMemberDetail(no);

    if (md != null && "N".equals(md.getDeleteYn())) {
      queryResult = mm.deleteMember(no);
    }

    return (queryResult == 1) ? true : false;
  }

@Override
public List<MemberDTO> getMemberList(MemberDTO params) {
	 List<MemberDTO> memberList = Collections.emptyList();

	    int memberTotalCount = mm.selectMemberTotalCount(params);

	    PaginationInfo paginationInfo = new PaginationInfo(params);
	    paginationInfo.setTotalRecordCount(memberTotalCount);

	    params.setPaginationInfo(paginationInfo);

	    if (memberTotalCount > 0) {
	      memberList = mm.selectMemberList(params);
	    }

	    return memberList;
}


}