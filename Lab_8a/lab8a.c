// 64050229
// Vish Siriwatana
// Q1
// 20! = 2432902008176640000

#include <stdio.h>
#include <sys/types.h>
#include <unistd.h>
#include <signal.h>
#include <stdlib.h>


int main(void) {
    pid_t pid = fork();
    if (pid == 0) {
        printf("child created\n");
        while(1) {
            printf("Please kill me\n");
            sleep(1);
        }
        printf("This line not show sir :)");
        exit(0);
    } else {
        sleep(1);
        for (int i = 3; i > 0; i--) {
            printf("parentProcess will kill childProcess in %d\n", i);
            sleep(1);
        }
        kill(pid, SIGTERM);
    }
}