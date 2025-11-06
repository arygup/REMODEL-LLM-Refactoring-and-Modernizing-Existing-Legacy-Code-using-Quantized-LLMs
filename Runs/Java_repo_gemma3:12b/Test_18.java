public class Test_18 {

    public static class Data {
        public int a;
        public char b;
        public double c;
    
        public Data() {
        }
    
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
        System.out.printf("Size of int: %lu\n", (long)Integer.SIZE);
        System.out.printf("Size of Data: %lu\n", (long)new Data().getClass().getField("a").getModifiers());
        System.out.printf("Size of Data*: %lu\n", (long)Pointer.SIZE);
    }

}