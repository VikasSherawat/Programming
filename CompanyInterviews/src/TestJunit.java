import junit.framework.TestCase;
import org.junit.Assert;
import org.junit.Test;

/**
 * Created by vikas on 9/5/17.
 */
public class TestJunit extends TestCase{
    SampleTest test;
    public TestJunit(){
         test = new SampleTest();
    }

    @Test
    public void testSortMethod(){
        Assert.assertEquals(true, test.testmethod(15));
    }

    @Test
    public void testLengthMethod(){
        assertTrue(test.getLen("vikas")==5);
    }

    @Test
    public void testArray(){
        int[] arr = {1,2,3};
        int[] brr = {3,2,1};
        Assert.assertArrayEquals(new int[]{1,2,3}, test.sortArray(brr));
    }




}
