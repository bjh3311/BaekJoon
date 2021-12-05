#include <iostream>
#include <limits.h>
using namespace std;

int main()
{
	int N;//행렬의 개수
	cin >> N;
	int arr[501][2];
	int dp[501][501];
	for (int i = 1; i <= N; i++)
	{
		for (int j = 1; j <= N; j++)
		{
			dp[i][j] = 0;
		}
	}
	int a, b;
	for (int i = 1; i <= N; i++)
	{
		cin >> a;
		cin >> b;
		arr[i][0] = a;
		arr[i][1] = b;
	}
	for (int L = 1; L < N; L++)//L은 길이이다
	{
		for (int i = 1; i <=N-L; i++)//시작 부분
		{
			int j = i + L;
			dp[i][j] = INT_MAX;
			for (int k = i; k <j; k++)
			{
				dp[i][j] = min(dp[i][j], dp[i][k] + dp[k+1][j] + (arr[i][0] * arr[k][1] * arr[j][1]));
			}
		}
	}
	cout << dp[1][N] << endl;
}