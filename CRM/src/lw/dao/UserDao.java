package lw.dao;

import lw.domain.User;

public interface UserDao extends BaseDao<User>{



	User login(User user);

}
