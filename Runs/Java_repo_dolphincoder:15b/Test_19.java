public class Test_19 {

    public static class Inner {
        public int inner_val;
    
        public Inner() {}
    
        public Inner(Inner other) {
            this.inner_val = other.inner_val;
        }
    
        public Inner(int inner_val) {
            this.inner_val = inner_val;
        }
    }

    public static class Outer {
      public Inner inner_data;
      public char[] name = new char[20];
    }

    // FAILED_STRIPPING: LLM returned a class, not a method.
    public class Main {
        static public void main(String[] args) {
            Outer o = new Outer();  // Creating an instance of the struct Outer
    
            // Accessing inner_data and assigning values
            o.inner_data.inner_val  = 123;
    
            // Accessing name array and copying string to it
            o.name = "MyStruct";
    
            System.out.println("Name: " + o.name);     // Printing the value of 'o'
            System.out.println("Inner: " + o.inner_data.inner_val);  // Printing the inner value
        }
    }
    
    class Inner {    // Inner struct definition
        int inner_val;
    }
    
    class Outer {   // Outer struct definition
        Inner inner_data = new Inner();   // Creating an instance of the Inner struct within the outer struct
        String name;
    }

}