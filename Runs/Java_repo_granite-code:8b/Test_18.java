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
        
        long sizeof_int = 4L;
        System.out.println("Size of int: " + sizeof_int);
        
        struct Data p_struct_data = new struct Data();
        long sizeof_struct_data = 24L;
        System.out.println("Size of Data: " + sizeof_struct_data);
        
        long sizeof_struct_data_pointer = 8L;
        System.out.println("Size of Data*: " + sizeof_struct_data_pointer);
      }

}