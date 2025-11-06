public class Test_18 {

    public static class Data {
        public int a;
        public char b;
        public double c;
    
        public Data() {
        }
    
        public Data(Data other) {
            this.a = other.a;
            this.b = other.b;
            this.c = other.c;
        }
    
        public Data(int a, char b, double c) {
            this.a = a;
            this.b = b;
            this.c = c;
        }
    }

    public static void main(String[] args) {
        // Size of int: 4 bytes (32 bits)
        System.out.printf("Size of int: %d\n", Integer.SIZE / 8);
        
        // Size of struct Data: assuming 16 bytes as per typical C structure alignment
        long dataStructSize = 16;
        System.out.printf("Size of struct Data: %d\n", dataStructSize);
        
        // Size of pointer to struct Data (equivalent to reference size, typically 8 bytes in 64-bit JVM)
        long pointerSize = Long.BYTES; // Using Long.BYTES as an assumption for pointer size
        System.out.printf("Size of struct Data*: %d\n", pointerSize);
    }

}