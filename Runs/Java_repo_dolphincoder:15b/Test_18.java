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
    
    Note: This Java class contains the exact same fields as the C struct, and it has the required constructors according to rule 3 above. The constructors are implemented as described in rule 3.2 and 3.3.

    public static void main(String[] args) {
        System.out.println("Size of int: " + Integer.BYTES);
        Data data = new Data();
        System.out.println("Size of Data: " + (data.a + Character.BYTES + Double.BYTES));
        System.out.println("Size of Data*: " + Integer.BYTES);
    }

}