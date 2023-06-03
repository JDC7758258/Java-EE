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
    printf("�����õ�˳���La=");
    listPrint(la);
    int x;
    int i;
    printf("������Ԫ�ز����λ��");
    scanf("%d", &i);
    printf("������Ҫ���������Ԫ��");
    scanf("%d", &x);
    (la, i, x);
    printf("����һ�����ֺ��˳���La=");
    listPrint(la);
    printf("������Ҫɾ�����ֵ�λ��");
    scanf("%d", &i);
    listDelete(la, i);
    printf("ɾ��һ�����ֺ��˳���La=");
    listPrint(la);
    printf("������Ҫ����Ԫ��Ϊ");
    scanf("%d", &e);
    printf("���ҵ�Ԫ��λ��Ϊ%d", locateElem(la, e));
    printf("\n");
    printf("��ʱ˳��������La=");
    listSort(la);
    listPrint(la);
    printf("La��Ϊ:%d\n", getLength(la));
    printf("���������:");
    scanf("%d", &i);
    printf("��λ��Ԫ��Ϊ:%d\n", getElem(la, i));
    //���´���La
    initList(la);
    printf("ע�����������������Ԫ�أ�Ҫ������ֵ����\n");
    listBuild(la);
    printf("�����õ�˳���La=");
    listPrint(la);
    //����Lb
    printf("ע�����������������Ԫ�أ�Ҫ������ֵ����\n");
    initList(lb);
    listBuild(lb);
    printf("�����õ�˳���Lb=");
    listPrint(lb);
    //�ϲ�Lc
    initList(lc);
    listMerger(la, lb, lc);
    printf("Lc��Ϊ:%d\n", getLength(lc));
    printf("�ϲ���Lc=");
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
    printf("���������Ա�ĳ���");
    scanf("%d", &n);
    l.length = n;
    printf("����������Ԫ��");
    for (i = 0; i <= l.length - 1; i++) {
        scanf("%d", &l.elem[i]);
    }
    return 1;
}

//��ӡ���
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

//˳���Ĳ���
int locateElem(sqList L, int e) {
    int i;
    for (i = 0; i < L.length; i++) {
        if (e == L.elem[i]) {
            return i + 1;
        }
    }
    printf("û���ҵ�!%d\n", e);
    return 0;
}

//˳��������
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

//˳������
int getLength(sqList list) {
    return list.
            length;
}

//���ұ���Ԫ��
int getElem(sqList list, int i) {
    int e;
    if ((i < 1) || (i > list.length))
        return
                2;
    e = list.elem[i - 1];
    return
            e;
}

//˳���ĺϲ�
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