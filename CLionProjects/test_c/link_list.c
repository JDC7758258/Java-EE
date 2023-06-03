#include<stdio.h>
#include<stdlib.h>
#include<malloc.h>

#define ok 1
#define error 2
#define overflow -2
#define maxsize 100
typedef struct {
    int *elem;
    int length;
} sqlist;

//顺序表的初始化
int Initlist(sqlist &L) {
    L.elem = (int *) malloc(maxsize * sizeof(int));
    if (!L.elem) {
        printf("overflow");
    }
    L.length = 0;
    return ok;
}

//顺序表的建立
int listbuild(sqlist &L) {
    int i, n;
    printf("请输入线性表的长度");
    scanf("%d", &n);
    L.length = n;
    printf("请输入数据元素");
    for (i = 0; i <= L.length - 1; i++) {
        scanf("%d", &L.elem[i]);
    }
    return ok;
}

//顺序表的插入
int listinsert(sqlist &L, int i, int e) {
    int j;
    if (i < 1 || i > L.length + 1) {
        return error;
    }
    if (L.length >= maxsize) {
        return overflow;
    }
    for (j = L.length - 1; j >= i - 1; j--) {
        L.elem[j + 1] = L.elem[j];
    }
    L.elem[i - 1] = e;
    ++L.length;
    return ok;
}

//删除顺序表中的元素
int listdelete(sqlist &L, int i) {
    int j;
    if (i < 1 || i > L.length) {
        return error;
    }
    for (j = i; j < L.length - 1; j++) {
        L.elem[j - 1] = L.elem[j];
    }
    --L.length;
    return ok;
}

//顺序表的查找
int locateelem(sqlist L, int e) {
    int i;
    for (i = 0; i < L.length; i++) {
        if (e == L.elem[i]) {
            return i + 1;
        }
    }
    printf("没有找到!%d\n", e);
    return 0;
}

//打印输出
int listprint(sqlist &L) {
    int a;
    for (a = 0; a < L.length; a++) {
        printf("%d", L.elem[a]);
    }
    printf("\n");
    return 1;
}

//顺序表的逆置
int listsort(sqlist &L) {
    int i;
    int m = L.length / 2;
    int n = L.length;
    int temp;
    for (i = 0; i < m; i++) {
        temp = L.elem[i];
        L.elem[i] = L.elem[n - 1 - i];
        L.elem[n - 1 - i] = temp;
    }
    return ok;
}

//顺序表求表长
int Getlength(sqlist &L) {
    return L.length;
}

//查找表中元素
int Getelem(sqlist &L, int i) {
    int e;
    if ((i < 1) || (i > L.length)) return error;
    e = L.elem[i - 1];
    return e;
}

//顺序表的合并 
int listmerger(sqlist &La, sqlist &Lb, sqlist &Lc) {
    int *pa, *pb, *pc, *pa_last, *pb_last;
    Lc.length = La.length + Lb.length;
    pc = Lc.elem;
    pa = La.elem;
    pb = Lb.elem;
    pa_last = La.elem + La.length - 1;
    pb_last = Lb.elem + Lb.length - 1;
    while ((pa <= pa_last) && (pb <= pb_last)) {
        if (*pa <= *pb) {
            *pc++ = *pa++;

        } else *pc++ = *pb++;
    }
    while (pa <= pa_last) {
        *pc++ = *pa++;
    }
    while (pb <= pb_last) {
        *pc++ = *pb++;
    }
    return ok;
}

int main() {
    int a;
    int e;
    sqlist La, Lb, Lc;
    Initlist(La);
    listbuild(La);
    printf("创建好的顺序表La=");
    listprint(La);
    int x;
    int i;
    printf("请输入元素插入的位置");
    scanf("%d", &i);
    printf("请输入要插入的数据元素");
    scanf("%d", &x);
    listinsert(La, i, x);
    printf("插入一个数字后的顺序表La=");
    listprint(La);
    printf("请输入要删除数字的位置");
    scanf("%d", &i);
    listdelete(La, i);
    printf("删除一个数字后的顺序表La=");
    listprint(La);
    printf("请输入要查找元素为");
    scanf("%d", &e);
    printf("查找的元素位置为%d", locateelem(La, e));
    printf("\n");
    printf("此时顺序表的逆置La=");
    listsort(La);
    listprint(La);
    printf("La表长为:%d\n", Getlength(La));
    printf("请输入序号:");
    scanf("%d", &i);
    printf("该位置元素为:%d\n", Getelem(La, i));
    //重新创建La
    Initlist(La);
    printf("注：请输入有序的数据元素，要求是数值升序\n");
    listbuild(La);
    printf("创建好的顺序表La=");
    listprint(La);
    //创建Lb
    printf("注：请输入有序的数据元素，要求是数值升序\n");
    Initlist(Lb);
    listbuild(Lb);
    printf("创建好的顺序表Lb=");
    listprint(Lb);
    //合并Lc
    Initlist(Lc);
    listmerger(La, Lb, Lc);
    printf("Lc表长为:%d\n", Getlength(Lc));
    printf("合并后Lc=");
    listprint(Lc);
    return 0;
}
