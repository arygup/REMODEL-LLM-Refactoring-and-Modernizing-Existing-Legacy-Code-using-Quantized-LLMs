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
        public Outer() {}
    
        public Outer(Outer other) {
            this.inner_data = new Inner(other.inner_data);
            this.name = new String(other.name);
        }
    
        public Outer(Inner inner_data, String name) {
            this.inner_data = inner_data;
            this.name = name;
        }
    
        public static class Inner {
            // Add getters and setters for any fields defined in the C struct 'Inner'
        }
    }

    public static void main(String[] args) {
        Outer o = new Outer();
        o.inner_data.inner_val = 123;
        System.arraycopy("MyStruct".toCharArray(), 0, o.name, 0, "MyStruct".length());
        System.out.println("Name: " + new String(o.name));
        System.out.println("Inner: " + o.inner_data.inner_val);
    }

}