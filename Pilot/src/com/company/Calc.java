package com.company;

import java.util.Scanner;

/**
 * Created by ciba7 on 02.11.2016.
 */
public class Calc {
    public static void main(String[] args) {
        Scanner reader = new Scanner(System.in);
       /* //Write number 1
        System.out.println("Введите первое число ");
        int number1 = reader.nextInt();
        //Write number 2
        System.out.println("Введите второе число ");
        int number2 = reader.nextInt();
        */
        System.out.println("Выберите необходимую операцию над числами: ");
        System.out.println("1 - проссумировать; 2 - посчитать разницу;");
        System.out.println("3 - разделить; 4 - умножить");

        MathOperations logic = new MathOperations();

       // int rezult = 0;
        int operation = reader.nextInt();

        switch (operation) {
            case 1:
                System.out.println("Сумма ваших чисел = " + logic.Sum());
                break;
            case 2:
                System.out.println("Введите 2 числа");
                System.out.println("Разница ваших чисел = " + logic.Otn(reader.nextInt(), reader.nextInt()));
                break;
            case 3:
                System.out.println("Введите 2 числа");
                System.out.println("Деление ваших чисел = " + logic.Del(reader.nextInt(), reader.nextInt()));
                break;
            case 4:
                System.out.println("Введите 2 числа");
                System.out.println("Умножение ваших чисел = " + logic.Umn(reader.nextInt(), reader.nextInt()));
                break;
            default:
                System.out.println("Вы ввели значение не из предложеных");
        }


       /* switch (operation) {
            case 1:
                rezult = number1 + number2;
                break;
            case 2:
                rezult = number1 - number2;
                break;
            case 3:
                rezult = number1 / number2;
                break;
            case 4:
                rezult = number1 * number2;
                break;
            default:
                System.out.println("Вы ввели значение не из предложеных");
        }

        System.out.println("Операция над вашими числами такова: " + );
        */

    }
}
