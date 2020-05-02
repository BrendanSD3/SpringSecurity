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
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.SessionAttributes;



/**
 *
 * @author brend
 */

  
@Controller
@RequestMapping("/agent")
@SessionAttributes("agent")
public class AgentController  {
    
      @RequestMapping(value = "")
    public String hometest(HttpSession sess, HttpServletRequest request) {
        if(request.isUserInRole("USER")||request.isUserInRole("ADMIN")){
       
        return "/homepage";
        }
        else
        {
         throw new ForbiddenException();
        }
    }
    
    @RequestMapping(value = "/home")
    public String homepage(HttpSession sess, HttpServletRequest request) {
        if(request.isUserInRole("USER")||request.isUserInRole("ADMIN")){
          return "/homepage";
        }
        else
        {
         throw new ForbiddenException();
        }
    }
    
      @RequestMapping(value = "/view")
    public String view(HttpSession sess, HttpServletRequest request) {
        if(request.isUserInRole("ADMIN")){
             
            sess.setAttribute("uname", getLoggedInUserName());
            return "/view";
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
//    @Autowired
//    AgentService service;
//        
//     @RequestMapping(value = "/login")
//    public String login() {
//        return "login";
//    }
//    
//    //@GetMapping("/view")
//    @RequestMapping("/view")
//    public ModelAndView getAgent(HttpSession sess, HttpServletRequest request){
//        if(request.isUserInRole("ADMIN")){
//            sess.setAttribute("uname", getLoggedInUserName());
//         //System.out.println("Getting Called");
//        List <Agent> a = service.getAgent();
//        //System.out.println("Printingreturnedlist" + a);
//        return new ModelAndView("/allAgents", "agentList", a);
//        }
//        else{
//            
//            throw new ForbiddenException();
//        }
//       
//    }
////   @GetMapping("/login")
////   public ModelAndView login(){
////       return new ModelAndView("/login");
////   }
////   
////   @PostMapping("/login")
////   public ModelAndView logon()
////   {
////       return new ModelAndView("redirect:/agent/view");
////   }
//    @GetMapping("/add")
//    public ModelAndView displayAgentAddForm(){
//        return new ModelAndView("/addAgent","agent",new Agent());
//    
//    }
//    //@RequestMapping(value = "/addAgent", method = RequestMethod.POST)
//    @PostMapping("/addAgent")
//    public ModelAndView addAnAgent(@Valid @ModelAttribute("agent")Agent agent, 
//      BindingResult result, ModelMap model) {
//        if (result.hasErrors()) {
//            System.out.println("results"+ result);
//             return new ModelAndView("/error");
//        }
//        service.addAgent(agent);
//        //route the user to the next page
//        return new ModelAndView("redirect:/agent/view");
//    }                      
//    @GetMapping("/displayAgent{id}")
//    public ModelAndView displayAgent(@QueryParam("id") int id){
//      Agent a = service.getAgentByID(id);
//        
//        return new ModelAndView("/displayAgent","foundagent", a);
//    
//    }
//    
//    
//      @GetMapping("/edit")
//    public ModelAndView edit(@QueryParam("id") int id){
//        Agent ag = service.getAgentByID(id);
//          System.out.println("IN EDIT");
//          System.out.println("agent" + ag);
//        return new ModelAndView("/editAgent","agent",ag);
//    }
//    
//    
//    
//    
////    @GetMapping("/find/{id}")
////    public ModelAndView find(@PathVariable("id") int id, ModelAndView model){
////        model.addObject("agent", service.getAgentByID(id));
////        model.setViewName("/displayAgent");
////        return model;
////    }
//    @PostMapping("/updateAgent")
//    public ModelAndView UpdateAgent(@Valid @ModelAttribute("agent")Agent agent, 
//      BindingResult result, ModelMap model) {
//        if (result.hasErrors()) {
//             return new ModelAndView("/error");
//        }
//        service.updateAgent(agent);
//        //route the user to the next page
//        return new ModelAndView("redirect:/agent/view");
//    }                  
//    @GetMapping("/delete")
//    public ModelAndView deleteAnAgent(@QueryParam("id") int id){
//        Agent a = service.getAgentByID(id);
//        service.deleteAnAgent(a);
//        return new ModelAndView("redirect:/agent/view");
//        //return new ModelAndView("/allAgents", "agentlist", service.getAllAgents());
//    }
//      private String getLoggedInUserName() {
//       Object principal = SecurityContextHolder.getContext()
//               .getAuthentication().getPrincipal();
//       if(principal instanceof UserDetails){
//           return ((UserDetails)principal).getUsername();
//           
//       }
//      return principal.toString();
//    }
//}

