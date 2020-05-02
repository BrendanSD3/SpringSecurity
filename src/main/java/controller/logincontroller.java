/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 *
 * @author brend
 */
@Controller
@RequestMapping("/")
public class logincontroller {
    
    
    @GetMapping(value="/processlogin")
    public String processLogin(HttpSession sess, HttpServletRequest request)
    {
    if(request.isUserInRole("ADMIN")){
      sess.setAttribute("uname", getLoggedInUserName());
        System.out.println("HERE");
            return "redirect:/agent/view";
        }
    else if (request.isUserInRole("USER"))
    {System.out.println("HERE1");
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
