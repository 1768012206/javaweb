package com.hhit.dao;

import java.util.List;

import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Select;
import org.springframework.stereotype.Repository;

import com.hhit.pojo.User;

@Repository
public interface UserDao {
	@Select("select * from User where id=#{id}")
	public User getUser(int id);

	@Select("select * from User")
	public List<User> getAllUser();
	
	@Insert("insert into User values(#{0},#{1},#{2},#{3})")
	public void insertUser(int id, String name, String password, int type);
}
