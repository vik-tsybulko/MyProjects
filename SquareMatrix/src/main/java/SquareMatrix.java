import com.sun.org.apache.xerces.internal.impl.xpath.regex.Match;

import java.util.Scanner;

public class SquareMatrix {

    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);
        System.out.println("Write positive number");
        int inputNumber = scanner.nextInt();
        int counter = 0;
        int counter1 = inputNumber;
        int counter3 = 0;

//        for(int i = 0; i < inputNumber; i++){
//            for (int j = 0; j < inputNumber; j++){
//                System.out.print(counter + 1);
//                counter++;
//            }
//            System.out.println();
//        }
//        System.out.println();
//        for (int j = 0; j < inputNumber; j++){
//            for (int i = 0; i < inputNumber; i++){
//                System.out.print(counter1);
//                counter1--;
//            }
//            System.out.println();
//            counter1 = inputNumber * (j+2);
//        }



        for(int c1 = 0; c1 < inputNumber; c1++){
            System.out.print(counter3 + 1);
            counter3++;
        }
        System.out.println();

        if(inputNumber % 2 == 0) {

            for (int c2 = 0; c2 < inputNumber - 1; c2++) {

                if ((counter3 + inputNumber) % 2 == 0) {

                    counter3 += inputNumber;
                    for (int c4 = 0; c4 < inputNumber; c4++) {//чет
                        System.out.print(counter3);
                        counter3--;
                    }
                    counter3 += inputNumber + 1;

                } else {
                    for (int c3 = 0; c3 < inputNumber; c3++) {//нечет
                        System.out.print(counter3);
                        counter3++;
                    }
                    counter3 -= 1;
                }
                System.out.println();
            }
        }else {
            for (int c2 = 0; c2 < inputNumber - 1; c2++) {

                if ((counter3 + inputNumber) % 2 == 0) {

                    counter3 += inputNumber;
                    for (int c4 = 0; c4 < inputNumber; c4++) {//чет
                        System.out.print(counter3);
                        counter3--;
                    }
                    counter3 += inputNumber;

                } else {
                    for (int c3 = 0; c3 < inputNumber; c3++) {//нечет
                        System.out.print(counter3 + 1);
                        counter3++;
                    }
                    //counter3 -= 1;
                }
                System.out.println();
            }

        }

        System.out.println("___________________________");
        /*
 Заполнение по спирали двумерного массива со сторонами А Х В любого размера
 при условии, что А = В
 */
                // Выбираем размер стороны квадрата и рассчитываем общее количество элементов массива
        System.out.println("Write positive number");
                int Size = scanner.nextInt();
                int Max = Size * Size;
        /*
         координаты и рамки заполнения массива
         x[0],y[0] – нижние динамические границы
         x[1],y[1] – верхние динамические границы
         x[2],y[2] – текущие координаты
         x[3],y[3] – вектор смещения
         */
                int RC = 4;
                int[] x = new int[RC];
                int[] y = new int[RC];
                // Объявляем массив для заполнения
                int[][] Sp = new int[Size][Size];
                // Задаём начальные значения координат и рамок
                for (int i = 0; i < RC; i++) {
                    x[i] = y[i] = 0;
                }
                x[1] = y[1] = Size - 1;
                x[3] = 1;
                // Заполняем массив
                for (int i = 0; i < Max; i++) {
                    //Используем массив как координатное поле
                    Sp[x[2]][y[2]] = i + 1;
                    // Рассчитываем текущие координаты
                    x[2] = x[2] + x[3];
                    y[2] = y[2] + y[3];
                    // Рассчёт вектора смещения
                    if (y[3] == 0) {
                        if ((x[2] > x[0]) && (x[3] > 0)) {
                            x[3] = 1;
                        }
                        if ((x[2] < x[1]) && (x[3] < 0)) {
                            x[3] = -1;
                        }
                        if ((x[2] == x[1]) && (x[3] > 0)) {
                            x[3] = 0;
                            x[1]--;
                            y[3] = 1;
                        }
                        if ((x[2] == x[0]) && (x[3] < 0)) {
                            x[3] = 0;
                            x[0]++;
                            y[3] = -1;
                        }
                    }
                    if (x[3] == 0) {
                        if ((y[2] > y[0]) && (y[3] > 0)) {
                            y[3] = 1;
                        }
                        if ((y[2] < y[1]) && (y[3] < 0)) {
                            y[3] = -1;
                        }
                        if ((y[2] == y[1]) && (y[3] > 0)) {
                            y[3] = 0;
                            y[1]--;
                            x[3] = -1;
                        }
                        if ((y[2] == x[0]) && (y[3] < 0)) {
                            y[3] = 0;
                            y[0]++;
                            x[3] = 1;
                        }
                    }
                }
                // Печать массива заполненного данными по спирали
                System.out.println();
                for (int i = 0; i < Size; i++) {
                    for (int j = 0; j < Size; j++) {
                        System.out.format("%4d", Sp[j][i]);
                    }
                    System.out.println();
                }




    }
}
