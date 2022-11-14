/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Project/Maven2/JavaApp/src/main/java/${packagePath}/${mainClassName}.java to edit this template
 */

package com.curso.userproject;

import java.util.Scanner;

/**
 *
 * @author etovarna
 */
public class UserProject {

    public static void main(String[] args) {
        
        Scanner sc = new Scanner(System.in);
        int option = -1;
        int loggedOption = -1;
        boolean exit = false;
        boolean loggedExit = false;
        
        System.out.println("Hello! You are using an user management app.");
        System.out.println("");
        
        while (!exit) {
            while (option < 1 || option > 3){
                System.out.println("""
                                   Please enter a option to choose what you would like
                                   
                                   1) register
                                   2) log in
                                   3) exit
                                   """);
                option = sc.nextInt();
                sc.nextLine();
                
            }
            User myUser = new User();
            String username, password, email;
            switch (option){
                case 1:
                    System.out.println("");
                    System.out.print("Enter an username: ");
                    username=sc.nextLine();
                    myUser.setUsername(username);
                    System.out.println("");
                    System.out.print("Enter a password: ");
                    password=sc.nextLine();
                    myUser.setPassword(password);
                    System.out.println("");
                    System.out.print("Enter an email: ");
                    email=sc.nextLine();
                    myUser.setEmail(email);
                    Management.register(myUser);
                    System.out.println("");
                    System.out.println(Management.getMessage());
                    break;
                case 2:
                    System.out.println("");
                    System.out.print("Enter your username: ");
                    username=sc.nextLine();
                    myUser.setUsername(username);
                    System.out.println("");
                    System.out.print("Enter your password: ");
                    password=sc.nextLine();
                    myUser.setPassword(password);
                    if (myUser == Management.login(myUser)) {
                        loggedExit = true;
                    }
                    System.out.println("");
                    System.out.println(Management.getMessage());
                    while (!loggedExit) {
            
                        while (loggedOption < 1 || loggedOption > 4){
                            System.out.println("");
                            System.out.println("""
                                               Please enter a option to choose what you would like

                                               1) set a security question
                                               2) change your email
                                               3) change your password
                                               4) log out
                                               """);
                            loggedOption = sc.nextInt();
                            sc.nextLine();
                        }
                        switch (loggedOption){
                            case 1:
                                String securityQuestion, securityAnswer;
                                System.out.println("");
                                System.out.print("Enter a security question: ");
                                securityQuestion=sc.nextLine();
                                myUser.setSecurityQuestion(securityQuestion);
                                System.out.println("");
                                System.out.print("Enter a security answer: ");
                                securityAnswer=sc.nextLine();
                                myUser.setSecurityAnswer(securityAnswer);
                                System.out.println("");
                                System.out.println("You have set a security question and a security answer");
                                break;
                            case 2:
                                System.out.println("");
                                System.out.print("Enter your new email: ");
                                email=sc.nextLine();
                                myUser.setEmail(email);
                                System.out.println("");
                                System.out.println("You have successfully changed your email.");
                                break;
                            case 3:
                                System.out.println("");
                                System.out.print("Enter your new password: ");
                                password=sc.nextLine();
                                myUser.setPassword(password);
                                System.out.println("");
                                System.out.println("You have successfully changed your password.");
                                break;
                            case 4:
                                System.out.println("");
                                System.out.println("You have successfully logged out.");
                                loggedExit = true;
                                break;
                        }
                        
                        loggedOption=-1;
                        
                    }
                    break;
                case 3:
                    System.out.println("");
                    System.out.println("Goodbye!");
                    exit = true;
                    break;
            }
            
            System.out.println("");
            option=-1;
            
        }
        
    }
}
