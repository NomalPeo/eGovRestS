package egovframework.user.service.impl;

import java.util.List;

import egovframework.rte.psl.dataaccess.mapper.Mapper;
import egovframework.user.vo.UserVO;

@Mapper("UserDAO")
public interface UserDAO {

	List<UserVO> getAllUser();

	UserVO getUser(String id);

	Object delUser(String id);

	UserVO writeUser(UserVO vo);

	void userUpdate(UserVO vo);
	
}
