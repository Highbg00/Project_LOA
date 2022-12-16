package com.example.project_loa.loa;

import com.example.project_loa.data.CommonData;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.apache.http.HttpResponse;
import org.apache.http.client.ResponseHandler;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.impl.client.BasicResponseHandler;
import org.apache.http.impl.client.HttpClientBuilder;
import org.springframework.stereotype.Service;
import org.apache.http.client.HttpClient;
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

        /*try {
            HttpClient client = HttpClientBuilder.create().build(); // HttpClient 생성
            HttpGet getRequest = new HttpGet(apiURL); //GET 메소드 URL 생성

            HttpResponse response = client.execute(getRequest);

            //Response 출력
            if (response.getStatusLine().getStatusCode() == 200) {
                ResponseHandler<String> handler = new BasicResponseHandler();
                String body = handler.handleResponse(response);
                vo = mapper.readValue(body, ProfileVO.class);
            }
            System.out.println(apiURL);
            System.out.println(response.toString());
        }
        catch (Exception e) {
            System.out.println(e.getMessage());
            // TODO: handle exception
        }*/

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
        }catch (Exception e){
            System.out.println(e);
        }
        return null;
    }
}
