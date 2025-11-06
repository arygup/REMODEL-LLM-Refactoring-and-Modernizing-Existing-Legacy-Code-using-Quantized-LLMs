public class Test_19 {

    public static class Inner {
        public int innerVal;
    
        // Constructor 1: default constructor
        public Inner() {
            this.innerVal = 0;
        }
    
        // Constructor 2: copy constructor
        public Inner(Inner other) {
            this.innerVal = other.innerVal;
        }
    
        // Constructor 3: all-fields constructor
        public Inner(int innerVal) {
            this.innerVal = innerVal;
        }
    }

    public static class Outer {
    
      public static class Inner {
        // fields and constructors for Inner class
      }
    
      private byte[] name = new byte[20]; // assuming ASCII encoding, adjust as needed
    
      // default constructor
      public Outer() {}
    
      // copy constructor
      public Outer(Outer other) {
        System.arraycopy(other.name, 0, this.name, 0, other.name.length);
      }
    
      // all-field constructor
      public Outer(byte[] name) {
        if (name.length > this.name.length) {
          throw new IllegalArgumentException("Name length exceeds maximum");
        }
        System.arraycopy(name, 0, this.name, 0, name.length);
      }
    
      // getters and setters for name field
      public byte[] getName() {
        return Arrays.copyOf(this.name, this.name.length);
      }
    
      public void setName(byte[] name) {
        if (name.length > this.name.length) {
          throw new IllegalArgumentException("Name length exceeds maximum");
        }
        System.arraycopy(name, 0, this.name, 0, name.length);
      }
    }

    public static void main(String[] args) {
      Outer o = new Outer();
      o.inner_data.inner_val = 123;
      System.arraycopy("MyStruct".getBytes(), 0, o.name, 0, "MyStruct".length());
      System.out.println("Name: " + new String(o.name));
      System.out.println("Inner: " + o.inner_data.inner_val);
    }

}