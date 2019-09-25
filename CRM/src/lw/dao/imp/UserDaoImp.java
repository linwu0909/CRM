package lw.dao.imp;

import java.util.List;

import org.springframework.orm.hibernate5.support.HibernateDaoSupport;

import lw.dao.UserDao;
import lw.domain.User;
//用户管理的dao实现类
public class UserDaoImp extends BaseDaoImp<User> implements UserDao{



	//DAO中根据用户名和密码进行查询的方法	
	@Override
	public User login(User user) {
		List<User> list= (List<User>) this.getHibernateTemplate().find("from User where user_code=? and user_password = ? ", user.getUser_code(),user.getUser_password());
		if(list.size()>0){
			return list.get(0);
		}
		return null;
	}
	
}
