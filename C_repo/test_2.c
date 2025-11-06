#include <stdio.h>

typedef struct {
    int x;
    int y;
} Point;

// Pass-by-pointer (modifies original)
void move(Point *p) {
    p->x += 5;
}

// Pass-by-value (modifies a copy)
void move_copy(Point p_val) {
    p_val.x += 100;
    printf("Inside move_copy: %d\n", p_val.x);
}

int main() {
    Point p1 = {10, 20};
    printf("Original: %d\n", p1.x); // 10
    
    move_copy(p1); // Pass a copy
    printf("After move_copy: %d\n", p1.x); // Unchanged: 10
    
    move(&p1); // Pass a pointer
    printf("After move: %d\n", p1.x); // Changed: 15
    return 0;
}