public class Test_18 {

    public static class Data {
        public int a;
        public char b;
        public double c;
    
        public Data() {}
    
        public Data(Data other) {
            this.a = other.a;
            this.b = other.b;
            this.c = other.c;
        }
    
        public Data(int a, char b, double c) {
            this.a = a;
            this.b = b;
            this.c = c;
        }
    }

    public static void main(String[] args) {
        System.out.println("Size of int: " + Long.SIZE / 8 + " bytes");
        structData d = new structData();
        d.a = 0;
        d.b = 'a';
        d.c = 1.2;
        System.out.println("Size of Data: " + sizeof(d));
        structData* pd = null; // equivalent to int *p in C
        System.out.println("Size of Data*: " + (pd == null ? 0 : 8) + " bytes");
      }

}