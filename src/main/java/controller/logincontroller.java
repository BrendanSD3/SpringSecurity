/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller;

import Model.Users;
import DAO.MyUsersService;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import javax.ws.rs.QueryParam;
import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;


import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.SessionAttributes;
import org.springframework.web.servlet.ModelAndView;


/**
 *
 * @author brend
 */
@Controller
@RequestMapping("")
@SessionAttributes("login")
public class logincontroller {
    
     @Autowired
     MyUsersService service;
    
     @GetMapping(value="/login")
    public ModelAndView login()
    {
        return new ModelAndView("/login","user",new Users());
    
    }
    @GetMapping(value="/register")
    public ModelAndView register()
    {
        return new ModelAndView("/register","user",new Users());
    
    }
    @PostMapping(value="/processReg")
    public String process(@QueryParam("username") String username, @QueryParam("password") String password)
    {
        System.out.println("HERE????");
        String reg=service.RegisterUser(username, password);
        System.out.println("reg");
        return "redirect:/login";
    }
    
    @GetMapping(value="/processlogin")
    public String processLogin(HttpSession sess, HttpServletRequest request)
    {
       
    if(request.isUserInRole("ADMIN")){
      sess.setAttribute("uname", getLoggedInUserName());
       
            return "redirect:/agent/view";
        }
    else if (request.isUserInRole("USER"))
    {
         sess.setAttribute("uname", getLoggedInUserName());
            return "redirect:/agent/home";
        
        
    }
       else
        {
           
            throw new ForbiddenException();
        }
    }
    private String getLoggedInUserName() {
       Object principal = SecurityContextHolder.getContext()
               .getAuthentication().getPrincipal();
       if(principal instanceof UserDetails){
           return ((UserDetails)principal).getUsername();
           
       }
      return principal.toString();
    }
    
}
