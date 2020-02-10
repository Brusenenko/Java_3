package Lesson_4;

public class Task_1 {
    private final Object lock = new Object();  // Объект синхронизации
    private volatile char currentLetter = 'A';  // текущая буква
    private final int Q = 5;  // количество итераций в цикле

    public static void main(String[] args) {
        Task_1 test = new Task_1();

        Thread threadA = new Thread(() -> test.printA());
        Thread threadB = new Thread(() -> test.printB());
        Thread threadC = new Thread(() -> test.printC());

        threadA.start();
        threadB.start();
        threadC.start();
    }

    public void printA() {
        synchronized (lock) {
            try {
                for (int i = 0; i < Q; i++) {
                    while (currentLetter != 'A') {
                        lock.wait();
                    }
                    System.out.print("A");
                    currentLetter = 'B';
                    lock.notifyAll();
                }
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }

    public void printB() {
        synchronized (lock) {
            try {
                for (int i = 0; i < Q; i++) {
                    while (currentLetter != 'B') {
                        lock.wait();
                    }
                    System.out.print("B");
                    currentLetter = 'C';
                    lock.notifyAll();
                }
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }

    public void printC() {
        synchronized (lock) {
            try {
                for (int i = 0; i < Q; i++) {
                    while (currentLetter != 'C') {
                        lock.wait();
                    }
                    System.out.print("C");
                    currentLetter = 'A';
                    lock.notifyAll();
                }
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
}