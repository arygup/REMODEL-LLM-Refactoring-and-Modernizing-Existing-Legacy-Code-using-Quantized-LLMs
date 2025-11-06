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

    public static void main(String[] args) throws Exception {
            Item item = new Item();
            
            if (item == null) {
                System.out.println("Alloc failed\n");
                return;
            }

}