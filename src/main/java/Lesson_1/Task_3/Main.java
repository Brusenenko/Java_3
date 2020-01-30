package Lesson_1.Task_3;

public class Main {
    public static void main(String[] args) {
        // Создание экземпляров фруктов
        Apple apple = new Apple();
        Orange orange = new Orange();

        // Создание экземпляров ящиков для фруктов
        Box<Apple> appleBox = new Box<Apple>();
        Box<Orange> orangeBox = new Box<Orange>();

        // Помещаем фрукты в ящики

        orangeBox.putFruit(14, orange);
        appleBox.putFruit(21, apple);

        System.out.println("Вес ящика для апельсинов: " + orangeBox.getWeight());
        System.out.println("Вес ящика для яблок: " + appleBox.getWeight());

        // сравнение ящиков методом compare

        if (appleBox.compare(orangeBox)){   // true
            System.out.println("Ящик, в котором " + orangeBox.getCount() + " апельсинов весит столько же, сколько и ящик, в котором " + appleBox.getCount() + " яблок");
        }

        //пересыпаем содержимое ящика
        Box<Apple> appleBox2 = new Box<Apple>();
        System.out.println("Вес первого ящика с яблоками до пересыпки: " + appleBox.getWeight());
        System.out.println("Вес второго ящика с яблоками до пересыпки: " + appleBox2.getWeight());

        appleBox.shift(appleBox2);

        // проверка
        System.out.println("Вес первого ящика с яблоками после пересыпки: " + appleBox.getWeight());
        System.out.println("Вес второго ящика с яблоками после пересыпки: " + appleBox2.getWeight());

        // Проверка сортировки
        Box<Orange> orangeBox2 = new Box<Orange>();
        //appleBox.shift(orangeBox); // Ошибка. В ящик для яблок нельзя класть апельсины
    }
}
