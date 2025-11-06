public class Test_18 {

    public static class Data {
        public int a;
        public String b; // Java uses String instead of char array for strings
        public double c;
    
        public Data() {}
    
        public Data(Data other) {
            this.a = other.a;
            this.b = other.b;
            this.c = other.c;
        }
    
        public Data(int a, char b, double c) {
            this.a = a;
            this.b = String.valueOf(b); // Convert char to String
            this.c = c;
        }
    }

    public static void main(String[] args) {
      System.out.printf("Size of int: %d\n", SizeOf(int.class));
      structData sizeOfData = new structData();
      System.out.printf("Size of Data: %d\n", SizeOf(sizeOfData.getClass()));
      structDataPtr sizeOfDataPtr = sizeOfData;
      System.out.printf("Size of Data*: %d\n", SizeOf(sizeOfDataPtr.getClass()));
    }

}