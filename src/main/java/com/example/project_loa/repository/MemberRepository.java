package com.example.project_loa.repository;

import com.example.project_loa.member.MemberVO;
import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface MemberRepository {
    public boolean member_join(MemberVO vo);
}
