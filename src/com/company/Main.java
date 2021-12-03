package com.company;

import java.io.File;
import java.util.ArrayList;
import java.util.Scanner;
import java.io.IOException;

public class Main {

    private static File bookStore = new File("bookDataBase.txt");
    private static ArrayList<String> bookList = new ArrayList<>();


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
    public static void userInput() {               //gets user to input the book title
        try {
            Scanner input = new Scanner(System.in);

            int numOfBooks = Integer.parseInt(getInput("how many books do you want to add"));
            String[] bookTitle = new String[numOfBooks];
            for (int i = 0; i < numOfBooks; i++) {
                bookTitle[i] = getInput("please enter your book title" + " " + (i + 1));
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

    public static void main(String[] args) {


        userInput();

        CreateFile();

    }
}
