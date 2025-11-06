public class Test_8 {

    public static class Flags {
        private final int flags;
    
        public Flags() {
            this(0);
        }
    
        public Flags(Flags other) {
            this(other.flags);
        }
    
        public Flags(int flags) {
            this.flags = flags;
        }
    
        public int getA() {
            return (flags & 1) != 0 ? 1 : 0;
        }
    
        public void setA(int a) {
            if (a == 0 || a == 1) {
                flags = (flags & ~1) | (a << 0);
            }
        }
    
        public int getB() {
            return (flags >> 1) & 7;
        }
    
        public void setB(int b) {
            if ((b & ~7) == 0) {
                flags = (flags & ~(7 << 1)) | ((b << 1) & 7);
            }
        }
    
        public int getC() {
            return (flags >> 4) & 127;
        }
    
        public void setC(int c) {
            if ((c & ~127) == 0) {
                flags = (flags & ~(127 << 4)) | ((c << 4) & 127);
            }
        }
    }

    public static void main(String[] args) {
        Flags f = new Flags();
        f.a = 1;
        f.b = 5;
        f.c = 100;
        System.out.println("Flag a: " + f.a);
        System.out.println("Flag b: " + f.b);
        System.out.println("Flag c: " + f.c);
        f.b = 10;
        System.out.println("Flag b (overflow): " + f.b);
    }

}