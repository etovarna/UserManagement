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

    private static String errorMessage;
    private static int attempts = 0;
    private static User userTry;
    
    public static User register(User user) {
        if(UserDB.containsUser(user)) {
            errorMessage = "The user already exists.";
            return null;
        }
        UserDB.addUser(user);
        return user;
    }
    
    public static User login(User myUser) {
        User user = null;
        User correctUser = UserDB.getUser(myUser.getUsername());
        if (correctUser == null) {
            errorMessage = "The user does not exist.";
        } else if (myUser.getPassword().equals(correctUser.getPassword())) {
            attempts = 0;
            user = correctUser;
        } else{
            errorMessage = "The password is not correct.";
            if(userTry == null) {
                userTry = myUser;
                attempts++;
            } else if(userTry.equals(myUser)) {
                attempts++;
            } else {
                userTry = myUser;
                attempts = 1;
            }
        }
        return user;
    }
    
    private static User check

    public static User loginWithSecurityQuestion(User myUser, String securityAnswer) {
        User correctUser = UserDB.getUser(myUser.getUsername());
        if (correctUser == null) {
            errorMessage = "The user does not exist.";
            return null;
        }
        if(myUser.getSecurityQuestion() == null) {
            errorMessage = "The user does not have a security question";
            return null;
        }
        if (securityAnswer.equals(correctUser.getSecurityAnswer())) {
            attempts = 0;
            return correctUser;
        }
        errorMessage = "The security answer is not correct.";
        attempts++;
        return null;
    }

    public static String getErrorMessage() {
        return errorMessage;
    }
    
    public static void setErrorMessage(String message) {
        errorMessage = message;
    }
    
    public static int getAttempts() {
        return attempts;
    }

    public static void setAttempts(int attempts) {
        Management.attempts = attempts;
    }
    
}
