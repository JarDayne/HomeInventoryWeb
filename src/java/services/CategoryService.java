/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package services;

import dataaccess.CategoryDB;
import dataaccess.ItemDB;
import dataaccess.UserDB;
import java.util.List;
import models.Category;
import models.Item;
import models.User;

/**
 *
 * @author Jaren
 */
public class CategoryService {
    
    public List<Category> getAllCategories( ) throws Exception { 
    
        CategoryDB categoryData = new CategoryDB(); 
        List<Category> allCategories = categoryData.getAll();
        return allCategories;
    } 
    
    
    public void addCategory(int categoryId, String categoryName) throws Exception { 
        
        Category category = new Category(categoryId, categoryName); 
        CategoryDB categoryData = new CategoryDB();
        categoryData.insert(category);
    } 
    
    
    public void updateCategoryName(int categoryId, String categoryName) throws Exception { 
        
        CategoryDB categoryData = new CategoryDB(); 
        Category category = categoryData.get(categoryId); 
        category.setCategoryName(categoryName);
        
        categoryData.update(category);
    } 
}
