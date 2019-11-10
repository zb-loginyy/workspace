package com.shouyue.Service;

import com.shouyue.entity.Users;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface Userservice {
    public void regist(Users users);

    public Users login(Users users);

    public List<Users> selectall(@Param("index")Integer index, @Param("number") Integer number);

    public void add(Users users);

    public List<Users> selectone(String name);

    public void delete(Integer id);

    public void update(Users users);

    public List<Users> allpeople();

    public Users byid(Integer id);

    public void updatesta(Users users);

    public Integer counts();
}
