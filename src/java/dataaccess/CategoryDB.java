/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dataaccess;

import java.util.List;
import javax.persistence.EntityManager;
import models.Category;
import models.Item;

/**
 *
 * @author Jaren
 */
public class CategoryDB {
    
    public Category get(Integer categoryId) { 
        
        EntityManager em = DBUtil.getEmFactory().createEntityManager(); 
        
        try { 
            
            Category category = em.find(Category.class, categoryId); 
            return category; 
        } finally { 
            
            em.close(); 
        }
    }
    
    public List<Category> getAll() { 
        
        EntityManager em = DBUtil.getEmFactory().createEntityManager(); 
        
        try { 
        
            List<Category> allCategories = em.createNamedQuery("Category.findAll", Category.class).getResultList(); 
            return allCategories;
        } finally { 
        
            em.close();
        } 
    } 
}
