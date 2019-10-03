package sqeare;

import org.testng.Assert;
import org.testng.annotations.Test;

public class EquationTests {

    @Test
    public void test0 (){
        Equation c = new Equation (1,1,1);
        Assert.assertEquals(c.rootNumber(), 0);
    }

    @Test
    public void test1 (){
        Equation c = new Equation (1,2,1);
        Assert.assertEquals(c.rootNumber(), 1);
    }

    @Test
    public void test2 (){
        Equation c = new Equation (1,5,6);
        Assert.assertEquals(c.rootNumber(), 2);
    }
}
