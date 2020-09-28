import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;

import java.util.Arrays;
import java.util.Collection;

@RunWith(Parameterized.class)
public class TestTasks {
    @Parameterized.Parameters
    public static Collection<Object[]> data() {
        return Arrays.asList(new Object[][] {
                {new int[]{4,1}, new int[]{1,4,0}},
                {new int[]{1,2}, new int[]{1,2,0,1,2,3,0,1,7}},
                {new int[]{1,7}, new int[]{1,2,4,4,2,1,1,3,0,4,1,7}},
                {new int[]{0,2,3,0,1,7}, new int[]{1,2,4,0,2,3,0,1,7}},
        });
    }

    private Tasks tasks;
    private int[] a;
    private int[] b;
    private boolean found = true;

    public TestTasks(int[] a, int[] b) {
        this.a = a;
        this.b = b;
    }

    @Before
    public void init() {
        tasks = new Tasks();
    }

    @Test
    public void testTask1() {
        Assert.assertTrue("Arrays are not equals", Arrays.equals(a, tasks.task1(b)));
    }

    @Test
    public void testTask2() {
        Assert.assertEquals(found, tasks.task2(b));
    }
}
