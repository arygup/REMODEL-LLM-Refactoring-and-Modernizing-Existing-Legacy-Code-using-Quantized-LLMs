public class Test_8 {

    public static class Flags {
        private int a;
        private int b;
        private int c;
    
        public Flags() {
        }
    
        public Flags(Flags other) {
            this.a = other.a;
            this.b = other.b;
            this.c = other.c;
        }
    
        public Flags(int a, int b, int c) {
            this.a = a & 1;
            this.b = b & 7;
            this.c = c & 127;
        }
    
        public int getA() {
            return (a & 1);
        }
    
        public void setA(int a) {
            this.a = a & 1;
        }
    
        public int getB() {
            return (b & 7);
        }
    
        public void setB(int b) {
            this.b = b & 7;
        }
    
        public int getC() {
            return (c & 127);
        }
    
        public void setC(int c) {
            this.c = c & 127;
        }
    }

    public static void main(String[] args) {
      Flags f = new Flags();
      f.a = 1;
      f.b = 5;
      f.c = 100;
      System.out.printf("Flag a: %u\n", (long) f.a & 0xFFFFFFFFL);
      System.out.printf("Flag b: %u\n", (long) f.b & 0xFFFFFFFFL);
      System.out.printf("Flag c: %u\n", (long) f.c & 0xFFFFFFFFL);
      f.b = 10;
      System.out.printf("Flag b (overflow): %u\n", (long) f.b & 0xFFFFFFFFL);
    }

}