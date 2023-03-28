package com.example.project_loa.repository;


import com.example.project_loa.member.MemberVO;
import org.apache.ibatis.annotations.Mapper;

import java.util.HashMap;

@Mapper
public interface MemberRepository {
    int member_join(MemberVO vo);

    int member_id_check(String id);

    MemberVO member_login(HashMap<String, String> map);

    int social_email(MemberVO vo);

    int social_insert(MemberVO vo);

    int social_update(MemberVO vo);
}
