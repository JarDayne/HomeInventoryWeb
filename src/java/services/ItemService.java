/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package services;

import dataaccess.CategoryDB;
import dataaccess.ItemDB;
import java.util.List;
import models.Category;
import models.Item;
import models.User;

/**
 *
 * @author Jaren
 */
public class ItemService {
    
    //Get Items to display for Owner
    public List<Item> getAllByOwner(User owner) { 
    
        ItemDB itemData = new ItemDB(); 
        List<Item> ownedItems = itemData.getAllByOwner(owner); 
        return ownedItems;
    } 
    
    //Add item for Owner
    public void addItem(Item newItem, User owner) { 
    
        System.out.println("hi");
    } 
            
            
    //Delete item for Owner 
            
            
    //Edit item for Owner
    public void updateItem(int itemID, int categoryID, String itemName, double price) { 
        
        ItemDB itemData = new ItemDB(); 
        Item item = itemData.get(itemID); 
        
        CategoryDB categoryData = new CategoryDB();
        Category category = categoryData.get(categoryID); 
        
        item.setCategory(category); 
        item.setItemName(itemName); 
        item.setPrice(price);
        
        itemData.update(item);
    } 
            
    
}
