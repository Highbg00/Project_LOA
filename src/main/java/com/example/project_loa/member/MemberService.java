package com.example.project_loa.member;

import java.util.HashMap;

public interface MemberService {

    boolean member_join(MemberVO vo);


    MemberVO member_login(HashMap<String, String> map);


    boolean member_update(MemberVO vo);


    boolean member_delete(String id);


    boolean member_id_check(String id);


    boolean member_social_email(MemberVO vo);


    boolean member_social_insert(MemberVO vo);

    
    boolean member_social_update(MemberVO vo);
}
