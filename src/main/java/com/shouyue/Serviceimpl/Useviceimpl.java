package com.shouyue.Serviceimpl;

import com.shouyue.Service.Userservice;
import com.shouyue.dao.Usersmethod;
import com.shouyue.entity.Users;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@Transactional
public class Useviceimpl implements Userservice {

    @Autowired
    private Usersmethod usersmethod;


    @Override
    public void regist(Users users) {

        usersmethod.regist(users);


    }

    @Override
    @Transactional(readOnly = true,propagation = Propagation.SUPPORTS)
    public Users login(Users users) {
        Users logins = usersmethod.login(users);
        return logins;
    }

    @Override
    @Transactional(readOnly = true,propagation = Propagation.SUPPORTS)
    public List<Users> selectall(Integer index, Integer number) {
        List<Users> selectall = usersmethod.selectall(index, number);
        return selectall;
    }

    @Override
    public void add(Users users) {
        usersmethod.add(users);

    }

    @Override
    @Transactional(readOnly = true,propagation = Propagation.SUPPORTS)
    public List<Users> selectone(String name) {
        List<Users> selectone = usersmethod.selectone(name);
        return selectone;
    }

    @Override
    public void delete(Integer id) {
    usersmethod.delete(id);
    }

    @Override
    public void update(Users users) {
       usersmethod.update(users);
    }

    @Override
    public List<Users> allpeople() {
        List<Users> allpeoples = usersmethod.allpeople();
        return allpeoples;
    }

    @Override
    public Users byid(Integer id) {
        Users byid = usersmethod.byid(id);


        return byid;
    }

    @Override
    public void updatesta(Users users) {
        usersmethod.updatesta(users);
    }

    @Override
    public Integer counts() {
        Integer counts = usersmethod.counts();
        return counts;
    }
}
