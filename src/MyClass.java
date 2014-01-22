import java.util.*;

class ComparePerson implements Comparable<ComparePerson> {
    private String name;
    private int age;

    public ComparePerson(String name, int age) {
        this.name = name;
        this.age = age;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof ComparePerson)) return false;

        ComparePerson person = (ComparePerson) o;

        if (age != person.age) return false;
        if (name != null ? !name.equals(person.name) : person.name != null) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = name != null ? name.hashCode() : 0;
        result = 31 * result + age;
        return result;

    }

    @Override
    public int compareTo(ComparePerson o) {
        return this.name.compareTo(o.getName());
    }

    @Override
    public String toString() {
        return this.getName();
    }
}
public class MyClass {
    public List sortByAge(List people){
        Collections.sort(people, new Comparator<ComparePerson>() {
            @Override
            public int compare(ComparePerson p1, ComparePerson p2) {
                return p1.getAge() - p2.getAge();
            }
        });
        return people;
    }
    public List sortByNameLength(List people){
        Collections.sort(people, new Comparator<ComparePerson>() {
            @Override
            public int compare(ComparePerson p1, ComparePerson p2) {
                return p1.getName().length() - p2.getName().length();
            }
        });
        return people;
    }
    public List sortByNameInReverse(List people){
        Collections.sort(people, new Comparator<ComparePerson>() {
            @Override
            public int compare(ComparePerson p1, ComparePerson p2) {
                return p2.getName().compareTo(p1.getName());
            }
        });
        return people;
    }

    public static void main(String[] args) {
        ComparePerson swamiji = new ComparePerson("Swamiji", 3);
        ComparePerson kunal = new ComparePerson("Kunal", 50);
        ComparePerson digvijay = new ComparePerson("Digvijay", 35);

        List<ComparePerson> people = addPeopleToList(digvijay, kunal, swamiji);
        MyClass myClass = new MyClass();

        Collections.sort(people);
        System.out.println("name   :  "+people);
        System.out.println("age   :  "+myClass.sortByAge(people));
        System.out.println("name Length   :  "+myClass.sortByNameLength(people));
        System.out.println("name reverse   :  "+myClass.sortByNameInReverse(people));
    }

    public static List addPeopleToList(ComparePerson... persons) {
        List<ComparePerson> people = new ArrayList<ComparePerson>();
        for (ComparePerson person : persons) {
            people.add(person);
        }
        return people;
    }
}
