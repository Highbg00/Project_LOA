package com.example.project_loa.common;

import org.springframework.stereotype.Service;
import org.springframework.util.FileCopyUtils;
import org.springframework.web.multipart.MultipartFile;

import javax.servlet.ServletOutputStream;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;
import java.net.URLEncoder;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.UUID;

@Service
public class CommonService {
	

	public void fileDownload(String filename, String filepath, 
			HttpSession session, HttpServletResponse response) {

		File file = new File( session.getServletContext().getRealPath("resources") 
				+ "/" + filepath );

		String mime = session.getServletContext().getMimeType(filename);
		
		response.setContentType(mime);

		try {
			filename = URLEncoder.encode(filename, "utf-8").replaceAll("\\+", "%20");
		

			response.setHeader("content-disposition","attachment; filename=" + filename);
		
			ServletOutputStream out = response.getOutputStream();
			
			FileCopyUtils.copy(new FileInputStream(file), out);
			out.flush();
			
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}		
	}
	

	public String fileUpload(String category, MultipartFile file, HttpSession session) {

		String resources = session.getServletContext().getRealPath("resources");

		String folder = resources + "/upload/" + category + "/" 
						+ new SimpleDateFormat("yyyy/MM/dd").format(new Date());
		String uuid = UUID.randomUUID().toString() + "_" + file.getOriginalFilename();
		
		File dir = new File( folder );


		
		if ( ! dir.exists() )	dir.mkdirs();

			try {
				file.transferTo(new File( folder, uuid  ));

			} catch (Exception e) {
				e.printStackTrace();
			} 
		

		return folder.substring(resources.length() + 1) + "/" + uuid;
	}
	
	

	public String requestAPI(StringBuffer url, String property) {
		String result = "";
		try {

			HttpURLConnection con = (HttpURLConnection) new URL(url.toString()).openConnection();
			con.setRequestMethod("GET");
			con.setRequestProperty("Authorization", property);			
			int responseCode = con.getResponseCode();

			BufferedReader br;
			System.out.print("responseCode=" + responseCode);
			if (responseCode == 200) {
				br = new BufferedReader(new InputStreamReader(con.getInputStream(), "utf-8"));
			} else {
				br = new BufferedReader(new InputStreamReader(con.getErrorStream(), "utf-8"));
			}
			String inputLine;
			StringBuffer res = new StringBuffer();
			while ((inputLine = br.readLine()) != null) {
				res.append(inputLine);
			}
			br.close();
			con.disconnect();
			result = res.toString();
		} catch (Exception e) {
			System.out.println(e);
		}
		
		return result;
	}
	
	
	
	

	public String requestAPI(StringBuffer url) {
		String result = "";
		try {


			HttpURLConnection con = (HttpURLConnection) new URL(url.toString()).openConnection();
			con.setRequestMethod("GET");
			int responseCode = con.getResponseCode();

			BufferedReader br;
			System.out.print("responseCode=" + responseCode);
			if (responseCode == 200) {
				br = new BufferedReader(new InputStreamReader(con.getInputStream(), "utf-8"));
			} else {
				br = new BufferedReader(new InputStreamReader(con.getErrorStream(), "utf-8"));
			}
			String inputLine;
			StringBuffer res = new StringBuffer();			
			while ((inputLine = br.readLine()) != null) {
				res.append(inputLine);
			}
			br.close();
			con.disconnect();
			result = res.toString();
		} catch (Exception e) {
			System.out.println(e);
		}
		
		return result;
	}
	
	
}
