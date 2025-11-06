public class Test_15 {

    public static class Item {
        public int id;
        public float value;
    
        // Default constructor
        public Item() {}
    
        // Copy constructor
        public Item(Item other) {
            this.id = other.id;
            this.value = other.value;
        }
    
        // All-field constructor
        public Item(int id, float value) {
            this.id = id;
            this.value = value;
        }
    }

    public static void main(String[] args) {
      do {
        Item itemPtr = new Item();
        if (itemPtr == null) {
          System.out.println("Alloc failed");
          break;
        }
        itemPtr.id = 101;
        itemPtr.value = 99.9f;
        System.out.printf("Item ID: %d\n", itemPtr.id);
        free(itemPtr);
      } while (false);
    }

}