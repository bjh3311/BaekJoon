#include <iostream>
using namespace std;

long long power(long long x, long long y, long long mod)
{
	long long res = 1;
	x %= mod;
	while (y) 
	{
		if (y % 2) res = (res * x) % mod;
		y /= 2;
		x = (x*x) % mod;
	}
	return res;
}
bool miller_rabin(long long n, long long a)
{
	if (a % n == 0)
	{
		return false;
	}
	long long k = n - 1;
	while (1)
	{
		long long temp = power(a, k, n);
		if (temp == n - 1)
		{
			return true;
		}
		if (k % 2)
		{
			return (temp == 1 || temp == n - 1);
		}
		k /= 2;
	}
}//n�̼Ҽ��̸� true�� ��ȯ
int main ()
{
	long long n;
	cin >> n;
	long long a[3] = { 2,7,61 };//10�����ϴ� 3���� ����ϴ�
	for (int i = 0; i < 3; i++)
	{
		if (miller_rabin(n, a[i]))//�Ҽ��̸�(true�̸�) 1�� ����ϰ� �ٷ� ����
		{
			cout << "1" << endl;
			return 0;
		}
	}
	cout << "0" << endl;
}
