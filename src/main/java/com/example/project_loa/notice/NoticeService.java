package com.example.project_loa.notice;

import java.util.List;

public interface NoticeService {
	
	void notice_insert(NoticeVO vo);
	
	void notice_reply_insert(NoticeVO vo);
	
	List<NoticeVO> notice_list();
	
	NoticePage notice_list(NoticePage page);
	
	NoticeVO notice_detail(int id);

	void notice_update(NoticeVO vo);

	void notice_delete(int id);

	void notice_read(int id);

	List<NoticeReplyVO> reply_list(int id);

	void reply_insert(NoticeReplyVO vo);

	void notice_replycnt_modify(int notice_id);

}
