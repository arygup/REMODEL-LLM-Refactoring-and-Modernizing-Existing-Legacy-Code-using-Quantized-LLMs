public class Test_8 {

    public static class Flags {
        private int flags;
    
        // Default constructor
        public Flags() {
            this.flags = 0;
        }
    
        // Copy constructor
        public Flags(Flags other) {
            this.flags = other.flags;
        }
    
        // All-field constructor
        public Flags(int a, int b, int c) {
            this.setA(a);
            this.setB(b);
            this.setC(c);
        }
    
        // Getter for 'a'
        public int getA() {
            return (flags & 0x1);
        }
    
        // Setter for 'a'
        public void setA(int a) {
            flags = (flags & ~0x1) | (a & 0x1);
        }
    
        // Getter for 'b'
        public int getB() {
            return (flags >>> 1) & 0x7;
        }
    
        // Setter for 'b'
        public void setB(int b) {
            flags = (flags & ~0xE) | ((b << 1) & 0xE);
        }
    
        // Getter for 'c'
        public int getC() {
            return (flags >>> 4) & 0x7F;
        }
    
        // Setter for 'c'
        public void setC(int c) {
            flags = (flags & ~0xFE0) | ((c << 4) & 0xFE0);
        }
    }

    public static void main(String[] args) {
      Flags f = new Flags();
      f.a = 1;
      f.b = 5 & 0xFFFFFFFFL;
      f.c = 100 & 0xFFFFFFFFL;
      System.out.printf("Flag a: %u\n", f.a);
      System.out.printf("Flag b: %u\n", f.b);
      System.out.printf("Flag c: %u\n", f.c);
      f.b = 10 & 0xFFFFFFFFL;
      System.out.printf("Flag b (overflow): %u\n", f.b);
    }

}