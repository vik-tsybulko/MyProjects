package com.company;


import java.util.Scanner;

/**
 * Created by ciba7 on 02.11.2016.
 */
public class MathOperations {
    Scanner reader = new Scanner(System.in);

    public int Sum() {
                System.out.println("Введите 1-ое число");
                int n1 = reader.nextInt();
                System.out.println("Введите 2-ое число");
                int n2 = reader.nextInt();
        return n1 + n2 ;
    }

    public int Otn(int number1, int number2) {
        return number1 - number2;
    }

    public int Umn(int number1, int number2){
        return number1 * number2;
    }
    public int Del(int number1, int number2){
        return number1 / number2;
    }



}
