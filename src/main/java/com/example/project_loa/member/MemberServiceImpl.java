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
        return dao.member_join(vo) == 1 ? true : false;
    }

    @Override
    public MemberVO member_login(HashMap<String, String> map) {
        return dao.member_login(map);
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
        return dao.member_id_check(id) == 0 ? true : false;
    }

    @Override
    public boolean member_social_email(MemberVO vo) {
        return dao.social_email(vo) == 0 ? false : true ;
    }

    @Override
    public boolean member_social_insert(MemberVO vo) {
        return dao.social_insert(vo) == 0 ? false : true;
    }

    @Override
    public boolean member_social_update(MemberVO vo) {
        return dao.social_update(vo) == 0 ? false : true;
    }
}
