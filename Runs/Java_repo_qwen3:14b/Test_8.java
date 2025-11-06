public class Test_8 {

    public static class Flags {
        private int bits;
    
        public Flags() {
            this.bits = 0;
        }
    
        public Flags(Flags other) {
            this.bits = other.bits;
        }
    
        public Flags(int a, int b, int c) {
            this();
            setA(a);
            setB(b);
            setC(c);
        }
    
        public int getA() {
            return (bits & 0x1) >> 0;
        }
    
        public void setA(int value) {
            bits = (bits & ~0x1) | ((value & 0x1) << 0);
        }
    
        public int getB() {
            return (bits & (0x7 << 1)) >> 1;
        }
    
        public void setB(int value) {
            bits = (bits & ~(0x7 << 1)) | ((value & 0x7) << 1);
        }
    
        public int getC() {
            return (bits & (0x7F << 4)) >> 4;
        }
    
        public void setC(int value) {
            bits = (bits & ~(0x7F << 4)) | ((value & 0x7F) << 4);
        }
    }

    public static void main(String[] args) {
            long flags = 0;
    
            // Set values (a, b, c) into the flags
            flags = (flags & ~0x1) | (1 & 0x1);       // Set a = 1
            flags = (flags & ~(0x7 << 1)) | ((5 & 0x7) << 1); // Set b = 5
            flags = (flags & ~(0x7F << 4)) | ((100 & 0x7F) << 4); // Set c = 100
    
            // Extract and print values
            int a = (int) ((flags & 0x1) >> 0);
            int b = (int) ((flags & (0x7 << 1)) >> 1);
            int c = (int) ((flags & (0x7F << 4)) >> 4);
    
            // Output
            System.out.printf("a: %d\n", a);
            System.out.printf("b: %d\n", b);
            System.out.printf("c: %d\n", c);
        }

}