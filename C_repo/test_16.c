#include <stdio.h>

// Tests handling of global variables.
// C globals should be translated to 'public static'
// class members in Java.

int g_counter = 10;

void increment_global() {
    g_counter += 5;
}

int main() {
    printf("Global: %d\n", g_counter);
    increment_global();
    printf("Global after func: %d\n", g_counter);
    
    g_counter = 1;
    printf("Global after main: %d\n", g_counter);
    return 0;
}