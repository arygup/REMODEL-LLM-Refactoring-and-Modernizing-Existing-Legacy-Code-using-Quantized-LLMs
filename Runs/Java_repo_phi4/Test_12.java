public class Test_12 {

    public static void main(String[] args) {
            HashMap<String, Integer> statusMap = new HashMap<>();
            statusMap.put("STOPPED", 0);
            statusMap.put("RUNNING", 1);
    
            int s = statusMap.get("STOPPED");
            s += 1;
            
            if (s == statusMap.get("RUNNING")) {
                System.out.println("Status is RUNNING (1)");
            }
            
            System.out.printf("Status int value: %d\n", s);
        }

}