package service;

import org.springframework.beans.factory.annotation.Autowired;

import dao.springDao;
import entity.User;

public class UserservImpl implements Userservice{


	@Autowired
	springDao userDao;
	
	@Autowired
	 User user;
	@Override
	public User getUsers() {
		// TODO Auto-generated method stub
		return userDao.getUser();
	}
	@Override
	public void updateUser(String username, String address) {
		// TODO Auto-generated method stub
		
	}

}
