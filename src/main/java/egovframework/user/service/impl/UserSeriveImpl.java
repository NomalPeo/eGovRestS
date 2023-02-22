package egovframework.user.service.impl;


import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import egovframework.user.service.UserService;
import egovframework.user.vo.UserVO;
@Service("UserService")
public class UserSeriveImpl implements UserService {
	
	@Resource(name="UserDAO")
	private UserDAO userDao;
	
	@Override
	public List<UserVO> getAllUser() {
		return userDao.getAllUser();
	}

	@Override
	public UserVO getUser(String id) {
		return userDao.getUser(id);
	}

	@Override
	public Object delUser(String id) {
		return userDao.delUser(id);
	}

	@Override
	public UserVO Write(UserVO vo) {
		return userDao.writeUser(vo);
	}

	@Override
	public void userUpdate(UserVO vo) {
		userDao.userUpdate(vo);
	}

}
