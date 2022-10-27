## Ans Lab9_q1

> A
```c
exitCriticalSection(0);
```
> B
```c
enterCriticalSection(1);
```
> make file
```make
all: goodCnt

goodCnt: lab9_q1.o peterson.o
		gcc -o goodCnt lab9_q1.o peterson.o

lab9_q1.0: lab9_q1.c
		gcc -c lab9_q1.c

peterson.o: peterson.c
		gcc -c peterson.c

clean:
		rm -rf *.o goodCnt
```


## Ans Lab9_q2

> C
```c
sem_wait(&mySemaphore);
```
> D
```c
sem_init(&mySemaphore, 0, 1);
```
> output
```
thr 140016422483520 exits. lastSeen = 200000
Last cnt from tid[0] is 200000
final cnt = 200000
```