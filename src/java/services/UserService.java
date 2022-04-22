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
    
    public User loginUser(String email, String password)  { 
        
        UserDB userData = new UserDB(); 
        User user = userData.get(email);
        
        try { 
            String userEmail = user.getEmail(); 
            String userPassword = user.getPassword();
            
            if( !(userEmail.equals(email) && userPassword.equals(password)) ) { 
            
            user = null;
        } 
        } catch (NullPointerException nex) { 
        } 
        
        return user;
    } 
    
    
    public void registerUser(String email, String firstName, String lastName, String password) throws Exception { 
        
        UserDB userData = new UserDB(); 
        User user = new User(email, true, firstName, lastName, password); 
        userData.insert(user);
    } 
    
    
    public void userAccountEdit(String email, String firstName, String lastName, String password, String oldEmail) throws Exception { 
        
        UserDB userData = new UserDB(); 
        User user = userData.get(oldEmail);
        user.setEmail(email);
        user.setFirstName(firstName);
        user.setLastName(lastName);
        user.setPassword(password);
        
        userData.update(user);
    } 
    
    
    //Note: The user must be active to log in to their account again
    public void userDeactivate(String email) throws Exception { 
    
        UserDB userData = new UserDB(); 
        User user = userData.get(email);
        user.setActive(false); 
        
        userData.update(user);
    } 
    
    
    //Get Users to display for Admin
    public List<User> getAllUsers( ) throws Exception { 
    
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
