public class Test_19 {

    public static class Inner {
        public int inner_val;
    
        // No-argument default constructor
        public Inner() {}
    
        // Copy constructor
        public Inner(Inner other) {
            this.inner_val = other.inner_val;
        }
    
        // All-field constructor
        public Inner(int inner_val) {
            this.inner_val = inner_val;
        }
    }

    public static class Outer {
        public Inner innerData;
    
        public char[] name = new char[20];
    
        // Default constructor
        public Outer() {
            this.innerData = new Inner();
        }
    
        // Copy constructor
        public Outer(Outer other) {
            if (other != null) {
                this.innerData = new Inner(other.innerData);
                for (int i = 0; i < name.length; i++) {
                    this.name[i] = other.name[i];
                }
            }
        }
    
        // All-field constructor
        public Outer(Inner innerData, char[] name) {
            this.innerData = innerData;
            if (name != null && name.length == 20) {
                System.arraycopy(name, 0, this.name, 0, 20);
            } else {
                throw new IllegalArgumentException("Name must be an array of length 20.");
            }
        }
    
        public static class Inner {
            // Define fields and constructors for the Inner class if necessary
            // Example:
            // private int someField;
    
            // Default constructor
            public Inner() {
                // Initialize fields if necessary
            }
    
            // Copy constructor
            public Inner(Inner other) {
                // Copy all fields from 'other'
                // this.someField = other.someField;
            }
    
            // All-field constructor
            // public Inner(int someField) {
            //     this.someField = someField;
            // }
        }
    }

    public static void main(String[] args) {
        Outer o = new Outer();
        o.innerData().innerVal(123);
        o.name("MyStruct");
        System.out.println("Name: " + o.name());
        System.out.println("Inner: " + o.innerData().innerVal());
    }

}