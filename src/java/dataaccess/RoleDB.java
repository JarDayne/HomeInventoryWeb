/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dataaccess;

import javax.persistence.EntityManager;
import models.Category;
import models.Role;

/**
 *
 * @author Jaren
 */
public class RoleDB {
    
    public Role get(Integer roleID) throws Exception { 
        
        EntityManager em = DBUtil.getEmFactory().createEntityManager(); 
        
        try { 
            
            Role role = em.find(Role.class, roleID); 
            return role; 
        } finally { 
            
            em.close(); 
        }
    } 
}
