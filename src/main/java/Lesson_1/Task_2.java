package Lesson_1;

//2. Написать метод, который преобразует массив в ArrayList;

import java.util.ArrayList;
import java.util.Arrays;

class Stats<T> {
    private T[] list;

    public Stats(T[] list){
        this.list = list;
    }

    public ArrayList<T> toArrayList(){
        return new ArrayList<T>(Arrays.asList(list));
    }
}

class Task_2 {
    public static void main(String[] args) {
        Integer[] mas1 = new Integer[] {1, 2, 3, 4, 5};
        String[] mas2 = new String[] {"a", "b", "c", "d", "e"};
        Double[] mas3 = new Double[] {1d, 2d, 3d, 4d, 5d};

        Stats<Integer> list1 = new Stats<Integer>(mas1);
        Stats<String> list2 = new Stats<String>(mas2);
        Stats<Double> list3 = new Stats<Double>(mas3);

        ArrayList<Integer> arrayList1 = list1.toArrayList();
        ArrayList<String> arrayList2 = list2.toArrayList();
        ArrayList<Double> arrayList3 = list3.toArrayList();

        System.out.println(arrayList1);
        System.out.println(arrayList2);
        System.out.println(arrayList3);
    }

}