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
        public Inner inner_data = new Inner();
        public char[] name = new char[20];
    
        // No-argument default constructor
        public Outer() {}
    
        // Copy constructor
        public Outer(Outer other) {
            this.inner_data = new Inner(other.inner_data);
            System.arraycopy(other.name, 0, this.name, 0, this.name.length);
        }
    
        // All-field constructor
        public Outer(Inner inner_data, char[] name) {
            this.inner_data = new Inner(inner_data);
            System.arraycopy(name, 0, this.name, 0, this.name.length);
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