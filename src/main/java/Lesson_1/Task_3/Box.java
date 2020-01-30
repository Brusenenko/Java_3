package Lesson_1.Task_3;

import java.util.ArrayList;

public class Box<T extends Fruit> {
    private ArrayList<T> fruitList;

    private int count;

    public Box() {
        this.fruitList = new ArrayList<T>();
    }

    public int getCount() {
        return count;
    }

    public float getWeight() {
        if (this.fruitList.size() == 0)
            return 0;
        float weight = 0;
        for (T fruit : fruitList)
            weight += fruit.getWeight();
        return weight;
    }

    public void putFruit(int count, T fruit){
        for (int i = 0; i < count; i++) {
            this.fruitList.add(fruit);
            this.count++;
        }
    }

    public boolean compare(Box box) {
        return this.getWeight() == box.getWeight();

    }

    public void shift (Box<? super T> box){
        box.fruitList.addAll(this.fruitList);
        this.fruitList.clear();
    }

}
