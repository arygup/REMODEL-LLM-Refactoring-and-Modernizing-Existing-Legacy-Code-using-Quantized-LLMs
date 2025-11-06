public class Test_15 {

    public static class Item {
        public int id;
        public float value;
    
        // No-argument constructor
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
        Item itemPtr = new Item(); // Java doesn't have malloc, we use new instead.
        if (itemPtr == null) { 
            System.out.println("Alloc failed\n");
            return;
        }
        itemPtr.id = 101;
        itemPtr.value = 99.9f; // Java uses f to denote float literals.
        System.out.printf("Item ID: %d\n", itemPtr.id); // System.out.printf works similar to C's printf.
    }

}