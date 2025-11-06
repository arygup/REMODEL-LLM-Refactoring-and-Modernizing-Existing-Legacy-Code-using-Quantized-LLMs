public class Test_8 {

    public class Flags {
        private int value = 0;
    
        // Bitfield 'a' (1 bit)
        private static final int MASK_A   =  0x1; // binary 0001
        private static final int SHIFT_A  =  0;
    
        // Bitfield 'b' (3 bits)
        private static final int MASK_B   =  0xe; // binary 1110
        private static final int SHIFT_B  =  1;
    
        // Bitfield 'c' (7 bits)
        private static final int MASK_C   =  0xfe0; // binary 111111100000
        private static final int SHIFT_C  =  4;
    
        public Flags() {}
    
        // Copy constructor
        public Flags(Flags other) {
            this.value = other.getValue();
        }
    
        // All-field constructor
        public Flgs(int a, int b, int c) {
            setA(a);
            setB(b);
            setC(c);
        }
    
        private void setBitField(int mask, int shift, int value) {
            this.value &= ~mask; // clear the bitfield
            this.value |= (value << shift) & mask; // set the bitfield 
        }
    
        // getter and setter for 'a'
        public int getA() { return (value & MASK_A) >>> SHIFT_A; }
        public void setA(int a) { this.setBitField(MASK_A, SHIFT_A, a); }
    
        // getter and setter for 'b'
        public int getB() { return (value & MASK_B) >>> SHIFT_B; }
        public void setB(int b) { this.setBitField(MASK_B, SHIFT_B, b); }
    
        // getter and setter for 'c'
        public int getC() { return (value & MASK_C) >>> SHIFT_C; }
        public void setC(int c) { this.setBitField(MASK_C, SHIFT_C, c); }
    
        // getter for the whole value 
        public int getValue() { return this.value; }
    }

    public static void main() {
      Flags f = new Flags();
      f.a = 1;
      f.b = 5;
      f.c = 100;
      System.out.printf("Flag a: %u\n", f.a);
      System.out.printf("Flag b: %u\n", f.b);
      System.out.printf("Flag c: %u\n", f.c);
      f.b = 10;
      System.out.printf("Flag b (overflow): %u\n", f.b);
    }

}