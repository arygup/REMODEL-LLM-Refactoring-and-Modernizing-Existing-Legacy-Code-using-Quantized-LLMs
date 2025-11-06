public class Test_18 {

    public static class Data {
        public int a;
        public char b;
        public double c;
    
        // No-argument default constructor
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
      System.out.printf("Size of int: %lu\n", Long.toString((long) Integer.BYTES));
      System.out.printf("Size of Data: %lu\n", Long.toString((long) (Integer.BYTES + 1 + Double.BYTES)));
      System.out.printf("Size of Data*: %lu\n", Long.toString((long) Long.BYTES));
    }

}