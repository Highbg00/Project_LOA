package com.example.project_loa.notice;

import java.util.List;

public interface NoticeService {
	
	void notice_insert(NoticeVO vo);
	
	void notice_reply_insert(NoticeVO vo);
	
	List<NoticeVO> notice_list();
	
	NoticePage notice_totallist(NoticePage page);
	
	NoticeVO notice_detail(int id);
	void notice_update(NoticeVO vo);
	void notice_delete(int id);
	void notice_read(int id);
	
}
