package egovframework.user.service;

import java.util.List;

import egovframework.user.vo.UserVO;

public interface UserService {

	List<UserVO> getAllUser();

	UserVO getUser(String id);

	Object delUser(String id);

	UserVO Write(UserVO vo);

	void userUpdate(UserVO vo);

}
