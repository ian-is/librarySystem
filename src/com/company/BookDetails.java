package com.company;

public class BookDetails {

    public static String BookDetails() {             //details about the book
        String bookDetails = "";
        while (bookDetails.equals("")) {
            try {
                String bookTitle = Menu.getInput("Enter the title of your book");
                String author = Menu.getInput("Enter the name of the author");
                String genre = Menu.getInput("Enter the genre of the book");
                int ISBN = Integer.parseInt(Menu.getInput("Enter the ISBN"));
                bookDetails = bookTitle + " , " + author + " , " + genre + " , " + ISBN + " . " + "\n";
            } catch (Exception e) {
                System.out.println("error, please re-enter details" + " " + e);
            }
        }
        return bookDetails;
    }
}
