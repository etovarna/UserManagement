/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.curso.userproject;

import java.util.HashMap;
import java.util.Map;

/**
 *
 * @author etovarna
 */
public class UserDB {
    
    private static HashMap<String,User> users = new HashMap<>(){{
        users.put("edu", new User("edu", "1234abcd", "edu@t-systems.com"));      
        users.put("javi", new User("javi", "123", "javi@t-systems.com"));
    }};
    
    public static User getUser(String username){
        return users.get(username);
    }
    
    public static boolean containsUser(User user){
        return users.containsValue(user);
    }
    
    public static void addUser(User user){
        users.put(user.getUsername(), user);
    }
    
    //Add a method to print users
    
}
