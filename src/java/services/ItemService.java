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
public class ItemService {
    
    //Get Items to display for Owner
    public List<Item> getAllByOwner(String email) { 
    
        ItemDB itemData = new ItemDB(); 
        List<Item> ownedItems = itemData.getAllByOwnerEmail(email); 
        return ownedItems;
    } 
    
    //Add item for Owner
    public void addItem(int categoryID, String itemName, double price, String email) throws Exception { 
    
        CategoryDB categoryData = new CategoryDB();
        Category category = categoryData.get(categoryID); 
        UserDB userData = new UserDB();
        User user = userData.get(email); 
        
        
        Item item = new Item(0, itemName, price);
        item.setCategory(category);
        item.setOwner(user); 
        
        ItemDB itemData = new ItemDB();
        itemData.insert(item);
    } 
            
            
    //Delete item for Owner 
    public void deleteItem(int itemID) throws Exception { 

        ItemDB itemData = new ItemDB(); 
        Item item = itemData.get(itemID); 
        itemData.delete(item);
    } 
            
            
    //Edit item for Owner
    public void updateItem(int itemID, int categoryID, String itemName, double price) throws Exception { 
        
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
