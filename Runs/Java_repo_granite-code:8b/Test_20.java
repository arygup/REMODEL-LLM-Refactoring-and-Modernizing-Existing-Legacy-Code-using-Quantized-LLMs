public class Test_20 {

    public static void main(String[] args) throws Exception {
        int i = 2;
        switch (i) {
          case 1:
            System.out.print("Case 1\n");
    
          case 2:
            System.out.print("Case 2 (fall-through)\n");
    
          case 3:
            System.out.print("Case 3 (fall-through)\n");
            break;
    
          case 4:
            System.out.print("Case 4\n");
            break;
    
          default:
            System.out.print("Default\n");
        }

}