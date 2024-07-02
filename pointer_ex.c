// #include<stdio.h>

// int f(int x, int * py, int ** ppz)
// {
// int y, z;
// ** ppz+=1;
// z =** ppz;
// printf("%d\n",z);
// * py+=2; y =* py;
// printf("%d\n",y);
// printf("%d\n",x);
// x += 3;
// printf("%d\n",x);

// return x + y + z;
// }
// void main()
// {
// int c, * b, ** a;
// c = 4; b =& c;
// a =& b;
// printf("%d", f(c, b, a));
// printf("%d", f(c, b, a));
// }

// #include<stdio.h>
// int recur(int num)
// {
// int c = 0;
// while (num)
// {
// c++;
// printf("%d-",num);
// num >>= 1;
// printf("%d\n",num);
// }
// return (c);
// }
// int main()
// {
// printf("%d",recur(1011));
// }
#include <stdio.h>
int main(){
    char s1[7] = "1234", *p;
     printf ("%d\n", p);
    p = s1 + 2;
    printf ("%d\n", p);
    *p = '0' ;
    printf ("%s\n", s1);
    }
