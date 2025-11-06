#include <stdio.h>

// Tests C enums.
// This version is rewritten to use a 'typedef' which
// works around a bug in the c_analyzer.py that cannot
// handle declarations like 'enum Status s;'.

// We 'typedef' the enum, giving it the name 'Status'
typedef enum {
    STOPPED = 0,
    RUNNING = 1,
    PAUSED = 2
} Status; // <-- The type name is now 'Status'

int main() {
    // The declaration is now 'Status s', not 'enum Status s'
    // This will look like a 'TypeDecl' to pycparser and
    // avoid the 'Enum' object bug in visit_Decl.
    Status s = STOPPED; 
    
    s = s + 1; // Now s is RUNNING (1)
    
    if (s == RUNNING) {
        printf("Status is RUNNING (1)\n");
    }
    
    printf("Status int value: %d\n", s);
    return 0;
}