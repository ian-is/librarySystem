package com.company;

import com.sun.xml.internal.ws.api.model.wsdl.WSDLOutput;

import java.io.File;
import java.io.FileWriter;
import java.util.ArrayList;
import java.util.Scanner;
import java.io.IOException;

public class Main {
// create the write to file so that the input is stored
// get the user to input the book title author and isbn number and genre
// something to add to the file list
//make a main menu where user chooses what to do firsts

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

    public static void WriteToFile(){                //add the inputs to the database
        try{
            FileWriter writer = new FileWriter(bookStore.getName(), false);
            for (int i = 0; i < bookList.size(); i++) {
                writer.write(bookList.get(i));
            }
            writer.close();
            System.out.println("added to file");
        }catch(IOException e){
            System.out.println("error");
            e.printStackTrace();
        }
    }
    public static void AddToList(){                   //adds the details to the list
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
    public static String BookDetails (){             //details about the book
        String bookDetails= "";
        while(bookDetails.equals("")){
            try{
                String bookTitle = getInput("Enter the title of your book");
                String author = getInput("Enter the name of the author");
                String genre = getInput("Enter the genre of the book");
                int ISBN = Integer.parseInt(getInput("Enter the ISBN"));
                bookDetails = bookTitle + "," + author + "," + genre + "," + ISBN;
            }catch (Exception e){
                System.out.println("error, please re-enter details" + " " + e);
            }
        }
        return bookDetails;
    }

    public static void main(String[] args) {         //main menu
        boolean choice = true;
        while (choice){
            String menu = getInput("would you like to:" + "add a book," + " " +" " +"search for a book," + " "  +" "+ "Exit");
            if (menu.equalsIgnoreCase("add a book")){
                userInput();
                BookDetails();
            }
            if (menu.equalsIgnoreCase("exit")){
                CreateFile();
                WriteToFile();
                choice = false;
           }else{
                System.out.println("this option does not exist");
            }
            }
        System.out.println(bookList);




    }
}
