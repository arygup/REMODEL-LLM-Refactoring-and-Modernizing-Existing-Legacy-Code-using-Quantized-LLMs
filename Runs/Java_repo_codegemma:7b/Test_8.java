public class Test_8 {

    public static class Flags {
    
        private int value;
    
        public boolean isA() {
            return (value & 0x1) != 0;
        }
    
        public void setA(boolean a) {
            value = (value & ~0x1) | (a ? 0x1 : 0);
        }
    
        public int getB() {
            return (value >> 1) & 0x7;
        }
    
        public void setB(int b) {
            value = (value & ~(0x7 << 1)) | ((b & 0x7) << 1);
        }
    
        public int getC() {
            return (value >> 4) & 0x7f;
        }
    
        public void setC(int c) {
            value = (value & ~(0x7f << 4)) | ((c & 0x7f) << 4);
        }
    
        public Flags() {
            value = 0;
        }
    
        public Flags(Flags other) {
            value = other.value;
        }
    
        public Flags(boolean a, int b, int c) {
            value = (a ? 0x1 : 0) | ((b & 0x7) << 1) | ((c & 0x7f) << 4);
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