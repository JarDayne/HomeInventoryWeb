/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dataaccess;

import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.EntityTransaction;
import models.Item;
import models.Role;
import models.User;

/**
 *
 * @author Jaren
 */
public class UserDB {
    
    public User get(String email) { 

        EntityManager em = DBUtil.getEmFactory().createEntityManager(); 

        try { 

            User user = em.find(User.class, email); 
            return user; 
        } finally { 

            em.close(); 
        }
    } 
    
    
    public List<User> getAll() { 
        
        EntityManager em = DBUtil.getEmFactory().createEntityManager(); 
        
        try { 
        
            List<User> allUser = em.createNamedQuery("Usser.findAll", User.class).getResultList(); 
            return allUser;
        } finally { 
        
            em.close();
        } 
    } 
    
    
    public void insert(User user) throws Exception { 
        
        EntityManager em = DBUtil.getEmFactory().createEntityManager(); 
        EntityTransaction trans = em.getTransaction();
        
        try { 
            
            Role role = user.getRole();
            role.getUserList().add(user); 
            trans.begin(); 
            em.persist(user); 
            em.merge(role);
            trans.commit();
        } catch (Exception ex) { 
            
            trans.rollback();
        } finally { 
        
            em.close();
        } 
    } 
    
    
    public void delete(User user) { 
    
        EntityManager em = DBUtil.getEmFactory().createEntityManager(); 
        EntityTransaction trans = em.getTransaction();
        
        try { 
            
            Role role = user.getRole();
            role.getUserList().remove(user);
            trans.begin(); 
            em.remove( em.merge(user) ); 
            em.merge(role);  //possible error
            trans.commit();
        } catch (Exception ex) { 
            
            trans.rollback();
        } finally { 
        
            em.close();
        } 
    } 
    
    
    public void update(User user) { 
        
        EntityManager em = DBUtil.getEmFactory().createEntityManager(); 
        EntityTransaction trans = em.getTransaction();
        
        try { 
            
            trans.begin(); 
            em.merge(user); 
            trans.commit();
        } catch (Exception ex) { 
            
            trans.rollback();
        } finally { 
        
            em.close();
        } 
    }
}
