package com.example.project_loa.controller;

import com.example.project_loa.common.CommonService;
import com.example.project_loa.member.MemberServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;

@Controller
public class NoticeController {

    @Autowired private MemberServiceImpl service;

    @Autowired private CommonService common;


}
