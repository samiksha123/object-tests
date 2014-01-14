
public class Wrong {
        private String name;
        private int age;

        Wrong(String name, int age) {
            this.name = name;
            this.age = age;
        }
        @Override
        public boolean equals(Object obj) {
            return this == obj;
        }

        @Override
        public int hashCode() {
            int result = name.hashCode();
            result = (int) (Math.random() * result + age);
            return result;
        }
    }

