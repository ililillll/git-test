package com.board.domain;

import lombok.Data;

@Data
public class UserDTO extends CommonDTO {
	private String nickname;
	private String pw;
	private String pw2; //confirm
	private String adminpw;
	private int employeeNo;
}
