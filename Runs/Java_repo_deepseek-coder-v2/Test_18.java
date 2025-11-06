public class Test_18 {

    public static class Data {
        public int a;
        public char b;
        public double c;
    
        // No-argument constructor
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
      System.out.printf("Size of int: %d\n", Integer.SIZE / 8);
      System.out.printf("Size of Data: %d\n", java.lang.ref.Reference.get().getClass().getDeclaredField("theData").getType().getComponentType().getSize());
      System.out.printf("Size of Data*: %d\n", java.lang.ref.Reference.get().getClass().getDeclaredField("theData").getType().getSize());
    }

}