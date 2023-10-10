package com.board.domain;

import lombok.Data;

@Data
public class MemberDTO extends CommonDTO {
	private   Long no;
	private String name;
	private String juminNum;
	private String telNum;
	private String email;
	private    int depNo;
	
	private String nickname;
	private String pw;
	private String adminpw;
}