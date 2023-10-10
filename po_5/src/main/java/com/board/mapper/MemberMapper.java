package com.board.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;

import com.board.domain.DeptDTO;
import com.board.domain.MemberDTO;

@Mapper
public interface MemberMapper {
  public int insertMember(MemberDTO params);
  public MemberDTO selectMemberDetail(Long no);
  public int updateMember(MemberDTO params);
  public int deleteMember(Long no);
  public List<MemberDTO> selectMemberList(MemberDTO params);
  public int selectMemberTotalCount(MemberDTO params);
  public List<MemberDTO> allMember(); 

  public int insertDept(DeptDTO params);
}