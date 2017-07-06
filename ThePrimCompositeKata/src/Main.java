import java.util.Arrays;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) {

        Scanner scan = new Scanner(System.in);
        System.out.println("Write length Array");
        Integer n = scan.nextInt();
        Integer[] arr = new Integer[n];//Определили массив из 101 интом так как в джава индексация начинается с 0
        Integer i;

        System.out.println("Get your Prime numbers");
        for (i = 1; i < arr.length; i++) {//цикл который бегает по массиву (и=1 так как нам нужны значения от 1 до 100
            if ((i % 2 == 0) && (i / 2 != 1)) {//оотсеиваем все четные значения кроме 2
                System.out.println("Even " + i);
            } else if ((i % 3 == 0) && (i / 3 != 1)) {//отсеиваем значения кратные 3 кроме 3
                System.out.println("Composite " + i);
            } else if ((i % 5 == 0) && (i / 5 != 1)) {//отсеиваем значения кратные 5 кроме 5
                System.out.println("Composite " + i);
            } else if ((i % 7 == 0) && (i / 7 != 1)) {//отсеиваем значения кратные 7 кроме 7
                System.out.println("Composite " + i);
            } else System.out.println("Prime " + i);//выводим все простые числа

        }

    }
}