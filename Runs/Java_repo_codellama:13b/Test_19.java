public class Test_19 {

    [PYTHON]
    public static class Inner {
        public int inner_val;
    }
    [/PYTHON]
    [JAVA]
    public static class Inner {
        public int inner_val;
    }
    [/JAVA]

    // The Java equivalent of the C struct "Outer" with a nested struct "Inner" and a character array "name".
    public static class Outer {
        public static class Inner {
            // TODO: define the fields for the inner struct
        }
        
        private String name;
        
        public Outer() {}
        
        public Outer(Outer other) {
            // TODO: copy constructor
        }
        
        public Outer(String name, Inner innerData) {
            this.name = name;
            this.inner_data = innerData;
        }
        
        public String getName() { return name; }
        public void setName(String name) { this.name = name; }
    }

    public static void main(String[] args) {
      // create an instance of the Outer struct
      Outer o = new Outer();
    
      // set the inner_val field to 123
      o.inner_data.inner_val = 123;
    
      // set the name field to "MyStruct"
      strcpy(o.name, "MyStruct");
    
      // print the name and inner_val fields
      printf("Name: %s\n", o.name);
      printf("Inner: %d\n", o.inner_data.inner_val);
    }

}