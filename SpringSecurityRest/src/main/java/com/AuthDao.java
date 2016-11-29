package com;

import org.springframework.data.repository.CrudRepository;

public interface AuthDao  extends CrudRepository<Auth, Long> {
	public Auth findByUser(String name);

}
