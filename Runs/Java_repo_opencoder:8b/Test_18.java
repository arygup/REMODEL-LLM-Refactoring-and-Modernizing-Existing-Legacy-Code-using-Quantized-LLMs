public class Test_18 {

    public static class Data {
        public int a;
        public char b;
        public double c;
    
        // Default constructor
        public Data() {}
    
        // Copy constructor
        public Data(Data other) {
            this.a = other.a;
            this.b = other.b;
            this.c = other.c;
        }
    
        // All-field constructor
        public Data(int a, char b, double c) {
            this.a = a;
            this.b = b;
            this.c = c;
        }
    }

    public static void main(String[] args) {
        System.out.println("Size of int: " + Integer.SIZE);
        System.out.println("Size of Data: " + sizeof_Data());
        System.out.println("Size of Data*: " + Pointer.SIZE);
    }

}