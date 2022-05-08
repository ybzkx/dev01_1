package com.fc.controller;

import com.fc.entity.TbUser;
import com.fc.service.UserService;
import com.fc.vo.ResultVO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

@Controller
@RequestMapping("user")
public class UserController {
    @Autowired
    private UserService userService;

    @PostMapping("login")
    public ModelAndView login(TbUser user,
                              Integer remember,
                              HttpSession session,
                              HttpServletResponse response,
                              ModelAndView mv){
        //调用业务层的登录方法
       ResultVO result = userService.login(user.getUsername(),user.getPassword());

       //登陆成功的情况
        if (result.getCode() == 200){

            session.setAttribute("user",result.getData());

            Cookie cookie;
            //勾选记住我
            if (remember != null && remember == 1){
                cookie = new Cookie("JSESSIONID", session.getId());
                //半个钟头
                cookie.setMaxAge(30*60);


            }else {
                cookie = new Cookie("JSESSIONID", null);

                //浏览器关闭时，自动销毁
                cookie.setMaxAge(-1);
            }
            //发送到浏览器
            response.addCookie(cookie);

            mv.setViewName("redirect:/index.jsp");

        }else{
            //登录失败
            mv.addObject("resultInfo",result);

            mv.setViewName("redirect:/login.jsp");
        }


        return mv;
    }


    @GetMapping("logout")
    public ModelAndView logout(ModelAndView mv,HttpSession session,HttpServletResponse response){

        //销毁session
        session.invalidate();

        Cookie cookie = new Cookie("JSESSIONID", null);

        cookie.setMaxAge(0);

        response.addCookie(cookie);

        mv.setViewName("redirect:/login.jsp");

        return mv;
    }


    @GetMapping("userCenter")
    public ModelAndView userCenter(ModelAndView mv){

        mv.addObject("menu_page","user");
        mv.addObject("changePage","/user/info.jsp");
        mv.setViewName("forward:/index.jsp");
        return mv;
    }


    @GetMapping("checkNick")
    @ResponseBody
    public Integer checkNick(String nick){
        return userService.checkNick(nick);
    }



    @PostMapping("update")
    public ModelAndView update(MultipartFile img, TbUser user, HttpSession session, ModelAndView mv) {
        TbUser contextUser = (TbUser) session.getAttribute("user");

        // 一定要把id给传递过来
        user.setId(contextUser.getId());

        ResultVO vo = userService.update(img, user);

        session.setAttribute("user", vo.getData());

        mv.setViewName("redirect:userCenter");
        return mv;
    }
}

