import java.util.*;
public class 프로그래머스_양궁대회 {
	public static void main(String[] args) {
		// TODO Auto-generated method stubs
		int[] arr= {0,0,1,2,0,1,1,1,1,1,1};
		for(int temp: solution(9,arr))
		{
			System.out.print(temp+" ");
		}
	}
	public static int[] pre;//계속 참조할 배열
	public static int[] answer= {-1};
	public static int max=Integer.MIN_VALUE;
	public static int count;
	public static int[] solution(int n,int[] info)
	{
		count=n;
		pre=info.clone();
		int[] init=new int[11];
		DFS(0,init);
		return answer;
	}
	public static void DFS(int n,int[] temp)
	{
		if(n==count)//화살을 전부 쐇다면 비교한다
		{
			int lion=0;
			int apache=0;
			for(int i=0;i<=10;i++)
			{	
				if(temp[i]!=0||pre[i]!=0)//두명중 한명이라도 해당점수에 맞췄어야 한다
				{
					if(temp[i]>pre[i])//해당점수에 더 많이 맞췄다면 
					{
						lion=lion+(10-i);//라이언한테 점수추가
					}
					else//같거나 작다면 어피치한테 점수추가
					{
						apache=apache+(10-i);
					}
				}
			}
			if(lion>apache)//라이언의 점수가 어피치보다 높다면
			{
				if(lion-apache>=max)//점수차가 여태까지보다 같거나 더 벌어질때만
				{
					max=lion-apache;
					answer=temp.clone();
				}
			}
			return;
		}
		for(int i=0;i<=10&&temp[i]<=pre[i];i++)
		{
			temp[i]++;
			DFS(n+1,temp);
			temp[i]--;
		}
	}
}
