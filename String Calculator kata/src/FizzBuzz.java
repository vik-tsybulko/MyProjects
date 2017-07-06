import java.util.Scanner;

public class FizzBuzz {
    public static void main(String[] args) {

        int i;
        int[] arr = new int[101];
        for(i=1; i<arr.length; i++) {
            if (i % 3 != 0 || i % 5 != 0) {
                if (i % 3 != 0) {
                    if (i % 5 != 0) {
                        System.out.println(i);
                    } else System.out.println("Buzz");
                } else System.out.println("Fizz");
            }else System.out.println("FizzBuzz");
        }
    }


}