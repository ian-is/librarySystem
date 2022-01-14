package com.company;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;

import com.company.Main;

public class FileHandling {


    public static File bookStore = new File("bookDataBase.txt");
    private static File logInDetails = new File("LogInDetails.txt");
    public static ArrayList<String> bookList = new ArrayList<>();


    public static void CreateFile() {                       //creates the file
        try {

            if (FileHandling.bookStore.createNewFile()) {
                System.out.println("file created:" + FileHandling.bookStore.getName());
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
            FileWriter writer = new FileWriter(FileHandling.bookStore.getName(), true);
            for (int i = 0; i < FileHandling.bookList.size(); i++) {
                writer.write(FileHandling.bookList.get(i));
            }
            writer.close();
            System.out.println("added to file");
        } catch (IOException e) {
            System.out.println("error");
            e.printStackTrace();
        }
    }

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

    private static void writeToLogInFile(String details) {
        try {
            FileWriter writer = new FileWriter(logInDetails.getName(), true);
            writer.write(details);
            writer.close();
            System.out.println("successfully added to the file");
        } catch (IOException e) {
            System.out.println("error");
            e.printStackTrace();

        }
    }

    public static void AddToList() {                   //adds the details to the list
        int add = Integer.parseInt(Menu.getInput("how many books would you like to add"));
        for (int i = 0; i < add; i++) {
            bookList.add(BookDetails.BookDetails());
        }
    }
}
