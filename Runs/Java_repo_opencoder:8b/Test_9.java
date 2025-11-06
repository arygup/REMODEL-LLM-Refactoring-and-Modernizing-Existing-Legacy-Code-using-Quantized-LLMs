public class Test_9 {

    public static class TypeA {
        public int value;
    
        public TypeA() {}
    
        public TypeA(TypeA other) {
            if (other != null) {
                this.value = other.value;
            }
        }
    
        public TypeA(int value) {
            this.value = value;
        }
    }

    public static class TypeB {
        public double value;
    
        public TypeB() {}
    
        public TypeB(TypeB other) {
            if (other != null) {
                this.value = other.value;
            }
        }
    
        public TypeB(double value) {
            this.value = value;
        }
    }

    public static void main(String[] args) {
            // Test cases for the translated function would go here.
        }
    
        private static void printGeneric(Object data, int type) {
            switch(type) {
                case 1:
                    TypeA a = (TypeA) data;
                    System.out.println("TypeA: " + a.getValue());
                    break;
                case 2:
                    TypeB b = (TypeB) data;
                    System.out.println("TypeB: " + b.getValue());
                    break;
            }
        }

    public static void main(String[] args) {
        TypeA a = new TypeA(123);
        TypeB b = new TypeB(456.789);
        
        do_while_loop: do { 
            printGeneric(a, 1); 
            break do_while_loop;
        } while(false);
    
        do_while_loop: do { 
            printGeneric(b, 2); 
            break do_while_loop;
        } while(false);
    }

}