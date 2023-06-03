#include <stdio.h>
#include <stdlib.h>
#include <malloc.h>
#define ok 1
#define error 2
#define overflow -2
#define maxsize 100
typedef struct
{
	int *elem;
	int length;
} sqlist;
//˳���ĳ�ʼ��
int InitList(sqlist &L)
{
	L.elem = (int *)malloc(maxsize * sizeof(int));
	if (!L.elem)
	{
		printf("overflow");
	}
	L.length = 0;
	return 0;
}
//˳���Ľ���
int listbuild(sqlist &L)
{
	int i, n;
	printf("���������Ա�ĳ���");
	scanf("%d", &n);
	L.length = n;
	printf("����������Ԫ��");
	for (i = 0; i <= L.length - 1; i++)
	{
		scanf("%d", &L.elem[i]);
	}
	return ok;
}
//˳���Ĳ���
int listinsert(sqlist &L, int i, int e)
{
	int j;
	if (i < 1 || j > L.length + 1)
	{
		return error;
	}
	if (L.length >= maxsize)
	{
		return overflow;
	}
	for (j = L.length - 1; j >= i - 1; j--)
	{
		L.elem[j + 1] = L.elem[j];
	}
	L.elem[i - 1] = e;
	++L.length;
	return ok;
}
//ɾ��˳��������Ԫ��
int listdelete(sqlist &L, int i)
{
	int j;
	if (i < 1 || i > L.length)
	{
		return error;
	}
	for (j = i; j <= L.length - 1; j++)
	{
		L.elem[j - 1] = L.elem[j];
	}
	--L.length;
	return ok;
}
//˳���Ĳ���
int locateelem(sqlist L, int e)
{
	int i;
	for (i = 0; i < L.length; i++)
	{
		if (e == L.elem[i])
		{
			return i + 1;
		}
	}
	printf("û���ҵ�!%d\n", e);
	return 0;
}
//��ӡ���
int listprint(sqlist &L)
{
	int a;
	for (a = 0; a < L.length; a++)
	{
		printf("%d", L.elem[a]);
	}
	printf("\n");
	return 1;
}
//˳��������
int listsort(sqlist &L)
{
	int i;
	int m = L.length / 2;
	int n = L.length;
	int temp;
	for (i = 0; i < m; i++)
	{
		temp = L.elem[i];
		L.elem[i] = L.elem[n - 1 - i];
		L.elem[n - 1 - i] = temp;
	}
	return ok;
}
//˳���ĺϲ�
int listmerger(sqlist &La, sqlist &Lb, sqlist &Lc)
{
	int *pa, *pb, *pc, *pa_last, *pb_last;
	Lc.length = La.length + Lb.length;
	pc = Lc.elem;
	pa = La.elem;
	pb = Lb.elem;
	pa_last = La.elem + La.length - 1;
	pb_last = Lb.elem + Lb.length - 1;
	while ((pa <= pa_last) && (pb <= pb_last))
	{
		if (*pa <= *pb)
		{
			*pc++ = *pa++;
		}
		else
			*pc++ = *pb++;
	}
	while (pa <= pa_last)
	{
		*pc++ = *pa++;
	}
	while (pb <= pb_last)
	{
		*pc++ = *pb++;
	}
	return ok;
}
int main() int a;
int e;
sqlist La, Lb, Lc;
InitList(La);
listbuild(La);
printf("�����õ�˳���La=");
listprint(La);
//����
int x;
int i;
printf("������Ԫ�ز����λ��");
scanf("%d", &i);
printf("������Ҫ���������Ԫ��");
scanf("%d", &x);
listinsert(La, i, x);
printf("����һ�����ݺ��˳���La=");
listinsert(La);
//ɾ��
printf("������Ҫɾ�����ֵ�λ��");
scanf("%d", &i);
listdelete(La, i);
printf("ɾ��һ�����ݺ��˳���La=");
listprint(La);
//����
printf("������Ҫ���ҵ�Ԫ��");
scanf("%d", &e);
printf("���ҵ�Ԫ��λ��Ϊ%d", locateelem(La, e));
printf("\n");
