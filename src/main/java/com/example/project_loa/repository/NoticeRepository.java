package com.example.project_loa.repository;

import com.example.project_loa.notice.NoticePage;
import com.example.project_loa.notice.NoticeReplyVO;
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

    List<NoticeReplyVO> reply_list(int id);

    void reply_insert(NoticeReplyVO vo);

    void reply_modify(NoticeReplyVO vo);

    void notice_replycnt_modify(int notice_id);

}
