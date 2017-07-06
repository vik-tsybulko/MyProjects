import java.io.*;
import java.io.File;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Sorted {
    public static void main(String[] args) throws FileNotFoundException {
        String f = "/media/viktor/D2DE64D6DE64B3FF/JavaProjects/Task_1Tkach/src/main/resources/aa.txt";
        String r;
        List<String> list = new ArrayList<String>();
        BufferedReader reader = new BufferedReader(new FileReader(f));
        try {

            while ((r = reader.readLine()) !=null) {
                list.add(r);
            }
            //String[] lineAsArray = list.toArray(new String[list.size()]);
            reader.close();
            System.out.println(Arrays.toString(list));
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
