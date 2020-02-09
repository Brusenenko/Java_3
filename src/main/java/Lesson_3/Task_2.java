package Lesson_3;

import java.io.*;
import java.util.ArrayList;
import java.util.Collections;

public class Task_2 {
    public static void main(String[] args) throws IOException {

        ArrayList<InputStream> al = new ArrayList<>();
        al.add(new FileInputStream("1.txt"));
        al.add(new FileInputStream("2.txt"));
        al.add(new FileInputStream("3.txt"));
        al.add(new FileInputStream("4.txt"));
        al.add(new FileInputStream("5.txt"));

        try(FileOutputStream fos = new FileOutputStream("result.txt");
            SequenceInputStream in = new SequenceInputStream(Collections.enumeration(al))
                ){
            int x;
            while ((x = in.read()) != -1) {
                fos.write(x);
            }
        }
    }
}
