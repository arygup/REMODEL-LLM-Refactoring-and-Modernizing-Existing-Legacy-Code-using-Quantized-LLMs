#include <stdio.h>

// Tests 'void*' pointers, which are C's generic pointer type.
// This is very hard to translate to strongly-typed Java.

struct TypeA {
    int value;
};

struct TypeB {
    double value;
};

void printGeneric(void* data, int type) {
    if (type == 1) {
        struct TypeA* a = (struct TypeA*)data;
        printf("TypeA: %d\n", a->value);
    } else if (type == 2) {
        struct TypeB* b = (struct TypeB*)data;
        printf("TypeB: %f\n", b->value);
    }
}

int main() {
    struct TypeA a = {123};
    struct TypeB b = {456.789};
    
    printGeneric(&a, 1);
    printGeneric(&b, 2);
    return 0;
}