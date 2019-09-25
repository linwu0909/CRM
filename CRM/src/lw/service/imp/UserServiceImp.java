package lw.service.imp;
import java.util.List;

import org.springframework.transaction.annotation.Transactional;
import lw.dao.UserDao;
import lw.domain.User;
import lw.service.UserService;
import lw.utils.MD5Utils;
@Transactional
public class UserServiceImp implements UserService{
	
	//注入dao
	private UserDao userDao;
	
	public void setUserDao(UserDao userDao) {
		this.userDao = userDao;
	}

	@Override
	//业务层注册用户的方法
	public void regist(User user) {
		// 对密码进行加密处理
		user.setUser_password(MD5Utils.md5(user.getUser_password()));
		user.setUser_state("1");
		//调用dao
		userDao.save(user);
	}

	@Override
	public User login(User user) {
		user.setUser_password(MD5Utils.md5(user.getUser_password()));
		//调用dao
		return userDao.login(user);
	}

	@Override
	public List<User> findAll() {
		return userDao.findAll();
	}
	
}
