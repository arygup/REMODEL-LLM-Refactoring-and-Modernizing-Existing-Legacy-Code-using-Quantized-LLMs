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
        class Item {
            int id;
            float value;
        }
        
        Item item = new Item();
        if (item == null) {
            System.out.println("Alloc failed");
            return;
        }
        item.id = 101;
        item.value = 99.9f;
        System.out.println("Item ID: " + item.id);
    }

}