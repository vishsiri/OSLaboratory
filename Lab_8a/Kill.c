#include <stdio.h>
#include <stdlib.h>
#include <signal.h>
#include <sys/types.h>
#include <unistd.h>
int notDone = 1;
int cnt = 0;
void mySIGhandler(int sig) {
    signal(SIGALRM, SIG_IGN);
    notDone = 1;
    //printf("loop should break\n");

}

int main(void) {
    signal(SIGALRM, mySIGhandler);
    pid_t pid = fork();
    if (pid == 0) {
        // sleep(4);
        // printf("sending SIGALRM\n");
        // kill(getppid(), SIGALRM);
        // exit(0);

        printf("child created\n");
        while(1) {
            cnt++;
            if (notDone) {
                printf("sending SIGALRM\n");
                kill(getppid(), SIGALRM);
                printf("it takes %d",cnt);
                exit(0);
            }

        }
        printf("this line should not be shown\n");
        exit(0);
    }
    else {
        printf("parent wait for SIGALRM\n");
        while (notDone) {
            cnt++;
        }
            
    }
    printf("parent wait for SIGALRM\n");
    return 0;
}