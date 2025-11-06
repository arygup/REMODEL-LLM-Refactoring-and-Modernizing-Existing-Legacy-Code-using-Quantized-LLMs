public class Test_19 {

    public static class Inner {
        public int inner_val;
    
        public Inner() {
            // no-argument constructor
        }
    
        public Inner(Inner other) {
            if (other == null) throw new IllegalArgumentException("Argument cannot be null");
            this.inner_val = other.inner_val;
        }
    
        public Inner(int inner_val) {
            this.inner_val = inner_val;
        }
    }

    public static class Outer {
        public static class Inner {
    
        }
    
        public char[] name = new char[20];
    
        // Default constructor
        public Outer() {
        }
    
        // Copy constructor
        public Outer(Outer other) {
            if (other != null) {
                this.name = Arrays.copyOf(other.name, 20);
            }
        }
    
        // All-field constructor
        public Outer(char[] name) {
            this.name = name;
        }
    }

    public static void main(String[] args) {
            structOuter o = new structOuter();
            o.inner_data = new structInner();
            o.inner_data.inner_val = 123;
            strcpy(o.name, "MyStruct");
            printf("Name: %s\n", o.name);
            printf("Inner: %d\n", o.inner_data.inner_val);
        }

}