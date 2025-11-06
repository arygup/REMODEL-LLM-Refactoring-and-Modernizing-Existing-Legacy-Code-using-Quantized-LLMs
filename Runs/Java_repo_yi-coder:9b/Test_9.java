public class Test_9 {

    public class TypeA {
        // Fields
        public int value;
    
        // Constructors
        public TypeA() {}
    
        public TypeA(TypeA other) {
            this.value = other.value;
        }
    
        public TypeA(int value) {
            this.value = value;
        }
    }

    public static class TypeB {
        public double value;
    
        //Default Constructor
        public TypeB() {}
    
        //Copy constructor
        public TypeB(TypeB other) {
            this.value = other.value;
        }
    
        //All-field constructor
        public TypeB(double value) {
            this.value = value;
        }
    }

    public static void printGeneric(Object data, int type) {
      if (type == 1 && data instanceof TypeA) {
        TypeA a = (TypeA)data;
        System.out.println("TypeA: " + a.value);
      } else if (type == 2 && data instanceof TypeB) {
        TypeB b = (TypeB)data;
        System.out.println("TypeB: " + b.value);
      }
    }

    public static void main(String[] args) {
        TypeA a = new TypeA();
        a.value = 123;
        TypeB b = new TypeB();
        b.value = 456.789;
        printGeneric(a, 1);
        printGeneric(b, 2);
    }

}