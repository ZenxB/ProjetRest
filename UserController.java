package com.efrei.webservice_spring_efrei.controller;

import com.efrei.webservice_spring_efrei.model.User;
import com.efrei.webservice_spring_efrei.services.UserService;
import org.h2.engine.Mode;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.Objects;

@RestController
public class UserController {
    @Autowired
    private UserService userService;

    @GetMapping("/login")
    public ModelAndView login(){
        ModelAndView mav= new ModelAndView("login");
        mav.addObject("user", new User());
        return mav;
    }

    @PostMapping("/login")
    public String login(@ModelAttribute("user") User user){
        User oauthUser = userService.user(user.getUsername(), user.getPassword());
        System.out.print(oauthUser);
        if(Objects.nonNull(oauthUser)){
            return "/admin";
        }else{
            return "\"utilisateur oub mot de passe incorect\"";
        }

    }
    @RequestMapping(value = {"/logout"}, method = RequestMethod.POST)
    public String logoutDo(HttpServletRequest request, HttpServletResponse response)
    {
        return "redirect:/login";
    }

}
