public class Test_19 {

    public class Inner {
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
    
        // Default constructor
        public Outer() {}
    
        // Copy constructor
        public Outer(Outer other) {
            this.innerData = new Inner(other.innerData);
            System.arraycopy(other.name, 0, this.name, 0, Math.min(other.name.length, this.name.length));
        }
    
        // All-field constructor
        public Outer(Inner innerData, char[] name) {
            this.innerData = innerData;
            System.arraycopy(name, 0, this.name, 0, Math.min(name.length, this.name.length));
        }
    }

    public static void main(String[] args) {
        Outer o = new Outer();
        o.innerData.innerVal = 123;
        System.arraycopy("MyStruct".toCharArray(), 0, o.name, 0, Math.min("MyStruct".length(), o.name.length));
        System.out.printf("Name: %s\n", new String(o.name).trim());
        System.out.printf("Inner: %d\n", o.innerData.innerVal);
    }

}