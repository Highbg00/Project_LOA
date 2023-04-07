package com.example.project_loa.member;

import lombok.Data;

@Data
public class MemberVO {
    private String id, name, pw, addr, tel, gender, email, post, admin;
    private String birth;

    private String social_type, social_email;
}
