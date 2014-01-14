import org.junit.Test;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import static junit.framework.Assert.assertEquals;

public class MyClassTest extends MyClass {
    @Test
    public void testSortByAge() throws Exception {
        MyClass myClass = new MyClass();
        ComparePerson swamiji = new ComparePerson("Swamiji", 3);
        ComparePerson kunal = new ComparePerson("Kunal", 50);
        ComparePerson digvijay = new ComparePerson("Digvijay", 35);

        List<ComparePerson> people = addPeopleToList(digvijay, kunal, swamiji);
        List<ComparePerson> expected = addPeopleToList(swamiji, digvijay, kunal);

        List<ComparePerson> actual = myClass.sortByAge(people);

        assertEquals(expected,actual);
    }

    @Test
    public void testSortByNameLength() throws Exception {
        MyClass myClass = new MyClass();
        ComparePerson swamiji = new ComparePerson("Swamiji", 3);
        ComparePerson kunal = new ComparePerson("Kunal", 50);
        ComparePerson digvijay = new ComparePerson("Digvijay", 35);

        List<ComparePerson> people = addPeopleToList(digvijay, kunal, swamiji);
        List<ComparePerson> expected = addPeopleToList(kunal,swamiji,digvijay );

        List<ComparePerson> actual = myClass.sortByNameLength(people);

        assertEquals(expected,actual);
    }

    @Test
    public void testSortByNameInReverse() throws Exception {
        MyClass myClass = new MyClass();
        ComparePerson swamiji = new ComparePerson("Swamiji", 3);
        ComparePerson kunal = new ComparePerson("Kunal", 50);
        ComparePerson digvijay = new ComparePerson("Digvijay", 35);

        List<ComparePerson> people = addPeopleToList(digvijay, kunal, swamiji);
        List<ComparePerson> expected = addPeopleToList(swamiji,kunal,digvijay );

        List<ComparePerson> actual = myClass.sortByNameInReverse(people);

        assertEquals(expected,actual);
    }

    @Test
    public void testSortByName() throws Exception {
        MyClass myClass = new MyClass();
        ComparePerson swamiji = new ComparePerson("Swamiji", 3);
        ComparePerson kunal = new ComparePerson("Kunal", 50);
        ComparePerson digvijay = new ComparePerson("Digvijay", 35);

        List<ComparePerson> people = addPeopleToList(digvijay, kunal, swamiji);
        List<ComparePerson> expected = addPeopleToList(digvijay ,kunal,swamiji);

        Collections.sort(people);

        assertEquals(expected,people);
    }
}

