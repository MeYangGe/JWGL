package com.system.service;

import com.system.model.User;
import org.springframework.stereotype.Service;

public interface UserService {
   public int deleteByPrimaryKey(Integer uid);

    public int insert(User record);

    public int insertSelective(User record);

    public User selectByPrimaryKey(Integer uid);

    public int updateByPrimaryKeySelective(User record);

    public int updateByPrimaryKey(User record);

    public User selectBySelective(User user);

    public User selectByUname(String uname);

    public String getPermissions(Integer uid);
}
