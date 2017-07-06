package com.company;

import java.util.Scanner;

public class AwesomeStack {

    public static void main(String[] args) {
        Stack mStack = new Stack(10);
        Scanner scanner = new Scanner(System.in);

        mStack.addElement(scanner.nextInt());
        mStack.addElement(scanner.nextInt());
        mStack.addElement(scanner.nextInt());
        mStack.addElement(scanner.nextInt());

        //mStack.deleteElement();

        System.out.print("Стек: ");
        while (!mStack.isEmpty()) {
            int value = mStack.deleteElement();
            System.out.print(value);
            System.out.print(" ");
        }
        System.out.println("");
    }
}