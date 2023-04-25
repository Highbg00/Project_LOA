package com.example.project_loa.repository;

import com.example.project_loa.notice.NoticePage;
import com.example.project_loa.notice.NoticeVO;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
public interface NoticeRepository {
    void notice_insert(NoticeVO vo);

    List<NoticeVO> notice_list(NoticePage page);

    List<NoticeVO> notice_list();

    NoticeVO notice_detail(int id);

    void notice_update(NoticeVO vo);

    void notice_delete(int id);

    void notice_read(int id);

    int notice_totallist(NoticePage page);

    void notice_reply_insert(NoticeVO vo);
}
