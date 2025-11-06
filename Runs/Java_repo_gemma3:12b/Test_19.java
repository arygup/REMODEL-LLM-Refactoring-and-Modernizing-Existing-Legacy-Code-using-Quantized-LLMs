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

    public static class Outer {
        public Outer inner_data;
        public char[] name = new char[20];
    
        public Outer() {
        }
    
        public Outer(Outer other) {
            this.inner_data = other.inner_data;
            this.name = other.name.clone();
        }
    
        public Outer(Outer inner_data, char[] name) {
            this.inner_data = inner_data;
            this.name = name.clone();
        }
    }

    public static void main(String[] args) {
        Outer o = new Outer();
        o.inner_data.inner_val = 123;
        o.name = "MyStruct";
        System.out.println("Name: " + o.name);
        System.out.println("Inner: " + o.inner_data.inner_val);
    }

}