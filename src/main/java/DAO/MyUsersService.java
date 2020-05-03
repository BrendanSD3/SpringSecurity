/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DAO;

import Model.Authorities;
import Model.Users;
import Model.dbutil;
import javax.persistence.EntityManager;
import javax.persistence.EntityTransaction;
import javax.persistence.TypedQuery;
import org.springframework.context.annotation.Bean;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;


/**
 *
 * @author brend
 */
@Service

public class MyUsersService {
    
    public String RegisterUser(String username, String password)
    {
      //  System.out.println("HERE in Register");
         EntityManager em =dbutil.getEMF().createEntityManager();
          EntityTransaction trans=em.getTransaction();
          Users u=new Users();
          u.setId(1);
          u.setEnabled(true);
          u.setUsername(username);
          u.setPassword(passwordEncoder().encode(password));
         // System.out.println("USER info:   "+ u.getUsername()+u.getPassword());
          //boolean userexists=false;
         //userexists= SearchUsernameExists(username);
         Authorities a = new Authorities();
         a.setId(1);
         a.setUsername(u);
         a.setAuthority("ROLE_USER");
         
         try{
              trans.begin();
              em.persist(u);
              trans.commit();
          }
      catch(Exception ex){
          System.out.println("ex"+ ex);
          
      }
          finally{
              em.close();
          }
        
         addauthority(a);
         return "Creating User";
    }
    
    public void addauthority(Authorities a)
    {
       // System.out.println("auth"+ a);
        EntityManager em =dbutil.getEMF().createEntityManager();
          EntityTransaction trans=em.getTransaction();
               try{
              trans.begin();
              em.persist(a);
              trans.commit();
          }
      catch(Exception ex){
          System.out.println("ex"+ ex);
          
      }
          finally{
              em.close();
          }
        
          
          
          
        
    }
    public boolean SearchUsernameExists(String username)
    {
          EntityManager em =dbutil.getEMF().createEntityManager();
         String query="SELECT u FROM Users u WHERE u.username = :username";
        TypedQuery<Users> tq = em.createQuery(query, Users.class);
        tq.setParameter("username", username);
        Users user=null;
        try {
            user = tq.getSingleResult();
            
            if (user == null ) {
                return false;
            }
        } catch (Exception ex) {
            System.out.println(ex);
        } finally {
            em.close();
        }
//        if(user==null){
//          return false;
//        }
//        else{
//            return true;
//        }
        return true;
    }
    
    @Bean
public PasswordEncoder passwordEncoder() {
    return new BCryptPasswordEncoder();
}
    
    
}
