package com.board.service;

import java.util.List;

import com.board.domain.MemberDTO;

public interface MemberService {
	  public boolean registerMember(MemberDTO params);

	  public MemberDTO getMemberDetail(Long no);
	  
	  public boolean deleteMember(Long no);
	  
	  public List<MemberDTO> getMemberList(MemberDTO params);

	public List<MemberDTO> allMember();
}
