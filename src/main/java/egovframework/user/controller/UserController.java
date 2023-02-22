package egovframework.user.controller;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.io.PrintWriter;
import java.net.HttpURLConnection;
import java.net.URL;

import javax.servlet.http.HttpServletResponse;

import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
public class UserController {


	@RequestMapping(value="/main.do", method = RequestMethod.GET)
	public String main(Model model) throws Exception{
		String result = "";
		try {
			StringBuilder urlBuider = new StringBuilder("http://localhost:8083/main/users.json");
			URL url = new URL(urlBuider.toString());
			BufferedReader rd;
			rd = new BufferedReader(new InputStreamReader(url.openStream(),"UTF-8"));
			result = rd.readLine();
			model.addAttribute("list",result);
			JSONParser jsonparser = new JSONParser();
			JSONObject jObject = (JSONObject)jsonparser.parse(result);
			JSONArray data = (JSONArray)jObject.get("data");
			model.addAttribute("list1",data);
		}catch(Exception e) {
			e.printStackTrace();
		}
		return "main";
	}

	@RequestMapping(value="/oneList.do", method = RequestMethod.GET)
	public String oneList(Model model,String id) throws Exception{
		String result = "";
		try {
			StringBuilder urlBuider = new StringBuilder("http://localhost:8083/main/users/one/"+id+".json");
			URL url = new URL(urlBuider.toString());
			BufferedReader rd;
			rd = new BufferedReader(new InputStreamReader(url.openStream(),"UTF-8"));
			result = rd.readLine();
			model.addAttribute("list",result);
			JSONParser jsonparser = new JSONParser();
			JSONObject jObject = (JSONObject)jsonparser.parse(result);
			model.addAttribute("list1",jObject);
		}catch(Exception e) {
			e.printStackTrace();
		}
		return "oneList";
	}

	@RequestMapping(value="/userDel.do", method=RequestMethod.DELETE)
	public String userDel(Model model,String id) throws Exception{
		try {
			StringBuilder urlBuider = new StringBuilder("http://localhost:8083/main/mise/"+id+".json");
			URL url = new URL(urlBuider.toString());
			BufferedReader rd;
			HttpURLConnection conn = (HttpURLConnection) url.openConnection();
			conn.setRequestMethod("DELETE");
			rd = new BufferedReader(new InputStreamReader(conn.getInputStream(),"UTF-8"));
		}catch(Exception e) {
			e.printStackTrace();
		}
		return "redirect:/main.do";
	}

	@RequestMapping(value="userWrite.do")
	public String userWrite() {
		return "boardWrite/boardWrite";
	}

	@RequestMapping(value="userWriteSave.do", method=RequestMethod.POST)
	public void userWriteSave(Model model, userVO vo,HttpServletResponse res) throws Exception{
		JSONObject data = new JSONObject();
		data.put("id", vo.getId());
		data.put("name", vo.getName());
		data.put("nickName", vo.getNickName());
		data.put("pwd", vo.getPwd());
		
		String line = data.toString();
		try {
			String url_host = "http://localhost:8083/main/write.json";
			HttpURLConnection conn = null;
			URL url = new URL(url_host);
			conn = (HttpURLConnection)url.openConnection();
			conn.setRequestMethod("POST");
			conn.setRequestProperty("Content-Type", "application/json; charset=utf-8");
			conn.setDoOutput(true);

			try(OutputStream os = conn.getOutputStream()) {
				byte[] input = line.getBytes("utf-8");
				os.write(input, 0, input.length);			
			}

			try(BufferedReader br = new BufferedReader(
					new InputStreamReader(conn.getInputStream(), "utf-8"))) {
				StringBuilder response = new StringBuilder();
				String responseLine = null;
				while ((responseLine = br.readLine()) != null) {
					response.append(responseLine.trim());
				}
				System.out.println(response.toString());
			}
			res.setContentType("text/html; charset=utf-8");
			PrintWriter out = res.getWriter();
			out.println("<script>alert('글작성 완뇨');");
			out.println("window.location.href='/main.do';");
			out.println("</script>");
			out.flush();
			

		}catch(Exception e) {
			e.printStackTrace();
		}
	}
	
	@RequestMapping(value="userUpdate.do",method=RequestMethod.PUT)
	public void userUpdate(Model model, userVO vo,HttpServletResponse res) {
		String id = "";
		JSONObject data = new JSONObject();
		String result = "";
		data.put("id", vo.getId());
		data.put("name", vo.getName());
		data.put("nickName", vo.getNickName());
		data.put("pwd", vo.getPwd());
		String line = data.toString();
		try {
			String url_host = "http://localhost:8083/main/users/"+vo.getName()+".json";
			HttpURLConnection conn = null;
			URL url = new URL(url_host);
			conn = (HttpURLConnection)url.openConnection();
			conn.setRequestMethod("PUT");
			conn.setRequestProperty("Content-Type", "application/json; charset=utf-8");
			conn.setDoOutput(true);

			try(OutputStream os = conn.getOutputStream()) {
				byte[] input = line.getBytes("utf-8");
				os.write(input, 0, input.length);			
			}
			StringBuilder response = new StringBuilder();
			String responseLine = null;
			try(BufferedReader br = new BufferedReader(
					new InputStreamReader(conn.getInputStream(), "utf-8"))) {
				while ((responseLine = br.readLine()) != null) {
					response.append(responseLine.trim());
				}
				System.out.println(response.toString());
				result = response.toString();
			}
			JSONParser jsonparser = new JSONParser();
			JSONObject jObject = (JSONObject)jsonparser.parse(result);
			id = (String)jObject.get("id");
			System.out.println(jObject);
			res.setContentType("text/html; charset=utf-8");
			PrintWriter out = res.getWriter();
			out.println("<script>alert('수정 완뇨');");
			out.println("window.location.href='/oneList.do?id="+id+"';");
			out.println("</script>");
			out.flush();
			

			
		}catch(Exception e) {
			e.printStackTrace();
		}
	}

















}
