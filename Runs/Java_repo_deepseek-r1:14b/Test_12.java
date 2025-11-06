public class Test_12 {

    public static void main(String[] args) {
            enum Status { 
                STOPPED(0), 
                RUNNING(1);
                private final int value;
                
                Status(int v) { 
                    this.value = v; 
                }
                
                public int getValue() { 
                    return value; 
                }
            };
            
            Status s = Status.STOPPED;
            int intValue = s.getValue() + 1;
            if (intValue == Status.RUNNING.getValue()) {
                System.out.println("Status is RUNNING (1)");
            }
            System.out.printf("Status int value: %d\n", intValue);
        }

}