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
        public Inner innerData;
        public char[] name = new char[20];
    
        public Outer() {}
    
        public Outer(Outer other) {
            this.innerData = other.innerData;
            System.arraycopy(other.name, 0, this.name, 0, Math.min(name.length, other.name.length));
        }
    
        public Outer(Inner innerData, char[] name) {
            this.innerData = innerData;
            System.arraycopy(name, 0, this.name, 0, Math.min(name.length, 20));
        }
    }

    public static void main(String[] args) {
            struct Inner inner_data = new struct.Inner();
            inner_data.inner_val = 123;
            char[] name = new char[20];
            System.arraycopy("MyStruct".toCharArray(), 0, name, 0, "MyStruct".length());
            
            do_while_loop: do { 
                System.out.printf("Name: %s\n", String.valueOf(new String(name)));
                System.out.printf("Inner: %d\n", inner_data.inner_val);
            } while (false);
        }

}