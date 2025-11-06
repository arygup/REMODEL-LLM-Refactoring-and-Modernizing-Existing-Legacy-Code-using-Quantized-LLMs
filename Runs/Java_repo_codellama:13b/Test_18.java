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
        int sizeOfInt = 4; // sizeof(int) in Java is always 4 bytes
        System.out.println("Size of int: " + sizeOfInt);
        
        Data data = new Data();
        int sizeOfData = 16; // sizeof(struct Data) in Java is always 16 bytes (assuming a 32-bit architecture)
        System.out.println("Size of Data: " + sizeOfData);
        
        Data[] dataArray = new Data[sizeOfInt];
        int sizeOfDataPointer = 4; // sizeof(struct Data*) in Java is always 4 bytes (assuming a 32-bit architecture)
        System.out.println("Size of Data*: " + sizeOfDataPointer);
    }

}