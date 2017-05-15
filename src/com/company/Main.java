package com.company;

import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);

        System.out.println("Enter the string: ");
        StringBuffer myString = new StringBuffer(in.nextLine());

        Text s = new Text(myString);
        s.textToGolos();
        s.Sort();
        s.print();

    }
}
