#include <stdio.h>
#include <stdlib.h>

// Tests 'int**' (pointer to a pointer), often used for
// "out parameters" where a function allocates memory for a caller.
// Java would simulate this by having the function *return* the object.

void createInt(int** p) {
    *p = (int*)malloc(sizeof(int));
    **p = 42;
}

int main() {
    int* myIntPtr = NULL;
    createInt(&myIntPtr);
    
    if (myIntPtr != NULL) {
        printf("Value from out-param: %d\n", *myIntPtr);
        free(myIntPtr);
    }
    return 0;
}