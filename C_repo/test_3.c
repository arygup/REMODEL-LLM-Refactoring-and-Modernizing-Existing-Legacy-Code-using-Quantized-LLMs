#include <stdio.h>

union Converter {
    int i;
    float f;
};

int main() {
    union Converter c;
    
    // Write as float, read as int
    c.f = 123.456f;
    printf("Float: %f, Int bits: %d\n", c.f, c.i);

    // Write as int, read as float
    c.i = 1098765432;
    printf("Int: %d, Float bits: %f\n", c.i, c.f);
    
    return 0;
}