#include <stdio.h>

// Tests how function pointers are translated.
// C function pointers map to Java Interfaces or Lambda expressions.

int add(int a, int b) {
    return a + b;
}

int subtract(int a, int b) {
    return a - b;
}

// 'op' is a function pointer
int calculate(int x, int y, int (*op)(int, int)) {
    return op(x, y);
}

int main() {
    int (*add_ptr)(int, int) = &add;
    
    printf("Add: %d\n", calculate(10, 5, add_ptr));
    printf("Subtract: %d\n", calculate(10, 5, &subtract));
    return 0;
}