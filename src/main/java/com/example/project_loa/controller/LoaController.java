package com.example.project_loa.controller;

import com.example.project_loa.loa.LoaServiceImpl;
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

    @RequestMapping("/search")
    public String search(String userid, Model model) {
        System.out.println(userid);
        String str = null;
        ProfileVO vo = service.Search(userid);
        return null;
    }
}
