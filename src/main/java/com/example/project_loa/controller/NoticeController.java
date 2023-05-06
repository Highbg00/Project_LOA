package com.example.project_loa.controller;

import com.example.project_loa.common.CommonService;
import com.example.project_loa.member.MemberVO;
import com.example.project_loa.notice.NoticePage;
import com.example.project_loa.notice.NoticeReplyVO;
import com.example.project_loa.notice.NoticeServiceImpl;
import com.example.project_loa.notice.NoticeVO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;

import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.File;

@Controller
public class NoticeController {

    @Autowired private NoticeServiceImpl service;
    @Autowired private NoticePage page;
    @Autowired private CommonService common;

    @RequestMapping("/reply_insert.no")
    public String reply_insert(NoticeVO vo, MultipartFile file, HttpSession session){
        if( ! file.isEmpty()){
            vo.setFilename(file.getOriginalFilename());
            vo.setFilepath( common.fileUpload("notice", file, session));
        }

        vo.setWriter(((MemberVO)session.getAttribute("loginInfo")).getId());
        service.notice_reply_insert(vo);
        return "redirect:list.no";
    }

    @RequestMapping ("/reply.no")
    public String reply(int id, Model model) {

        model.addAttribute("vo", service.notice_detail(id));
        return "notice/reply";
    }

    @RequestMapping ("/update.no")
    public String update(NoticeVO vo, String attach
            , MultipartFile file, HttpSession session ) {


        NoticeVO notice = service.notice_detail(vo.getId());
        String uuid = session.getServletContext().getRealPath("resources")
                + "/" + notice.getFilepath();


        if (! file.isEmpty() ) {

            vo.setFilename(file.getOriginalFilename());
            vo.setFilepath( common.fileUpload("notice", file, session)  );


            if ( notice.getFilename() != null ) {
                File f = new File(uuid);
                if (f.exists())  f.delete();
            }
        } else {

            if ( attach.isEmpty() ) {
                if (notice.getFilename() != null) {
                    File f = new File(uuid);
                    if (f.exists())  f.delete();
                }
            } else {

                vo.setFilename(notice.getFilename());
                vo.setFilepath(notice.getFilepath());
            }
        }


        service.notice_update(vo);
        return "redirect:detail.no?id=" + vo.getId();
    }

    @RequestMapping ("/modify.no")
    public String modify(int id, Model model) {

        model.addAttribute("vo", service.notice_detail(id));
        return "notice/modify";
    }

    @RequestMapping ("/delete.no")
    public String delete(int id, HttpSession session) {
        NoticeVO notice = service.notice_detail(id);
        String uuid = session.getServletContext().getRealPath("resources")
                + "/" + notice.getFilepath();
        if ( notice.getFilename() != null ) {
            File file = new File(uuid);
            if (file.exists()) file.delete();
        }


        service.notice_delete(id);
        return "redirect:list.no";
    }

    @RequestMapping ("/download.no")
    public void download(int id, HttpSession session, HttpServletResponse response) {
        NoticeVO notice = service.notice_detail(id);
        common.fileDownload(notice.getFilename(), notice.getFilepath(), session, response);
    }

    @RequestMapping ("/detail.no")
    public String detail(int id, Model model) {

        service.notice_read(id);

        model.addAttribute("replylist", service.reply_list(id));
        model.addAttribute("vo", service.notice_detail(id));
        model.addAttribute("crlf", "\r\n");


        model.addAttribute("page", page);

        return "notice/detail";
    }

    @RequestMapping ("/insert.no")
    public String insert(NoticeVO vo, MultipartFile file, HttpSession session) {

        vo.setWriter( ((MemberVO) session.getAttribute("loginInfo")).getId() );

        if ( ! file.isEmpty() ) {

            vo.setFilename( file.getOriginalFilename());
            vo.setFilepath(common.fileUpload("notice", file, session));	//
        }


        service.notice_insert(vo);
        return "redirect:list.no";
    }

    @RequestMapping ("/list.no")
    public String list(HttpSession session, @RequestParam(defaultValue = "1")
    int curPage, Model model, String search, String keyword) {

        session.setAttribute("category", "no");

        page.setCurPage(curPage);
        page.setSearch(search);
        page.setKeyword(keyword);

        model.addAttribute("page", service.notice_list(page));

        return "notice/list";
    }

    @RequestMapping ("/new.no")
    public String notice() {
        return "notice/new";
    }

    @RequestMapping("/replyinsert.no")
    public String reply_insert(NoticeReplyVO vo, HttpSession session){
        vo.setWriter(((MemberVO) session.getAttribute("loginInfo")).getId() );

        service.reply_insert(vo);
        service.notice_replycnt_modify(vo.getNotice_id());
        return "redirect:detail.no?id=" + vo.getNotice_id();
    }
}
