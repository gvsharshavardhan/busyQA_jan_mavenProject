package roughPrac;

import listeners.MyListener;
import org.testng.Assert;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

@Listeners(MyListener.class)
public class ListenerTest {

    @Test
    public void test1() {
        Assert.assertTrue(false);
    }

    @Test(dependsOnMethods = {"test1"})
    public void test2() {
    }

    @Test
    public void test3() {
        Assert.assertEquals("abc", "abc");
    }

    @Test
    public void test4() {
        Assert.assertEquals("abc", "abc");
    }

}
