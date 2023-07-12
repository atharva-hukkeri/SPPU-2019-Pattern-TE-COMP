#include <stdio.h>
#include <stdlib.h>
#include <math.h>
int n, r;
struct frame
{
    char ack;
    int data;
} frm[10];
int sender(void);
int sender()
{
    int i;
    printf("\nEnter Number of frames to be sent:");
    scanf("%d", &n);
    for (i = 1; i < n; i++)
    {
        printf("\nEnter data for frames [%d] ", i);
        scanf("%d", &frm[i].data);
        frm[i].ack = 'y';
    }
    return 0;
}
void recvack(void);
void recvack()
{
    int i;
    rand();
    r = rand() % n;
    frm[r].ack = n;
    for (i = 1; i <= n; i++)
    {
        if (frm[i].ack == n)
        {
            printf("\nThe frame number %d is not received\n", r);
        }
    }
}
void resend_sr(void);
void resend_sr()
{
    printf("\nresending frame %d\n", r);
    sleep(2);

    frm[r].ack = 'y';
    printf("\nThe received frame is %d", frm[r].data);
}
void resend_gb(void);
void resend_gb()
{
    int i;
    printf("\nresending from frame %d", r);
    for (i = r; i <= n; i++)
    {
        sleep(2);
        frm[i].ack = 'y';
        printf("\nReceived data of frame %d is %d", i, frm[i].data);
    }
}
void goback(void);
void goback()
{
    sender();
    recvack();
    resend_gb();
    printf("\nAll frames sent successfully\n");
}
void selective(void);
void selective()
{
    sender();
    recvack();
    resend_sr();
    printf("\nAll frames sent successfully\n");
}
int main()
{
    int c;
    do
    {
        printf("\n\n1. Selective Repeat ARQ\n2. Goback ARQ\n3. Exit");
        printf("\nEnter your choice:");
        scanf("%d", &c);
        switch (c)
        {
        case 1:
            selective();
            break;
        case 2:
            goback();
            break;
        case 3:
            exit(0);
        }
    } while (c >= 4);
}