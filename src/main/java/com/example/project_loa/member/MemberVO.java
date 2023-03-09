package com.example.project_loa.member;

import lombok.Data;

@Data
public class MemberVO {
    private String id, name, pw, addr, tel, gender, email, post, admin;
    private String birth;

    // social_type : 소셜 로그인 형태가 네이버인지 카카오인지 구분할 필드명
    // social_email : 소셜 이메일 값을 저장할 필드명
    private String social_type, social_email;
}
