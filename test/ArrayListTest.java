import org.junit.Test;

import java.util.ArrayList;

public class ArrayListTest {
    @Test(expected = java.lang.ClassCastException.class)
    public void testGivesExceptionWhenIllegalCast() throws ClassCastException {
        ArrayList list = new ArrayList<String>();
        list.add(new Object());
        list.add(new Object());
        String a = (String)list.get(0);
    }
}



