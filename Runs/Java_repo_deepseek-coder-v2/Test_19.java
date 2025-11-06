public class Test_19 {

    public static class Inner {
        public int innerVal;
    
        // Default constructor
        public Inner() {}
    
        // Copy constructor
        public Inner(Inner other) {
            this.innerVal = other.innerVal;
        }
    
        // All-field constructor
        public Inner(int innerVal) {
            this.innerVal = innerVal;
        }
    }

    public static class Outer {
        public Inner inner_data;
        public char[] name = new char[20];
    
        public Outer() {}
    
        public Outer(Outer other) {
            this.inner_data = new Inner(other.inner_data);
            System.arraycopy(other.name, 0, this.name, 0, 20);
        }
    
        public Outer(Inner inner_data, char[] name) {
            this.inner_data = inner_data;
            if (name != null && name.length == 20) {
                System.arraycopy(name, 0, this.name, 0, 20);
            } else {
                throw new IllegalArgumentException("Name array must be exactly 20 characters long.");
            }
        }
    
        public static class Inner {
            // Define the fields and methods for Inner here if needed
        }
    }

    public static void main(String[] args) {
      Outer o = new Outer();
      o.inner_data.inner_val = 123;
      System.arraycopy("MyStruct".getBytes(), 0, o.name, 0, "MyStruct".length());
      System.out.println("Name: MyStruct");
      System.out.println("Inner: 123");
    }

}