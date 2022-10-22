>  **Vish Siriwatana 64050229**
> Operating System Lab 8b Answer
> Date : 22/10/2022

## Lab8b_q1.c
| Question | Answer |
|--|--|
| <center>1.3 | <center>`pfd[1]` | 
| <center>1.4 | <center>`buf` |
| <center>1.5 | <center>`pfd[0]` |
| <center>1.6 | <center>`pdf[0]` |
| <center>1.7 | <center>`pdf[1]` |
| <center>1.8 | <center>`pdf[1]` |

> Result from **Lab8b_q1.c**

![result Lab_8b](https://github.com/vishsiri/OSLaboratory/blob/main/Lab_8b/image/a.png)

## Lab8b_q2.c

| Question | Answer |
|--|--|
| <center>2.1 | <center>`dup2(fd, 1);` |


```c
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
    dup2(fd, 1); <<<<<<<<THIS ANSWER

    /* to aaa.txt instead of screen */
    printf("please read this line in aaa.txt\n");
    close(fd);
    return 0;
}
```
> Result from **Lab8_2.sh**

![image lab8_2.sh](https://github.com/vishsiri/OSLaboratory/blob/main/Lab_8b/image/b.png)

