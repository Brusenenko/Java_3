import Lesson_6.Task_2;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;

import java.util.Arrays;
import java.util.Collection;

@RunWith(Parameterized.class)
public class Test_Task_2 {
    @Parameterized.Parameters
    public static Collection<Object[]> data() {
        return Arrays.asList(new Object[][] {
                {false, new int[]{2,1,4,4,1,1}},
                {false, new int[]{4,4,4,4,4}},
                {false, new int[]{1,1,1}},
                {true, new int[]{1,1,4,4,4,4,1,1}},
        });
    }

    private Task_2 t;
    private boolean a;
    private int[] b;

    public Test_Task_2(boolean a, int[] b) {
        this.a = a;
        this.b = b;
    }

    @Before
    public void init() {
        t = new Task_2();
    }

    @Test
    public void testTask2() {
        Assert.assertEquals(a, t.task2(b));
    }
}
