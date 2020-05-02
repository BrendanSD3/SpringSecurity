/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Model;



/**
 *
 * @author brend
 */import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
public class dbutil {
    



     
    private static final EntityManagerFactory EMF = 
            Persistence.createEntityManagerFactory("taste_PU");
    
    public static EntityManagerFactory getEMF() { return EMF; }

}