#include <stdio.h>
#include <stdlib.h>
#include <math.h>

int hwan(double a,double b,double c, double d,double e, double f)
{
	double q = sqrt((d - a)*(d - a) + (e - b)*(e - b));

	if (a == d && b == e)
	{
		if (c == f)
			return -1;
		else if (c != f)
			return 0;
	}
	else
	{
		if (q == c + f)
			return 1;
		else if (q == f - c)
			return 1;
		else if (q == c - f)
			return 1;
		else if (q > c + f)
			return 0;
		else if (q < f - c)
			return 0;
		else if (q < c - f)
			return 0;
		else if (q < c + f)
			return 2;
	}
}
int main(void)
{
	int a;
	int b = 6;
	scanf_s("%d", &a);
	int **arr;
	arr = (int **)malloc(a * sizeof(int *));
	for (int i = 0; i<a; ++i)
	{
		arr[i] = (int *)malloc(b * sizeof(int));
	}
	for (int x = 0; x < a; x++)
	{
		for (int y = 0; y < b; y++)
		{
			int g;
			scanf_s("%d", &g);
			arr[x][y] = g;
		}
	}
	for (int j = 0; j < a; j++)
	{
		printf("%d\n", hwan(arr[j][0], arr[j][1], arr[j][2], arr[j][3], arr[j][4], arr[j][5]));
	}
	return 0;
}