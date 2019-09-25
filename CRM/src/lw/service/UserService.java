package lw.service;

import java.util.List;

import lw.domain.User;

public interface UserService {

	void regist(User user);

	User login(User user);

	List<User> findAll();

}
