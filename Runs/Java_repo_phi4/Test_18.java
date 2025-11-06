public class Test_18 {

    public static class Data {
    
        public int a;
        public char b;
        public double c;
    
        // No-argument default constructor
        public Data() {
            this.a = 0;
            this.b = '\u0000';
            this.c = 0.0;
        }
    
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
        System.out.println("Size of int: " + Integer.BYTES);
        class Data {
            int a;
            char b;
            double c;
    
            Data() {}
        }
        System.out.println("Size of Data: " + (Integer.BYTES + Character.BYTES + Double.BYTES));
        System.out.println("Size of Data*: " + Integer.BYTES);
    }

}