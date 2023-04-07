package com.example.project_loa.notice;

import com.example.project_loa.repository.NoticeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class NoticeServiceImpl implements NoticeService {

	@Autowired private NoticeRepository dao;
	
	@Override
	public void notice_insert(NoticeVO vo) {
		dao.notice_insert(vo);
	}

	@Override
	public List<NoticeVO> notice_list() {
		return dao.notice_list();
	}

	@Override
	public NoticeVO notice_detail(int id) {
		return dao.notice_detail(id);
	}

	@Override
	public void notice_update(NoticeVO vo) {
		dao.notice_update(vo);
	}

	@Override
	public void notice_delete(int id) {
		dao.notice_delete(id);
	}

	@Override
	public void notice_read(int id) {
		dao.notice_read(id);
	}

	@Override
	public NoticePage notice_totallist(NoticePage page) {
		return dao.notice_totallist(page);
	}

	@Override
	public void notice_reply_insert(NoticeVO vo) {
		dao.notice_reply_insert(vo);
	}

}
