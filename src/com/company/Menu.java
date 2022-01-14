package com.company;

import java.util.Scanner;
                                                                       // this class contains the menu of the system: get input, main menu methods
import static com.company.Main.AddToList;

public class Menu {

    public static String getInput(String prompt) {
        System.out.println(prompt);
        Scanner input = new Scanner(System.in);
        return input.nextLine();


    }

    public static void mainMenu() {

        String logInMenu = Menu.getInput("would you like to log in or register");
        if (logInMenu.equals("log in")) {
            Members.LogIn();
        } else if (logInMenu.equals("register")) {
           Members.UserRegister();

        }

        boolean choice = true;
        while (choice) {
            String menu = Menu.getInput("would you like to:" + "add a book," + " " + " " + "search for a book," + " " + " " + "Exit");
            if (menu.equalsIgnoreCase("add a book")) {
                // userInput();
                AddToList();
                // BookDetails();
            }
            if (menu.equalsIgnoreCase("exit")) {
              FileHandling.CreateFile();
                FileHandling.WriteToFile();
                choice = false;
            } else {
                System.out.println("this option does not exist");
            }
        }
        System.out.println(FileHandling.bookList);
    }


}

