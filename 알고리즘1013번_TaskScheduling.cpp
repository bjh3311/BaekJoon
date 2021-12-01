#include <iostream>
#include <algorithm>
#include <vector>
using namespace std;

bool compare(pair<int, int>a, pair<int, int>b)
{
	if (a.second== b.second)
	{
		return a.first < b.first;
	}
	else
	{
		return a.second < b.second;
	}
}
int main()
{
	int N;
	cin >> N;
	vector<pair<int, int>>v;
	for (int i = 0; i < N; i++)
	{
		int a;
		int b;
		cin >> a;
		cin >> b;
		v.push_back(pair<int, int>(a,b));
	}
	sort(v.begin(), v.end(), compare);
	int end_time = v[0].second;
	int count = 1;
	for (int i = 1; i < N; i++)
	{
		if (end_time <= v[i].first)
		{
			end_time = v[i].second;
			count++;
		}
	}
	cout << count;

}