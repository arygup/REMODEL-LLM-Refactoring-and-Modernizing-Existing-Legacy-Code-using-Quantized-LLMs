public class Test_9 {

    public static class TypeA {
        public int value;
    
        public TypeA() {
        }
    
        public TypeA(TypeA other) {
            this.value = other.value;
        }
    
        public TypeA(int value) {
            this.value = value;
        }
    }

    public static class TypeB {
        public double value;
    
        public TypeB() {
        }
    
        public TypeB(TypeB other) {
            this.value = other.value;
        }
    
        public TypeB(double value) {
            this.value = value;
        }
    }

    public static void printGeneric(Object data, int type) {
      if (type == 1) {
        if (data instanceof TypeA) {
          TypeA a = (TypeA) data;
          System.out.printf("TypeA: %d\n", a.value);
        }
      } else if (type == 2) {
        if (data instanceof TypeB) {
          TypeB b = (TypeB) data;
          System.out.printf("TypeB: %f\n", b.value);
        }
      }
    }

    public static void main(String[] args) {
        TypeA a = new TypeA(123);
        TypeB b = new TypeB(456.789);
        
        printGeneric(a, 1);
        printGeneric(b, 2);
    }

}