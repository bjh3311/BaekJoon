import java.util.Arrays;
import java.util.Scanner;
public class 백준_14002번 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner scan=new Scanner(System.in);
		int N=scan.nextInt();
		int[] arr=new int[N];
		int[][] dp=new int[N][2];// 2번째는 이전 인덱스 지정
		StringBuilder sb=new StringBuilder();
		for(int i=0;i<N;i++)
		{
			arr[i]=scan.nextInt();
		}
		for(int i=0;i<N;i++)
		{
			if(dp[i][0]==0)
			{
				dp[i][0]=1;
			}
			for(int j=0;j<i;j++)
			{
				if(arr[i]>arr[j])
				{
					if(dp[j][0]+1>dp[i][0])
					{
						dp[i][0]=dp[j][0]+1;
						dp[i][1]=j;//이전 인덱스의 값 위치 지정
					}
					else
					{
						dp[i][0]=dp[i][0];
					}
				}
			}
		}
		int max=dp[0][0];
		int max_index=0;
		for(int i=0;i<N;i++)
		{
			if(max<dp[i][0])
			{
				max=dp[i][0];//max값 찾기
				max_index=i;
			}
		}
		sb.append(arr[max_index]+" ");
		int max_temp=max;
		max_temp--;
		while(max_temp!=0)
		{
			sb.append(arr[dp[max_index][1]]+" ");
			max_index=dp[max_index][1];	
			max_temp--;
		}
		System.out.println(max);
		String[] s=sb.toString().split(" ");
		for(int i=s.length-1;i>=0;i--)
		{
			System.out.print(s[i]+" ");
		}//역순으로 출력

	}

}
