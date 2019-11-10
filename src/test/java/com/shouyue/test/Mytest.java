package com.shouyue.test;

import com.shouyue.Service.Userservice;
import com.shouyue.entity.Users;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import java.util.List;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration("classpath:applicationContext.xml")
public class Mytest {
    @Autowired
    private Userservice userservice;

    @Test
    public void test1(){
        Users users=new Users();
        users.setName("张三");
        users.setPassword("123456");
        users.setPhone("123456");
        users.setEmail("123@qq.com");
        users.setIp("123.12.22");
        users.setCome("QQ");
        userservice.regist(users);


    }

    @Test
     public void test2(){
         Users users=new Users();
         users.setName("张三");
         users.setPassword("123456");
         users.setPhone("123456");
         users.setEmail("123@qq.com");
         users.setIp("123.12.22");
         users.setCome("QQ");
         userservice.add(users);




     }


     @Test
    public void test3(){
        userservice.delete(2);



     }


     @Test
    public void test4(){
        Users users=new Users();
        users.setName("张三");
        users.setPassword("123456");
         Users login = userservice.login(users);
         System.out.println(login);


     }

     @Test
    public void test5(){
         List<Users> selectone = userservice.selectone("三");
         System.out.println(selectone);
         for (Users users : selectone) {
             System.out.println(users);
         }


     }

     @Test
    public void test6(){
         Users users=new Users();
         users.setId(1);
         users.setName("小青龙");
         users.setPassword("12343");
         users.setPhone("123456");
         users.setEmail("13642544@qq.com");
         users.setIp("123.12.22");
         users.setCome("QQ");
         userservice.add(users);
        userservice.update(users);

     }


     @Test
    public void test7(){
        Users users=new Users();
        users.setId(3);
        users.setPhone("5236987");
        users.setEmail("25698@qq.com");
        userservice.update(users);


     }
     @Test
    public  void test8(){
         List<Users> selectall = userservice.selectall(0, 3);
         for (Users users : selectall) {
             System.out.println(users);
         }

     }

     @Test
    public void test9(){

         Integer counts = userservice.counts();
         System.out.println(counts);
     }


}
