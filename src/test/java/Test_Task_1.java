import Lesson_6.Task_1;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;

import java.util.Arrays;
import java.util.Collection;

@RunWith(Parameterized.class)
public class Test_Task_1 {
    @Parameterized.Parameters
    public static Collection<Object[]> data() {
        return Arrays.asList(new Object[][] {
                {new int[]{1,7}, new int[]{1,2,4,4,2,3,4,1,7}},
                {new int[]{3,0,7}, new int[]{1,2,0,0,2,4,3,0,7}},
                {new int[]{0,2,3,0,1,7}, new int[]{1,2,4,0,2,3,0,1,7}},
        });
    }
    private Task_1 t;
    private int[] a;
    private int[] b;
    public Test_Task_1(int[] a, int[] b) {
        this.a = a;
        this.b = b;
    }

    @Before
    public void init() {
        t = new Task_1();
    }

    @Test
    public void testTask1() {
        Assert.assertArrayEquals("Arrays are not equals", a, t.task1(b));
    }
}
