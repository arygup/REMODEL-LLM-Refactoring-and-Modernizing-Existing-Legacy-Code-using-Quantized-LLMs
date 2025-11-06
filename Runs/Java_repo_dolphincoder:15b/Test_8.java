public class Test_8 {

    public static class Flags {
        private int a, b, c;
    
        public Flags() {}
    
        public Flags(Flags other) {
            this.a = other.a;
            this.b = other.b;
            this.c = other.c;
        }
    
        public Flags(int a, int b, int c) {
            this.a = a & 1;  // Ensuring only one bit is set
            this.b = b & 7;   // Ensuring only three bits are set
            this.c = c & 0x7F;  // Ensuring only seven bits are set
        }
    
        public int getA() {
            return a;
        }
    
        public void setA(int value) {
            a = value & 1;  // Ensuring only one bit is set
        }
    
        public int getB() {
            return b;
        }
    
        public void setB(int value) {
            b = value & 7;   // Ensuring only three bits are set
        }
    
        public int getC() {
            return c;
        }
    
        public void setC(int value) {
            c = value & 0x7F;  // Ensuring only seven bits are set
        }
    }

    public static void main(String[] args) {
        Flags f = new Flags();
        f.a  = 1;
        f.b  = 5;
        f.c  = 100;
    
        System.out.printf("Flag a: %u\n", f.a);
        System.out.printf("Flag b: %u\n", f.b);
        System.out.printf("Flag c: %u\n", f.c);
    
        f.b  = 10;
    
        System.out.printf("Flag b (overflow): %u\n", f.b);
    }

}