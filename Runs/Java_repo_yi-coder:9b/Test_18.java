public class Test_18 {

    public static class Data {
        public int a;
        public char b;
        public double c;
    
        // Default Constructor
        public Data() {} 
    
        // Copy Constructor
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
        System.out.println("Size of int: " + Integer.SIZE / 8);
        // In Java, sizeOf struct is not directly available, so we have to estimate it as the sum of sizes of its fields
        int dataSize = Integer.SIZE/8 /* for int a */  + Byte.SIZE/8 /* for char b*/ + Double.SIZE/8 /* for double c*/; 
        System.out.println("Size of Data: " + dataSize);
        // Size of pointer is the same as size of address - it can point to any variable, so it's equal to the size of a memory address
        int pointerSize = System.getProperty("sun.arch.data.model").equals("32") ? 4 : 8; // System property returns number of bits in architecture (32 or 64 bit system)
        System.out.println("Size of Data*: " + pointerSize);
    }

}