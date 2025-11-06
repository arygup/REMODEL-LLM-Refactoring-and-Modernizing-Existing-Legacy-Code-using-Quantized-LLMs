public class Test_8 {

    public static class Flags {
        private int a;
        private int b;
        private int c;
    
        public Flags() {
            this.a = 0;
            this.b = 0;
            this.c = 0;
        }
    
        public Flags(Flags other) {
            this.a = other.a;
            this.b = other.b;
            this.c = other.c;
        }
    
        public Flags(int a, int b, int c) {
            this.a = a;
            this.b = b;
            this.c = c;
        }
    
        public int getA() {
            return a;
        }
    
        public void setA(int a) {
            this.a = a;
        }
    
        public int getB() {
            return b;
        }
    
        public void setB(int b) {
            this.b = b;
        }
    
        public int getC() {
            return c;
        }
    
        public void setC(int c) {
            this.c = c;
        }
    }

    public static void main(String[] args) {
        long f_a = 1L;
        long f_b = 5L;
        long f_c = 100L;
        System.out.printf("Flag a: %u%n", f_a & 0xFFFFFFFFL);
        System.out.printf("Flag b: %u%n", f_b & 0xFFFFFFFFL);
        System.out.printf("Flag c: %u%n", f_c & 0xFFFFFFFFL);
        f_b = 10L;
        System.out.printf("Flag b (overflow): %u%n", f_b & 0xFFFFFFFFL);
    }

}