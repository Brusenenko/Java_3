package Lesson_1;

//1. Написать метод, который меняет два элемента массива местами (массив может быть любого ссылочного типа);

public class Task_1 {
    public static void main(String[] args) {
        Integer[] list1 = new Integer[] {1, 2, 3, 4, 5};
        String[] list2 = new String[] {"1", "2", "3", "4", "5"};

        swap(list1, 2, 3);
        swap(list2, 2, 5);
    }
    // метод swap меняет местами два эдемента массива, где a и b - порядковые номера эдементов

    public static void swap(Object[] list, int a, int b){
        if (a <= list.length && b <= list.length){
            Object buf = list[a-1];
            list[a-1] = list[b-1];
            list[b-1] = buf;

            for (Object obj : list) {
                System.out.print(obj + " ");
            }

            System.out.println();

        } else{
            System.out.println("Недопустимые значения");
        }

    }
}
