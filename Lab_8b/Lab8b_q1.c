#include <stdlib.h> //for atoi()
#include <unistd.h> //for pipe
#include <wait.h>   //for wait()
#include <string.h> //for strcpy()
#define SIZE 10     // pipe buffer size
#include <stdio.h>
int main() {

    int pfd[2];
    // storing (pipe) file descriptor
    // returned from pipe()
    int nread;
    int pid; // pid_t is actually an int
    char buf[SIZE];
    char inbuf[SIZE * 2];
    pipe(pfd); // Q1.1
    // if (pipe(pfd) == -1)
    //{perror("pipe failed\n"); exit(-1);}
    printf("write pipe id = %d ", pfd[1]);
    printf(" read file id = %d\n", pfd[0]);

    pid = fork(); // Q1.2
    if (pid == 0) {
        close( /* Q1.3 */ pfd[1]);
        while((nread == read(pfd[0], /* Q1.4 */ buf, SIZE)) != 0)
            if (nread > 11) {
                printf("avoid overflow no conversion %s. \n", buf);
            } else {
                    printf("child received %s. + 5 = %d\n", buf, atoi(buf)+5);
            }
            close (/* Q1.5 */ pfd[0]);
    } else {
        close(pfd[0]);
        printf(inbuf, "%ld", 123456789012);
        write(/* Q1.6 */ pfd[1],inbuf, strlen(inbuf));
        close(/* Q1.8 */ pfd[1]); wait(NULL);
    }
    return 0;
}