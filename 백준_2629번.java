import java.util.*;
import java.io.*;
public class 백준_2629번 {

	public static void main(String[] args) throws IOException{
		// TODO Auto-generated method stub
		BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
		int N=Integer.parseInt(br.readLine());//추의 개수
		String[] s=br.readLine().split(" ");//추의 무게들
		int sum=0;
		int[] arr=new int[N];
		for(int i=0;i<N;i++)
		{
			int temp=Integer.parseInt(s[i]);
			sum=sum+temp;//추의 무게합
			arr[i]=temp;
		}
		boolean[] dp=new boolean[40001];
		for(int i=0;i<N;i++)
		{
			ArrayList<Integer> temp=new ArrayList<Integer>();
			temp.add(arr[i]);
			for(int j=1;j<=40000;j++)
			{
				if(dp[j])
				{
					if(arr[i]-j>0)
					{
						temp.add(arr[i]-j);
					}
					if(arr[i]+j<=sum)
					{
						temp.add(arr[i]+j);
					}
					if(j-arr[i]>0)
					{
						temp.add(j-arr[i]);
					}
				}
			}
			for(int j=0;j<temp.size();j++)
			{
				dp[temp.get(j)]=true;
			}
		}
		int ball=Integer.parseInt(br.readLine());//구슬의 개수
		s=br.readLine().split(" ");//구슬의 값들
		for(int i=0;i<ball;i++)
		{
			int value=Integer.parseInt(s[i]);
			if(dp[value])
			{
				System.out.print("Y ");
			}
			else
			{
				System.out.print("N ");
			}
		}
	}
}
