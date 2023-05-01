package com.example.project_loa.notice;

import com.example.project_loa.common.PageVO;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class NoticePage extends PageVO {
	
	private List<NoticeVO> list;

	public List<NoticeVO> getList() {
		return list;
	}

	public void setList(List<NoticeVO> list) {
		this.list = list;
	}		
}
