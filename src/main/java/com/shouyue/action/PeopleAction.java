package com.shouyue.action;


import com.shouyue.Service.Userservice;
import com.shouyue.entity.Users;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import java.util.List;

@RequestMapping("/P")
@Controller
public class PeopleAction {

    @Autowired
    private Userservice userservice;


    @RequestMapping("/login")
    public String   login(Users users, String role,HttpServletRequest request)throws Exception{

        Users login = userservice.login(users);
        if(login!=null){
             request.setAttribute("flag",role);
             request.setAttribute("id",login.getId());
            return  "forward:/P/show.do";

        }else{
            return  "redirect:/rzy/login.jsp";
        }

    }

    @RequestMapping("/show")
    public String showall(HttpServletRequest request)throws  Exception{

        String flag =(String) request.getAttribute("flag");
        if("admin".equals(flag)){
            List<Users> allpeople = userservice.allpeople();
            request.setAttribute("show",allpeople);
            Integer id =(Integer) request.getAttribute("id");
            Users byid = userservice.byid(id);
            request.setAttribute("one",byid);
            return  "forward:/rzy/admin.jsp";
        }else{
           Integer id =(Integer) request.getAttribute("id");
            Users byid = userservice.byid(id);
            request.setAttribute("one",byid);
            return  "forward:/rzy/userlist.jsp";
        }

    }

     @RequestMapping("/delete")
    public String delete(Integer id,HttpServletRequest request){
        request.setAttribute("flag","admin");
        userservice.delete(id);
        return "forward:/P/show.do";

     }

     @RequestMapping("/updatesta")
    public String updatesta(Integer id,HttpServletRequest request,String status){
        Users users=new Users();
        users.setId(id);
        if("正常".equals(status)){
            users.setStatus("冻结");
        }else{
            users.setStatus("正常");
        }

        userservice.updatesta(users);

        request.setAttribute("flag","admin");
          return  "forward:/P/show.do";



     }

    @RequestMapping("/select")
    @ResponseBody
    public Users selectonebyid(Integer id){
        Users byid = userservice.byid(id);
        return  byid;

    }

    @RequestMapping("/update")
    public String update(Users users,HttpServletRequest request){
        userservice.update(users);
        request.setAttribute("flag","admin");
        return    "forward:/P/show.do";


    }

    @RequestMapping("/add")
    public String add(Users users,HttpServletRequest request){
        userservice.add(users);
        request.setAttribute("flag","admin");
        return  "forward:/P/show.do";


    }

    @RequestMapping("/mohu")
    public String mohu(String name,HttpServletRequest request){
        List<Users> allpeople = userservice.selectone(name);
        request.setAttribute("show",allpeople);
        return  "forward:/rzy/admin.jsp";

    }

    @RequestMapping("/fenye")
    public String allcounts(HttpServletRequest request,Integer count,Integer index){
        Integer pagenum = index;
        request.setAttribute("pagenum",pagenum);
        request.setAttribute("flag","admin");
        Integer counts = userservice.counts();
        if(counts%count!=0){
            Integer page=counts/count+1;
            request.setAttribute("page",page);
        }else{
            Integer page=counts/count;
            request.setAttribute("page",page);
        }
        request.setAttribute("count",count);

        List<Users> allpeople = userservice.selectall((index - 1) * count, count);

        request.setAttribute("show",allpeople);

        return  "forward:/rzy/admin.jsp";


    }
    @RequestMapping("/exit")
    public String exit(HttpSession session){
        return  "redirect:/rzy/login.jsp";



    }

}
