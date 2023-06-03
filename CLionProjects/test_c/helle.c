//
// Created by JDC on 2022/10/27.
//
#include <stdio.h>
#include <malloc.h>

#define maxsize 100
typedef struct {
    int *elem;
    int length;
} sqList;

int getLength(sqList list);

int initList(sqList la);

int listDelete(sqList list, int i);

int listPrint(sqList la);

int locateElem(sqList L, int e);

int listBuild(sqList la);

int listMerger(sqList la, sqList lb, sqList lc);

int listSort(sqList list);

int getElem(sqList list, int i);

int main() {
    int a;
    int e;
    sqList la, lb, lc;
    initList(la);
    listBuild(la);
    printf("创建好的顺序表La=");
    listPrint(la);
    int x;
    int i;
    printf("请输入元素插入的位置");
    scanf("%d", &i);
    printf("请输入要插入的数据元素");
    scanf("%d", &x);
    (la, i, x);
    printf("插入一个数字后的顺序表La=");
    listPrint(la);
    printf("请输入要删除数字的位置");
    scanf("%d", &i);
    listDelete(la, i);
    printf("删除一个数字后的顺序表La=");
    listPrint(la);
    printf("请输入要查找元素为");
    scanf("%d", &e);
    printf("查找的元素位置为%d", locateElem(la, e));
    printf("\n");
    printf("此时顺序表的逆置La=");
    listSort(la);
    listPrint(la);
    printf("La表长为:%d\n", getLength(la));
    printf("请输入序号:");
    scanf("%d", &i);
    printf("该位置元素为:%d\n", getElem(la, i));
    //重新创建La
    initList(la);
    printf("注：请输入有序的数据元素，要求是数值升序\n");
    listBuild(la);
    printf("创建好的顺序表La=");
    listPrint(la);
    //创建Lb
    printf("注：请输入有序的数据元素，要求是数值升序\n");
    initList(lb);
    listBuild(lb);
    printf("创建好的顺序表Lb=");
    listPrint(lb);
    //合并Lc
    initList(lc);
    listMerger(la, lb, lc);
    printf("Lc表长为:%d\n", getLength(lc));
    printf("合并后Lc=");
    listPrint(lc);
    return 0;
}

int initList(sqList la) {
    int adsLa = &la;
    la.elem = (int *) malloc(maxsize * sizeof(int));
    if (!la.elem) {
        printf("oveFlow");
    }
    la.length = 0;
    return 1;
}

int listBuild(sqList l) {
    int i, n;
    printf("请输入线性表的长度");
    scanf("%d", &n);
    l.length = n;
    printf("请输入数据元素");
    for (i = 0; i <= l.length - 1; i++) {
        scanf("%d", &l.elem[i]);
    }
    return 1;
}

//打印输出
int listPrint(sqList list) {

    int a;
    for (a = 0; a < list.length; a++) {
        printf("%d", list.elem[a]);
    }
    printf("\n");
    return 1;
}

int listDelete(sqList list, int i) {
    int j;
    if (i < 1 || i > list.length) {
        return 2;
    }
    for (j = i; j < list.length - 1; j++) {
        list.elem[j - 1] = list.elem[j];
    }
    --list.length;
    return 1;
}

//顺序表的查找
int locateElem(sqList L, int e) {
    int i;
    for (i = 0; i < L.length; i++) {
        if (e == L.elem[i]) {
            return i + 1;
        }
    }
    printf("没有找到!%d\n", e);
    return 0;
}

//顺序表的逆置
int listSort(sqList list) {
    int i;
    int m = list.length / 2;
    int n = list.length;
    int temp;
    for (
            i = 0;
            i < m;
            i++) {
        temp = list.elem[i];
        list.elem[i] = list.elem[n - 1 - i];
        list.elem[n - 1 - i] =
                temp;
    }
    return
            1;
}

//顺序表求表长
int getLength(sqList list) {
    return list.
            length;
}

//查找表中元素
int getElem(sqList list, int i) {
    int e;
    if ((i < 1) || (i > list.length))
        return
                2;
    e = list.elem[i - 1];
    return
            e;
}

//顺序表的合并
int listMerger(sqList laList, sqList lbList, sqList lcList) {
    int *pa, *pb, *pc, *pa_last, *pb_last;
    lcList.
            length = laList.length + lbList.length;
    pc = lcList.elem;
    pa = laList.elem;
    pb = lbList.elem;
    pa_last = laList.elem + laList.length - 1;
    pb_last = lbList.elem + lbList.length - 1;
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
    return 1;
}