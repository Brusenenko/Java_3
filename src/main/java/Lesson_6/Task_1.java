package Lesson_6;

public class Task_1 {
    public int[] task1(int[] arr) throws RuntimeException {
        int[] res;
        int i = arr.length - 1;
        int j = 0;
        boolean found = false;
        while (i >= 0 && !found) {
            found = arr[i] == 4;
            j = i;
            i--;
        }
        if(found) {
            res = new int[arr.length - j - 1];
            for (i = j + 1; i < arr.length; i++) {
                res[i - j - 1] = arr[i];
            }
        } else {
            throw new RuntimeException("Массив не содержит 4");
        }
        return  res;
    }
}
