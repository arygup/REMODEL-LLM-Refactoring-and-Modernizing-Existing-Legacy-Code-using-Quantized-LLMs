#include <stdio.h>
#include <string.h>

// Tests nested structs and their access.
// This should map to nested Java classes.

struct Inner {
    int inner_val;
};

struct Outer {
    struct Inner inner_data;
    char name[20];
};

int main() {
    struct Outer o;
    o.inner_data.inner_val = 123;
    strcpy(o.name, "MyStruct");
    
    printf("Name: %s\n", o.name);
    printf("Inner: %d\n", o.inner_data.inner_val);
    return 0;
}