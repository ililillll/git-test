package com.board.domain;

import java.time.LocalDateTime;

import com.board.paging.Criteria;

import lombok.Getter;
import lombok.Setter;

@Getter @Setter
public class WorkDTO extends Criteria {
	private int num;
	private int no;
	private String name;
	private String jumin;
	private LocalDateTime workDate;
	private LocalDateTime workOn;
	private LocalDateTime workOff;
	private String workTime;
	

}
