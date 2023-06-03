#include <stdio.h>
#include <stdlib.h>
typedef struct ned
{
	int data;
	struct ned *next;
}ned;
	void main()
{
	int arry[5],i;
	printf("输入5个数据\n");
	for(i=0;i<5;i++)
		scanf("%d",&arry[i]);
	ned *l,*p,*e;
	l=new ned;
	l->next=NULL;
	p=l;
	for(i=0;i<5;i++)
	{
	e=new ned;
	e->data=arry[i];
	e->next=NULL;
	p->next=e;
	p=p->next;
	}
	p=l;
	for(i=0;i<5;i++)
	{
		p=p->next;
		printf("%4d",p->data);
	}
	}
