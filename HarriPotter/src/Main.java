import com.sun.xml.internal.ws.server.sei.SEIInvokerTube;

import java.util.*;

public class Main {

    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);

        List<Integer> books = new ArrayList<>();

        System.out.println("Сколько Вам книг Части 1");
        books.add(0, scanner.nextInt());
        System.out.println("Сколько Вам книг Части 2");
        books.add(1, scanner.nextInt());
        System.out.println("Сколько Вам книг Части 3");
        books.add(2, scanner.nextInt());
        System.out.println("Сколько Вам книг Части 4");
        books.add(3, scanner.nextInt());
        System.out.println("Сколько Вам книг Части 5");
        books.add(4, scanner.nextInt());

        System.out.println("Итого вы хотите купить: ");

        System.out.println("Часть 1 - " + books.get(0) + "шт");
        System.out.println("Часть 2 - " + books.get(1) + "шт");
        System.out.println("Часть 3 - " + books.get(2) + "шт");
        System.out.println("Часть 4 - " + books.get(3) + "шт");
        System.out.println("Часть 5 - " + books.get(4) + "шт");



        final int prise = 8;
        double cost = 0;
        int kolvoRaznihKnig = 0;
        while ((books.get(0) > 0) || (books.get(1) > 0) || (books.get(2) > 0) || (books.get(3) > 0) || (books.get(4) > 0) ){
            kolvoRaznihKnig = 0;
            for (int i = 0; i < books.size(); i++){
                if(books.get(i) > 0){
                    kolvoRaznihKnig += 1;
                    books.set(i, books.get(i) - 1);
                }
            }
            switch (kolvoRaznihKnig) {
                case 2:
                    cost += prise * (books.size() - 3) * 0.95;//когда ДВЕ разные книги покупается
                    break;
                case 3:
                    cost += prise * (books.size() - 2) * 0.9;
                    break;
                case 4:
                    cost += prise * (books.size() - 1) * 0.8;
                    break;
                case 5:
                    cost += prise * books.size() * 0.75;
                    break;
                default:
                    cost += prise ;
            }

        }
        System.out.println("Общая стоимость покупки будет составлять: " + cost);


    }
}
