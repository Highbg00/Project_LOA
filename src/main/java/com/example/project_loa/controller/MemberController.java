package com.example.project_loa.controller;

import com.example.project_loa.common.CommonService;
import com.example.project_loa.member.MemberServiceImpl;
import com.example.project_loa.member.MemberVO;
import lombok.extern.log4j.Log4j2;
import org.json.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpSession;
import java.util.HashMap;
import java.util.UUID;

@Controller
@Log4j2
public class MemberController {

    @Autowired private MemberServiceImpl service;

    @Autowired private CommonService common;

    private String naver_client_id = "__C0ZrY2Fgz292IoT25e";

    private String kakao_client_id = "9ffbe4a90ddce03b83ab9773dc02a048";

    @RequestMapping("/join")
    public String member_join(MemberVO vo) {

        service.member_join(vo);

        return "redirect:/";
    }

    @RequestMapping ("/member")
    public String member(HttpSession session) {
        return "member/join";
    }

    @ResponseBody
    @RequestMapping ("/id_check")
    public boolean id_check(String id) {
        return service.member_id_check(id);
    }

    @ResponseBody
    @RequestMapping ("/memberLogin")
    public boolean login(String id, String pw, HttpSession session) {

        HashMap<String, String> map = new HashMap<String, String>();
        map.put("id", id);
        map.put("pw", pw);
        MemberVO vo = service.member_login(map);

        session.setAttribute("loginInfo", vo);

        return vo == null ? false : true;
    }

    @RequestMapping ("/login")
    public String login(HttpSession session) {
        session.setAttribute("category", "login");
        return "member/login";
    }

    @RequestMapping ("/logout")
    public String logout(HttpSession session) {
        session.removeAttribute("loginInfo");

        return "redirect:/";
    }

    @GetMapping("/naverLogin")
    public String naverLogin( HttpSession session ) {

        String state = UUID.randomUUID().toString();

        session.setAttribute("state", state);


        StringBuffer url = new StringBuffer("https://nid.naver.com/oauth2.0/authorize?response_type=code");
        url.append("&client_id=").append(naver_client_id);
        url.append("&state=").append(state);
        url.append("&redirect_uri=http://localhost:8080/navercallback");
        System.out.println(url.toString());
        return "redirect:" + url.toString();

    }

    @RequestMapping ("/navercallback")
    public String navercallback(@RequestParam(required = false) String code, String state
            , @RequestParam(required = false) String error, HttpSession session ) {

        if ( !state.equals(session.getAttribute("state")) || error != null ) {
            return "redirect:/";	// 메인 페이지로 이동
        }

        StringBuffer url = new StringBuffer("https://nid.naver.com/oauth2.0/token?grant_type=authorization_code");
        url.append("&client_id=").append(naver_client_id);
        url.append("&client_secret=ElN15NYRu2");
        url.append("&code=").append(code);
        url.append("&state=").append(state);

        JSONObject json = new JSONObject(common.requestAPI(url));
        String token = json.getString("access_token");
        String type = json.getString("token_type");


        url = new StringBuffer("https://openapi.naver.com/v1/nid/me");
        json = new JSONObject(common.requestAPI(url, type + " " + token));

        if (json.getString("resultcode").equals("00")) {
            json = json.getJSONObject("response");

            MemberVO vo = new MemberVO();


            vo.setSocial_type("naver");
            vo.setId(json.getString("id"));
            vo.setEmail(json.getString("email"));
            vo.setName(json.getString("name"));
            vo.setGender(json.has("gender") && json.getString("gender").equals("F") ? "여" : "남");

            if ( service.member_social_email(vo) )
                service.member_social_update(vo);
            else
                service.member_social_insert(vo);

            // vo 에 담은 데이터를 session 의 loginInfo 에 담음
            session.setAttribute("loginInfo", vo);
        }

//		{
//			"resultcode": "00",
//			"message": "success",
//			"response": {
//			    "email": "openapi@naver.com",
//			    "nickname": "OpenAPI",
//			    "profile_image": "https://ssl.pstatic.net/static/pwe/address/nodata_33x33.gif",
//			    "age": "40-49",
//			    "gender": "F",
//			    "id": "32742776",
//			    "name": "오픈 API",
//			    "birthday": "10-01"
//			}
//		}

        return "redirect:/";
    }

    // 카카오 로그인 요청
    @RequestMapping("/kakaoLogin")
    public String kakaoLogin (HttpSession session) {

        String state = UUID.randomUUID().toString();

        session.setAttribute("state", state);

        StringBuffer url = new StringBuffer("https://kauth.kakao.com/oauth/authorize?response_type=code");
        url.append("&client_id=").append(kakao_client_id);
        url.append("&state=").append(state);
        url.append("&redirect_uri=http://localhost:8080/kakaocallback");
        return "redirect:" + url.toString();
    }

    @RequestMapping ("/kakaocallback")
    public String kakaocallback(HttpSession session, String code, String state, String error) {

        if ( !state.equals(session.getAttribute("state")) || error != null ) {
            return "redirect:/";
        }


        // 접근 토근발급 요청 : 토큰받기 (Sample - Request)
//		curl -v -X POST "https://kauth.kakao.com/oauth/token" \
//		 -H "Content-Type: application/x-www-form-urlencoded" \
//		 -d "grant_type=authorization_code" \
//		 -d "client_id=${REST_API_KEY}" \
//		 --data-urlencode "redirect_uri=${REDIRECT_URI}" \
//		 -d "code=${AUTHORIZE_CODE}"

        StringBuffer url = new StringBuffer("https://kauth.kakao.com/oauth/token?grant_type=authorization_code");
        url.append("&client_id=").append(kakao_client_id);
        url.append("&redirect_uri=http://localhost:8080/kakaocallback");
        url.append("&code=").append(code);

        JSONObject json = new JSONObject(common.requestAPI(url));

        String type = json.getString("token_type");
        String token = json.getString("access_token");


        url = new StringBuffer("https://kapi.kakao.com/v2/user/me");

        json = new JSONObject(common.requestAPI(url, type + " " + token));

        if (! json.isEmpty() ) {	// json 안에 값이 있다면.. 저장처리..
            MemberVO vo = new MemberVO();
            vo.setSocial_type("kakao");
            vo.setId(json.get("id").toString() );

            json = json.getJSONObject("kakao_account");
            vo.setEmail( json.getString("email") ) ;

            vo.setName( json.getJSONObject("profile").getString("nickname") );
            vo.setGender( json.has("gender") && json.getString("gender").equals("female") ? "여" : "남");

            if ( service.member_social_email(vo) )
                service.member_social_update(vo);
            else
                service.member_social_insert(vo);


            session.setAttribute("loginInfo", vo);
        }

//		{
//		    "id":123456789,
//		    "kakao_account": {
//		        "profile_needs_agreement": false,
//		        "profile": {
//		            "nickname": "홍길동",
//		            "thumbnail_image_url": "http://yyy.kakao.com/.../img_110x110.jpg",
//		            "profile_image_url": "http://yyy.kakao.com/dn/.../img_640x640.jpg",
//		            "is_default_image":false
//		        },
//		        "name_needs_agreement":false,
//		        "name":"홍길동",
//		        "email_needs_agreement":false,
//		        "is_email_valid": true,
//		        "is_email_verified": true,
//		        "email": "sample@sample.com",
//		        "age_range_needs_agreement":false,
//		        "age_range":"20~29",
//		        "birthday_needs_agreement":false,
//		        "birthday":"1130",
//		        "gender_needs_agreement":false,
//		        "gender":"female"
//		    },
//		    "properties":{
//		        "nickname":"홍길동카톡",
//		        "thumbnail_image":"http://xxx.kakao.co.kr/.../aaa.jpg",
//		        "profile_image":"http://xxx.kakao.co.kr/.../bbb.jpg",
//		        "custom_field1":"23",
//		        "custom_field2":"여"
//		        ...
//		    }
//		}

        return "redirect:/calendar.do";
    }

}
