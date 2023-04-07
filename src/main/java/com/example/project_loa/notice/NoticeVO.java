package com.example.project_loa.notice;

import lombok.Data;

import java.sql.Date;

@Data
public class NoticeVO {
	private int id, readcnt, no, root, step, indent;
	private String title, content, writer, name;
	private Date writedate;
	private String filename, filepath;
	
}
