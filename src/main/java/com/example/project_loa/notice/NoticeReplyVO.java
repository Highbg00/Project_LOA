package com.example.project_loa.notice;

import lombok.Data;

@Data
public class NoticeReplyVO {
    private int reply_id, notice_id, step;
    private String content, writer, name;
}
