package com.example.project_loa.controller;

import com.example.project_loa.member.MemberServiceImpl;
import com.example.project_loa.member.MemberVO;
import lombok.extern.log4j.Log4j2;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpSession;

@Controller
@Log4j2
public class MemberController {

    @Autowired private MemberServiceImpl service;

    @RequestMapping("/join")
    public String member_join(MemberVO vo) {

        service.member_join(vo);

        return "redirect:/";
    }

    @RequestMapping ("/member")
    public String member(HttpSession session) {
        // 타이틀에 회원가입이라는 문구를 보여주기 위해서
        session.setAttribute("category", "join");
        return "member/join";
    }

    @ResponseBody
    @RequestMapping ("/id_check")
    public boolean id_check(String id) {
        return service.member_id_check(id);
    }
}
