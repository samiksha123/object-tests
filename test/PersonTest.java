import com.sun.org.apache.bcel.internal.generic.NEW;
import org.junit.Test;

import java.util.*;

import static junit.framework.Assert.assertEquals;
import static org.junit.Assert.assertNotSame;
import static org.junit.Assert.assertSame;

public class PersonTest {
    @Test
    public void test_for_same_string_literals() throws Exception {
        String str1 = "samiksha";
        String str2 = new String("samiksha");
        boolean expected = true;

        boolean actual = str1.equals(str2);

        assertEquals(actual,expected);
    }
    @Test
    public void test_for_different_string_literals() throws Exception {
        String str1 = "samiksha";
        String str2 = new String("manali");
        boolean expected = false;

        boolean actual = str1.equals(str2);

        assertEquals(actual,expected);

    }
    @Test
    public void test_for_same_person_object() throws Exception {
       Person p1 = new Person("samiksha",18);
       Person p2 = new Person("samiksha",18);
        boolean expected = true;

        boolean actual =  p1.equals(p2);

        assertEquals(actual,expected);

    }
    @Test
    public void test_for_different_person_object() throws Exception {
        Person p1 = new Person("samiksha",18);
        Person p2 = new Person("manali",19);
        boolean expected = false;

        boolean actual =  p1.equals(p2);

        assertEquals(actual,expected);
    }
    @Test
    public void test_for_different_object_HashCode() throws Exception {
        Person p1 = new Person("samiksha",18);
        Person p2 = new Person("manali",19);
        int expected = p2.hashCode();

        int actual =  p1.hashCode();

        assertNotSame(actual, expected);
    }
    @Test
    public void test_for_same_object_HashCode() throws Exception {
        Person p1 = new Person("samiksha",18);
        Person p2 = new Person("samiksha",18);
        int expected = p2.hashCode();

        int actual =  p1.hashCode();
        assertEquals(actual, expected);
    }




    //-----------------------------------set ,map,list
    @Test
    public void test_for_checking_equality_of_persons_in_arraylist() throws Exception {
        ArrayList<Person> people = new ArrayList<Person>();
        people.add(new Person("samiksha",18));
        people.add(new Person("samiksha",18));

        boolean result = people.get(0).equals(people.get(1));
        assertEquals(true, result);
    }
    @Test
    public void test_for_checking_hashcode_of_persons_in_arraylist() throws Exception {
        ArrayList<Person> people = new ArrayList<Person>();
        people.add(new Person("samiksha",18));
        people.add(new Person("samiksha",18));

        boolean result = people.get(0).hashCode() == people.get(1).hashCode();
        assertEquals(true, result);
    }

    @Test
    public void test_case_for_hash_map_having_same_object_in_a_single_list() throws Exception {

        List<Person> people = new ArrayList<Person>();
        people.add(new Person("samiksha",18));
        people.add(new Person("samiksha",18));

        Map<String, List<Person>> map = new HashMap<String, List<Person>>();
        map.put("A", people);
        List samiksha = map.get("A");

        boolean actual = samiksha.get(0).equals(samiksha.get(1));

        int p1HashCode = samiksha.get(0).hashCode();
        int p2HashCode = samiksha.get(1).hashCode();

        assertEquals(actual, true);
        assertEquals(p1HashCode, p2HashCode);
    }
    @Test
    public void test_case_for_hash_map_having_same_object_in_a_different_list() throws Exception {

        List<Person> people1 = new ArrayList<Person>();
        List<Person> people2 = new ArrayList<Person>();
        people1.add(new Person("samiksha",18));
        people1.add(new Person("kavita",19));

        people2.add(new Person("samiksha",18));
        people2.add(new Person("kavita",19));

        Map<String, List<Person>> map = new HashMap<String, List<Person>>();
        map.put("A", people1);
        map.put("B", people2);
        List list1 = map.get("A");
        List list2 = map.get("B");

        boolean actual1 = list1.get(0).equals(list2.get(0));
        boolean actual2 = list1.get(0).equals(list2.get(0));

        assertEquals(actual1, true);
        assertEquals(actual2, true);
    }
    @Test
    public void test_case_for_hash_map_having_different_object_in_a_different_list() throws Exception {

        List<Person> people1 = new ArrayList<Person>();
        List<Person> people2 = new ArrayList<Person>();
        people1.add(new Person("samiksha",18));
        people1.add(new Person("kavita",19));

        people2.add(new Person("kajal",18));
        people2.add(new Person("sheetal",19));

        Map<String, List<Person>> map = new HashMap<String, List<Person>>();
        map.put("A", people1);
        map.put("B", people2);
        List list1 = map.get("A");
        List list2 = map.get("B");

        boolean actual1 = list1.get(0).equals(list2.get(0));
        boolean actual2 = list1.get(0).equals(list2.get(0));

        assertEquals(actual1, false);
        assertEquals(actual2, false);
    }
    @Test
    public void test_case_for_hash_set_having_different_value() throws Exception {
        Set<Person> set = new HashSet<Person>();
        set.add(new Person("samiksha",18));
        set.add(new Person("kavita",19));

        assertEquals(set.size(),2);
    }
    @Test
    public void test_case_for_hash_set_having_same_object_reference_in_a_single_list1() throws Exception {
        Person p1 = new Person("samiksha",18);
        Set<Person> set = new HashSet<Person>();
        set.add(p1);
        set.add(p1);

        assertEquals(set.size(),1);
    }
    @Test
    public void test_case_for_hash_set_having_same_object_in_a_single_list1() throws Exception {
        Set<Person> set = new HashSet<Person>();
        set.add(new Person("samiksha",18));
        set.add(new Person("samiksha",18));

        assertEquals(set.size(),1);
    }
}
