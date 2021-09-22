package com.example.northwind.business.abstracts;

import com.example.northwind.corre.entities.User;
import com.example.northwind.corre.utilities.results.DataResult;
import com.example.northwind.corre.utilities.results.Result;


public interface UserService {
	Result add(User user);
	DataResult<User> findByEmail(String email);
}
