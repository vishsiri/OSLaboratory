#include <stdio.h>
#include <stdlib.h>
#include <unistd.h>
int main() {
    FILE *file_desc = fopen("aaa.txt", "w");
    //"w" write mode
    int fd = fileno(file_desc);
    //obtain file descriptor
    printf("current file descriptor id is %d\n", fd);

    //after mapping to stdout, texts to be displayed
    //will be redirected to file "aaa.txt" instead

    // ans 2.1
    dup2(fd, 1);

    /* to aaa.txt instead of screen */
    printf("please read this line in aaa.txt\n");
    close(fd);
    return 0;
}