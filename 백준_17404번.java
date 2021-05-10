import java.util.*;
import java.io.*;
public class 백준_17404번 {

	public static void main(String[] args) throws IOException{
		// TODO Auto-generated method stub
		BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
		int N=Integer.parseInt(br.readLine());
		int[][] arr=new int[N][3];
		int[][][] dp=new int[N][3][3];
		//첫번째 인덱스는 몇번째집인지,2번째는 첫번쨰집 색깔,3번째는 첫번째집 이외의 색깔을 의미
		String[] s;
		for(int i=0;i<N;i++)
		{
			s=br.readLine().split(" ");
			for(int j=0;j<3;j++)
			{
				arr[i][j]=Integer.parseInt(s[j]);
			}
		}
		dp[1][0][0]=Integer.MAX_VALUE;//첫째날에 빨강이면 둘째날은 빨강을 고르지 못한다.
		dp[1][0][1]=arr[0][0]+arr[1][1];
		dp[1][0][2]=arr[0][0]+arr[1][2];
		dp[1][1][1]=Integer.MAX_VALUE;//첫쨰날에 초록이면 둘쨰날은 초록을 고르지 못한다.
		dp[1][1][0]=arr[0][1]+arr[1][0];
		dp[1][1][2]=arr[0][1]+arr[1][2];
		dp[1][2][2]=Integer.MAX_VALUE;//첫째날에 파랑이면 둘쨰날은 파랑을 고르지 못한다.
		dp[1][2][0]=arr[0][2]+arr[1][0];
		dp[1][2][1]=arr[0][2]+arr[1][1];
		for(int i=2;i<N-1;i++)
		{
			for(int j=0;j<3;j++)
			{
				dp[i][j][0]=arr[i][0]+Math.min(dp[i-1][j][1],dp[i-1][j][2]);
				dp[i][j][1]=arr[i][1]+Math.min(dp[i-1][j][0],dp[i-1][j][2]);
				dp[i][j][2]=arr[i][2]+Math.min(dp[i-1][j][0],dp[i-1][j][1]);
			}
		}
		dp[N-1][0][0]=Integer.MAX_VALUE;//첫째날이 빨강이면 마지막날도 빨강은 못고른다.
		dp[N-1][0][1]=arr[N-1][1]+Math.min(dp[N-2][0][0], dp[N-2][0][2]);
		dp[N-1][0][2]=arr[N-1][2]+Math.min(dp[N-2][0][0], dp[N-2][0][1]);
		dp[N-1][1][1]=Integer.MAX_VALUE;//첫째날이 초록이면 마지막날도 초록은 못고른다
		dp[N-1][1][0]=arr[N-1][0]+Math.min(dp[N-2][1][1], dp[N-2][1][2]);
		dp[N-1][1][2]=arr[N-1][2]+Math.min(dp[N-2][1][0], dp[N-2][1][1]);
		dp[N-1][2][2]=Integer.MAX_VALUE;//첫쨰날이 파랑이면 마지막날도 파랑은 못고른다.
		dp[N-1][2][0]=arr[N-1][0]+Math.min(dp[N-2][2][1], dp[N-2][2][2]);
		dp[N-1][2][1]=arr[N-1][1]+Math.min(dp[N-2][2][0], dp[N-2][2][2]);
		int result=Integer.MAX_VALUE;
		for(int i=0;i<3;i++)//최소값찾기
		{
			for(int j=0;j<3;j++)
			{
				
				result=Math.min(result, dp[N-1][i][j]);
			}
		}
		System.out.println(result);
	}
}
