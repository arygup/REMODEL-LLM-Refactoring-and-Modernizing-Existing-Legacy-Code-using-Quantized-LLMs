public class Test_15 {

    public static class Item {
        public int id;
        public float value;
    
        // Constructors
    
        public Item() {}
    
        public Item(Item other) {
            this.id = other.id;
            this.value = other.value;
        }
    
        public Item(int id, float value) {
            this.id = id;
            this.value = value;
        }
    }

    public static void main(String[] args) {
       do_while_loop: do {
          Item itemPtr = new Item();
          itemPtr.id = 101;
          itemPtr.value = 99.9f;
          
          System.out.printf("Item ID: %d\n", itemPtr.id);
    
          break do_while_loop; // cleanup
        } while(false);
        
        return 0;
    }

}