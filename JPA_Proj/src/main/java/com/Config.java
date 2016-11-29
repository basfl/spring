package com;

import org.springframework.beans.factory.annotation.Autowired;

public class Config {
	@Autowired
	UserDao userDao;

	public void func() {
		Long id = (long) 0;

		User us = userDao.findOne(id);
		System.out.println("address is " + us.getAddress());
		User us1 = userDao.findByName("John Smith II");
		System.out.println("@@@@@@" + us1.getName() + "and is is " + us1.getId());

		System.out.println("hi");
	}

}
