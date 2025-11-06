public class Test_19 {

    struct Outer
    {
       struct Inner inner1; /* This is a struct defined inside another struct */
       struct Inner *inner2; /* This is a pointer to a struct defined inside another struct */
       char name[50];  // 49 bytes + \0 = 50 bytes
       char *desc;   /* This is a pointer */
    }

    // FAILED_EXTRACTION: LLM returned empty response.

    // FAILED_EXTRACTION: LLM returned empty response.

}