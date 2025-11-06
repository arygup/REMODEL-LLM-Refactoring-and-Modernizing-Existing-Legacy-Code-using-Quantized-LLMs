public class Test_9 {

    public static class TypeA {
    
        public int value;
    
        // No-argument default constructor
        public TypeA() {
            // Default initialization if necessary
        }
    
        // Copy constructor
        public TypeA(TypeA other) {
            this.value = other.value;
        }
    
        // All-field constructor
        public TypeA(int value) {
            this.value = value;
        }
    }

    public static class TypeB {
        public double value;
    
        // Public no-argument default constructor
        public TypeB() {
            this.value = 0.0;
        }
    
        // Public copy constructor
        public TypeB(TypeB other) {
            if (other != null) {
                this.value = other.value;
            }
        }
    
        // Public all-field constructor
        public TypeB(double value) {
            this.value = value;
        }
    }

    public static void printGeneric(Object data, int type) {
        if (type == 1) {
            TypeA a = (TypeA) data;
            System.out.println("TypeA: " + a.value);
        } else if (type == 2) {
            TypeB b = (TypeB) data;
            System.out.printf("TypeB: %f\n", b.value);
        }
    }

    public static void main(String[] args) {
        TypeA a = new TypeA(123);
        TypeB b = new TypeB(456.789);
        printGeneric(a, 1);
        printGeneric(b, 2);
    }

}