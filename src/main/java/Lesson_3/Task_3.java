package Lesson_3;

import java.io.*;

public class Task_3 {

    public static void main(String[] args) throws IOException {
        int pageSize = 1800;    // кол-во символов на странице
        int maxLineLength = 100;    // кол-во символов в строке при выводе на консоль
        String bookPath = "book.txt"; // Путь к файлу

        File file = new File(bookPath);

        try (BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
             RandomAccessFile raf = new RandomAccessFile(bookPath, "r")
                ){
            System.out.println(String.format("Всего страниц в книге: %d. Введите номер страницы:", file.length()/pageSize));

            int numPage = Integer.parseInt(reader.readLine());

            raf.seek((numPage - 1) * pageSize);
            byte[] page = new byte[pageSize];
            raf.read(page);

            int lineLength = 0;
            for (byte b : page) {
                if (lineLength < maxLineLength) {
                    System.out.print((char)b);
                    lineLength++;
                } else {
                    System.out.println();
                    lineLength = 0;
                }
            }
        }
    }
}
