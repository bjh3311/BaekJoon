import java.util.Arrays;
import java.util.Scanner;
public class 백준_11054번 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner scan=new Scanner(System.in);
		int N=scan.nextInt();
		int[] arr=new int[N];
		int[] dp=new int[N];//왼쪽에서 오른쪽
		int[] dp_2=new int[N];//오른쪽에서 왼쪽
		int[] result=new int[N];//결과값
		for(int i=0;i<N;i++)
		{
			arr[i]=scan.nextInt();
		}
		for(int i=0;i<N;i++)
		{
			if(dp[i]==0)
			{
				dp[i]=1;
			}
			for(int j=0;j<i;j++)
			{
				if(arr[i]>arr[j])
				{
					dp[i]=Math.max(dp[i], dp[j]+1);
				}
				
			}
		}//왼쪽에서 오른쪽으로 증가하는 수열 찾기
		for(int i=N-1;i>=0;i--)
		{
			if(dp_2[i]==0)
			{
				dp_2[i]=1;
			}
			for(int j=N-1;j>i;j--)
			{
				if(arr[i]>arr[j])
				{
					dp_2[i]=Math.max(dp_2[i],dp_2[j]+1);
				}
			}
		}//오른쪽에서 왼쪽으로 증가하는 수열 찾기
		for(int i=0;i<N;i++)
		{
			result[i]=dp[i]+dp_2[i]-1;
		}
		Arrays.sort(result);
		System.out.println(result[N-1]);
	}
}
