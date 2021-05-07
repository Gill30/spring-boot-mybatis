package com.mybatis.demo.mappers;

import java.util.List;

import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.SelectKey;

import com.mybatis.demo.model.User;

@Mapper
public interface UserMapper {
	
	@Select("SELECT * FROM Test.users")
	List<User> findAll();

	@Insert("insert into users(name, salary) values(#{name}, #{salary})")
	@SelectKey(statement = "SELECT LAST_INSERT_ID()", keyProperty = "id",
				before = false, resultType = Integer.class)
	void insert(User user);

}
