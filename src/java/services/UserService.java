/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package services;

import dataaccess.CategoryDB;
import dataaccess.ItemDB;
import dataaccess.RoleDB;
import dataaccess.UserDB;
import java.util.List;
import models.Category;
import models.Item;
import models.Role;
import models.User;

/**
 *
 * @author Jaren
 */
public class UserService {
    
    //Get Users to display for Admin
    public List<User> getAllUsers( ) { 
    
        UserDB userData = new UserDB(); 
        List<User> allUsers = userData.getAll();
        return allUsers;
    } 
    
    
    //Admin function to add user
    public void addUserAdmin(int roleID, String email, boolean active, String firstName, String lastName, String password) throws Exception { 
    
        RoleDB roleData = new RoleDB(); 
        Role role = roleData.get(roleID); 
        
        User user = new User(email, active, firstName, lastName, password); 
        user.setRole(role);
        
        UserDB userData = new UserDB();
        userData.insert(user);
    } 
    
    
    //Admin function to remove a user including associated items
    public void deleteUserAdmin(String email) throws Exception { 

        UserDB userData = new UserDB(); 
        User user = userData.get(email); 
        user.setItemList(null);
        userData.update(user);
        userData.delete(user);
    } 
    
    
    //Admn function to update a user
    public void updateUserAdmin(int roleID, String email, boolean active, String firstName, String lastName, String password, String oldEmail) throws Exception { 
        
        RoleDB roleData = new RoleDB(); 
        Role role = roleData.get(roleID); 
        
        UserDB userData = new UserDB();
        User user = userData.get(oldEmail); 
        user.setRole(role); 
        user.setEmail(email);
        user.setActive(active);
        user.setFirstName(firstName);
        user.setLastName(lastName);
        user.setPassword(password);
        
        userData.update(user);
    } 
}
