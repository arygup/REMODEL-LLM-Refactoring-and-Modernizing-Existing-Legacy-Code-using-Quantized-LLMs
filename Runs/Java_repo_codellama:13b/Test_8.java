public class Test_8 {

    public static class Flags {
        private int data;
        
        public Flags() { }
        
        public Flags(int data) {
            this.data = data;
        }
        
        public Flags(Flags other) {
            this.data = other.data;
        }
        
        public int getA() {
            return (data & 0b1) != 0 ? 1 : 0;
        }
        
        public void setA(int a) {
            data &= ~(1 << 0);
            data |= ((a & 1) << 0);
        }
        
        public int getB() {
            return (data >> 1) & 0b111;
        }
        
        public void setB(int b) {
            data &= ~(7 << 1);
            data |= ((b & 7) << 1);
        }
        
        public int getC() {
            return (data >> 4) & 0b1111111;
        }
        
        public void setC(int c) {
            data &= ~(127 << 4);
            data |= ((c & 127) << 4);
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