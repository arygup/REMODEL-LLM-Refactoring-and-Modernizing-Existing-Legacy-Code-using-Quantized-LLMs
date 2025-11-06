public class Test_19 {

    public static class Inner {
        public int inner_val;
        
        public Inner() {
        }
        
        public Inner(Inner other) {
            this.inner_val = other.inner_val;
        }
        
        public Inner(int inner_val) {
            this.inner_val = inner_val;
        }
    }

    import java.util.Arrays;
    
    public static class Outer {
        public static class Inner { 
            // Placeholder for struct Inner; add fields as needed
        }
    
        private Inner innerData;
        private char[] name = new char[20];
    
        // Default constructor initializes with default values
        public Outer() {
            this.innerData = new Inner();
            Arrays.fill(name, '\0'); // Initialize char array with default value
        }
    
        // Copy constructor to create an instance from another Outer object
        public Outer(Outer other) {
            if (other == null) {
                throw new IllegalArgumentException("Cannot copy from a null Outer object");
            }
            this.innerData = new Inner(other.innerData);
            System.arraycopy(other.name, 0, this.name, 0, name.length);
        }
    
        // All-field constructor to initialize both fields explicitly
        public Outer(Inner innerData, char[] name) {
            if (name == null || name.length != 20) {
                throw new IllegalArgumentException("Name must be a non-null array of length 20");
            }
            this.innerData = innerData;
            this.name = Arrays.copyOf(name, 20);
        }
    
        // Getters and setters can be added as needed
    }

    public static void main(String[] args) {
        // Create an instance of Outer
        Outer o = new Outer();
        
        // Set the value of inner_val in inner_data to 123
        o.inner_data.inner_val = 123;
        
        // Set the name field to "MyStruct"
        o.name = "MyStruct";
        
        // Print the values using printf-like formatting
        System.out.println("Name: " + o.name);
        System.out.println("Inner: " + o.inner_data.inner_val);
    }

}