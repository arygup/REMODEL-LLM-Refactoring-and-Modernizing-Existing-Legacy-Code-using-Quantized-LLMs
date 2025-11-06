public class Test_15 {

    public static class Item {
        public int id;
        public float value;
    
        public Item() {
        }
    
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
        Item itemPtr = new Item();
        if (itemPtr == null) {
            System.out.printf("Alloc failed\n");
            System.exit(1);
        }
        itemPtr.id = 101;
        itemPtr.value = 99.9f;
        System.out.printf("Item ID: %d\n", itemPtr.id);
        return;
    }

}