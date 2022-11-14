/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.curso.userproject;

/**
 *
 * @author etovarna
 */
public class Management {

    private static String message;
    private static int attempts = 0;
    private static User userTry;
    
    public static boolean hasBeenRegistered(User user){
        return UserDB.containsUser(user);
    }
    
    public static void register(User myUser) {
        if(hasBeenRegistered(myUser)) {
            message = "The user already exists.";
        } else {
            UserDB.addUser(myUser);
            message = "You have successfully registered.";
        }
    }
    
    public static User login(User myUser) {
        User user = null;
        User correctUser = UserDB.getUser(myUser.getUsername());
        if (correctUser == null) {
            message = "The user does not exist.";
        } else if (myUser.getPassword().equals(correctUser.getPassword())) {
            attempts = 0;
            user = correctUser;
            message = "You have successfully logged in.";
        } else {
            
            if (!passwordAttemps(myUser))
                message = "The password is not correct.";
                
        }
        return user;
    }
    
    private static boolean passwordAttemps(User myUser) {
        
        boolean rightPassword = false;
        if (userTry == null) {
                userTry = myUser;
                attempts++;
            } else if (userTry.equals(myUser)) {
                attempts++;
            } else {
                userTry = myUser;
                attempts = 1;
                rightPassword = true;
            }
        return rightPassword;
                
    }

    public static User loginWithSecurityQuestion(User myUser, String securityAnswer) {
        User correctUser = UserDB.getUser(myUser.getUsername());
        if (correctUser == null) {
            message = "The user does not exist.";
            return null;
        }
        if(myUser.getSecurityQuestion() == null) {
            message = "The user does not have a security question";
            return null;
        }
        if (securityAnswer.equals(correctUser.getSecurityAnswer())) {
            attempts = 0;
            return correctUser;
        }
        message = "The security answer is not correct.";
        attempts++;
        return null;
    }

    public static String getMessage() {
        return message;
    }
    
    public static int getAttempts() {
        return attempts;
    }
    
}
