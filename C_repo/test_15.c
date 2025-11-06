#include <stdio.h>
#include <stdlib.h>

// Tests dynamic memory allocation for structs.
// 'malloc' should be translated to 'new', and 'free'
// should be removed entirely (relying on Java's GC).

typedef struct {
    int id;
    float value;
} Item;

int main() {
    Item* itemPtr = (Item*)malloc(sizeof(Item));
    
    if (itemPtr == NULL) {
        printf("Alloc failed\n");
        return 1;
    }
    
    itemPtr->id = 101;
    itemPtr->value = 99.9f;
    
    printf("Item ID: %d\n", itemPtr->id);
    
    free(itemPtr);
    // In Java, this 'free' is gone.
    // A test for use-after-free in C would be complex
    // to map to Java, so we just test the alloc/access.
    
    return 0;
}