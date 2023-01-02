package com.example.project_loa.controller;

import com.example.project_loa.loa.LoaServiceImpl;

import com.example.project_loa.loa.Profile2VO;
import com.example.project_loa.loa.ProfileVO;
import lombok.extern.log4j.Log4j2;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@Log4j2
public class LoaController {

    @Autowired private LoaServiceImpl service;
    Profile2VO vo2;
    @RequestMapping("/search")
    public String search(String userid, Model model) {
        System.out.println(userid);
        String str = null;
        ProfileVO vo = service.Search(userid);

        vo2.setCharacterName(vo.getCharacterName());
        vo2.setCharacterImage(vo.getCharacterImage());
        vo2.setPvpGradeName(vo.getPvpGradeName());
        vo2.setTownName(vo.getTownName());
        vo2.setTitle(vo.getTitle());
        vo2.setGuildMemberGrade(vo.getGuildMemberGrade());
        vo2.setGuildName(vo.getGuildName());
        vo2.setServerName(vo.getServerName());
        vo2.setCharacterClassName(vo.getCharacterClassName());
        vo2.setItemAvgLevel(vo.getItemAvgLevel());
        vo2.setCharacterLevel(vo.getCharacterLevel());
        vo2.setTownLevel(vo.getTownLevel());
        vo2.setExpeditionLevel(vo.getExpeditionLevel());
        model.addAttribute("vo", vo2);
        return "main/search";
    }
}
