package Lesson_3;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;

public class Task_1 {

    public static void main(String[] args) throws IOException {

        File file = new File("text.txt");

        try (FileInputStream inputStream = new FileInputStream(file)){
            byte[] buffer = new byte[(int) file.length()];

             int count = inputStream.read(buffer); // чтение файла сразу в блок байт

            // вывод байт в косоль
            for (byte b : buffer) {
                System.out.print(b);
            }

            // вывод char в косоль
            for (byte b : buffer) {
                System.out.print((char) b);
            }
        }
    }

}
