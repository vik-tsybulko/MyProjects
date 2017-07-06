import javax.management.ObjectName;
import java.io.*;
import java.lang.reflect.Array;
import java.nio.CharBuffer;
import java.util.Collections;
import java.util.ArrayList;
import java.util.List;
import java.util.*;
import java.util.Iterator.*;
import java.text.Collator;
import java.util.Locale;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Task1Read {

    public static File fw = new File("F:\\JavaProjects\\bb.txt");
    public static File fr = new File("F:\\JavaProjects\\aa.txt");

    public static void main(String[] agrs) {


        List  coll = new ArrayList((int) fr.length());

        try (BufferedReader r = new BufferedReader(new FileReader(fr))){
            String line;
            while ((line = r.readLine()) !=null){
                System.out.println(line);
            }
        } catch (IOException ex) {
            System.out.println(ex.getMessage());
        }
     Collections.sort(coll, new Comparator<Object>() {
                 public int compare(Object o1, Object o2) {
                     return o1.toString().compareTo(o2.toString());
                 }
             });
     System.out.println(coll.size());
        //try (BufferedReader reader = new BufferedReader(new FileReader(fr)));


//        try (FileWriter w = new FileWriter(fw)){
//        w.write(String.valueOf(Text));
//
//        } catch (IOException ex){
//            System.out.println(ex.getMessage());
//        }
    }

   }