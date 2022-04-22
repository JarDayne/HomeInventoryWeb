/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dataaccess;

import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.EntityTransaction;
import models.Category;
import models.Item;
import models.User;

/**
 *
 * @author Jaren
 */
public class ItemDB {
    
    //Get all Items as list
    public List<Item> getAll() { 
        
        EntityManager em = DBUtil.getEmFactory().createEntityManager(); 
        
        try { 
        
            List<Item> allItems = em.createNamedQuery("Item.findAll", Item.class).getResultList(); 
            return allItems;
        } finally { 
        
            em.close();
        } 
    } 
    
    
    public Item get(Integer itemID) { 
    
        EntityManager em = DBUtil.getEmFactory().createEntityManager(); 
        
        try { 
            
            Item item = em.find(Item.class, itemID); 
            return item; 
        } finally { 
            
            em.close(); 
        }
    } 
    
    
    //Get Item list by category MAY BE NOT NEEDED
    public List<Item> getAllByCategory(Category category) { 
        
        EntityManager em = DBUtil.getEmFactory().createEntityManager(); 
        
        try { 
            
            Category itemCategory = em.find(Category.class, category); 
            return itemCategory.getItemList(); 
        } finally { 
            
            em.close(); 
        } 
    }
     
    //Get Item list by User for User Items Display
    public List<Item> getAllByOwnerEmail(String email) { 
    
        EntityManager em = DBUtil.getEmFactory().createEntityManager(); 
        
        try { 
            
            User userItems = em.find(User.class, email); 
            return userItems.getItemList(); 
        } finally { 
            
            em.close(); 
        } 
    } 
    
    
    //Add Item 
    public void insert(Item item) throws Exception { 
        
        EntityManager em = DBUtil.getEmFactory().createEntityManager(); 
        EntityTransaction trans = em.getTransaction();
        
        try { 
            
            User owner = item.getOwner(); 
            owner.getItemList().add(item); 
            trans.begin(); 
            em.persist(item); 
            em.merge(owner);
            trans.commit();
        } catch (Exception ex) { 
            
            trans.rollback();
        } finally { 
        
            em.close();
        } 
    } 
    
    //Delete Item
    public void delete(Item item) { 
    
        EntityManager em = DBUtil.getEmFactory().createEntityManager(); 
        EntityTransaction trans = em.getTransaction();
        
        try { 
            
            User owner = item.getOwner();
            owner.getItemList().remove(item);
            trans.begin(); 
            em.remove( em.merge(item) ); 
            em.merge(owner); //possible error
            trans.commit();
        } catch (Exception ex) { 
            
            trans.rollback();
        } finally { 
        
            em.close();
        } 
    } 
    
    
    //Edit Item
    public void update(Item item) { 
        
        EntityManager em = DBUtil.getEmFactory().createEntityManager(); 
        EntityTransaction trans = em.getTransaction();
        
        try { 
            
            trans.begin(); 
            em.merge(item); 
            trans.commit();
        } catch (Exception ex) { 
            
            trans.rollback();
        } finally { 
        
            em.close();
        } 
    } 
}
