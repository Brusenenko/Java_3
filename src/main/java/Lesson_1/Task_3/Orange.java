package Lesson_1.Task_3;

public class Orange extends Fruit {

    public Orange (){
        super.weight = 1.5f;
    }

    @Override
    public float getWeight() {
        return weight;
    }
}
