public class Test_15 {

    public static class Item {
        public int id;
        public float value;
    
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
        Item item = new Item();
        if (item == null) {
            System.out.println("Alloc failed");
            return;
        }
        item.id = 101;
        item.value = 99.9f;
        System.out.printf("Item ID: %d\n", item.id);
        Item temp = item;
        item = null;
        System.out.flush();
        gc(); // Add this line to ensure garbage collection of the allocated memory, since Java doesn't have a direct free function like C
        temp = null; // Ensure the temp object is also garbage collected
    }

}