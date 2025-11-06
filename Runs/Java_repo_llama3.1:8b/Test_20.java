public class Test_20 {

    public static void main(String[] args) {
      int i = 2;
      do {
        switch (i)
        {
          case 1:
            System.out.println("Case 1");
    
          case 2:
            System.out.println("Case 2 (fall-through)");
    
          case 3:
            System.out.println("Case 3 (fall-through)");
            break;
    
          case 4:
            System.out.println("Case 4");
            break;
    
          default:
            System.out.println("Default");
    
        }
        while(false);
      
      } catch(Exception e) {
        // handle exception
      }
    
      return;
    }

}