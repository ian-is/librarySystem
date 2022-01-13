package com.company;
import java.util.Scanner;
public class Menu {

    public static String getInput(String prompt){
        System.out.println(prompt);
        Scanner input = new Scanner(System.in);
        return input.nextLine();


    }



    }

