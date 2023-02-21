import java.util.*;
import java.io.*;

public class 백준_1644번 {

	public static void main(String[] args) throws IOException{
		// TODO Auto-generated method stub
		BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
		int N=Integer.parseInt(br.readLine());
		if(N==1)
		{
			System.out.println("0");
			System.exit(0);
		}
		ArrayList<Integer> arr=new ArrayList<Integer>();//오름차순으로 정렬되어 있다
		boolean[] era=new boolean[N+1];
		for(int i=2;i<=N;i++)//에라토스테네스의 체
		{
			if(!era[i])//소수이면
			{
				arr.add(i);
				for(int j=2;i*j<=N;j++)
				{
					era[i*j]=true;
				}
			}
		}
		int left=0;
		int right=0;
		int answer=0;
		int sum=arr.get(0);
		while(left<arr.size()&&right<arr.size()&&left<=right)
		{
			if(sum==N)
			{
				answer++;
				right++;
				if(right<arr.size())
				{
					sum=sum+arr.get(right);
				}
			}
			else if(sum>N)
			{
				sum=sum-arr.get(left);
				left++;
			}
			else
			{
				right++;
				if(right<arr.size())
				{
					sum=sum+arr.get(right);
				}
			}
		}
		System.out.println(answer);
	}
}