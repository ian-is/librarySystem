package com.company;

import com.sun.xml.internal.ws.api.model.wsdl.WSDLOutput;

import java.io.File;
import java.io.FileWriter;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Scanner;
import java.io.IOException;

public class Main {
//add a sign in and register system

    private static File bookStore = new File("bookDataBase.txt");
    private static File logInDetails = new File("LogInDetails.txt");
    private static ArrayList<String> bookList = new ArrayList<>();


    public static void main(String[] args) {   //main menu

        String logInMenu = getInput("would you like to log in or register");
        if (logInMenu.equals("log in")) {
            LogIn();
        } else if (logInMenu.equals("register")) {
            UserRegister();

        }


        boolean choice = true;
        while (choice) {
            String menu = getInput("would you like to:" + "add a book," + " " + " " + "search for a book," + " " + " " + "Exit");
            if (menu.equalsIgnoreCase("add a book")) {
                // userInput();
                AddToList();
                // BookDetails();
            }
            if (menu.equalsIgnoreCase("exit")) {
                CreateFile();
                WriteToFile();
                choice = false;
            } else {
                System.out.println("this option does not exist");
            }
        }
        System.out.println(bookList);
    }


    public static void CreateFile() {                       //creates the file
        try {

            if (bookStore.createNewFile()) {
                System.out.println("file created:" + bookStore.getName());
            } else {
                System.out.println("this file already exists");     // if the same file is added again it will give an error
            }
        } catch (IOException e) {
            System.out.println("an error has occurred");
            e.printStackTrace();
        }
    }

    public static void WriteToFile() {                //add the inputs to the database
        try {
            FileWriter writer = new FileWriter(bookStore.getName(), true);
            for (int i = 0; i < bookList.size(); i++) {
                writer.write(bookList.get(i));
            }
            writer.close();
            System.out.println("added to file");
        } catch (IOException e) {
            System.out.println("error");
            e.printStackTrace();
        }
    }

    public static void AddToList() {                   //adds the details to the list
        int add = Integer.parseInt(getInput("how many books would you like to add"));
        for (int i = 0; i < add; i++) {
            bookList.add(BookDetails());
        }
    }

    public static void userInput() {               //gets user to input the book title
        try {
            Scanner input = new Scanner(System.in);

            int numOfBooks = Integer.parseInt(getInput("how many books do you want to add"));
            String[] bookTitle = new String[numOfBooks];
            for (int i = 0; i < numOfBooks; i++) {
                bookTitle[i] = getInput("please enter your book title" + " " + " " + (i + 1));
            }
        } catch (Exception e) {
            System.out.println();
        }
    }

    public static String getInput(String prompt) {
        System.out.println(prompt);
        Scanner input = new Scanner(System.in);
        return input.nextLine();
    }

    public static String BookDetails() {             //details about the book
        String bookDetails = "";
        while (bookDetails.equals("")) {
            try {
                String bookTitle = getInput("Enter the title of your book");
                String author = getInput("Enter the name of the author");
                String genre = getInput("Enter the genre of the book");
                int ISBN = Integer.parseInt(getInput("Enter the ISBN"));
                bookDetails = bookTitle + " , " + author + " , " + genre + " , " + ISBN + " . " + "\n";
            } catch (Exception e) {
                System.out.println("error, please re-enter details" + " " + e);
            }
        }
        return bookDetails;
    }

    // this is for the user login and register

    private static void CreateLogInFile() {
        try {
            if (logInDetails.createNewFile()) {
                System.out.println("file created:" + logInDetails.getName());
            } else {
                System.out.println("this file already exists");     // if the same file is added again it will give an error
            }
        } catch (IOException e) {
            System.out.println("an error has occurred");
            e.printStackTrace();

        }
    }

    private static void writeToLogInFile() {
        try {
            String accountDetails = "";
            FileWriter writer = new FileWriter(logInDetails.getName(), true);
            writer.write(accountDetails);
            writer.close();
            System.out.println("successfully added to the file");
        } catch (IOException e) {
            System.out.println("error");
            e.printStackTrace();

        }
    }


    private static void LogIn() {                           //get the user to input their log in details

        String userInputLogin = getInput("Hello, would you like to sign in");
        if (userInputLogin.equals("yes")) {
            String userLogIn = getInput("enter your email");
            String userPassword = getInput("enter your password");
        }

    }

    private static String UserRegister() {
        // String userRegister = getInput("would you like to register");
        //if (userRegister.equals("yes")){
        String emailAndPassword = "";

        String userEmailRegister = getInput("enter a email you would like to register");
        String userPasswordRegister = getInput("Enter a password you would like to register");
        emailAndPassword = userEmailRegister  + "," + userPasswordRegister + "." +  "\n";

        return emailAndPassword;
}

    }




































