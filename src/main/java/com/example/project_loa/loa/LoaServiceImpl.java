package com.example.project_loa.loa;

import com.example.project_loa.data.CommonData;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.google.gson.Gson;
import org.springframework.stereotype.Service;
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;
import java.net.URLEncoder;

@Service
public class LoaServiceImpl implements LoaService{
    @Override
    public ProfileVO Search(String userid) {
        ObjectMapper mapper = new ObjectMapper();

        ProfileVO vo = null;
        String header = "bearer " + CommonData.API_TOKEN;
        String apiURL = "https://developer-lostark.game.onstove.com/armories/characters/"+ URLEncoder.encode(userid) +"/profiles";

        try{
            URL url = new URL(apiURL);
            HttpURLConnection con = (HttpURLConnection) url.openConnection();
            con.setRequestMethod("GET");
            con.setRequestProperty("accept", "application/json");
            con.setRequestProperty("authorization", header);
            int responseCode = con.getResponseCode();
            BufferedReader br;
            if(responseCode==200) { // 정상 호출
                br = new BufferedReader(new InputStreamReader(con.getInputStream()));
            } else {  // 에러 발생
                br = new BufferedReader(new InputStreamReader(con.getErrorStream()));
            }
            String inputLine;
            StringBuffer response = new StringBuffer();
            while ((inputLine = br.readLine()) != null) {
                response.append(inputLine);
            }
            br.close();
            System.out.println(apiURL);
            System.out.println(response.toString());
            String str = response.toString();
            vo = new Gson().fromJson(str,ProfileVO.class);

        }catch (Exception e){
            System.out.println(e);
        }
        return vo;
    }
    @Override
    public Profile2VO Search2(String userid) {
        ObjectMapper mapper = new ObjectMapper();

        Profile2VO vo = null;
        String header = "bearer " + CommonData.API_TOKEN;
        String apiURL = "https://developer-lostark.game.onstove.com/armories/characters/"+ URLEncoder.encode(userid) +"/profiles";

        try{
            URL url = new URL(apiURL);
            HttpURLConnection con = (HttpURLConnection) url.openConnection();
            con.setRequestMethod("GET");
            con.setRequestProperty("accept", "application/json");
            con.setRequestProperty("authorization", header);
            int responseCode = con.getResponseCode();
            BufferedReader br;
            if(responseCode==200) { // 정상 호출
                br = new BufferedReader(new InputStreamReader(con.getInputStream()));
            } else {  // 에러 발생
                br = new BufferedReader(new InputStreamReader(con.getErrorStream()));
            }
            String inputLine;
            StringBuffer response = new StringBuffer();
            while ((inputLine = br.readLine()) != null) {
                response.append(inputLine);
            }
            br.close();
            System.out.println(apiURL);
            System.out.println(response.toString());
            String str = response.toString();
            vo = new Gson().fromJson(str,Profile2VO.class);

        }catch (Exception e){
            System.out.println(e);
        }
        return vo;
    }
}
