public class Test_8 {

    public static class Flags {
    
        private final int data;
    
        public Flags(int data) {
            this.data = data & 0xFFFFFF;
        }
    
        public Flags(Flags other) {
            this.data = other.data;
        }
    
        public Flags(boolean a, int b, int c) {
            int combinedData = (c << 3 | b << 10 | (a ? 1 : 0) << 13);
            this.data = combinedData & 0xFFFFFF;
        }
    
        public boolean getA() {
            return (data >>> 13) == 1;
        }
    
        public void setA(boolean a) {
            int mask = ~(1 << 13);
            data = (data & mask) | ((a ? 1 : 0) << 13);
        }
    
        public int getB() {
            return (data >>> 10) & 7;
        }
    
        public void setB(int b) {
            int mask = ~(7 << 10);
            data = (data & mask) | (b << 10);
        }
    
        public int getC() {
            return data & 0x7F;
        }
    
        public void setC(int c) {
            int mask = ~0x7F;
            data = (data & mask) | (c & 0x7F);
        }
    }

    public static void main(String[] args) {
        Flags f = new Flags();
        f.a = 1;
        f.b = 5;
        f.c = 100;
        System.out.printf("Flag a: %u\n", f.a);
        System.out.printf("Flag b: %u\n", f.b);
        System.out.printf("Flag c: %u\n", f.c);
        f.b = 10;
        System.out.printf("Flag b (overflow): %u\n", f.b & 0xFFFFFFFFL); // Masking overflow
    }

}