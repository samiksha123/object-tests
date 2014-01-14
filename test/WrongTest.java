import org.junit.Test;

import static junit.framework.Assert.assertEquals;
import static org.junit.Assert.assertNotSame;


public class WrongTest {
    @Test
    public void test_for_same_person_object_with_wrong_equal() throws Exception {
        Wrong w1 = new Wrong("samiksha",18);
        Wrong w2 = new Wrong("samiksha",18);
        boolean expected = false;

        boolean actual =  w1.equals(w2);

        assertEquals(expected,actual);
    }
    @Test
    public void test_for_same_object_HashCode() throws Exception {
        Wrong w1 = new Wrong("samiksha",18);
        Wrong w2 = new Wrong("samiksha",18);
        int expected = w2.hashCode();

        int actual =  w1.hashCode();

        assertNotSame(actual, expected);
    }
}
