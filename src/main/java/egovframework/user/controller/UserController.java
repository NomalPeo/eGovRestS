package egovframework.user.controller;

import java.nio.charset.Charset;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.annotation.Resource;

import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import egovframework.user.service.UserService;
import egovframework.user.vo.UserVO;

@RestController
@RequestMapping("/main")
public class UserController {
	
	@Resource(name="UserService")
	private UserService userService;
	
	// 전체 유저 조회
	@RequestMapping(value="/users.json",method = RequestMethod.GET)
	public ResponseEntity<Map<String, Object>> main() {
		List<UserVO> userList = userService.getAllUser();
		Map<String,Object> result = new HashMap<String, Object>();
		result.put("data", userList);
		result.put("count", userList.size());
		return ResponseEntity.status(HttpStatus.OK).body(result);
	}
	
	// 특정 유저 조회
	/*@RequestMapping(value="/one/{id}.do", method=RequestMethod.GET)
	public ResponseEntity<UserVO> getUser(@PathVariable("id") String id){
		UserVO userVo = userService.getUser(id);
		return ResponseEntity.status(HttpStatus.OK).body(userVo);
	}*/
	// 특정 유저 조회
		@RequestMapping(value="/users/one/{id}.json", method=RequestMethod.GET)
		public ResponseEntity<UserVO> getUser(@PathVariable("id") String id){
			UserVO userVo = userService.getUser(id);
			HttpHeaders headers = new HttpHeaders();
			headers.setContentType(new MediaType("application","json",Charset.forName("utf-8")));
			return new ResponseEntity<UserVO>(userVo,headers,HttpStatus.OK);
		}
	
	
	@RequestMapping(value="/mise/{id}.json", method=RequestMethod.DELETE)
	public String delUser(@PathVariable("id") String id){
		userService.delUser(id);
		return "redirect:/main/all.json";
	}
	
	
	@RequestMapping(value="/write.json", method=RequestMethod.POST)
	public ResponseEntity<UserVO> userWrite(@RequestBody UserVO input){                     
		UserVO userVo = userService.Write(input);
		HttpHeaders headers = new HttpHeaders();
		headers.setContentType(new MediaType("application","json",Charset.forName("utf-8")));
		return new ResponseEntity<UserVO>(userVo,headers,HttpStatus.OK);
	}
	
	@RequestMapping(value="/users/{name}.json", method=RequestMethod.PUT)
	public ResponseEntity<UserVO> usersPut (@PathVariable("name")String name, @RequestBody UserVO vo){
		userService.userUpdate(vo);
		UserVO userVo = userService.getUser(vo.getId());
		HttpHeaders headers = new HttpHeaders();
		headers.setContentType(new MediaType("application","json",Charset.forName("utf-8")));
		return new ResponseEntity<UserVO>(userVo,headers,HttpStatus.OK);
	}
}








