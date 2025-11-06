public class Test_8 {

    public static class Flags {
        private int value;
    
        public Flags() {
            this.value = 0;
        }
    
        public Flags(Flags other) {
            this.value = other.value;
        }
    
        public Flags(int a, int b, int c) {
            this.value = 
                ((a & 1) << 0) |
                ((b & 7) << 1) |
                ((c & 127) << 4);
        }
    
        public boolean getA() {
            return (value & 0x1) != 0;
        }
    
        public void setA(boolean a) {
            if (a) {
                value |= 0x1;
            } else {
                value &= ~0x1;
            }
        }
    
        public int getB() {
            return (value >> 1) & 0x7;
        }
    
        public void setB(int b) {
            value = (value & ~0x7) | ((b & 0x7) << 1);
        }
    
        public int getC() {
            return (value >> 4) & 0x7F;
        }
    
        public void setC(int c) {
            value = (value & ~0xFF) | ((c & 0x7F) << 4);
        }
    }

    public static void main(String[] args) {
            Flags f = new Flags();
            
            // Assign values with appropriate bit masks
            f.a = 1L & 0x1L;    // a is 1 bit
            f.b = 5L & 0x7L;   // b is 3 bits (max value 7)
            f.c = 100L & 0x7FL;// c is 7 bits (max value 127)
            
            System.out.println("a: " + f.a);
            System.out.println("b: " + f.b);
            System.out.println("c: " + f.c);
            
            // Modify b to exceed its bit width
            f.b = 10L & 0x7L;
            System.out.println("\nAfter modifying b:");
            System.out.println("a: " + f.a);
            System.out.println("b: " + f.b);  // should be 2 (since 10 % 8 = 2)
            System.out.println("c: " + f.c);
        }

}