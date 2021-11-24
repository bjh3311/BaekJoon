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
}//n이소수이면 true를 반환
int main ()
{
	long long n;
	cin >> n;
	long long a[3] = { 2,7,61 };//10억이하는 3개면 충분하다
	for (int i = 0; i < 3; i++)
	{
		if (miller_rabin(n, a[i]))//소수이면(true이면) 1을 출력하고 바로 종료
		{
			cout << "1" << endl;
			return 0;
		}
	}
	cout << "0" << endl;
}
