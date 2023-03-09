package com.example.project_loa.member;

import com.example.project_loa.repository.MemberRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.HashMap;

@Service
public class MemberServiceImpl implements MemberService{

    @Autowired private MemberRepository dao;

    @Override
    public boolean member_join(MemberVO vo) {
        return dao.member_join(vo);
    }

    @Override
    public MemberVO member_login(HashMap<String, String> map) {
        return null;
    }

    @Override
    public boolean member_update(MemberVO vo) {
        return false;
    }

    @Override
    public boolean member_delete(String id) {
        return false;
    }

    @Override
    public boolean member_id_check(String id) {
        return false;
    }

    @Override
    public boolean member_social_email(MemberVO vo) {
        return false;
    }

    @Override
    public boolean member_social_insert(MemberVO vo) {
        return false;
    }

    @Override
    public boolean member_social_update(MemberVO vo) {
        return false;
    }
}
