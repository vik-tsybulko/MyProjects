import java.io.*;
import java.util.ArrayList;


public class Exercise_1 {


    /** Файл, с которого мы берем текст */
    static File f = null;
    /** Путь к файлу */
    static String path = "resources/1.txt"; //Тут был адрес файла
    /** Строка, считываемая в данный момент */
    static String line;
    /**  ФайлРидер */
    static FileReader fR = null;
    /** БуфередРидер */
    static BufferedReader bR = null;

    /** Список слов, которые мы будем искать в тексте */
    static ArrayList<String> words = new ArrayList<String>();

    /** Строка, которую мы обрабатываем в данный момент в нижнем регистре (line lower case) */
    static String lineLC = null;
    /** Слово, которое мы ищем в данный момент в нижнем регистре (word lower case)*/
    static String wordLC = null;

    /** Номер текущей строки */
    static int currLine = 1;
    /** Начальная позиция в строке, с которой начинать отображение */
    static int beginI = 0;
    /** Конечная позиция в строке, с которой начинать отображение */
    static int endI = 0;
    /** Позиция искомого слова в строке */
    static int wordPos = 0;
    public static void main (String args []){
        try {
            f = new File(path);
            fR = new FileReader(f);
        } catch (FileNotFoundException e) {
            System.out.println("File not found at: " + path);
        }
        BufferedReader bR = new BufferedReader(fR);
 
		/* Тут просто список искомых слов (или букв или словосочетаний) */
        words.add("World");
        words.add("of");
			
		/* Программа по очереди считывает каждую строчку в файле, и если в ней содержится 
		 * нужное нам слово, то выводит по 10 символов до и после слова (вместе с самим словом).
		 * */
        try {
            while ((line = bR.readLine()) != null){
                System.out.println("String number: " + currLine + "");
                lineLC = line.toLowerCase();
                currLine++;
                for(int w = 0; w < words.size(); w++){
                    wordLC=words.get(w).toLowerCase();

                    if(lineLC.contains(wordLC)){
                        wordPos = lineLC.lastIndexOf(wordLC);

                        beginI = wordPos;
                        if(beginI<10){
                            beginI = 0;
                        } else {
                            beginI-=10;
                        }

                        endI = wordPos;
                        if(endI>(lineLC.length() - wordLC.length() - 10)){
                            endI = lineLC.length();
                        } else {
                            endI += wordLC.length() + 10;
                        }
						
						/* Я сделал именно таким, немного громоздким способом чтобы 
						 * можно было выделить искомое слово большими буквами */
                        System.out.println("   ..."
                                + line.substring(beginI, wordPos)
                                + words.get(w).toUpperCase()
                                + line.substring(wordPos + wordLC.length(), endI)
                                + "...");

                    }

                }

            }


            fR.close();
            bR.close();
        } catch (IOException e) {
            System.out.println("Input/Output error: " + e.toString());
        }


    }
}