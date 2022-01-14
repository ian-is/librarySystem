package com.company;
// contains the methods to the user input, log in, user register
import java.util.Scanner;

public class Members {


    public static void userInput() {               //gets user to input the book title
        try {
            Scanner input = new Scanner(System.in);

            int numOfBooks = Integer.parseInt(Menu.getInput("how many books do you want to add"));
            String[] bookTitle = new String[numOfBooks];
            for (int i = 0; i < numOfBooks; i++) {
                bookTitle[i] = Menu.getInput("please enter your book title" + " " + " " + (i + 1));
            }
        } catch (Exception e) {
            System.out.println();
        }
    }
    public static void LogIn() {                           //get the user to input their log in details

        String userInputLogin = Menu.getInput("Hello, would you like to sign in");
        if (userInputLogin.equals("yes")) {
            String userLogIn = Menu.getInput("enter your email");
            String userPassword = Menu.getInput("enter your password");
        }

    }

    static String UserRegister() {
        // String userRegister = getInput("would you like to register");
        //if (userRegister.equals("yes")){
        String emailAndPassword = "";

        String userEmailRegister = Menu.getInput("enter a email you would like to register");
        String userPasswordRegister = Menu.getInput("Enter a password you would like to register");
        emailAndPassword = userEmailRegister + "," + userPasswordRegister + "." + "\n";

        return emailAndPassword;

    }
}
