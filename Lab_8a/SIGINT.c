#include <stdio.h>
#include <unistd.h>
#include <signal.h>
#include <stdlib.h>

void INThandler(int);

void main(void) {
    signal(SIGINT, INThandler);

    while(1) {
        printf("a");
    }
}

void INThandler(int sig) {
    signal(sig, SIG_IGN);
    printf("\nDid you hit Ctrl-C? want to quit? [y/n (any key)] \n");
    
    char c;
    
    scanf("%c", &c);

    if (c == 'y' || c == 'Y')
        exit(0);
    else
        signal(SIGINT, INThandler);
}