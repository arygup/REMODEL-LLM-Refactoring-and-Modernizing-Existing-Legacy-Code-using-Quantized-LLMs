public class Test_8 {

    public static class Flags {
        private int value;
    
        public Flags() {}
    
        public Flags(Flags other) {
            this.value = other.value;
        }
    
        public Flags(int a, int b, int c) {
            this.value = ((c & 0x7f) << 7) | ((b & 0x7) << 4) | (a & 0x1);
        }
    
        public boolean isA() {
            return (value & 1) != 0;
        }
    
        public void setA(boolean value) {
            if (value) {
                this.value |= 1;
            } else {
                this.value &= ~1;
            }
        }
    
        public int getB() {
            return (value >> 4) & 7;
        }
    
        public void setB(int value) {
            this.value = ((this.value & ~(0x7f << 4)) | (value & 0x7) << 4);
        }
    
        public int getC() {
            return value >> 7;
        }
    
        public void setC(int value) {
            this.value = ((this.value & ~(0x7f << 7)) | (value & 0x7f) << 7);
        }
    }

    public static void main(String[] args)
    {
      long[] f = new long[3];
      f[0] = 1;
      f[1] = 5;
      f[2] = 100;
      System.out.println("Flag a: " + (f[0] & 0xFFFFFFFFL));
      System.out.println("Flag b: " + (f[1] & 0xFFFFFFFFL));
      System.out.println("Flag c: " + (f[2] & 0xFFFFFFFFL));
      f[1] = 10;
      System.out.println("Flag b (overflow): " + (f[1] & 0xFFFFFFFFL));
    }

}