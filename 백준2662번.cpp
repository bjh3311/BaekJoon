#include <iostream>
#include <stack>
using namespace std;
int main()
{
	stack<int> invests;
	int N, M;
	cin >> N;//투자금액
	cin >> M;//기업들의 개수
	int dp[301][21];
	int dp_invest[301][21];
	int arr[301][21];//첫번째 인덱스는 투자금액, 두번째는 몇번쨰 기업인지
	int a;
	for (int i = 1; i <= N; i++)
	{
		cin >> a;
		for (int j = 1; j <= M; j++)
		{
			cin >> arr[i][j];
			
		}
	}
	for(int i=0;i<=N;i++)
	{
		for (int j = 0; j <= M; j++)
		{
			dp[i][j] = 0;
			dp_invest[i][j] = 0;
		}
	}
	for (int comp = 1; comp <= M; comp++)//회사별로 오름차순
	{
		for (int value = 0; value <= N; value++)//금액
		{
			for (int invest = 0; invest <= N - value; invest++)
			{
				if (dp[value + invest][comp] < dp[value][comp - 1] + arr[invest][comp])
				{
					dp[value + invest][comp] = dp[value][comp - 1] + arr[invest][comp];
					dp_invest[value + invest][comp] = invest;
				}
			}
		}
	}
	cout << dp[N][M] << endl;
	int invest;
	int value = N;
	int comp = M;
	while (comp != 0)
	{
		invest = dp_invest[value][comp];
		invests.push(invest);
		value = value - invest;
		comp--;
	}
	while (invests.empty()==false)
	{
		cout << invests.top() << " ";
		invests.pop();
	}
	return 0;
}